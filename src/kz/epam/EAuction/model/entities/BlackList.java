package kz.epam.EAuction.model.entities;

import java.io.Serializable;

/**
 * Created by Вит on 16.10.2016.
 */
public class BlackList extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int userId;

    public BlackList() {
        super();
    }

    public BlackList(int id) {
        super(id);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlackList)) return false;
        if (!super.equals(o)) return false;

        BlackList blackList = (BlackList) o;

        return userId == blackList.userId;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + userId;
        return result;
    }

    @Override
    public String toString() {
        return "BlackList{" +
                "userId=" + userId +
                '}';
    }
}
