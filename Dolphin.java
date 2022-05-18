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
    
    public void act()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            move(-2);
        }
        
        if(Greenfoot.isKeyDown("d"))
        {
            move(2);
        }
        
        if(Greenfoot.isKeyDown("space"))
        {
            turn(2);
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
