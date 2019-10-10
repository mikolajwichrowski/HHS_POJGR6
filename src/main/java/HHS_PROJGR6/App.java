package HHS_PROJGR6;

import javax.swing.*;
import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

/**
 * App class
 * 
 * Used as the application entry class. This class is part of the main only its
 * a bit neater because instead of running the application from a method we run
 * it from an object.
 */
public class App extends JFrame {

    /**
     * Generated serial id
     */
    private static final long serialVersionUID = -2280803615953081532L;

    private JTextField timeDisplay;

    public App() {
        // Set dimensions, create canvas and hotel
        Hotel myHotel = new Hotel();

        // Init entities
        myHotel.init();

        Dimension d = new Dimension(getPixelResolution() * (myHotel.getHighestPositions()[0] + 4), getPixelResolution() * (myHotel.getHighestPositions()[1] + 5));
        Canvas canvas = new Canvas(d);

        myHotel.setHotelCanvas(canvas);

        // Adding components to the JFrame
        add(myHotel.getHotelCanvas());

        // Options for the JFrame
        setTitle("HotelSimulatie GR6");
        setResizable(true);
        setSize(d);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(350,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);

        // Start frames
        myHotel.frame();


    }

    /**
     * Main runs the application
     * 
     * @param args
     */
    public static void main(String[] args) {
        new App();
    }
}
