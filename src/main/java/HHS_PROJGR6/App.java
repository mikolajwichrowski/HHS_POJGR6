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
 * a bit neater because instead of running the application from a method we run
 * it from an object.
 */
public class App extends JFrame {

    /**
     * Generated serial id
     */
    private static final long serialVersionUID = -2280803615953081532L;

    /**
     * 
     */
    private JButton buttonPlus;

    /**
     * 
     */
    private JButton buttonMinus;

    /**
     * 
     */
    private JTextField timeDisplay;

    /**
     * 
     */
    private JTextField timeFactor;

    /**
     * Constructor of App
     */
    public App() {
        // Set dimensions, create canvas and hotel
        Dimension d = new Dimension(1150, 800);
        Canvas canvas = new Canvas(d);
        Hotel myHotel = new Hotel();

        // Set canvas and add width for gui elements
        myHotel.setHotelCanvas(canvas);
        d.width += 500;

        // Set button plus and functionality
        buttonPlus = new JButton("Hotel TijdsEenheid +");
        buttonPlus.setBounds(1250, 50, 175, 80);
        buttonPlus.setBackground(Color.GREEN);
        buttonPlus.setForeground(Color.BLACK);
        buttonPlus.addActionListener(e -> {
            Clock.addClockspeed();
            timeFactor.setText("HTE: " + Clock.getClockspeed());
        });

        // Set button minus and functionality
        buttonMinus = new JButton("Hotel TijdsEenheid -");
        buttonMinus.setBounds(1250, 150, 175, 80);
        buttonMinus.setBackground(Color.RED);
        buttonMinus.setForeground(Color.BLACK);
        buttonMinus.addActionListener(e -> {
            Clock.reduceClockspeed();
            timeFactor.setText("HTE: " + Clock.getClockspeed());
        });

        // Set time display
        timeDisplay = new JTextField(5);
        timeDisplay.setFont(new Font("Consolas", Font.PLAIN, 32));
        timeDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        timeDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        timeDisplay.setBounds(1250, 250, 175, 80);

        // Set factor display
        timeFactor = new JTextField(5);
        timeFactor.setFont(new Font("Consolas", Font.PLAIN, 32));
        timeFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        timeFactor.setHorizontalAlignment(SwingConstants.CENTER);
        timeFactor.setBounds(1250, 350, 175, 80);
        timeFactor.setText("HTE: " + Clock.getClockspeed());

        // Set timer for hotel clock Format time and display
        new Timer(1, e -> timeDisplay.setText(Clock.datetime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)))).start();

        // Adding components to the JFrame
        add(myHotel.getHotelCanvas());

        add(timeDisplay);
        add(timeFactor);
        add(buttonPlus);
        add(buttonMinus);

        // Init hotel rooms
        myHotel.initRooms();

        // Options for the JFrame
        setTitle("HotelSimulatie GR6");
        setResizable(true);
        setSize(d);
        setLocationRelativeTo(null);
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
