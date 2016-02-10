/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kjmd54grid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.beans.value.ObservableValue;
/**
 *
 * @author kylemccarthy
 */
public class Kjmd54Grid extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        
        Scene scene = new Scene(root, 300, 250);
        GridGenerator grid = new GridGenerator(root, scene.getHeight(), scene.getWidth(), 15, 10);
        grid.addBlocksToGrid();
        
        // listen for the resizing of the width
        scene.widthProperty().addListener((ObservableValue<? extends Number> observable, Number oldWidth, Number newWidth) -> {
            grid.setWidth(newWidth.doubleValue());
            grid.refreshBlockDimensions();
        });
        
        // listen for the resizing of the height
        scene.heightProperty().addListener((ObservableValue<? extends Number> observable, Number oldHeight, Number newHeight) -> {
            grid.setHeight(newHeight.doubleValue());
            grid.refreshBlockDimensions();
        });
        
        primaryStage.setTitle("Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
