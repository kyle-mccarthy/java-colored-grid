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
    protected Rectangle[][] blocks;
    
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
        this.blocks = new Rectangle[this.rows][this.cols];
        this.grid.setGridLinesVisible(true);
        this.initColors();
        this.generateBlocks();
    }
    
    /**
     * 
     */
    protected void initColors()
    {
        this.colors.add(Color.rgb(248, 177, 149));
        this.colors.add(Color.rgb(246, 114, 128));
        this.colors.add(Color.rgb(192, 108, 132));
        this.colors.add(Color.rgb(108, 91, 123));
        this.colors.add(Color.rgb(53, 92, 125));
        this.colors.add(Color.rgb(142, 125, 142));
        this.colors.add(Color.rgb(192, 131, 140));
        this.colors.add(Color.rgb(241, 137, 134));
        this.colors.add(Color.rgb(220, 155, 143));
    }
    
    /**
     * 
     */
    protected void calcBlockSize()
    {
        this.blockWidth = this.width/this.cols;
        this.blockHeight = this.height/this.rows;
    }
    
    protected void generateBlocks() {
       this.calcBlockSize();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                Random rand = new Random();
                Rectangle r = new Rectangle(this.blockWidth, this.blockHeight, this.colors.get(rand.nextInt(this.colors.size())));
                this.blocks[i][j] = r;
            }
        } 
    }
    
    /**
     * 
     */
    public void addBlocksToGrid() {
        this.calcBlockSize();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.grid.add(this.blocks[i][j], i, j);
            }
        }
    }    
}
