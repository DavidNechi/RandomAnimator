import java.awt.Graphics;


class RectangleDingus extends Dingus {
    protected int length;
    protected boolean filled; // true: filled, false: outline

    /* 
     @param maxX upper bound for the x coordinate of the position
     @param maxY upper bound for the y coordinate of the position
    */

    public RectangleDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);

        // initialize randomly the CircleDingus properties, i.e., radius and filledness
        length = random.nextInt(10, maxX / 4);
        filled = random.nextBoolean();
    }

    //set different color
    public void SetColor(Graphics g){
        g.setColor(color);
    }

    @Override
    void draw(Graphics g) {
        SetColor(g);
        if (filled) {
            g.fillRect(x, y, length, length);
        }// else {
           // g.drawRect(x, y, length, length);
        //}
    }

     //this method calculates the limits an object has regarding collision with the walls 
    //ofthe frame
    @Override
    void updatechords(int x, int y){
        this.x = x;
        this.y = y;

        this.limitleftx = x;
        this.limitrightx = x + this.length;
        this.limituppery = y;
        this.limitlowery = y + this.length;
    }

}
