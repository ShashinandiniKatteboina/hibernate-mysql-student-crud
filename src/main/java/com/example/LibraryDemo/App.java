package com.example.LibraryDemo;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryDAO dao = new LibraryDAO();

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book By ID");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Book ID: ");
                int bookId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Title: ");
                String title = sc.nextLine();

                System.out.print("Enter Author: ");
                String author = sc.nextLine();

                System.out.print("Enter Category: ");
                String category = sc.nextLine();

                System.out.print("Enter Price: ");
                int price = sc.nextInt();

                System.out.print("Enter Available Copies: ");
                int copies = sc.nextInt();

                Library book = new Library(
                        bookId,
                        title,
                        author,
                        category,
                        price,
                        copies
                );

                dao.saveBook(book);

                System.out.println("Book Added Successfully!");
                break;

            case 2:

                List<Library> books = dao.getAllBooks();

                for (Library b : books) {
                    System.out.println(
                            b.getBookId() + " | " +
                            b.getTitle() + " | " +
                            b.getAuthor() + " | " +
                            b.getCategory() + " | " +
                            b.getPrice() + " | " +
                            b.getAvailableCopies()
                    );
                }
                break;

            case 3:

                System.out.print("Enter Book ID: ");
                int searchId = sc.nextInt();

                Library b = dao.getBookById(searchId);

                if (b != null) {
                    System.out.println("Book ID: " + b.getBookId());
                    System.out.println("Title: " + b.getTitle());
                    System.out.println("Author: " + b.getAuthor());
                    System.out.println("Category: " + b.getCategory());
                    System.out.println("Price: " + b.getPrice());
                    System.out.println("Available Copies: " + b.getAvailableCopies());
                } else {
                    System.out.println("Book Not Found!");
                }
                break;

            case 4:

                System.out.print("Enter Book ID to Update: ");
                int updateId = sc.nextInt();
                sc.nextLine();

                Library updateBook = dao.getBookById(updateId);

                if (updateBook != null) {

                    System.out.print("Enter New Title: ");
                    updateBook.setTitle(sc.nextLine());

                    System.out.print("Enter New Author: ");
                    updateBook.setAuthor(sc.nextLine());

                    System.out.print("Enter New Category: ");
                    updateBook.setCategory(sc.nextLine());

                    System.out.print("Enter New Price: ");
                    updateBook.setPrice(sc.nextInt());

                    System.out.print("Enter New Available Copies: ");
                    updateBook.setAvailableCopies(sc.nextInt());

                    dao.updateBook(updateBook);

                    System.out.println("Book Updated Successfully!");
                } else {
                    System.out.println("Book Not Found!");
                }
                break;

            case 5:

                System.out.print("Enter Book ID to Delete: ");
                int deleteId = sc.nextInt();

                dao.deleteBook(deleteId);

                System.out.println("Book Deleted Successfully!");
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