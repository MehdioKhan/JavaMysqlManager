
package Views.panels;
import Controller.Database;
import Exceptions.ExceptionHandler;
import Views.Page;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class InsertTranslator extends JPanel{
    public static JFrame frame ;
    private final JLabel firstNameLable ;
    private JTextField firstNameField ;
    private final JLabel lastNameLable ;
    private JTextField lastNameField ;
    private final JButton insertButton ;
    private final JButton closeButton ;
    private ExceptionHandler eh;

    public InsertTranslator(JFrame frm,Database db) throws ClassNotFoundException{
        
        setLayout(new GridLayout(5,2,20,20));
        InsertAuthor.frame = frm ;
	firstNameLable = new JLabel("  First Name :");
	add(firstNameLable);
	firstNameField = new JTextField(100);
	add(firstNameField);
	lastNameLable = new JLabel("  Last Name :");
	add(lastNameLable);
	lastNameField = new JTextField(100);
	add(lastNameField);
        insertButton = new JButton("Insert");
        add(insertButton);
        closeButton = new JButton("Close");
        add(closeButton);
	eh = new ExceptionHandler();
        
        closeButton.addActionListener((ActionEvent ae) -> {
            try {
                InsertTranslator.frame = new Views.Frame(frm, Page.Show, db);
                
            } catch (Exception ex) {
                eh.setText(ex.getMessage());
                eh.show();            
            }
        });
        
        insertButton.addActionListener((ActionEvent ae) -> {
            try {
                db.insertTranslator(firstNameField.getText(),lastNameField.getText());
                firstNameField.setText("");
                lastNameField.setText("");
                eh.setText("Operation Successfull.");
                eh.show();
                
            } catch (Exception ex) {
                eh.setText(ex.getMessage());
                eh.show();
            }
        });

    }
}