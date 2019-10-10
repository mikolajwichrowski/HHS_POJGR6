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

        Dimension d = new Dimension(getPixelResolution() * (myHotel.getHighestPositions()[0] + 4), getPixelResolution() * (myHotel.getHighestPositions()[1] + 5) - 100);
        Canvas canvas = new Canvas(d);

        // Change size of window for legenda
        d = new Dimension(getPixelResolution() * (myHotel.getHighestPositions()[0] + 4), getPixelResolution() * (myHotel.getHighestPositions()[1] + 5) + 300);

        // Add canvas to hotel
        myHotel.setHotelCanvas(canvas);

        JPanel p = new JPanel();
        p.setFont(new Font("Calabri", Font.ITALIC, 20));
        p.setBackground(new Color(245, 245, 240));
        p.setBounds(10, 600, getPixelResolution() * (myHotel.getHighestPositions()[0] + 4), 200);
        p.setLayout(new FlowLayout());

        JLabel info = new JLabel("Groen = Kamer is schoon \n", JLabel.LEFT);
        info.setPreferredSize(new Dimension(getPixelResolution() * (myHotel.getHighestPositions()[0] + 4), 20));

        info.setForeground(Color.GREEN);
        p.add(info);

        info.setText("Oranje = Kamer wordt schoongemaakt \n");
        info.setForeground(Color.ORANGE);
        p.add(info);

        info.setText("Rood = Kamer vies \n");
        info.setForeground(Color.RED);
        p.add(info);

        info.setText("M = menu \n");
        p.add(info);

        info.setText("S = Settings \n");
        p.add(info);

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
