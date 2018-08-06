
package Models;

public class Book {
    private int bookID, authorID, categoryID, translatorID;
    private String title, publishedYear;

    public Book(int bookID,String title, int authorID, int translatorID,
            int categoryID,String publishedYear) {
        this.bookID = bookID;
        this.authorID = authorID;
        this.categoryID = categoryID;
        this.translatorID = translatorID;
        this.title = title;
        this.publishedYear = publishedYear;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }
    
    
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getTranslatorID() {
        return translatorID;
    }

    public void setTranslatorID(int translatorID) {
        this.translatorID = translatorID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
