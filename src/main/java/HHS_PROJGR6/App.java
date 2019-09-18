package HHS_PROJGR6;

import javax.swing.*;

import HHS_PROJGR6.External.HotelEventManager;

import java.awt.*;

/**
 * App class
 * 
 * Used as the application entry class. 
 * This class is part of the main only its a bit neater because insteat of running the application from a method
 * we run it from an object.
 */
public class App extends JFrame {
    /**
     * Generated serial id
     */
    private static final long serialVersionUID = -2280803615953081532L;

    /**
     * Constructor
     */
    public App() {
        // Set dimensions and add canvas to draw the hotel on
        Dimension d = new Dimension(1400, 800);
        Hotel myHotel = new Hotel(
            new Canvas(d)
        );

        // Add canvas to JPanel
        add(myHotel.hotelCanvas);

        // Add buttons and add dimension to window to fit buttons
        d.width += 200;

        // Button add tempo definition
        JButton buttonPlus = new JButton("Hotel TijdsEenheid +");
        buttonPlus.setBounds(1175, 50,175, 80);
        buttonPlus.setBackground(Color.DARK_GRAY);
        buttonPlus.setForeground(Color.WHITE);

        // Button decrease definition
        JButton buttonMinus = new JButton("Hotel TijdsEenheid -");
        buttonMinus.setBounds(1175, 150,175, 80);
        buttonMinus.setBackground(Color.DARK_GRAY);
        buttonMinus.setForeground(Color.WHITE);

        // TODO: add input box for HTE

        // Adds buttons
        add(buttonPlus);
        add(buttonMinus);

        // Shows window with title and other parameters
        setTitle("HotelSimulatie GR6");
        setLayout(null);
        setResizable(true);
        setSize(d);
        setLayout(null);
        super.setLocationRelativeTo(null);
        setVisible(true);

        // Start Events thread
        HotelEventManager eventManager = new HotelEventManager();
        eventManager.register(myHotel);
        eventManager.changeSpeed(2);
        new Thread(eventManager).start();
    }

    /**
     * Application entry point
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Run Application
        // Show buttons
        // new Canvas();
        new App();
        // new Clock();
    }
}