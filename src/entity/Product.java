package entity;

import java.util.Scanner;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double priceProduct;
    private int quantityProduct;
    private String statusProduct;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, double priceProduct, int quantityProduct, String statusProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.quantityProduct = quantityProduct;
        this.statusProduct = statusProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public String getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(String statusProduct) {
        this.statusProduct = statusProduct;
    }

    public void inputProduct() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter id product: ");
                idProduct = Integer.parseInt(scanner.nextLine());
                if (idProduct < 0) {
                    System.out.println("Id product must be greater than 0!");
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid id product!");
            }
        }

        while (true) {
            System.out.print("Enter name product: ");
            nameProduct = scanner.nextLine().trim();
            if (nameProduct.length() > 0) {
                break;
            }
            System.out.println("Name product is required!");
        }

        while (true) {
            try {
                System.out.print("Enter price product: ");
                priceProduct = Double.parseDouble(scanner.nextLine());
                if (priceProduct < 0) {
                    System.out.println("Price product must be greater than 0!");
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid price product!");
            }
        }

        while (true) {
            try {
                System.out.print("Enter quantity product: ");
                quantityProduct = Integer.parseInt(scanner.nextLine());
                if (quantityProduct < 0) {
                    System.out.println("Quantity product must be greater than 0!");
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid quantity product!");
            }
        }

        while (true) {
            System.out.print("Enter status product: ");
            statusProduct = scanner.nextLine().trim();
            if (statusProduct.length() > 0) {
                break;
            }
            System.out.println("Status product is required!");
        }
    }

    public void displayProduct() {
        System.out.printf("%-10d%-20s%-20.2f%-20d%-20s\n",
                idProduct, nameProduct, priceProduct, quantityProduct, statusProduct);
    }
}
