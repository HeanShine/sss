package InterfaceImpliment;

import entity.Product;

import java.util.List;

public interface InterfaceProduct {
    public boolean isCheckIdProduct(int idProduct);

    public void addProduct(Product product);

    public void editProduct(int idProduct, Product productInput);

    public void deleteProduct(int idProduct);

    public List<Product> showProduct();

    public Product searchTheMostProduct();
    public Product sortProductByPriceProduct();
}
