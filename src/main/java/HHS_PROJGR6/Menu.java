package HHS_PROJGR6;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Menu extends JFrame {

    private JTextField timeFactor,pixelFactor,filthFactor,leasureFactor,elevatorFactor,stairFactor,timeDisplay;

    /**
     *
     */
    public Menu() {
        super.setSize(365, 540);
        super.setLocation(0, 0);

        JLabel tijdsEenheid = new JLabel("Hotel Time Unit");
        tijdsEenheid.setFont(new Font("Calabri", Font.ITALIC, 12));
        tijdsEenheid.setBounds(20, 0, 175, 40);

        timeFactor = new JTextField(3);
        timeFactor.setFont(new Font("Consolas", Font.BOLD, 18));
        //timeFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        timeFactor.setHorizontalAlignment(SwingConstants.CENTER);
        timeFactor.setBounds(125, 30, 100, 40);
        timeFactor.setText("0.5");

        // Set button plus and functionality
        JButton buttonPlus = new JButton("Time unit +");
        buttonPlus.setBounds(20, 30, 100, 40);
        buttonPlus.setBackground(new Color(112, 219, 112));
        buttonPlus.setForeground(new Color(255, 255, 255));
        buttonPlus.addActionListener(e -> {
            Clock.addClockspeed();
            timeFactor.setText("" + Clock.getClockspeed());
        });

        // Set button minus and functionality
        JButton buttonMinus = new JButton("Time unit -");
        buttonMinus.setBounds(228, 30, 100, 40);
        buttonMinus.setBackground(new Color(255, 77, 77));
        buttonMinus.setForeground(new Color(255, 255, 255));
        buttonMinus.addActionListener(e -> {
            Clock.reduceClockspeed();
            timeFactor.setText("" + Clock.getClockspeed());
        });

        JLabel pixelResolution = new JLabel("Pixel Resolution");
        pixelResolution.setBounds(20, 70, 175, 40);
        pixelResolution.setFont(new Font("Calabri", Font.ITALIC, 12));

        JButton pixelPlus = new JButton("Resolution +");
        pixelPlus.setBounds(20, 100, 100, 40);
        pixelPlus.setBackground(new Color(112, 219, 112));
        pixelPlus.setForeground(new Color(255, 255, 255));
        pixelPlus.addActionListener(e -> {
            if (Settings.getPixelResolution() < 100){
                Settings.setPixelResolution(Settings.getPixelResolution() + 10);
                repaint();
            }
            pixelFactor.setText(""+ Settings.getPixelResolution());
        });

        JButton pixelMin = new JButton("Resolution -");
        pixelMin.setBounds(228, 100, 100, 40);
        pixelMin.setBackground(new Color(255, 77, 77));
        pixelMin.setForeground(new Color(255, 255, 255));
        pixelMin.addActionListener(e -> {
            if (Settings.getPixelResolution() > 10){
                Settings.setPixelResolution(Settings.getPixelResolution() - 10);
                repaint();
            }
            pixelFactor.setText(""+ Settings.getPixelResolution());
        });

        pixelFactor = new JTextField();
        pixelFactor.setFont(new Font("Consolas", Font.BOLD, 20));
        pixelFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        pixelFactor.setHorizontalAlignment(SwingConstants.CENTER);
        pixelFactor.setBounds(125, 100, 100, 40);
        pixelFactor.setText(""+ Settings.getPixelResolution());
        pixelFactor.setText("40");

        JLabel filthTime = new JLabel("Cleaning expensive");
        filthTime.setBounds(20, 140, 175, 40);
        filthTime.setFont(new Font("Calabri", Font.ITALIC, 12));

        JButton filthPlus = new JButton("Cleaning +");
        filthPlus.setBounds(20, 170, 100, 40);
        filthPlus.setBackground(new Color(112, 219, 112));
        filthPlus.setForeground(new Color(255, 255, 255));
        filthPlus.addActionListener(e -> {
            if (Settings.getFilthTime() < 20){
                Settings.setFilthTime(Settings.getFilthTime() + 2 );
            }
            filthFactor.setText(""+ Settings.getFilthTime());
        });

        JButton filthMin = new JButton("Cleaning -");
        filthMin.setBounds(228, 170, 100, 40);
        filthMin.setBackground(new Color(255, 77, 77));
        filthMin.setForeground(new Color(255, 255, 255));
        filthMin.addActionListener(e -> {
            if (Settings.getFilthTime() > 0){
                Settings.setFilthTime(Settings.getFilthTime() - 2 );
            }
            filthFactor.setText(""+ Settings.getFilthTime());
        });

        filthFactor = new JTextField();
        filthFactor.setFont(new Font("Consolas", Font.BOLD, 20));
        filthFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        filthFactor.setHorizontalAlignment(SwingConstants.CENTER);
        filthFactor.setBounds(125, 170, 100, 40);
        filthFactor.setText("10");

        JLabel leasureTime = new JLabel("Leasure Time");
        leasureTime.setBounds(20, 210, 175, 40);
        leasureTime.setFont(new Font("Calabri", Font.ITALIC, 12));

        JButton leasurePlus = new JButton("Leasure +");
        leasurePlus.setBounds(20, 240, 100, 40);
        leasurePlus.setBackground(new Color(112, 219, 112));
        leasurePlus.setForeground(new Color(255, 255, 255));
        leasurePlus.addActionListener(e -> {
            if (Settings.getLeasureTime() < 20){
                Settings.setLeasureTime(Settings.getLeasureTime() + 2 );
            }
            leasureFactor.setText(""+ Settings.getLeasureTime());
        });

        JButton leasureMin = new JButton("Leasure -");
        leasureMin.setBounds(228, 240, 100, 40);
        leasureMin.setBackground(new Color(255, 77, 77));
        leasureMin.setForeground(new Color(255, 255, 255));
        leasureMin.addActionListener(e -> {
            if (Settings.getLeasureTime() > 0){
                Settings.setLeasureTime(Settings.getLeasureTime() - 2 );
            }
            leasureFactor.setText(""+ Settings.getLeasureTime());
        });

        leasureFactor = new JTextField();
        leasureFactor.setFont(new Font("Consolas", Font.BOLD, 20));
        leasureFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        leasureFactor.setHorizontalAlignment(SwingConstants.CENTER);
        leasureFactor.setBounds(125, 240, 100, 40);
        leasureFactor.setText("10");

        JLabel elevatorTime = new JLabel("Elevator time");
        elevatorTime.setBounds(20, 280, 175, 40);
        elevatorTime.setFont(new Font("Calabri", Font.ITALIC, 12));

        JButton elevatorPlus = new JButton("Elevator +");
        elevatorPlus.setBounds(20, 310, 100, 40);
        elevatorPlus.setBackground(new Color(112, 219, 112));
        elevatorPlus.setForeground(new Color(255, 255, 255));
        elevatorPlus.addActionListener(e -> {
            if (Settings.getElevatorCost() < 10){
                Settings.setElevatorCost(Settings.getElevatorCost() + 1 );
            }
            elevatorFactor.setText(""+ Settings.getElevatorCost());
        });

        JButton elevatorMin = new JButton("Elevator -");
        elevatorMin.setBounds(228, 310, 100, 40);
        elevatorMin.setBackground(new Color(255, 77, 77));
        elevatorMin.setForeground(new Color(255, 255, 255));
        elevatorMin.addActionListener(e -> {
            if (Settings.getElevatorCost() > 0){
                Settings.setElevatorCost(Settings.getElevatorCost() - 1 );
            }
            elevatorFactor.setText(""+ Settings.getElevatorCost());
        });

        elevatorFactor = new JTextField();
        elevatorFactor.setFont(new Font("Consolas", Font.BOLD, 20));
        elevatorFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        elevatorFactor.setHorizontalAlignment(SwingConstants.CENTER);
        elevatorFactor.setBounds(125, 310, 100, 40);
        elevatorFactor.setText("5");

        JLabel stairTime = new JLabel("Stair time");
        stairTime.setBounds(20, 350, 175, 40);
        stairTime.setFont(new Font("Calabri", Font.ITALIC, 12));

        JButton stairPlus = new JButton("Stair +");
        stairPlus.setBounds(20, 380, 100, 40);
        stairPlus.setBackground(new Color(112, 219, 112));
        stairPlus.setForeground(new Color(255, 255, 255));
        stairPlus.addActionListener(e -> {
            if (Settings.getStairCost() < 5){
                Settings.setStairCost(Settings.getStairCost() + 1 );
            }
            stairFactor.setText(""+ Settings.getStairCost());
        });

        JButton stairMin = new JButton("Stair -");
        stairMin.setBounds(228, 380, 100, 40);
        stairMin.setBackground(new Color(255, 77, 77));
        stairMin.setForeground(new Color(255, 255, 255));
        stairMin.addActionListener(e -> {
            if (Settings.getStairCost() > 0){
                Settings.setStairCost(Settings.getStairCost() - 1 );
            }
            stairFactor.setText(""+ Settings.getStairCost());
        });

        stairFactor = new JTextField();
        stairFactor.setFont(new Font("Consolas", Font.BOLD, 20));
        stairFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        stairFactor.setHorizontalAlignment(SwingConstants.CENTER);
        stairFactor.setBounds(125, 380, 100, 40);
        stairFactor.setText("2");

        timeDisplay = new JTextField(5);
        timeDisplay.setFont(new Font("Consolas", Font.BOLD, 18));
        // timeDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        timeDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        timeDisplay.setBackground(new Color(0, 0, 128));
        timeDisplay.setBorder(null);
        timeDisplay.setForeground(new Color(255, 255, 255));
        timeDisplay.setBounds(20, 450, 100, 40);
        // Set timer for hotel clock Format time and display
        new Timer(1000, e -> timeDisplay.setText(Clock.datetime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)))).start();

        JLabel timeLabel = new JLabel("Local time");
        timeLabel.setBounds(20, 420, 175, 40);
        timeLabel.setFont(new Font("Calabri", Font.ITALIC, 12));

        add(buttonPlus);add(buttonMinus);add(timeFactor);add(tijdsEenheid);add(pixelResolution);add(pixelPlus); add(pixelMin);add(pixelFactor);
        add(filthTime);add(filthPlus);add(filthMin);add(filthFactor);add(leasureTime);add(leasurePlus);add(leasureMin);add(leasureFactor);
        add(elevatorTime);add(elevatorPlus);add(elevatorMin);add(elevatorFactor);add(stairTime);add(stairPlus);add(stairMin);add(stairFactor);
        add(timeLabel);add(timeDisplay);

        setTitle("Regulation screen");
        setResizable(true);
        getContentPane().setBackground(new Color(245, 245, 240));
        setLayout(null);
    }
}
