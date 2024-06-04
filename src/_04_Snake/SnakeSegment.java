package _04_Snake;

import java.awt.Color;
import java.awt.Graphics;

public class SnakeSegment {
    private Location location;
    private int size;
   int h;

    public SnakeSegment(Location loc, int size, int h) {
        this.location = loc;
        this.size = size;
    }
    
    public void setLocation(Location loc) {
        this.location = loc;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public void draw(Graphics g) {
    	if(h!=1) {
        g.setColor(Snake.SNAKE_COLOR);
        g.drawRect(location.getX() * size, location.getY() * size, size, size);;
    	}if(h==1) {
    	   g.setColor(Color.BLUE);
    	   g.drawRect(location.getX() * size, location.getY() * size, size, size);;
       }
     }
}
