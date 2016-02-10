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
        this.initColors();
        this.generateBlocks();
    }
    
    /**
     * Set the width of the grid
     * @param width 
     */
    public void setWidth(double width) {
        this.width = width;
    }
    
    /**
     * Set the height of the grid
     * @param height 
     */
    public void setHeight(double height) {
        this.height = height;
    }
    
    /**
     * Set the colors to be used on the grid.
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
     * Calculate the size of the blocks width and height based on the width
     * and height of the grid in combination with the desired number of rows
     * and columns.
     */
    protected void calcBlockSize() {
        this.blockWidth = Math.ceil(this.width/this.cols);
        this.blockHeight = Math.ceil(this.height/this.rows);
    }
    
    /**
     * Generate the required number of blocks based on the rows and columns,
     * set the size of the blocks based on the size of the grid.  Make the block
     * a random color for the colors array.
     */
    protected void generateBlocks() {
       this.calcBlockSize();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                Random rand = new Random();
                Rectangle r = new Rectangle(this.blockWidth, this.blockHeight, 
                        this.colors.get(rand.nextInt(this.colors.size())));
                this.blocks[i][j] = r;
            }
        } 
    }
    
    /**
     * Append the blocks to the grid.
     */
    public void addBlocksToGrid() {
        this.calcBlockSize();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.grid.add(this.blocks[i][j], j, i);
            }
        }
    }

    /**
     * Refresh the dimensions of the block width/height.  Will be called if the
     * scene is resized to ensure that the there is no whitespace/trim.
     */
    public void refreshBlockDimensions() {
        this.calcBlockSize();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                Rectangle r = this.blocks[i][j];
                r.setWidth(this.blockWidth);
                r.setHeight(this.blockHeight);
            }
        }
    }
}
