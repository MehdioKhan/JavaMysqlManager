
package Views.panels;

import Controller.Database;
import Exceptions.ExceptionHandler;
import Models.Author;
import Models.Book;
import Models.Category;
import Models.Translator;
import Views.Frame;
import Views.Page;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class Show extends JPanel{
    public static JFrame frame ;
    private JTable dataTable ;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JButton exitButton, refereshButton,insertButton,
            updateButton,deleteButton;
    private JRadioButton authorRadioButton, bookRadioButton,
            translatorRadioButton, categoryRadioButton;
    private ButtonGroup buttonGroup;
    private String[] header;
    private String selectedTable,columnID;
    private ExceptionHandler eh;
    
    @SuppressWarnings("empty-statement")
    public Show(JFrame frm, Database db) throws ClassNotFoundException, SQLException{

//        setLayout(new GridLayout(2,2));
        
        Show.frame = frm ;
        JPanel p = new JPanel(new GridLayout(2,2));
        tableModel = new DefaultTableModel();
        dataTable = new JTable(tableModel);
        scrollPane = new JScrollPane(dataTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        dataTable.setFillsViewportHeight(true);
        dataTable.setColumnSelectionAllowed(false);
        dataTable.getTableHeader().setReorderingAllowed(false);
        scrollPane.setSize(100, 100);
        add(scrollPane);
        buttonGroup = new ButtonGroup();
        authorRadioButton = new JRadioButton("Author");
        authorRadioButton.setSelected(true);
        buttonGroup.add(authorRadioButton);
        translatorRadioButton = new JRadioButton("Translator");
        buttonGroup.add(translatorRadioButton);
        bookRadioButton = new JRadioButton("Book");
        buttonGroup.add(bookRadioButton);
        categoryRadioButton = new JRadioButton("Category");
        buttonGroup.add(categoryRadioButton);
        p.add(authorRadioButton);
        p.add(translatorRadioButton);
        p.add(bookRadioButton);
        p.add(categoryRadioButton);
        refereshButton = new JButton("Refresh");
        p.add(refereshButton);
        insertButton = new JButton("Insert");
        p.add(insertButton);
        updateButton = new JButton("Update");
        p.add(updateButton);
        deleteButton = new JButton("Delete");
        p.add(deleteButton);
	deleteButton.setEnabled(false);
        add(p);
        eh = new ExceptionHandler();
        
        refereshButton.addActionListener((ActionEvent ae) -> {
            while(tableModel.getRowCount()!=0)
                tableModel.removeRow(0);
            
            try{
                if(authorRadioButton.isSelected()){
                    selectedTable = "author";
                    header = new String[]{"authorID", "fName", "lName"};
                    tableModel.setColumnIdentifiers(header);
                    ArrayList<Author> authors = db.getAuthor();
                    for(Author a:authors)
                        tableModel.addRow(new Object[]{a.getAuthorID(),a.getfName(),a.getlName()});
                }else if(translatorRadioButton.isSelected()){
                    selectedTable = "translator";
                    header = new String[]{"translatorID", "fName", "lName"};
                    tableModel.setColumnIdentifiers(header);
                    ArrayList<Translator> translators = db.getTranslator();
                    for(Translator a:translators)
                        tableModel.addRow(new Object[]{a.getTranslatorID(),a.getfName(),a.getlName()});
                    
                }else if(bookRadioButton.isSelected()){
                    selectedTable = "book";
                    header = new String[]{"bookID","title","authorID", "translatorID",
                        "categoryID", "publishedYear"};
                    tableModel.setColumnIdentifiers(header);
                    ArrayList<Book> books = db.getBook();
                    for(Book a:books)
                        tableModel.addRow(new Object[]{a.getBookID(),a.getTitle(),a.getAuthorID(),
                            a.getTranslatorID(),a.getCategoryID(), a.getPublishedYear()});
                    
                }else if(categoryRadioButton.isSelected()){
                    selectedTable = "category";
                    header = new String[]{"categoryID", "Description"};
                    tableModel.setColumnIdentifiers(header);
                    ArrayList<Category> cats = db.getCategory();
                    for(Category a:cats)
                        tableModel.addRow(new Object[]{a.getCategoryID(),a.getDescription()});
                }
                deleteButton.setEnabled(true);
            } catch(SQLException ex){
                
            }
        });
        
        insertButton.addActionListener((ActionEvent ae) -> {
            try {
                if(authorRadioButton.isSelected())
                    Show.frame = new Frame(frm,Page.InsertAuthor,db);
                else if(translatorRadioButton.isSelected())
                    Show.frame = new Frame(frm,Page.InsertTranslator,db);
                else if(bookRadioButton.isSelected())
                    Show.frame = new Frame(frm,Page.InsertBook,db);
                else if(categoryRadioButton.isSelected())
                    Show.frame = new Frame(frm,Page.InsertCategory,db);
            } catch (SQLException ex) {
                eh.setText(ex.getMessage());
                eh.show();
            }
        });
        
        tableModel.addTableModelListener((TableModelEvent tme) -> {
            int row = tme.getFirstRow();
            int column = tme.getColumn();
            String columnName = tableModel.getColumnName(column);
            
            if(column!=0){
                if (dataTable.isEditing()){
                    int id = (int) dataTable.getValueAt(dataTable.getSelectedRow(),0);
                        String value = (String)tableModel.getValueAt(row, column);
                        try {
                            db.update(selectedTable, columnName, value, id);
                        } catch (SQLException ex) {
                            eh.setText(ex.getMessage());
                            eh.show();
                        }
                }
            }else{
                eh.setText("ID column is not updatable.");
                eh.show();
            }
        });  
        
        deleteButton.addActionListener((ActionEvent ae) -> {
            
            int id = (int)dataTable.getValueAt(dataTable.getSelectedRow(), 0);

            try {
                db.delete(selectedTable, id);
                eh.setText("Operation Successful. Refresh the list.");
                eh.show();
            } catch (SQLException ex) {
                eh.setText(ex.getMessage());
                eh.show();
            }
        });
    }
}
