import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
 import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 * Main class for the homework assignment Random Animator.
 * 
 * 
 * TODO:
 *
 * @author Andrei David Nechitoaia
 * @id 180 6130
 */
public class RandomAnimator {
    JFrame frame;
    Painting painting; // panel that provides the random painting
    JButton regenerateButton;
    JButton shotButton;
    JButton startAnimation;
    JButton stopAnimation;
    JButton recolor;

    /**
     * Create a new instance of the RandomAnimator application.
     */
    RandomAnimator() {

        // invokeLater: preferred way to create components
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JPanel panel = new JPanel();
                painting = new Painting();
                frame = new JFrame("Computer Assisted Random Animator");
                frame.add(painting, BorderLayout.CENTER);
                frame.add(panel, BorderLayout.SOUTH);
                regenerateButton = new JButton("Regenerate");

                //create the buttons: Start, Stop and Recolor
                stopAnimation = new JButton("Stop");
                startAnimation = new JButton("Start");
                recolor = new JButton("Recolor");

                //painting provides reaction to buttonclick
                regenerateButton.addActionListener(painting);
                stopAnimation.addActionListener(painting);
                startAnimation.addActionListener(painting);
                recolor.addActionListener(painting);

                //we add the buttons to the added panel
                panel.add(startAnimation);
                panel.add(recolor);
                panel.add(stopAnimation);
                panel.add(regenerateButton);
                shotButton = new JButton("Screenshot");
                shotButton.addActionListener(painting);
                panel.add(shotButton);
                frame.pack();
                painting.regenerate(); // can be done here since painting has a size!
                frame.setVisible(true);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    public static void main(String[] arg) {
        new RandomAnimator();
    }
}