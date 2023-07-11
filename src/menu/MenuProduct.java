package menu;

import entity.Product;
import manager.ManagerProduct;

import java.util.Scanner;

public class MenuProduct {
    private ManagerProduct managerProduct = new ManagerProduct();
    private Scanner scanner = new Scanner(System.in);


    public void menu() {
        int choose = 0;
        do {
            System.out.println("-----Menu Product-----");
            System.out.println("1. Add product");
            System.out.println("2. Edit product");
            System.out.println("3. Delete product");
            System.out.println("4. Show product");
            System.out.println("5. Search the most product");
            System.out.println("6. Sort product by price product");
            System.out.println("0. Exit");

            while (true) {
                System.out.println("Enter choose : ");
                try {
                    choose = scanner.nextInt();
                } catch (Exception e) {
                    System.err.println("Choose must be an integer!");
                    scanner.nextLine();
                    continue;
                }
                if (choose < 0 || choose > 6) {
                    System.err.println("Choose must be greater than 0 and less than 6!");
                } else {
                    break;
                }
            }

            switch (choose) {
                case 1:
                    Product product = new Product();
                    product.inputProduct();
                    managerProduct.addProduct(product);
                    break;
                case 2:
                    int idEdit;
                    while (true) {
                        System.out.println("Enter id edit : ");
                        try {
                            idEdit = scanner.nextInt();
                        } catch (Exception e) {
                            System.err.println("Id must be an integer!");
                            scanner.nextLine();
                            continue;
                        }
                        if (idEdit < 0) {
                            System.err.println("Id must be greater than 0!");
                        } else {
                            break;
                        }
                    }
                    Product product1 = new Product();
                    product1.inputProduct();
                    managerProduct.editProduct(idEdit, product1);
                    break;

                case 3:
                    int idDelete;
                    while (true) {
                        System.out.println("Enter id delete : ");
                        try {
                            idDelete = scanner.nextInt();
                        } catch (Exception e) {
                            System.err.println("Id must be an integer!");
                            scanner.nextLine();
                            continue;
                        }
                        if (idDelete < 0) {
                            System.err.println("Id must be greater than 0!");
                        } else {
                            break;
                        }
                    }
                    managerProduct.deleteProduct(idDelete);
                    break;
                case 4:
                    managerProduct.showProduct();
                    break;
                case 5:
                    managerProduct.searchTheMostProduct();
                    break;
                case 6:
                    managerProduct.sortProductByPriceProduct();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Please choose again");
            }
        } while (choose != 6);
    }
}
