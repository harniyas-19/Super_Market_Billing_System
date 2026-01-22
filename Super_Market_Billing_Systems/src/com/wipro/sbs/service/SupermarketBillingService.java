package com.wipro.sbs.service;

import java.util.ArrayList;

import com.wipro.sbs.entity.Product;
import com.wipro.sbs.entity.Bill;
import com.wipro.sbs.entity.BillItem;
import com.wipro.sbs.util.ProductNotFoundException;
import com.wipro.sbs.util.OutOfStockException;
import com.wipro.sbs.util.BillNotFoundException;
import com.wipro.sbs.util.BillingOperationException;

public class SupermarketBillingService {

    ArrayList<Product> products;
    ArrayList<Bill> bills;
    int billNo = 1;
    public SupermarketBillingService(ArrayList<Product> products,ArrayList<Bill> bills) {
        this.products = products;
        this.bills = bills;
    }

    public Product findProduct(String productId) throws ProductNotFoundException {

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.getProductId().equals(productId)) {
                return p;
            }
        }
        throw new ProductNotFoundException("Invalid product id");
    }

    public void checkStock(String productId, int quantity) throws OutOfStockException, ProductNotFoundException {
        Product p = findProduct(productId);
        if (p.getStock() < quantity) {
            throw new OutOfStockException("Insufficient stock");
        }
    }
    
    public Bill generateBill(ArrayList<BillItem> items) throws BillingOperationException,ProductNotFoundException,OutOfStockException {
        if (items == null || items.size() == 0) {
            throw new BillingOperationException("Bill items empty");
        }
        double totalAmount = calculateTotal(items);
        for (int i = 0; i < items.size(); i++) {
            BillItem bi = items.get(i);
            Product p = findProduct(bi.getProductId());
            p.setStock(p.getStock() - bi.getQuantity());
        }
        String billId = "BILL" + billNo;
        billNo++;
        Bill bill = new Bill(billId, items, totalAmount);
        bills.add(bill);
        return bill;
    }
    
    private double calculateTotal(ArrayList<BillItem> items)throws ProductNotFoundException, OutOfStockException {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            BillItem bi = items.get(i);
            checkStock(bi.getProductId(), bi.getQuantity());
            Product p = findProduct(bi.getProductId());
            total = total + (p.getPrice() * bi.getQuantity());
        }
        return total;
    }
    
    public void cancelBill(String billId) throws BillNotFoundException, ProductNotFoundException {
        Bill bill = null;
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getBillId().equals(billId)) {
                bill = bills.get(i);
                break;
            }
        }
        if (bill == null) {
        	throw new BillNotFoundException("Bill does not exist");
        }
        for (int i = 0; i < bill.getItems().size(); i++) {
            BillItem bi = bill.getItems().get(i);
            Product p = findProduct(bi.getProductId());
            p.setStock(p.getStock() + bi.getQuantity());
        }

        bills.remove(bill);
    }
    
    public void printBillDetails(String billId) throws BillNotFoundException, ProductNotFoundException {
        for (int i = 0; i < bills.size(); i++) {
            Bill b = bills.get(i);
            if (b.getBillId().equals(billId)) {
                System.out.println("Bill Id : " + b.getBillId());
                for (int j = 0; j < b.getItems().size(); j++) {
                    BillItem bi = b.getItems().get(j);
                    Product p = findProduct(bi.getProductId());
                    System.out.println( p.getProductName() + "  Quantity: " + bi.getQuantity() + "  Amount: " + (p.getPrice() * bi.getQuantity())
                    );
                }
                System.out.println("Total Amount : " + b.getTotalAmount());
                return;
            }
        }
        throw new BillNotFoundException("Bill not found");
    }
    
    public void displayAllBills() {
        for (int i = 0; i < bills.size(); i++) {
            Bill b = bills.get(i);
            System.out.println(b.getBillId() + "  " + b.getTotalAmount());
        }
    }
}
