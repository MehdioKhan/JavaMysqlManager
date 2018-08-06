
package Controller;
import Models.Author;
import Models.Book;
import Models.Category;
import Models.Translator;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Database {
    private Connection con = null;
    private Properties properties;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsmd;

    public boolean isConnected(){
        return con != null;
    }
    public void connect() throws ClassNotFoundException, SQLException{
        if(con == null){
            Class.forName("com.mysql.jdbc.Driver");
            properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "");
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect", "true");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop",properties);
        }
    }
    public void insertAuthor(String fName, String lName) 
            throws SQLException{
        String q = "INSERT INTO author (fName,lName) VALUES (?,?)";
        ps = con.prepareStatement(q);
        ps.setString(1, fName);
        ps.setString(2, lName);
        ps.executeUpdate();
    }
    public void insertCategory(String description) 
            throws SQLException{
        String q = "INSERT INTO category (description) VALUES (?)";
        ps = con.prepareStatement(q);
        ps.setString(1, description);
        ps.executeUpdate();
    }
    public void insertTranslator(String fName, String lName) 
            throws SQLException{
        String q = "INSERT INTO translator (fName,lName) VALUES (?,?)";
        ps = con.prepareStatement(q);
        ps.setString(1, fName);
        ps.setString(2, lName);
        ps.executeUpdate();
    }
    public void insertBook(String title, int authorID,
            int translatorID, int categoryID, String publishedYear) 
            throws SQLException{
        String q = "INSERT INTO book (title,authorID,translatorID,categoryID,"
                + "publishedYear) VALUES (?,?,?,?,?)";
        ps = con.prepareStatement(q);
        ps.setString(1, title);
        ps.setInt(2, authorID);
        ps.setInt(3, translatorID);
        ps.setInt(4, categoryID);
        ps.setString(5, publishedYear);
        ps.executeUpdate();
    }
    
    public ArrayList<Author> getAuthor() throws SQLException{
        String q = "Select * From author";
        ArrayList<Author> authors = new ArrayList<>();
        stmt = con.createStatement();
        rs = stmt.executeQuery(q);
        while(rs.next())
            authors.add(new Author(rs.getInt(1),rs.getString(2),rs.getString(3)));
        return authors;
    }
    
    public ArrayList<Translator> getTranslator() throws SQLException{
        String q = "Select * From translator";
        ArrayList<Translator> translators = new ArrayList<>();
        stmt = con.createStatement();
        rs = stmt.executeQuery(q);
        while(rs.next())
            translators.add(new Translator(rs.getInt(1),rs.getString(2),rs.getString(3)));
        return translators;
    }
    
    public ArrayList<Category> getCategory() throws SQLException{
        String q = "Select * From category";
        ArrayList<Category> categories = new ArrayList<>();
        stmt = con.createStatement();
        rs = stmt.executeQuery(q);
        while(rs.next())
            categories.add(new Category(rs.getInt(1),rs.getString(2)));
        return categories;
    }
    
    public ArrayList<Book> getBook() throws SQLException{
        String q = "Select * From book";
        ArrayList<Book> books = new ArrayList<>();
        stmt = con.createStatement();
        rs = stmt.executeQuery(q);
        while(rs.next())
            books.add(new Book(rs.getInt(1),rs.getString(2),rs.getInt(3),
                    rs.getInt(4),rs.getInt(5),rs.getString(6)));
        return books;
    }
    
    public ArrayList<String> getTables() throws SQLException{
        String q = "select TABLE_NAME from information_schema.tables where"
                + " TABLE_SCHEMA like 'bookshop' and TABLE_TYPE like"
                + " 'BASE TABLE'";
        ArrayList<String> tables = new ArrayList<>();
        stmt = con.createStatement();
        rs = stmt.executeQuery(q);
        while(rs.next())
            tables.add(rs.getString(1));
        return tables;
    }

    public void delete(String table, int id) throws SQLException{
        String q = "DELETE FROM "+table+" WHERE "+table.concat("ID")+" = ?";
        ps = con.prepareStatement(q);
        ps.setInt(1,id);
        ps.executeUpdate();
    }
    
    public void update(String table, String columnChange,String value, int id) throws SQLException{
        String q = "UPDATE "+table+" SET "+columnChange+"='"+value+"' WHERE "+table.concat("ID")+" = ?;";
        ps = con.prepareStatement(q);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    public void close() throws SQLException{
        con.close();
    }
    
}
