package Model;

public class Product {
    public int productID;
    private static int currentID = 1;
    public String productName;
    public int productPrice;

    public Product(String productName, int productPrice) {
        this.productID = currentID++;
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
