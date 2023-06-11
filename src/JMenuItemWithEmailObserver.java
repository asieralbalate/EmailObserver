/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JMenuItem;

public class JMenuItemWithEmailObserver extends JMenuItem implements EmailObserver {

    public JMenuItemWithEmailObserver(String title) {
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
