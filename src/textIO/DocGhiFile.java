package textIO;

import entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFile {
    File file = new File("/Users/nguyenbang/coding/base-backend/QuanLySanPhamDemoModule2/src/textIO/docghi.txt");

    public List<Product> docFile() throws Exception {
        ArrayList<Product> productArrayList = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] arr = line.split(",");
            Product product = new Product(Integer.parseInt(arr[0]),
                    arr[1],
                    Double.parseDouble(arr[2]),
                    Integer.parseInt(arr[3]),
                    arr[4]);
            productArrayList.add(product);
        }
        bufferedReader.close();
        return productArrayList;
    }

    public void ghiFile(List<Product> productList) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Product product : productList) {
            bufferedWriter.write(product.getIdProduct() +
                    "," + product.getNameProduct() +
                    "," + product.getPriceProduct() +
                    "," + product.getQuantityProduct() +
                    "," + product.getStatusProduct());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}

