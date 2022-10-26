import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
// import java.util.Collection;
import java.util.Collections;
import java.util.Random;
// import java.util.Timer;
// import java.util.TimerTask;
import javax.swing.Timer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.*;


public class Painting extends JPanel implements ActionListener {

 
    static final long SEED = 45;

  
    static final Random RANDOM = new Random();
    int numberOfRegenerates = 0;


    char current = '0';
    String filename = "randomshot_"; 


    ArrayList<Dingus> shapes = new ArrayList<Dingus>();



    public Painting() {
        setPreferredSize(new Dimension(800, 450)); // make panel 800 by 450 pixels.
        // ...
    }

    @Override
    protected void paintComponent(Graphics g) { // draw all your shapes
        super.paintComponent(g); // clears the panel
        // draw all shapes
        // TODO
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).draw(g);
        }
    }


    //Initialize a timer to change the positions of shapes every 5 miliseconds
    //We create a new action listener for every shape and move it along the screen
    Timer timer = new Timer(5, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < shapes.size(); i++) {
                shapes.get(i).chechkLimits();
                shapes.get(i).setX(shapes.get(i).getX() + shapes.get(i).xVelocity);
                shapes.get(i).setY(shapes.get(i).getY() + shapes.get(i).yVelocity);
                shapes.get(i).updatechords(shapes.get(i).getX(), shapes.get(i).getY());
                repaint();
            }
        }

    });

    boolean startPress;

    /**
     * Reaction to button press.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if ("Regenerate".equals(e.getActionCommand())) {
            regenerate();
            paintComponent(getGraphics());
        } else if ("Start".equals(e.getActionCommand())) {
            //if Start button is pressed the method start() starts
            start();
            //if start is pressed than it does not work until it is stoped
            startPress = true;
        } else if ("Stop".equals(e.getActionCommand())) {
            //If Stop button is pressed the timer stops, therefore the 
            //the shapes stop as well
            timer.stop();
            //if start is not pressed it can be used
            startPress = false;
        } else if ("Recolor".equals(e.getActionCommand())) {
            //If recolor button is pressed it set a differrent color for every shape 
            //individually
            for (int i = 0; i < shapes.size(); i++) {
                shapes.get(i).color = new Color(
                        RANDOM.nextInt(255),
                        RANDOM.nextInt(255),
                        RANDOM.nextInt(255));

            }
        } else { // screenshot
            saveScreenshot(this, filename + current++); // ++ to show of compact code :-)
        }

    }


    public void start() {
        int shapesMove = RANDOM.nextInt(10, 21);
        if(startPress == false){

        Collections.shuffle(shapes);

        for (int i = 0; i < shapes.size(); i++) {
            if (i < shapesMove) {
                shapes.get(i).xVelocity = RANDOM.nextInt(-3, 3);
                shapes.get(i).yVelocity = RANDOM.nextInt(-3, 3);
            } else {
                shapes.get(i).xVelocity = 0;
                shapes.get(i).yVelocity = 0;
            }

        }
        this.timer.start();
    }
    }

    void regenerate() {
        numberOfRegenerates++; 


        shapes.clear();

        int numShapes = RANDOM.nextInt(20, 31);


        for (int i = 0; i < numShapes; i++) {
            int task = RANDOM.nextInt(5);
            switch (task) {
                case 1:
                    CircleDingus shape = new CircleDingus(800, 450);
                    shapes.add(shape);
                    break;
                case 2:
                    TreeDingus shape2 = new TreeDingus(800, 450);
                    shapes.add(shape2);
                    break;
                case 3:
                    RectangleDingus shape3 = new RectangleDingus(800, 450);
                    shapes.add(shape3);
                    break;
                case 4:
                    OvalDingus shape4 = new OvalDingus(800, 450);
                    shapes.add(shape4);
                    break;
                default:
                    break;

            }
        }
    }

//     void saveScreenshot(Component component, String name) {
//         // minus 1 because the initial picture should not count
//         String randomInfo = "" + SEED + "+" + (numberOfRegenerates - 1);
//         System.out.println(SwingUtilities.isEventDispatchThread());
//         BufferedImage image = new BufferedImage(
//                 component.getWidth(),
//                 component.getHeight(),
//                 BufferedImage.TYPE_INT_RGB);

//         // call the Component's paint method, using
//         // the Graphics object of the image.
//         Graphics graphics = image.getGraphics();
//         component.paint(graphics); // alternately use .printAll(..)
//         graphics.drawString(randomInfo, 0, component.getHeight());

//         try {
//             ImageIO.write(image, "PNG", new File(name + ".png"));
//             System.out.println("Saved screenshot as " + name);
//         } catch (IOException e) {
//             System.out.println("Saving screenshot failed: " + e);
//         }
//     }
// }
