import java.awt.Graphics;

/**
 * CircleDingus is an example of a very simple Dingus.
 * @author Andrei David Nechitoaia
 * @id 180 6130
 */
class OvalDingus extends Dingus {
    protected int width;
    protected int height;
    protected boolean filled; // true: filled, false: outline

    /**
     * Create and initialize a new CircleDingus.
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public OvalDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);

        // initialize randomly the CircleDingus properties, i.e., radius and filledness
        width = random.nextInt(20, maxX / 4);
        height = random.nextInt(20, maxY / 4);
        filled = random.nextBoolean();
    }

    //set different color
    public void SetColor(Graphics g) {
        g.setColor(color);
    }

    @Override
    void draw(Graphics g) {
        SetColor(g);
        if (filled) {
            g.fillOval(x, y, width, height);
            g.drawOval(x, y, width, height);
        }
        // g.drawRect(limitleftx, limituppery, limitrightx - limitleftx, limitlowery -
        // limituppery);
    }

    //this method calculates the limits an object has regarding collision with the walls 
    //of the frame
    @Override
    void updatechords(int x, int y) {
        this.x = x;
        this.y = y;

        this.limitleftx = x;
        this.limitrightx = x + 2 * this.width;
        this.limitlowery = y + 2 * this.height;
        this.limituppery = y;
    }

}