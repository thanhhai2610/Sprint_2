package vn.thanhhai.dto;

public class ProductSearchDto {
    private String name;
    private String categoryID;
    private String rangePrice;
    private String productAuctionStatus;

    public ProductSearchDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getRangePrice() {
        return rangePrice;
    }

    public void setRangePrice(String rangePrice) {
        this.rangePrice = rangePrice;
    }

    public String getProductAuctionStatus() {
        return productAuctionStatus;
    }

    public void setProductAuctionStatus(String productAuctionStatus) {
        this.productAuctionStatus = productAuctionStatus;
    }
}
