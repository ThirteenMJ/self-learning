package com.msb.bean;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * @author: thirteenmj
 * @date: 2022-07-23 19:38
 */
public class SearchPojo implements Serializable {

    private static final long serialVersionUID = 6691449325351022941L;

    @Field
    private Integer id;

    @Field
    private String name;

    @Field
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
