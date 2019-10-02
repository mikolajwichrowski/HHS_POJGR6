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
        buttonPlus.setBounds(850, 50, 175, 80);
        buttonPlus.setBackground(Color.GREEN);
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
        buttonMinus.setBounds(850, 150, 175, 80);
        buttonMinus.setBackground(Color.RED);
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
        timeDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        timeDisplay.setBounds(850, 250, 175, 80);
        timeDisplay.setText(Clock.datetime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));

        // Set factor display
        timeFactor = new JTextField(5);
        timeFactor.setFont(new Font("Consolas", Font.PLAIN, 32));
        timeFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        timeFactor.setHorizontalAlignment(SwingConstants.CENTER);
        timeFactor.setBounds(850, 350, 175, 80);
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

        // Adding components to the JFrame
        add(myHotel.getHotelCanvas());
        add(timeDisplay);
        add(timeFactor);
        add(buttonPlus);
        add(buttonMinus);

        // Run hotel
        myHotel.initRooms();
        new Thread(myHotel, "HotelThread").start();

        // Options for the JFrame
        setTitle("HotelSimulatie GR6");
        setResizable(true);
        setSize(d);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

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
