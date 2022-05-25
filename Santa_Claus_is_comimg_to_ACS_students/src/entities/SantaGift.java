package entities;

import enums.Category;

public class SantaGift extends Gift{
    private int quantity;

    public SantaGift() { }

    public SantaGift(String productName, Double price, Category category, int quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public void decreaseQuantity() {
        this.quantity -= 1;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{"
                +
                "productName='" + productName + '\''
                +
                ", price=" + price
                +
                ", category=" + category
                +
                ", quantity=" + quantity
                +
                '}';
    }
}
