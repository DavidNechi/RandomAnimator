import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Dingus represents an arbitraty shape.
 * @author Andrei David Nechitoaia
 * @id 180 6130
 */

abstract class Dingus {
    Random random = Painting.RANDOM;

    /**
     * Postion of the shape (upper left corner).
     */
    protected int x;
    protected int y;
    int limitleftx;
    int limitrightx;
    int limitlowery;
    int limituppery;
    int xVelocity = 2;
    int  yVelocity = 2;

    /**
     * Color used for drawing this shape.
     */
    protected Color color;

    /**
     * Maximal coordinates; drawing area is (0,0)- (maxX,maxY).
     */
    int maxX;
    int maxY;

    /**
     * Initialize color and position to random values.
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */

    public Dingus(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;

        //  Initialize to a random position
        this.updatechords(random.nextInt(maxX * 3/4), random.nextInt(maxY * 2 /3));

        //  Initialize to a random color
        //  TODO
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        Color color = new Color(r, g, b);
        this.color = color;
    }

    //methods to get positons and change positions and get color

    public Color getColor(){
        return color;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    abstract void draw(Graphics g);

    //This abstract method is used in every extension of dingus
    abstract void updatechords(int x, int y);

    public void chechkLimits(){
        if(this.limitleftx < 0 || this.limitrightx > maxX){
            xVelocity = -xVelocity;
        } 
        if(this.limituppery < 0 || this.limitlowery > maxY){
            yVelocity = -yVelocity;
        } 
    }  
}