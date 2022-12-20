package classes;

import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Flower {
    private String manufacturerCountry;
    private byte shelfLifeInDays;
    private enums.Color color;
    private int price;

    public Flower(String manufacturerCountry, byte shelfLifeInDays, enums.Color color, int price) {
        this.manufacturerCountry = manufacturerCountry;
        this.shelfLifeInDays = shelfLifeInDays;
        this.color = color;
        this.price = price;
    }

    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    public void setManufacturerCountry(String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }

    public byte getShelfLifeInDays() {
        return shelfLifeInDays;
    }

    public void setShelfLifeInDays(byte shelfLifeInDays) {
        this.shelfLifeInDays = shelfLifeInDays;
    }

    public enums.Color getColor() {
        return color;
    }

    public void setColor(enums.Color color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "manufacturerCountry='" + manufacturerCountry + '\'' +
                ", shelfLifeInDays=" + shelfLifeInDays +
                ", color=" + color +
                ", price=" + price +
                '}';
    }
}
