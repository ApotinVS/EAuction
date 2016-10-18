package kz.epam.EAuction.model.entities;

import java.io.Serializable;

/**
 * Created by Вит on 16.10.2016.
 */
public class BlackList extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int userId;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlackList)) return false;
        if (!super.equals(o)) return false;

        BlackList blackList = (BlackList) o;

        if (userId != blackList.userId) return false;
        return description.equals(blackList.description);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + userId;
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BlackList{" +
                "userId=" + userId +
                ", description='" + description + '\'' +
                '}';
    }
}
