import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int score = 0;
    public Label scoreLabel = new Label(score, 80);
    int level = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        Dolphin dolphin = new Dolphin();
        addObject(dolphin,300, 350);
        
        //Create a score label
        addObject(scoreLabel, 50, 40);
        
        spawnStrawberry();
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    
    public void spawnStrawberry()
    {
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        Strawberry strawberry = new Strawberry();
        addObject(strawberry, x, y);
        
        strawberry.setSpeed(level+1);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level += 1;
        }
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over!", 100);
        addObject(gameOverLabel, 300, 200);
    }
}
