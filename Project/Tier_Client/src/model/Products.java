package model;

import java.io.Serializable;
import java.util.Date;

public class Products implements Serializable {

    private static final long serialVersionUID = 1L;

    //Primary Key
    private Long id;
    private String name;
    private Double price;
    private Date arrival_date;
    private String manufacturer;
    private Integer quantity;

    public Products() {
    }

    public Products(Long id) {
        this.id = id;
    }

    public Products(Long id, String name, Double price, Date arrival_date, String manufacturer, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.arrival_date = arrival_date;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product ==> {" + "id=" + id + ", name=" + name + ", price=$" + price + ", arrival_date=" + arrival_date + ", manufacturer=" + manufacturer + ", quantity=" + quantity + " units" + '}';
    }
}
