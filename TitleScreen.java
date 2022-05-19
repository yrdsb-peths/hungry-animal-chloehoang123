import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Label titleLabel = new Label("Hungry Dolphin", 75);
        addObject(titleLabel,getWidth()/2, 75);
        prepare();
        Label instructionLabell = new Label("Use \u2190 and \u2192 to Move", 40);
        addObject(instructionLabell, getWidth()/2, 250);
        Label instructionLabel = new Label("Press <space> to begin", 40);
        addObject(instructionLabel, getWidth()/2, 325);
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Dolphin dolphin = new Dolphin();
        addObject(dolphin, getWidth()/2, 175);
    }
}
