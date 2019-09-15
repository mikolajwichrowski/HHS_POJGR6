package HHS_PROJGR6;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    /**
     * Generated serial id
     */

    private static final long serialVersionUID = -2280803615953081532L;

    public App() {
        // Set dimensions and add canvas to draw the hotel on
        Dimension d = new Dimension(1400, 800);
        Hotel myHotel = new Hotel(new Canvas(d));
        add(myHotel.hotelCanvas);

        // Add buttons and add dimension to window to fit buttons
        d.width += 200;

        JButton buttonPlus = new JButton("Hotel TijdsEenheid +");
        buttonPlus.setBounds(1175, 50,175, 80);
        buttonPlus.setBackground(Color.DARK_GRAY);
        buttonPlus.setForeground(Color.WHITE);

        JButton buttonMinus = new JButton("Hotel TijdsEenheid -");
        buttonMinus.setBounds(1175, 150,175, 80);
        buttonMinus.setBackground(Color.DARK_GRAY);
        buttonMinus.setForeground(Color.WHITE);

        add(buttonPlus);
        add(buttonMinus);

        // Show window
        setTitle("HotelSimulatie GR6");
        setLayout(null);
        setResizable(true);
        setSize(d);
        setLayout(null);
        super.setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run Application
        // Show buttons
        // new Canvas();
        new App();
        new Clock();
    }
}