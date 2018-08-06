
package Views.panels;
import Controller.Database;
import Exceptions.ExceptionHandler;
import Views.Page;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class InsertCategory extends JPanel{
    public static JFrame frame ;
    private final JLabel descriptionLable ;
    private JTextField descriptionField ;
    private final JButton insertButton ;
    private final JButton closeButton ;
    private ExceptionHandler eh;

    public InsertCategory(JFrame frm,Database db) throws ClassNotFoundException{
             
        setLayout(new GridLayout(3,2,20,20));
        InsertAuthor.frame = frm ;
	descriptionLable = new JLabel("  Description :");
	add(descriptionLable);
	descriptionField = new JTextField(100);
	add(descriptionField);
        insertButton = new JButton("Insert");
        add(insertButton);
        closeButton = new JButton("Close");
        add(closeButton);
        eh = new ExceptionHandler();
        
        closeButton.addActionListener((ActionEvent ae) -> {
            try {
                InsertCategory.frame = new Views.Frame(frm, Page.Show, db);
            } catch (Exception ex) {
                eh.setText(ex.getMessage());
                eh.show();           
            }
        });
        
        insertButton.addActionListener((ActionEvent ae) -> {
            try {
                db.insertCategory(descriptionField.getText());
                descriptionField.setText("");
                eh.setText("Operation Successfull.");
                eh.show();
                
            } catch (Exception ex) {
                eh.setText(ex.getMessage());
                eh.show();
            
            }
        });

    }
}