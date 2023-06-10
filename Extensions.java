/*
 Name: Christian Okyere
 File: Extensions.java
 Project: Conway's Game of Life
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;



public class Extensions extends JFrame implements ActionListener {
    private JButton startButton;

    public Extensions() {

        // creates a screen with a specified title, width and height
        setTitle("Simulation GUI"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        // creates an obbject for the type JPanel
        JPanel panel = new JPanel(new FlowLayout());
        JLabel densityLabel = new JLabel("Press here to begin the game:");
        panel.add(densityLabel);

        // draws the start button 
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        panel.add(startButton);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
                
        SwingUtilities.invokeLater(() -> {
            new Extensions();
        });
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            // Start the simulation
            Landscape scape = new Landscape(100, 100, .25);
            LandscapeDisplay display = new LandscapeDisplay(scape, 6);

            Timer timer = new Timer(10, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    scape.advance();
                    display.repaint();
                }
            });
            timer.start();
        } 
    }
}
