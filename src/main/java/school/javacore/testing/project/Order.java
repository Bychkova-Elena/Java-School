package school.javacore.testing.project;

public class Order {
    private static int count = 1;

    private int id;
    private String productName;
    private int quantity;
    private double unitPrice;

    public Order(String productName, int quantity, double unitPrice) {
        this.id = count;
        this.productName = productName;
        this.quantity = Math.max(quantity, 0);
        this.unitPrice = Math.max(unitPrice, 0);

        count++;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getTotalPrice() {
        return this.quantity * this.unitPrice;
    }
}
