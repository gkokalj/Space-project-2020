import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Our Goal is to reach the Planets and avoid the Asteroids. The Planets are therefore the main goals to achieve.
 * After the user reaches the first planet, the game's level 2 adds another asteroid to increase the difficulty.
 * After User reaches the second planet he wins the game.
 * if asteroid hits the space ship at any stage of the game the user loses.
 * 
 * Gregor Kokalj 
 * @version February 10 2020
 */
public class Planet extends Actor
{
    private final int PLANET_HEIGHT = 75;
    private final int PLANET_WIDTH = 75;
    
    public Planet()
    {
        GreenfootImage image = this.getImage();
        image.scale(PLANET_WIDTH, PLANET_HEIGHT); 
    }
        
    /**
     * Act - The Planets are our goal to reach. They are gonna be at the upper right and lower right corner.
     * 
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
