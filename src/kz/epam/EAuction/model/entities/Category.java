package kz.epam.EAuction.model.entities;

import java.io.Serializable;

/**
 * Created by Вит on 28.09.2016.
 */
public class Category extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String category;
    public Category(){
        super();
    }
    public Category(int id){
        super(id);
    }
    public Category(int id, String category){
        super(id);
        this.category = category;
    }
    public Category(String category){
        super();
        this.category = category;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(){
        this.category = category;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((category == null) ? 0 : category.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Category other = (Category) obj;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return super.getId() + "::" + category;
    }

}
