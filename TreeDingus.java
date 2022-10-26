import java.awt.Graphics;

/**
 * TreeDingus is an example of a slightly more advanced Dingus.
 * TreeDingus draws a "tree" using a rectangle as the trunk, and circle for a
 * crown.
 * @author Andrei David Nechitoaia
 * @id 180 6130
 */
class TreeDingus extends Dingus {
    private int crownRadius;
    private int trunkHeight;
    private int trunkWidth;
    private boolean filled; // true: filled; false: outline

    /**
     * Create and initialize a new TreeDingus.
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */

    public TreeDingus(int maxX, int maxY) {
        // initialize Dingus properties
        super(maxX, maxY);

        // initialize TreeDingus properties
        crownRadius = random.nextInt(10, maxX / 18); // or something more sophisticated
        trunkHeight = random.nextInt(crownRadius ,crownRadius * 2);
        trunkWidth = crownRadius / 3 + 1;
        filled = random.nextBoolean();
    }

    //set different color
    public void SetColor(Graphics g){
        g.setColor(color);
    }
    

    @Override
    void draw(Graphics g) {
        // draw crown
        SetColor(g);
        if (filled) {
            // more general way to draw an oval than with fillOval (hint :-)
            g.fillArc(x, y, 2 * crownRadius, 2 * crownRadius, 0, 360);
         } 

       SetColor(g);
        int xx = x + crownRadius - trunkWidth / 2;
        int yy = y + 2 * crownRadius;

        if (filled) {
            g.fillRect(xx, yy, trunkWidth, trunkHeight);
        } else {
            g.fillRect(xx, yy, trunkWidth, trunkHeight);
        }
    }

    //this method calculates the limits an object has regarding collision with the walls 
    //ofthe frame
    @Override
    void updatechords(int x, int y){
        this.x = x;
        this.y = y;

        this.limitleftx = x;
        this.limitrightx = x + 2 * this.crownRadius;
        this.limituppery = y;
        this.limitlowery = y + 2 * this.crownRadius + this.trunkHeight;
    }

}