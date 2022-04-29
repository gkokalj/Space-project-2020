import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Asteroids in the game are randomly flying around in space.
 * 
 * @author Gregor Kokalj
 * @version February 10 2020
 */
public class Asteroids extends Actor
{    
    private final int ASTEROID_HEIGHT = 40;
    private final int ASTEROID_WIDTH = 40;
    private final int DIST_TO_MOVE = 3;
    private final int DEG_TO_TURN = 3;
    private final int TURN_LIMIT = 150;
    private final int FULL_PERCENT = 100;
    private final int TURN_PERCENTAGE = 20;
    private final int SMALL_TURN = 30;
    private final int TURN_AROUND =180;
    
    public Asteroids()
    {
    GreenfootImage image = this.getImage();
    image.scale(ASTEROID_HEIGHT,ASTEROID_WIDTH);
    }
    /**
     * Method to move the Asteroids around
     */
    public void act() 
    {
    
        // check if Asteroid reaches the edge and turn away at random.
        if (this.isAtEdge()){
            int degToTurn = Greenfoot.getRandomNumber(TURN_LIMIT);
            this.turn(degToTurn);
        } 
        else if (Greenfoot.getRandomNumber(FULL_PERCENT) < TURN_PERCENTAGE){
            int smallTurn = Greenfoot.getRandomNumber(SMALL_TURN);
            this.turn(smallTurn);
        }
        //move 
        this.move(DIST_TO_MOVE);
        //encountering our space ship-->get intersect with SpaceShip object
        if (this.getOneIntersectingObject(SpaceShip.class) != null){
            //get reference to our SpaceShip object 
            SpaceShip Ship = (SpaceShip)this.getOneIntersectingObject(SpaceShip.class);
            //what does it do: destroy
            destroy(Ship);
        }
    }
        //if asteroid destroys the space ship then it removes it from the screen
        private void destroy(SpaceShip ship){
        World myWrld = (MyWorld)this.getWorld();
        myWrld.removeObject(ship);
    }

        
}
