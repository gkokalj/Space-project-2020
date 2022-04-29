import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The user will be able to move the space ship to reach the planets and win the game,
 * while avoiding the asteroids.
 * 
 * @author Gregor Kokalj
 * @version February 10 2020
 */
public class SpaceShip extends Actor
{
    private final int DIST_TO_MOVE = 3;
    private final int DEG_TO_TURN = 5;
    private final int SHIP_HEIGHT = 30;
    private final int SHIP_WIDTH = 30;
    public SpaceShip()

    {
    GreenfootImage image = this.getImage();
    image.scale(SHIP_HEIGHT,SHIP_WIDTH);
    }
    /**
     * Act - the act method moves the SpaceShip as follows:
     *   left cursor key - move the seahorse backward
     *   right cursor key - move the seahorse forward
     *   up cursor key - turn the seahorse counter clockwise DEG_TO_TURN
     *   down cursor key - turn the seahorse clockwise DEG_TO_TURNAct - do whatever the SpaceShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // move forward, if user presses the right key 
        if(Greenfoot.isKeyDown("right")){
            this.move(DIST_TO_MOVE);
        }
        
        //move backward, if user presses the left key
        if (Greenfoot.isKeyDown("left")){
            this.move(-DIST_TO_MOVE);
        }
        //move rocket counterclockWise 
        if (Greenfoot.isKeyDown("up")) {
            this.turn(-DEG_TO_TURN);
        }
        //move rocket clockWise 
        if (Greenfoot.isKeyDown("down")) {
            this.turn(DEG_TO_TURN);
        }
        //what if space ship intersects the planet
        //if (this.getOneIntersectingObject(Planet.class) =! null{
         //get planet object reference
         //Planet goal = (Planet)this.getOneIntersectingObject(Planet.class);
         
         //win(
        //}
        if (this.getOneIntersectingObject(Planet.class) != null){
            //get reference to our SpaceShip object 
            Planet myPlanet = (Planet)this.getOneIntersectingObject(Planet.class);
            //what does it do: destroy
            remove(myPlanet);    
    }
    
}
        private void remove(Planet myPlanet){
        World myWrld = (MyWorld)this.getWorld();
        myWrld.removeObject(myPlanet);
    }
}
