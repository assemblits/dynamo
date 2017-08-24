package inside;

import com.eru.dynamo.control.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DynamoTest extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: #252525");

        gridPane.add(new Gauge(),       0, 0);
        gridPane.add(new Alarm(),       1, 0);
        gridPane.add(new Display(),     2, 0);
        gridPane.add(new Gauge(),       3, 0);
        gridPane.add(new Generator(),   4, 0);
        gridPane.add(new LevelBar(),    0, 1);
        gridPane.add(new Load(),        1, 1);
        gridPane.add(new Radial(),      2, 1);
        gridPane.add(new Switch(),      3, 1);
        gridPane.add(new Transformer(), 4, 1);


        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}