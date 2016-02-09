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
    protected ArrayList<Color> colors = new ArrayList<>();
    protected final int blockWidth = 10;
    protected final int blockHeight = 10;
    
    /**
     * 
     * @param pane
     * @param width
     * @param height 
     */
    GridGenerator(GridPane pane, int rows, int cols) {
        this.grid = pane;
        this.rows = rows;
        this.cols = cols;
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
