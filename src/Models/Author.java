
package Models;

public class Author {
    private String fName,lName;
    private int authorID;

    public Author(int authorID, String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        this.authorID = authorID;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }
    
}
