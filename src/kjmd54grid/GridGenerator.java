/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kjmd54grid;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
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
    protected double blockWidth = 0;
    protected double blockHeight = 0;
    protected ArrayList<Color> colors = new ArrayList<>();
    
    /**
     * 
     * @param pane
     * @param width
     * @param height 
     */
    GridGenerator(GridPane pane, double height, double width, int rows, int cols) {
        this.grid = pane;
        this.rows = rows;
        this.cols = cols;
        this.height = height;
        this.width = width;
        this.grid.setGridLinesVisible(true);
        this.initColors();
        this.generate();
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
        this.colors.add(Color.RED);
        this.colors.add(Color.BLUE);
        this.colors.add(Color.GREEN);
        this.colors.add(Color.AQUAMARINE);
        this.colors.add(Color.CYAN);
        this.colors.add(Color.MAGENTA);
        this.colors.add(Color.ORANGE);
        this.colors.add(Color.PINK);
        this.colors.add(Color.YELLOW);
        this.colors.add(Color.BLUEVIOLET);
    }
    
    private void calcBlockSize()
    {
        this.blockWidth = this.width/this.cols;
        this.blockHeight = this.height/this.rows;
    }
    
    public void generate() {
        this.calcBlockSize();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                Random rand = new Random();
                Rectangle r = new Rectangle(this.blockWidth, this.blockHeight, this.colors.get(rand.nextInt(this.colors.size())));
                this.grid.add(r, i, j);
            }
        }
    }    
}
