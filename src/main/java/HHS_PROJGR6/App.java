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

        // Add JPanel to show a little legenda unfortunately Windows and Mac show
        // different layout
        JPanel p = new JPanel(new GridLayout(5, 1));
        p.setFont(new Font("Calabri", Font.ITALIC, 20));
        p.setBackground(new Color(245, 245, 240));
        p.setBounds(10, 560, 500, 100);

        JLabel text = new JLabel("Groen = Kamer is schoon", SwingConstants.LEFT);
        text.setForeground(Color.GREEN);
        p.add(text);

        text = new JLabel("Oranje = Kamer wordt schoongemaakt");
        text.setForeground(Color.ORANGE);
        p.add(text);

        text = new JLabel("Rood = Kamer vies");
        text.setForeground(Color.RED);
        p.add(text);

        text = new JLabel("M = Menu for settings");
        p.add(text);

        text = new JLabel("S = Statistics");
        p.add(text);

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
