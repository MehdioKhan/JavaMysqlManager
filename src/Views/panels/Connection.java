
package Views.panels;

import Controller.Database;
import Exceptions.ExceptionHandler;
import Views.Page;
import Views.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import static java.awt.image.ImageObserver.ABORT;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Connection extends JPanel{
    
    public static JFrame frame ;
    private final JLabel hostNameLable ;
    private final JLabel portLable ;
    private final JLabel userNameLable ;
    private final JLabel passwordLable ;
    private final JLabel dbNameLable ;
    private final JButton connectButton ;
    private final JLabel nullLable = new JLabel("");
    private final JButton exitButton ;
    private ExceptionHandler eh;
    
    public Connection(final JFrame frm, Database db) throws ClassNotFoundException{
        
        Connection.frame = frm;
        setLayout(new GridLayout(5, 1, 10, 10));
        hostNameLable = new JLabel("Host : localhost");
        add(hostNameLable);
        portLable = new JLabel("Port : 3306");
        add(portLable);
	userNameLable = new JLabel("Username : root");
	add(userNameLable);
	passwordLable = new JLabel("Password : ");
	add(passwordLable);
        dbNameLable = new JLabel("DB Name : bookshop");
        add(dbNameLable);
        add(nullLable);
	connectButton = new JButton("Connect");
	add(connectButton);
	exitButton = new JButton("Exit");
	add(exitButton);
        eh = new ExceptionHandler();
        
        exitButton.addActionListener((ActionEvent ae) -> {
            System.exit(ABORT);
        });
        
        connectButton.addActionListener((ActionEvent e) -> {
            try {
                db.connect();
                if(db.isConnected()){
                    Connection.frame = new Frame(frm,Page.Show, db);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                eh.setText(ex.getMessage());
                eh.show();
            }
        });
    }
}

