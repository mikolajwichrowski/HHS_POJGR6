package HHS_PROJGR6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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

    JButton buttonPlus;
    JButton buttonMinus;
    JTextField timeDisplay;
    JTextField timeFactor;

    /**
     * Constructor
     */
    public App() {
        // Set dimensions, create canvas and hotel
        Dimension d = new Dimension(1000, 800);
        Canvas canvas = new Canvas(d);
        Hotel myHotel = new Hotel();
        
        // Set canvas and add width for gui elements
        myHotel.setHotelCanvas(canvas);
        d.width += 500;

        // Set button plus and functionality
        buttonPlus = new JButton("Hotel TijdsEenheid +");
        buttonPlus.setBounds(1175, 50, 175, 80);
        buttonPlus.setBackground(Color.DARK_GRAY);
        buttonPlus.setForeground(Color.BLACK);
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clock.addClockspeed();
                timeFactor.setText("HTE: " + Clock.getClockspeed());
            }
        });

        // Set button minus and functionality
        buttonMinus = new JButton("Hotel TijdsEenheid -");
        buttonMinus.setBounds(1175, 150, 175, 80);
        buttonMinus.setBackground(Color.DARK_GRAY);
        buttonMinus.setForeground(Color.BLACK);
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clock.reduceClockspeed();
                timeFactor.setText("HTE: " + Clock.getClockspeed());
            }
        });

        // Set time display
        timeDisplay = new JTextField(5);
        timeDisplay.setFont(new Font("Consolas", Font.PLAIN, 32));
        timeDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        timeDisplay.setBounds(1175, 250, 175, 80);
        timeDisplay.setText(Clock.datetime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));

        // Set factor display
        timeFactor = new JTextField(5);
        timeFactor.setFont(new Font("Consolas", Font.PLAIN, 32));
        timeFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        timeFactor.setBounds(1175, 300, 175, 80);
        timeFactor.setText("HTE: " + Clock.getClockspeed());

        // Set timer for hotel clock
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set the visible time
                Clock.datetime = Clock.datetime.plusSeconds(Clock.getClockspeed());

                // Format time and display
                timeDisplay.setText(Clock.datetime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
            }
        }).start();

        // Add to current panel
        add(timeDisplay);
        add(timeFactor);
        add(buttonPlus);
        add(buttonMinus);
        add(myHotel.getHotelCanvas());

        // Run hotel
        new Thread(myHotel, "HotelThread").start();

        // Show window
        setTitle("HotelSimulatie GR6");
        setLayout(null);
        setResizable(true);
        setSize(d);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
    }

    /**
     * Application entry point
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Run Application
        new App();
    }
}
