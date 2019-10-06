package HHS_PROJGR6;

import HHS_PROJGR6.Utils.Statistics;

import javax.swing.*;
import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

/**
 * App class
 * 
 * Used as the application entry class. This class is part of the main only its
 * a bit neater because insteat of running the application from a method we run
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

            Menu menu = new Menu();
            menu.setVisible(true);

        Statistics statistics = new Statistics();
        statistics.setVisible(true);

        // Init hotel rooms
        myHotel.initRooms();

        Dimension d = new Dimension(getPixelResolution() * (myHotel.getHighestPositions()[0] + 4), getPixelResolution()* (myHotel.getHighestPositions()[1] + 5));
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
