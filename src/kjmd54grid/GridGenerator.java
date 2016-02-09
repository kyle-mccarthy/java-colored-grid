/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kjmd54grid;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kylemccarthy
 */
public class GridGenerator {
    protected GridPane grid;
    protected int rows = 0;
    protected int cols = 0;
    protected double height = 0;
    protected double width = 0;
    protected ArrayList<Color> colors = new ArrayList<>();
    protected final int blockWidth = 10;
    protected final int blockHeight = 10;
    
    /**
     * 
     * @param pane 
     */
    GridGenerator(GridPane pane) {
        this.grid = pane;
        this.initColors();
    }
    
    /**
     * 
     * @param pane
     * @param width
     * @param height 
     */
    GridGenerator(GridPane pane, double width, double height) {
        this.grid = pane;
        this.height = height;
        this.width = width;
        this.initColors();
    }
    
    /**
     * 
     */
    protected void initColors()
    {
        this.colors.add(Color.RED);
        this.colors.add(Color.BLUE);
        this.colors.add(Color.AQUAMARINE);
        this.colors.add(Color.GREEN);
    }
    
    /**
     * 
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    /**
     * 
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     * 
     * @return 
     */
    public double getWidth() {
        return width;
    }
    
    /**
     * 
     * @return 
     */
    public double getHeight() {
        return height;
    }
    
    public void generateRows() {
        
    }
    
    public void generateColumns() {
        
    }
    
    public void generateBlocks() {
        Random rand = new Random();
        Rectangle r = new Rectangle(this.blockWidth, this.blockHeight, 
                colors.get(rand.nextInt(this.colors.size())));
        this.grid.getChildren().add(r);
    }
    
}
