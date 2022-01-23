package entities;

import enums.Category;

public class Gift {
    protected String productName;
    protected Double price;
    protected Category category;

    public Gift() { }

    public Gift(String productName, Double price, Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public Gift(SantaGift santaGift) {
        this.productName = santaGift.getProductName();
        this.price = santaGift.getPrice();
        this.category = santaGift.getCategory();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
