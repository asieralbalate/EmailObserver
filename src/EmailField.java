
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 
 */
public class EmailField extends JTextField {

    private List<EmailObserver> observers;

    public EmailField() {
        super();
        observers = new ArrayList<EmailObserver>();
        
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                notifyAllObservers(checkEmail(getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                notifyAllObservers(checkEmail(getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                notifyAllObservers(checkEmail(getText()));
            }
        });
    }

    public void addObserver(EmailObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(EmailObserver observer) {
        observers.remove(observer);
    }

    public static boolean checkEmail(String s) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return s.matches(regex);
    }
    
    public void notifyAllObservers(Boolean valid) {
        for(EmailObserver observer : observers) {
            if (valid) {
                observer.validEmail();
            } else {
                observer.notValidEmail();
           }
        }
    }

}
