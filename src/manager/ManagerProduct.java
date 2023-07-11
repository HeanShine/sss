package manager;

import InterfaceImpliment.InterfaceProduct;
import entity.Product;
import textIO.DocGhiFile;

import java.util.ArrayList;
import java.util.List;

public class ManagerProduct implements InterfaceProduct {

    private ArrayList<Product> productList = new ArrayList<>();

    public DocGhiFile docGhiFile = new DocGhiFile();

    public ManagerProduct() {
        try {
            productList = (ArrayList<Product>) docGhiFile.docFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean isCheckIdProduct(int idProduct) {
        for (Product product : productList) {
            if (product.getIdProduct() == idProduct) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addProduct(Product product) {
        if (isCheckIdProduct(product.getIdProduct())) {
            System.err.println("Id product is exist");
            return;
        } else {
            productList.add(product);
            try {
                docGhiFile.ghiFile(productList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void editProduct(int idProduct, Product productInput) {
        if (isCheckIdProduct(idProduct)) {
            for (Product product : productList) {
                    product.setNameProduct(productInput.getNameProduct());
                    product.setPriceProduct(productInput.getPriceProduct());
                    product.setQuantityProduct(productInput.getQuantityProduct());
            }
        } else {
            System.err.println("Id product is not exist");
        }
    }

    @Override
    public void deleteProduct(int idProduct) {
        if (isCheckIdProduct(idProduct)) {
            for (Product product : productList) {
                if (product.getIdProduct() == idProduct) {
                    productList.remove(product);
                }
            }
        } else {
            System.err.println("Id product is not exist");
        }
    }

    @Override
    public List<Product> showProduct() {
        if (productList.isEmpty()) {
            System.err.println("List product is empty");
            return null;
        } else {
            for (Product product : productList) {
                product.displayProduct();
            }
        }
        return productList;
    }

    @Override
    public Product searchTheMostProduct() {
        if (productList.isEmpty()) {
            System.err.println("List product is empty");
            return null;
        } else {
            Double max = productList.get(0).getPriceProduct();
            for (Product product : productList) {
                if (product.getPriceProduct() > max) {
                    max = product.getPriceProduct();
                }
            }
            for (Product product : productList) {
                if (product.getPriceProduct() == max) {
                    product.displayProduct();
                    return product;
                }
            }
            return null;
        }
    }

    @Override
    public Product sortProductByPriceProduct() {
        if (productList.isEmpty()) {
            System.err.println("List product is empty");
            return null;
        } else {
            for (int i = 0; i < productList.size() - 1; i++) {
                for (int j = i + 1; j < productList.size(); j++) {
                    if (productList.get(i).getPriceProduct() > productList.get(j).getPriceProduct()) {
                        Product temp = productList.get(i);
                        productList.set(i, productList.get(j));
                        productList.set(j, temp);
                    }
                }
            }
            for (Product product : productList) {
                product.displayProduct();
            }
            return null;
        }
    }
}
