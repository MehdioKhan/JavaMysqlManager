
package Views;

import Controller.Database;
import Exceptions.ExceptionHandler;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Views.panels.*;
import java.sql.SQLException;

public class Frame extends JFrame {

    private static final long serialVersionUID = 1L;
    private Object Views;
    private ExceptionHandler eh;
    
    public Frame(JFrame frame, Page page,Database db) throws SQLException {
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        eh = new ExceptionHandler();
	try {
            if (page == Page.Connection) {
		frame.dispose();
		JPanel panel = new Connection(this, db);
		add(panel);
		setSize(300, 250);
		setTitle("Connection");
            } else if (page == Page.Show) {
		frame.dispose();
		JPanel panel = new Show(this, db);
		add(panel);
		setSize(600, 550);
		setTitle("Show Data");
            } else if(page == Page.InsertAuthor) {
		frame.dispose();
		JPanel panel = new InsertAuthor(this,db);
		add(panel);
		setSize(300, 250);
		setTitle("Insert Author");
            } else if(page == Page.InsertTranslator) {
		frame.dispose();
		JPanel panel = new InsertTranslator(this,db);
		add(panel);
		setSize(300, 250);
		setTitle("Insert Translator");
            }else if(page == Page.InsertBook) {
		frame.dispose();
		JPanel panel = new InsertBook(this,db);
		add(panel);
		setSize(500, 450);
		setTitle("Insert Book");
            }else if(page == Page.InsertCategory) {
		frame.dispose();
		JPanel panel = new InsertCategory(this,db);
		add(panel);
		setSize(300, 250);
		setTitle("Insert Category");
            }
            frame.pack();
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            setVisible(true);
            setLocationRelativeTo(null);
            setResizable(false);
    
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            eh.setText(e.getMessage());
            eh.show();
        }
    }
}