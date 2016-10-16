package kz.epam.EAuction.model.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Вит on 16.10.2016.
 */
public class Bet extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int userId;
    private int statusId;
    private int rating;
    private Date date;

    public Bet(int userId, int statusId, int rating) {
        super();
        this.userId = userId;
        this.statusId = statusId;
        this.rating = rating;
        this.date = new Date();
    }

    public Bet(int id, int userId, int statusId, int rating) {
        super(id);
        this.userId = userId;
        this.statusId = statusId;
        this.rating = rating;
        this.date = new Date();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bet)) return false;
        if (!super.equals(o)) return false;

        Bet bet = (Bet) o;

        if (userId != bet.userId) return false;
        if (statusId != bet.statusId) return false;
        if (rating != bet.rating) return false;
        return date.equals(bet.date);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + userId;
        result = 31 * result + statusId;
        result = 31 * result + rating;
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        return "Bet{" +
                "userId=" + userId +
                ", statusId=" + statusId +
                ", rating=" + rating +
                ", date=" + format.format(date) +
                '}';
    }
}
