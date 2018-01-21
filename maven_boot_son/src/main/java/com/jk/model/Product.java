package com.jk.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Product implements Serializable{
	
    private static final long serialVersionUID = -2859483893010697222L;

	private Integer productid;

    private String productname;

    private Integer productbrand;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date producttime;

    private Double productprice;

    private Integer producttype;

    private String productphotoid;

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public Integer getProductbrand() {
        return productbrand;
    }

    public void setProductbrand(Integer productbrand) {
        this.productbrand = productbrand;
    }

    public Date getProducttime() {
        return producttime;
    }

    public void setProducttime(Date producttime) {
        this.producttime = producttime;
    }

    public Double getProductprice() {
        return productprice;
    }

    public void setProductprice(Double productprice) {
        this.productprice = productprice;
    }

    public Integer getProducttype() {
        return producttype;
    }

    public void setProducttype(Integer producttype) {
        this.producttype = producttype;
    }

    public String getProductphotoid() {
        return productphotoid;
    }

    public void setProductphotoid(String productphotoid) {
        this.productphotoid = productphotoid == null ? null : productphotoid.trim();
    }
}