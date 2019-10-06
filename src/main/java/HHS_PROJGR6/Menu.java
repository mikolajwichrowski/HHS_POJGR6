package HHS_PROJGR6;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Menu extends JFrame {

    private JLabel tijdsEenheid;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JTextField timeFactor;
    private JLabel pixelResolution;
    private JButton pixelPlus;
    private JButton pixelMin;
    private JTextField pixelFactor;
    private JLabel filthTime;
    private JButton filthPlus;
    private JButton filthMin;
    private JTextField filthFactor;
    private JLabel leasureTime;
    private JButton leasurePlus;
    private JButton leasureMin;
    private JTextField leasureFactor;
    private JLabel elevatorTime;
    private JButton elevatorPlus;
    private JButton elevatorMin;
    private JTextField elevatorFactor;
    private JLabel stairTime;
    private JButton stairPlus;
    private JButton stairMin;
    private JTextField stairFactor;
    private JLabel timeLabel;
    private JTextField timeDisplay;

    /**
     *
     */
    public Menu() {
        super.setSize(460, 600);
        super.setLocation(900, 0);

        tijdsEenheid = new JLabel("Hotel TijdsEenheid");
        tijdsEenheid.setFont(new Font("Calabri", Font.ITALIC, 12));
        tijdsEenheid.setBounds(20, 10, 175, 40);

        // Set button plus and functionality
        buttonPlus = new JButton("TijdsEenheid +");
        buttonPlus.setBounds(20, 40, 150, 40);
        buttonPlus.setBackground(new Color(112, 219, 112));
        // buttonPlus.setForeground(new Color(255, 255, 255));
        buttonPlus.addActionListener(e -> {
            Clock.addClockspeed();
            timeFactor.setText("HTE: " + Clock.getClockspeed());
        });
        timeFactor = new JTextField(5);
        timeFactor.setFont(new Font("Consolas", Font.BOLD, 20));
        timeFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        timeFactor.setHorizontalAlignment(SwingConstants.CENTER);
        timeFactor.setBounds(175, 40, 100, 40);
        timeFactor.setText("HTE:" + Clock.getClockspeed());

        // Set button minus and functionality
        buttonMinus = new JButton("TijdsEenheid -");
        buttonMinus.setBounds(278, 40, 150, 40);
        buttonMinus.setBackground(new Color(255, 77, 77));
        // buttonMinus.setForeground(new Color(255, 255, 255));
        buttonMinus.addActionListener(e -> {
            Clock.reduceClockspeed();
            timeFactor.setText("HTE: " + Clock.getClockspeed());
        });

        pixelResolution = new JLabel("Pixel Resolutie");
        pixelResolution.setBounds(20, 80, 175, 40);
        pixelResolution.setFont(new Font("Calabri", Font.ITALIC, 12));

        pixelPlus = new JButton("Resolutie +");
        pixelPlus.setBounds(20, 110, 150, 40);
        pixelPlus.setBackground(new Color(112, 219, 112));
        // pixelPlus.setForeground(new Color(255, 255, 255));

        pixelMin = new JButton("Resolutie -");
        pixelMin.setBounds(278, 110, 150, 40);
        pixelMin.setBackground(new Color(255, 77, 77));
        // pixelMin.setForeground(new Color(255, 255, 255));

        pixelFactor = new JTextField();
        pixelFactor.setFont(new Font("Consolas", Font.BOLD, 20));
        pixelFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        pixelFactor.setHorizontalAlignment(SwingConstants.CENTER);
        pixelFactor.setBounds(175, 110, 100, 40);
        pixelFactor.setText("factor");

        filthTime = new JLabel("Schoonmaak duur");
        filthTime.setBounds(20, 150, 175, 40);
        filthTime.setFont(new Font("Calabri", Font.ITALIC, 12));

        filthPlus = new JButton("Schoonmaak duur +");
        filthPlus.setBounds(20, 180, 150, 40);
        filthPlus.setBackground(new Color(112, 219, 112));
        // filthPlus.setForeground(new Color(255, 255, 255));

        filthMin = new JButton("Schoonmaak duur -");
        filthMin.setBounds(278, 180, 150, 40);
        filthMin.setBackground(new Color(255, 77, 77));
        // filthMin.setForeground(new Color(255, 255, 255));

        filthFactor = new JTextField();
        filthFactor.setFont(new Font("Consolas", Font.BOLD, 20));
        filthFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        filthFactor.setHorizontalAlignment(SwingConstants.CENTER);
        filthFactor.setBounds(175, 180, 100, 40);
        filthFactor.setText("factor");

        leasureTime = new JLabel("activiteiten tijd");
        leasureTime.setBounds(20, 220, 175, 40);
        leasureTime.setFont(new Font("Calabri", Font.ITALIC, 12));

        leasurePlus = new JButton("activiteiten +");
        leasurePlus.setBounds(20, 250, 150, 40);
        leasurePlus.setBackground(new Color(112, 219, 112));
        // leasurePlus.setForeground(new Color(255, 255, 255));

        leasureMin = new JButton("activiteiten -");
        leasureMin.setBounds(278, 250, 150, 40);
        leasureMin.setBackground(new Color(255, 77, 77));
        // leasureMin.setForeground(new Color(255, 255, 255));

        leasureFactor = new JTextField();
        leasureFactor.setFont(new Font("Consolas", Font.BOLD, 20));
        leasureFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        leasureFactor.setHorizontalAlignment(SwingConstants.CENTER);
        leasureFactor.setBounds(175, 250, 100, 40);
        leasureFactor.setText("factor");

        elevatorTime = new JLabel("Lift tijd");
        elevatorTime.setBounds(20, 290, 175, 40);
        elevatorTime.setFont(new Font("Calabri", Font.ITALIC, 12));

        elevatorPlus = new JButton("Lift tijd +");
        elevatorPlus.setBounds(20, 320, 150, 40);
        elevatorPlus.setBackground(new Color(112, 219, 112));
        // elevatorPlus.setForeground(new Color(255, 255, 255));

        elevatorMin = new JButton("Lift tijd -");
        elevatorMin.setBounds(278, 320, 150, 40);
        elevatorMin.setBackground(new Color(255, 77, 77));
        // elevatorMin.setForeground(new Color(255, 255, 255));

        elevatorFactor = new JTextField();
        elevatorFactor.setFont(new Font("Consolas", Font.BOLD, 20));
        elevatorFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        elevatorFactor.setHorizontalAlignment(SwingConstants.CENTER);
        elevatorFactor.setBounds(175, 320, 100, 40);
        elevatorFactor.setText("factor");

        stairTime = new JLabel("Trap tijd");
        stairTime.setBounds(20, 360, 175, 40);
        stairTime.setFont(new Font("Calabri", Font.ITALIC, 12));

        stairPlus = new JButton("Trap tijd +");
        stairPlus.setBounds(20, 390, 150, 40);
        stairPlus.setBackground(new Color(112, 219, 112));
        // stairPlus.setForeground(new Color(255, 255, 255));

        stairMin = new JButton("Trap tijd -");
        stairMin.setBounds(278, 390, 150, 40);
        stairMin.setBackground(new Color(255, 77, 77));
        // stairMin.setForeground(new Color(255, 255, 255));

        stairFactor = new JTextField();
        stairFactor.setFont(new Font("Consolas", Font.BOLD, 20));
        stairFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        stairFactor.setHorizontalAlignment(SwingConstants.CENTER);
        stairFactor.setBounds(175, 390, 100, 40);
        stairFactor.setText("factor");

        timeDisplay = new JTextField(5);
        timeDisplay.setFont(new Font("Consolas", Font.BOLD, 28));
        // timeDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        timeDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        // timeDisplay.setBackground(new Color(0, 0, 128));
        timeDisplay.setBorder(null);
        // timeDisplay.setForeground(new Color(255, 255, 255));
        timeDisplay.setBounds(20, 460, 150, 40);

        // Set timer for hotel clock Format time and display
        new Timer(1, e -> timeDisplay.setText(Clock.datetime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)))).start();

        timeLabel = new JLabel("Tijd HTE");
        timeLabel.setBounds(20, 430, 175, 40);
        timeLabel.setFont(new Font("Calabri", Font.ITALIC, 12));

        add(buttonPlus);
        add(buttonMinus);
        add(timeFactor);
        add(tijdsEenheid);
        add(pixelResolution);
        add(pixelPlus);
        add(pixelMin);
        add(pixelFactor);
        add(filthTime);
        add(filthPlus);
        add(filthMin);
        add(filthFactor);
        add(leasureTime);
        add(leasurePlus);
        add(leasureMin);
        add(leasureFactor);
        add(elevatorTime);
        add(elevatorPlus);
        add(elevatorMin);
        add(elevatorFactor);
        add(stairTime);
        add(stairPlus);
        add(stairMin);
        add(stairFactor);
        add(timeLabel);
        add(timeDisplay);

        setTitle("regulering Scherm");
        setResizable(true);
        getContentPane().setBackground(new Color(245, 245, 240));
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
