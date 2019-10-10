package HHS_PROJGR6;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

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
        // Fix because windows and mac do stuff diferently
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {

        }

        // Set dimensions, create canvas and hotel
        Hotel myHotel = new Hotel();

        // Init entities
        myHotel.init();

        Dimension d = new Dimension(getPixelResolution() * (myHotel.getHighestPositions()[0] + 4), getPixelResolution() * (myHotel.getHighestPositions()[1] + 5));
        Canvas canvas = new Canvas(d);

        JPanel p = new JPanel();
        p.setBounds(10,500,200,400);

        JLabel groen = new JLabel("Groen = Kamer is schoon");
        groen.setForeground(Color.GREEN);
        JLabel oranje = new JLabel("Oranje = Kamer wordt schoongemaakt");
        oranje.setForeground(Color.ORANGE);
        JLabel red = new JLabel("Rood = Kamer vies");
        red.setForeground(Color.RED);
        JLabel menu = new JLabel("M = menu");
        JLabel settings = new JLabel("S = Settings");

        p.add(groen);
        p.add(oranje);
        p.add(red);
        p.add(menu);
        p.add(settings);

        groen.setPreferredSize(new Dimension(200,15));
        oranje.setPreferredSize(new Dimension(200,15));
        red.setPreferredSize(new Dimension(200,15));
        menu.setPreferredSize(new Dimension(200,15));
        settings.setPreferredSize(new Dimension(200,15));

        myHotel.setHotelCanvas(canvas);

        // Adding components to the JFrame
        add(myHotel.getHotelCanvas());
        add(p);




        // Options for the JFrame
        setTitle("HotelSimulatie GR6");
        setResizable(true);
        setSize(d);
        getContentPane().setBackground(new Color(245, 245, 240));
        setLayout(null);
        setLocation(350, 0);
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
