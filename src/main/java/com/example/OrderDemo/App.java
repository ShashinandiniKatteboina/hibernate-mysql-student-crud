package com.example.OrderDemo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OrderDAO dao = new OrderDAO();

        while (true) {

            System.out.println("\n===== ORDER MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Order");
            System.out.println("2. View All Orders");
            System.out.println("3. Search Order By ID");
            System.out.println("4. Update Order");
            System.out.println("5. Delete Order");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Order ID: ");
                int orderId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Customer Name: ");
                String customerName = sc.nextLine();

                System.out.print("Enter Food Item: ");
                String foodItem = sc.nextLine();

                System.out.print("Enter Quantity: ");
                int quantity = sc.nextInt();

                System.out.print("Enter Total Amount: ");
                int totalAmount = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Order Date (yyyy-mm-dd): ");
                LocalDate orderDate = LocalDate.parse(sc.nextLine());

                System.out.print("Enter Order Status: ");
                String orderStatus = sc.nextLine();

                Order order = new Order(
                        orderId,
                        customerName,
                        foodItem,
                        quantity,
                        totalAmount,
                        orderDate,
                        orderStatus
                );

                dao.saveOrder(order);
                System.out.println("Order Added Successfully!");
                break;

            case 2:

                List<Order> orders = dao.getAllOrders();

                for (Order o : orders) {
                    System.out.println(
                            o.getOrderId() + " | " +
                            o.getCustomerName() + " | " +
                            o.getFoodItem() + " | " +
                            o.getQuantity() + " | " +
                            o.getTotalAmount() + " | " +
                            o.getOrderDate() + " | " +
                            o.getOrderStatus()
                    );
                }
                break;

            case 3:

                System.out.print("Enter Order ID: ");
                int searchId = sc.nextInt();

                Order o = dao.getOrderById(searchId);

                if (o != null) {
                    System.out.println("Order ID: " + o.getOrderId());
                    System.out.println("Customer Name: " + o.getCustomerName());
                    System.out.println("Food Item: " + o.getFoodItem());
                    System.out.println("Quantity: " + o.getQuantity());
                    System.out.println("Total Amount: " + o.getTotalAmount());
                    System.out.println("Order Date: " + o.getOrderDate());
                    System.out.println("Order Status: " + o.getOrderStatus());
                } else {
                    System.out.println("Order Not Found!");
                }
                break;

            case 4:

                System.out.print("Enter Order ID to Update: ");
                int updateId = sc.nextInt();
                sc.nextLine();

                Order updateOrder = dao.getOrderById(updateId);

                if (updateOrder != null) {

                    System.out.print("Enter New Customer Name: ");
                    updateOrder.setCustomerName(sc.nextLine());

                    System.out.print("Enter New Food Item: ");
                    updateOrder.setFoodItem(sc.nextLine());

                    System.out.print("Enter New Quantity: ");
                    updateOrder.setQuantity(sc.nextInt());

                    System.out.print("Enter New Total Amount: ");
                    updateOrder.setTotalAmount(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter New Status: ");
                    updateOrder.setOrderStatus(sc.nextLine());

                    dao.updateOrder(updateOrder);

                    System.out.println("Order Updated Successfully!");
                } else {
                    System.out.println("Order Not Found!");
                }
                break;

            case 5:

                System.out.print("Enter Order ID to Delete: ");
                int deleteId = sc.nextInt();

                dao.deleteOrder(deleteId);

                System.out.println("Order Deleted Successfully!");
                break;

            case 6:

                System.out.println("Exiting...");
                sc.close();
                System.exit(0);

            default:
                System.out.println("Invalid Choice!");
            }
        }
    }
}