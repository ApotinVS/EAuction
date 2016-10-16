package kz.epam.EAuction.model.entities;

import java.io.Serializable;

/**
 * Created by Вит on 16.10.2016.
 */
public class Product extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int categoryId;
    private String productName;
    private String description;
    private int beginPrice;
    private int fullPrice;

    public Product(int categoryId, String productName, String description, int beginPrice, int fullPrice) {
        super();
        this.categoryId = categoryId;
        this.productName = productName;
        this.description = description;
        this.beginPrice = beginPrice;
        this.fullPrice = fullPrice;
    }

    public Product(int id, int categoryId, String productName, String description, int beginPrice, int fullPrice) {
        super(id);
        this.categoryId = categoryId;
        this.productName = productName;
        this.description = description;
        this.beginPrice = beginPrice;
        this.fullPrice = fullPrice;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBeginPrice() {
        return beginPrice;
    }

    public void setBeginPrice(int beginPrice) {
        this.beginPrice = beginPrice;
    }

    public int getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(int fullPrice) {
        this.fullPrice = fullPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (categoryId != product.categoryId) return false;
        if (beginPrice != product.beginPrice) return false;
        if (fullPrice != product.fullPrice) return false;
        if (!productName.equals(product.productName)) return false;
        return description.equals(product.description);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + categoryId;
        result = 31 * result + productName.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + beginPrice;
        result = 31 * result + fullPrice;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "categoryId=" + categoryId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", beginPrice=" + beginPrice +
                ", fullPrice=" + fullPrice +
                '}';
    }
}
