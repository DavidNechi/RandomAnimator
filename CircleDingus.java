import java.awt.Graphics;

/**
 * CircleDingus is an example of a very simple Dingus.
 * 
 * @author Andrei David Nechitoaia
 * @id 180 6130
 */
class CircleDingus extends Dingus {
    protected int radius;
    protected boolean filled; // true: filled, false: outline

    /**
     * Create and initialize a new CircleDingus.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public CircleDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);

        // initialize randomly the CircleDingus properties, i.e., radius and filledness
        radius = random.nextInt(maxX / 8);
        filled = random.nextBoolean();
    }


    //set a different color
    public void SetColor(Graphics g){
        g.setColor(color);
    }

    @Override
    void draw(Graphics g) {
        SetColor(g);
        if (filled) {
            g.fillArc(x, y, 2 * radius, 2 * radius, 0, 360);
        } //else {
          //  g.drawArc(x, y, 2 * radius, 2 * radius, 0, 360);
        //}
    }

    //this method calculates the limits an object has regarding collision with the walls 
    //of the frame
    @Override
    void updatechords(int x, int y){
        this.x = x;
        this.y = y;

        this.limitleftx = x;
        this.limitrightx = x + 2 * this.radius;
        this.limitlowery = y + 2 * this.radius;
        this.limituppery = y;
    } 

}
