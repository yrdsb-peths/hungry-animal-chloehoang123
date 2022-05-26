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
    GreenfootImage[] idleRight = new GreenfootImage[5];
    GreenfootImage[] idleLeft = new GreenfootImage[5];
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Constructor - The code that gets run one time when object is created
     */
    public Dolphin()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/dolphin_sprites/idle" + i + ".png");
            idleRight[i].scale(150, 150);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/dolphin_sprites/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(150, 150);
        }
        
        animationTimer.mark();
        
        setImage(idleRight[0]);
    }

    /**
     * Animate the dolphin
     */
    int imageIndex = 0;
    public void animateDolphin()
    {
        if(animationTimer.millisElapsed() < 150)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
           setImage(idleRight[imageIndex]);
           imageIndex = (imageIndex + 1) % idleRight.length; 
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
            facing = "left";
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            move(2);
            facing = "right";
        }
        
        animateDolphin();
        
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
