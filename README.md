🛒 Supermarket Billing System

A Java-based console application that simulates a real-world supermarket billing process.
This system handles product inventory, bill generation, stock validation, cancellation, and billing history management.

📌 Project Objective
The Supermarket Billing System manages end-to-end billing operations for a retail supermarket. It allows users to:
Browse available products
Generate bills with multiple items
Calculate total amount automatically
Validate product stock before billing
Cancel bills and restore stock
Maintain billing history for audit and review

The system ensures:
✅ Accurate inventory maintenance
✅ Prevention of billing when stock is insufficient
✅ Unique bill ID generation
✅ Clean cancellation process
✅ Exception handling for invalid operations

🏗️ Project Structure
com.wipro.sbs
│
├── entity
│   ├── Product.java
│   ├── BillItem.java
│   └── Bill.java
│
├── service
│   └── SupermarketBillingService.java
│
├── util
│   ├── ProductNotFoundException.java
│   ├── OutOfStockException.java
│   ├── BillNotFoundException.java
│   └── BillingOperationException.java
│
└── main
    └── Main.java
Output:
<img width="505" height="164" alt="image" src="https://github.com/user-attachments/assets/771e4f76-6eda-45a1-b3a6-c9768bb41561" />
