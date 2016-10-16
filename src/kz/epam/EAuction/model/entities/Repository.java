package kz.epam.EAuction.model.entities;

import java.io.Serializable;

/**
 * Created by Вит on 16.10.2016.
 */
public class Repository extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int productId;

    public Repository(int productId) {
        super();
        this.productId = productId;
    }

    public Repository(int id, int productId) {
        super(id);
        this.productId = productId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Repository)) return false;
        if (!super.equals(o)) return false;

        Repository that = (Repository) o;

        return productId == that.productId;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + productId;
        return result;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "productId=" + productId +
                '}';
    }
}
