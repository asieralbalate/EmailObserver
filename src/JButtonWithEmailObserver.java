
import javax.swing.JButton;


public class JButtonWithEmailObserver extends JButton implements EmailObserver {

    public JButtonWithEmailObserver(String title) {
        super(title);
    }
    
    @Override
    public void validEmail() {
        setEnabled(true);
    }

    @Override
    public void notValidEmail() {
        setEnabled(false);
    }
    
}
