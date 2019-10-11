package HHS_PROJGR6;

import javax.swing.*;
import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

/**
 * App class
 * <p>
 * Used as the application entry class. This class is part of the main only its
 * a bit neater because instead of running the application from a method we run
 * it from an object.
 */
public class App extends JFrame {

    JLabel L1, L2, L3, L4, L5;

    /**
     * Generated serial id
     */
    private static final long serialVersionUID = -2280803615953081532L;

    public App() {

        // Set dimensions, create canvas and hotel
        Hotel myHotel = new Hotel();

        // Init entities
        myHotel.init();

        Dimension d = new Dimension(getPixelResolution() * (myHotel.getHighestPositions()[0] + 4), getPixelResolution() * (myHotel.getHighestPositions()[1] + 5) - 100);
        Canvas canvas = new Canvas(d);

        // Change size of window for legenda
        d = new Dimension(getPixelResolution() * (myHotel.getHighestPositions()[0] + 4), getPixelResolution() * (myHotel.getHighestPositions()[1] + 2) + 200);

        // Add canvas to hotel
        myHotel.setHotelCanvas(canvas);

        // Add JPanel to show a little legenda unfortunately Windows and Mac show different layout
        JPanel p = new JPanel(new GridLayout(5, 1));
        p.setFont(new Font("Calabri", Font.ITALIC, 20));
        p.setBackground(new Color(245, 245, 240));
        p.setBounds(10, 510, 500, 100);


        L1 = new JLabel("Groen = Kamer is schoon", SwingConstants.LEFT);
        L1.setForeground(Color.GREEN);
        L1.setLocation(10,0);
        L2 = new JLabel("Oranje = Kamer wordt schoongemaakt");
        L2.setForeground(Color.ORANGE);
        L2.setLocation(20,0);
        L3 = new JLabel("Rood = Kamer vies");
        L3.setForeground(Color.RED);
        L4 = new JLabel("M = Menu for settings");
        L5 = new JLabel("S = Statistics");

        p.add(L1);
        p.add(L2);
        p.add(L3);
        p.add(L4);
        p.add(L5);

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
