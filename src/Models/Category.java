
package Models;

public class Category {
    private int categoryID;
    private String description;

    public Category(int categoryID, String description) {
        this.categoryID = categoryID;
        this.description = description;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
