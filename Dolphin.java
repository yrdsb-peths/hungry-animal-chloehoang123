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
    GreenfootImage idleLeft = new GreenfootImage("dolphin.png");
    String facing = "right";
    
    /**
     * Constructor - The code that gets run one time when object is created
     */
    public Dolphin()
    {
        idle.scale(175,100);
        idleLeft.mirrorHorizontally();
        idleLeft.scale(175,100);
        
        if(facing.equals("right"))
        {
            setImage(idle);
        }
        else
        {
            setImage(idleLeft);
        }
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setImage(idleLeft);
            move(-2);
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            setImage(idle);
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
