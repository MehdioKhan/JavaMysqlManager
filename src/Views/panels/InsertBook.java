
package Views.panels;
import Controller.Database;
import Exceptions.ExceptionHandler;
import Views.Page;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class InsertBook extends JPanel{
    public static JFrame frame ;
    private final JLabel titleLable ;
    private JTextField titleField ;
    private final JLabel authorIDLable ;
    private JTextField authorIDField ;
    private final JLabel translatorIDLable ;
    private JTextField translatorIDField ;
    private final JLabel categoryIDLable ;
    private JTextField categoryIDField ;
    private final JLabel publishedYearLabel;
    private JTextField publishedYearField;
    private final JButton insertButton ;
    private final JButton closeButton ;
    private ExceptionHandler eh;
    public InsertBook(JFrame frm,Database db) throws ClassNotFoundException{
        
        setLayout(new GridLayout(7,2,20,20));
        InsertAuthor.frame = frm ;
	titleLable = new JLabel("  Title :");
	add(titleLable);
	titleField = new JTextField(100);
	add(titleField);
	authorIDLable = new JLabel("  Author ID :");
	add(authorIDLable);
	authorIDField = new JTextField(100);
	add(authorIDField);
        translatorIDLable = new JLabel("  Translator ID :");
	add(translatorIDLable);
	translatorIDField = new JTextField(100);
	add(translatorIDField);
        categoryIDLable = new JLabel("  Category ID :");
	add(categoryIDLable);
	categoryIDField = new JTextField(100);
	add(categoryIDField);
        publishedYearLabel = new JLabel("  Published Date  ");
        add(publishedYearLabel);
        publishedYearField = new JTextField(4);
        add(publishedYearField);
        insertButton = new JButton("Insert");
        add(insertButton);
        closeButton = new JButton("Close");
        add(closeButton);
        eh = new ExceptionHandler();
        closeButton.addActionListener((ActionEvent ae) -> {
            try {
                InsertAuthor.frame = new Views.Frame(frm, Page.Show, db);
      
            } catch (Exception ex) {
                eh.setText(ex.getMessage());
                eh.show();
            }
        });
        
        insertButton.addActionListener((ActionEvent ae) -> {
            try {
                db.insertBook(titleField.getText(),
                        Integer.parseInt(authorIDField.getText()),
                        Integer.parseInt(translatorIDField.getText()),
                        Integer.parseInt(categoryIDField.getText()),
                        publishedYearField.getText());
                titleField.setText("");
                authorIDField.setText("");
                translatorIDField.setText("");
                categoryIDField.setText("");
                publishedYearField.setText("");
                eh.setText("Operation Successfull.");
                eh.show();
                
            } catch (NumberFormatException ex){
                eh.setText("IDs Must be number.");
                eh.show();
            } catch(Exception ex){
                eh.setText(ex.getMessage());
                eh.show();
            }
        });

    }
}