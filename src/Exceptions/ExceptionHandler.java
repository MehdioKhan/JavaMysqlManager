
package Exceptions;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ExceptionHandler {
    private final JTextArea exception;
    private final JScrollPane scrollPane;

    public ExceptionHandler() {
        this.exception = new JTextArea();
        this.exception.setLineWrap(true);
        this.exception.setWrapStyleWord(true);
        this.exception.setRows(5);
        this.scrollPane = new JScrollPane(exception);
    }
    
    public void setText(String message) {
        this.exception.setText(message);
    }
    
    public void show(){
        JOptionPane.showMessageDialog(null, this.scrollPane);
    }
}
