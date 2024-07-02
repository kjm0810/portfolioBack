package com.my.shoppingmall.dto;

public class ProductDto {
    private String ProductName;
    private Long ProductIdx; // int -> Long으로 변경
    private String ProductExp;
    private int ProductPrice;
    private String ProductRegistDate; // Date 대신 String으로 변경, YYYYMMDD 형식
    private int ProductCategoryIdx;
    private boolean ProductShow;
    private String ProductImg;

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public Long getProductIdx() {
        return ProductIdx;
    }

    public void setProductIdx(Long productIdx) {
        ProductIdx = productIdx;
    }

    public String getProductExp() {
        return ProductExp;
    }

    public void setProductExp(String productExp) {
        ProductExp = productExp;
    }

    public int getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(int productPrice) {
        ProductPrice = productPrice;
    }

    public String getProductRegistDate() {
        return ProductRegistDate;
    }

    public void setProductRegistDate(String productRegistDate) {
        ProductRegistDate = productRegistDate;
    }

    public int getProductCategoryIdx() {
        return ProductCategoryIdx;
    }

    public void setProductCategoryIdx(int productCategoryIdx) {
        ProductCategoryIdx = productCategoryIdx;
    }

    public boolean isProductShow() {
        return ProductShow;
    }

    public void setProductShow(boolean productShow) {
        ProductShow = productShow;
    }

    public String getProductImg() {
        return ProductImg;
    }

    public void setProductImg(String productImg) {
        this.ProductImg = productImg;
    }
}
