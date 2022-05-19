import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dolphin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dolphin extends Actor
{
    GreenfootSound dolphinSound = new GreenfootSound("dolphin1.mp3");
    GreenfootImage idle = new GreenfootImage("dolphin.png");
    
    /**
     * Constructor - The code that gets run one time when object is created
     */
    public Dolphin()
    {
        idle.scale(200,100);
        setImage(idle);
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
    
        //Eat the strawberry
        if(isTouching(Strawberry.class))
        {
            removeTouching(Strawberry.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            world.spawnStrawberry();
            dolphinSound.play();
        }
    }
}
