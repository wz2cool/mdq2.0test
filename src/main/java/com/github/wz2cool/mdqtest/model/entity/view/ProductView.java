package com.github.wz2cool.mdqtest.model.entity.view;

import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Frank
 * \* Date: 8/15/2017
 * \* Time: 11:00 AM
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ProductView {
    @Column(name = "product_id", table = "product")
    private Long productId;
    @Column(name = "name", table = "product")
    private String productName;
    @Column(name = "price", table = "product")
    private BigDecimal price;

    @Column(name = "category_id", table = "category")
    private Long categoryId;
    @Column(name = "name", table = "category")
    private String categoryName;
    @Column(name = "description", table = "category")
    private String description;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}