package model;

import java.io.Serializable;
import java.util.Date;

public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;

    //Primary Key
    private Long id;
    private Date sale_date;
    private Double total_amount;
    private Integer number_product;
    //Foreign Key
    private Long product_id;

    public Sales() {
    }

    public Sales(Long id) {
        this.id = id;
    }

    public Sales(Long id, Long product_id) {
        this.id = id;
        this.product_id = product_id;
    }

    public Sales(Long id, Date sale_date, Double total_amount, Integer number_product, Long product_id) {
        this.id = id;
        this.sale_date = sale_date;
        this.total_amount = total_amount;
        this.number_product = number_product;
        this.product_id = product_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSale_date() {
        return sale_date;
    }

    public void setSale_date(Date sale_date) {
        this.sale_date = sale_date;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public Integer getNumber_product() {
        return number_product;
    }

    public void setNumber_product(Integer number_product) {
        this.number_product = number_product;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

}
