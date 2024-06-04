package _04_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Snake {
	public static final Color SNAKE_COLOR = Color.GREEN;
	public static final int BODY_SIZE = 50;
boolean spawn;
	private SnakeSegment head;
	 ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE, 0);
		snake.add(head);
		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		System.out.println(snake.size());
		if(snake.size()<2) {
		snake.add(new SnakeSegment(snake.get(snake.size()-1).getLocation(), BODY_SIZE, 0));
		}
		else{
			spawn = true;
		}
	}

	public Location getHeadLocation() {
		return head.getLocation();
	}

	public void update() {
int nextx = head.getLocation().getX();
int nexty = head.getLocation().getY();

/*
		 * Create variables for the next X and Y location of the snake's head.
		 * Initialize them to the current X and Y locations.
		 */
/*switch (currentDirection) {

case UP:
	nexty-=1;
	System.out.println("fourth");
case RIGHT:
	nextx+=1;
case DOWN:
	nexty+=1;
case LEFT:
	nextx-=1;

}*/
if(currentDirection.equals(Direction.UP) && isNotOppositeDirection(Direction.UP)) {
	nexty-=1;
}
else if(currentDirection.equals(Direction.RIGHT) && isNotOppositeDirection(Direction.RIGHT)) {
	nextx+=1;
}
else if(currentDirection.equals(Direction.DOWN) && isNotOppositeDirection(Direction.DOWN)) {
	nexty+=1;
}
else if(currentDirection.equals(Direction.LEFT) && isNotOppositeDirection(Direction.LEFT)) {
	nextx-=1;
}
if(spawn) {
	snake.add(new SnakeSegment(snake.get(snake.size()-1).getLocation(), BODY_SIZE, 0));
spawn =false;
}
for (int i=snake.size()-1; i<snake.size(); i++){
	snake.get(i).setLocation(snake.get(i-snake.size()+1).getLocation());
}
		/*
		 * Use a switch statement to check on the currentDirection of the snake and
		 * calculate the head's next x and y position. Depending on the direction, the
		 * variables you created may increase or decrease by 1.
		 */
for (int i = 0; i < snake.size()-1; i++) {
	snake.get(i).setLocation(snake.get(i+1).getLocation());
}
		/*
		 * Change the Location of each SnakeSegment in your snake ArrayList to the
		 * Location of the segment in front of it.
		 * 
		 * Use a loop starting at the end of the ArrayList and stop before the head of
		 * the snake (index 0) or you will go out of bounds.
		 */
Location next = new Location(nextx, nexty);
head.setLocation(next);
		/*
		 * Create a new Location object and initialize it with the values calculated in
		 * the first step. Then set the head's location equal to the new location.
		 */
canMove = true;
		// Set the canMove member variable to true.

	}

	public void setDirection(Direction direction) {
//if(isNotOppositeDirection(direction)) {
	currentDirection = direction;
//}
		/*
		 * If the passed in direction is not the opposite direction of currentDirection
		 * and canMove is true, set currentDirection to the passed in direction and
		 * canMove to false
		 * 
		 * Hint: Use the isNotOppositeDirection method.
		 */

	}

	public boolean isNotOppositeDirection(Direction direction) {

		if(direction.equals(direction.UP)) {
			if(!currentDirection.equals(direction.DOWN)) {
				return true;
			}
			}
			if(direction.equals(direction.LEFT)) {
			if(!currentDirection.equals(direction.RIGHT)) {
				return true;
			}
			}
		if(direction.equals(direction.DOWN)) {
			if(!currentDirection.equals(direction.UP)) {
				return true;
			}
			}
		if(direction.equals(direction.RIGHT)) {
			if(!currentDirection.equals(direction.LEFT)) {
				return true;
			}

		}
	return false;



		/*
		 * Complete the method so it returns true if the passed in direction is not the
		 * opposite direction of currentDirection.
		 * 
		 * For example, if currentDirection is UP and the passed in direction is DOWN
		 * this method should return false.
		 */

		
	}

	public void resetLocation() {

		// Clear the snake.
snake.clear();
		/*
		 * Create a new Location object for the head at SnakeGame.WIDTH / 2,
		 * SnakeGame.HEIGHT / 2.
		 */
Location reset = new Location(SnakeGame.WIDTH / 2, SnakeGame.HEIGHT / 2);
		/*
		 * Set the head member variable equal to a new SnakeSegment object. Use the
		 * Location created in step 2 for the Location and the BODY_SIZE constant for
		 * the size.
		 */
head = new SnakeSegment(reset, BODY_SIZE, 1);
		// Add the head to the snake.
snake.add(head);
	}

	public boolean isOutOfBounds() {
if(head.getLocation().getX()>SnakeGame.WIDTH-1) {
	return true;
}
if(head.getLocation().getY()>SnakeGame.HEIGHT-1) {
	return true;
}
if(head.getLocation().getY()<0) {
	return true;
}
if(head.getLocation().getX()<0) {
	return true;
}
		/*
		 * Complete the method so it returns true if the head of the snake is outside of
		 * the window and false otherwise.
		 */

		return false;
	}

	public boolean isHeadCollidingWithBody() {
for (int i = 0; i < snake.size()-1; i++) {
	if(head.getLocation().getX()==snake.get(i+1).getLocation().getX() && head.getLocation().getY()==snake.get(i+1).getLocation().getY()) {
		return true;
	}
}
		/*
		 * Complete the method so it returns true if the head is located in the same
		 * location as any other body segment.
		 */

		return false;
	}

	public boolean isLocationOnSnake(Location loc) {
		for (int i = 0; i < snake.size(); i++) {
			if(loc.getX()==snake.get(i).getLocation().getX() && loc.getY()==snake.get(i).getLocation().getY()) {
				return true;
			}
		}
		if(loc.getX()==head.getLocation().getX() && loc.getY()==head.getLocation().getY()) {return true;}
		/*
		 * Complete the method so it returns true if the passed in location is located
		 * on the snake.
		 */

		return false;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}
}
