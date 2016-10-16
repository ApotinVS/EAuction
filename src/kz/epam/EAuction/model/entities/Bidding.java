package kz.epam.EAuction.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Вит on 16.10.2016.
 */
public class Bidding implements Serializable {
    private static final long serialVersionUID = 1L;
    private int productId;
    private List<Integer> betId;
    private Date dateBegin;
    private Date dateDead;

    public Bidding(int productId, int betId, Date dateDead) {
        this.productId = productId;
        this.betId.add(betId);
        this.dateBegin = new Date();
        this.dateDead = dateDead;
    }

    public Date getDateDead() {
        return dateDead;
    }

    public void setDateDead(Date dateDead) {
        this.dateDead = dateDead;
    }

    public List<Integer> getBetId() {
        return betId;
    }

    public void setBetId(List<Integer> betId) {
        this.betId = betId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bidding)) return false;

        Bidding bidding = (Bidding) o;

        if (productId != bidding.productId) return false;
        if (!dateBegin.equals(bidding.dateBegin)) return false;
        if (!dateDead.equals(bidding.dateDead)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + dateBegin.hashCode();
        result = 31 * result + dateDead.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Bidding{" +
                "productId=" + productId +
                ", betId=" + betId +
                ", dateBegin=" + dateBegin +
                ", dateDead=" + dateDead +
                '}';
    }
}
