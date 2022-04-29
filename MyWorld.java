import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world is the environment where the game is happening.
 * 
 * @author Gregor Kokalj
 * @version February 10 2020
 */
public class MyWorld extends World
{
    private final String START="START";
    private final String PLAYING="PLAYING";
    private final String WIN="WIN";
    private final String LOSE="LOST";
    private int Level = 1;
    private String curState;
    //asteroid X and Y
    int astX = 100;
    int astY = 50;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);  
        //set starting state
        curState=START;
        //Title screen 
        this.setBackground("Background.png");

    }

    public void act(){
        SpaceShip mySpaceShip = new SpaceShip();
        //Asteroid myAsteroid = new Asteroid();
        if (curState == START && Greenfoot.isKeyDown("space")) 
        {
            curState = PLAYING;//playing condition
            this.setBackground("PlayBlackground.png");
            //create planet object and put it in the upper right corner
            int planetX = 520;
            int planetY = 80;
            this.addObject(new Planet(), planetX, planetY);
            this.addObject(new Planet(),planetX,planetY + 280);
            //add asteroid #1
            this.addObject(new Asteroids(),astX,astY);

            this.addObject(new Asteroids(),astX + 400,astY + 20);

            int shipX = 0;
            int shipY = 280;
            this.addObject(mySpaceShip, shipX, shipY);
        }

        if (curState == PLAYING && Level == 1 && this.getObjects(Planet.class).size()==1){
            Level =2;
            this.addObject(new Asteroids(), astX + 20, astY + 50);
        }
        if (curState == PLAYING && (this.getObjects(Planet.class).size() == 0)) //winning state

        {

            curState = WIN; //winning condition
            this.setBackground("WinBackground.png");
        }
        //if (mySpaceShip.getOneIntersectingObject(Asteroids.class) != null)//loosing state
        if (curState == PLAYING && (this.getObjects(SpaceShip.class).size() == 0))
        {
            curState = LOSE; //lose condition
            this.setBackground("LoseBackground.png");
        }

    }
}
