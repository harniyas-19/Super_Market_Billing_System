package com.wipro.sbs.main;

import java.util.ArrayList;
import com.wipro.sbs.entity.*;
import com.wipro.sbs.service.SupermarketBillingService;
import com.wipro.sbs.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("P1", "Bread", 45, 40));
        products.add(new Product("P2", "Milk", 35, 50));
        products.add(new Product("P3", "Eggs", 60, 30));

        ArrayList<Bill> bills = new ArrayList<>();

        SupermarketBillingService service =new SupermarketBillingService(products, bills);

        try {
            ArrayList<BillItem> items = new ArrayList<>();
            items.add(new BillItem("P1", 2));
            items.add(new BillItem("P3", 1));

            Bill bill = service.generateBill(items);

            service.printBillDetails(bill.getBillId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
