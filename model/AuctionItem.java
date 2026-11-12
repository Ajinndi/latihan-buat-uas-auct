package model;

public abstract class AuctionItem {
    private String name;
    private double totalPrice;
    private int totalQuantity;
    private Category category;

    public AuctionItem(String name, double totalPrice, int totalQuantity, Category category) {
        this.name = name;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public int getTotalQuantity() {
        return totalQuantity;
    }
    public Category getCategory() {
        return category;
    }
    public double getUnitPrice() {
        return totalPrice / totalQuantity;
    }

    public abstract void displayInfo();
}