package HHS_PROJGR6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    /**
     * Constructor
     */
    public App() {
        // Set dimensions and add canvas to draw the hotel on
        // Set dimensions and add canvas to draw the hotel on
        Dimension d = new Dimension(1400, 800);
        Hotel myHotel = new Hotel(new Canvas(d));
        d.width += 200;

        buttonPlus = new JButton("Hotel TijdsEenheid +");
        buttonPlus.setBounds(1175, 50, 175, 80);
        buttonPlus.setBackground(Color.DARK_GRAY);
        buttonPlus.setForeground(Color.WHITE);
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clock.addClockspeed();
            }
        });

        buttonMinus = new JButton("Hotel TijdsEenheid -");
        buttonMinus.setBounds(1175, 150, 175, 80);
        buttonMinus.setBackground(Color.DARK_GRAY);
        buttonMinus.setForeground(Color.WHITE);

        add(myHotel.getHotelCanvas());
        add(buttonPlus);
        add(buttonMinus);
        add(new Clock());

        // Show window
        setTitle("HotelSimulatie GR6");
        setLayout(null);
        setResizable(true);
        setSize(d);
        setLayout(null);
        setLocationRelativeTo(null);
        super.getContentPane().setBackground(Color.WHITE);
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

        // new Canvas();
        new App();

    }

}
