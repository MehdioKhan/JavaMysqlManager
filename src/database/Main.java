
package database;

import Controller.Database;
import Views.Frame;
import Views.Page;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        Database db = new Database();
        JFrame frm = new JFrame();
        try {
            Frame main = new Frame(frm, Page.Connection, db);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
