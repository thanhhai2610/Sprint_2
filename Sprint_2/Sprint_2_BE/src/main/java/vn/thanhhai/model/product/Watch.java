package vn.thanhhai.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import vn.thanhhai.model.order.ProductOrderDetail;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Watch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String faceDiameter;
    private String waterproof;
    private String faceMaterial;
    private String strapSize;
    private String wireMaterial;
    private String shellMaterial;
    private String designs;
    private String warranty;

    private String registerDay;
    private String description;
    private Double price;
    private Integer quantity;
    private String avatar;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonManagedReference
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @JsonManagedReference
    private Brand brand;

    @Column(columnDefinition = "boolean default true")
    private Boolean deleteStatus;

    @JsonBackReference
    @OneToMany(mappedBy = "watch")
    private Set<ImgUrlProduct> imgUrlProducts;

    @JsonBackReference
    @OneToMany(mappedBy = "watch")
    private Set<ProductOrderDetail> productOrderDetails;

    public Watch() {
    }

    public Watch(Integer id, String name, String faceDiameter, String waterproof, String faceMaterial, String strapSize, String wireMaterial, String shellMaterial, String designs, String warranty, String registerDay, String description, Double price, Integer quantity, String avatar, Category category, Brand brand, Boolean deleteStatus, Set<ImgUrlProduct> imgUrlProducts, Set<ProductOrderDetail> productOrderDetails) {
        this.id = id;
        this.name = name;
        this.faceDiameter = faceDiameter;
        this.waterproof = waterproof;
        this.faceMaterial = faceMaterial;
        this.strapSize = strapSize;
        this.wireMaterial = wireMaterial;
        this.shellMaterial = shellMaterial;
        this.designs = designs;
        this.warranty = warranty;
        this.registerDay = registerDay;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.avatar = avatar;
        this.category = category;
        this.brand = brand;
        this.deleteStatus = deleteStatus;
        this.imgUrlProducts = imgUrlProducts;
        this.productOrderDetails = productOrderDetails;
    }

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

    public String getFaceDiameter() {
        return faceDiameter;
    }

    public void setFaceDiameter(String faceDiameter) {
        this.faceDiameter = faceDiameter;
    }

    public String getWaterproof() {
        return waterproof;
    }

    public void setWaterproof(String waterproof) {
        this.waterproof = waterproof;
    }

    public String getFaceMaterial() {
        return faceMaterial;
    }

    public void setFaceMaterial(String faceMaterial) {
        this.faceMaterial = faceMaterial;
    }

    public String getStrapSize() {
        return strapSize;
    }

    public void setStrapSize(String strapSize) {
        this.strapSize = strapSize;
    }

    public String getWireMaterial() {
        return wireMaterial;
    }

    public void setWireMaterial(String wireMaterial) {
        this.wireMaterial = wireMaterial;
    }

    public String getShellMaterial() {
        return shellMaterial;
    }

    public void setShellMaterial(String shellMaterial) {
        this.shellMaterial = shellMaterial;
    }

    public String getDesigns() {
        return designs;
    }

    public void setDesigns(String designs) {
        this.designs = designs;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getRegisterDay() {
        return registerDay;
    }

    public void setRegisterDay(String registerDay) {
        this.registerDay = registerDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Set<ImgUrlProduct> getImgUrlProducts() {
        return imgUrlProducts;
    }

    public void setImgUrlProducts(Set<ImgUrlProduct> imgUrlProducts) {
        this.imgUrlProducts = imgUrlProducts;
    }

    public Set<ProductOrderDetail> getProductOrderDetails() {
        return productOrderDetails;
    }

    public void setProductOrderDetails(Set<ProductOrderDetail> productOrderDetails) {
        this.productOrderDetails = productOrderDetails;
    }
}
