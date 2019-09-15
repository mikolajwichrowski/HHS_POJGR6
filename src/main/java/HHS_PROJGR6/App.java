package HHS_PROJGR6;

import java.awt.Dimension;
import javax.swing.*;  

public class App extends JFrame {
    /**
     * Generated serial id
     */
    private static final long serialVersionUID = -2280803615953081532L;

    public App() {
        // Set dimensions and add canvas to draw the hotel on
        Dimension d = new Dimension(900, 750);
        Hotel myHotel = new Hotel(new Canvas(d));
        add(myHotel.hotelCanvas);


        // Add buttons and add dimension to window to fit buttons
        d.width += 200;

        JButton buttonPlus = new JButton("HTE +");
        buttonPlus.setBounds(510, 50,100, 40);

        JButton buttonMinus = new JButton("HTE -");
        buttonMinus.setBounds(510, 100,100, 40);
 
        add(buttonMinus);
        add(buttonPlus);

        // Show window
        setTitle("HotelSimulatie GR6");
        setLayout(null);
        setResizable(false);
        setSize(d);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run Application
        // Show buttons
        // new Canvas();    
        new App();
    }
}




