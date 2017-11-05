package inside;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.assemblits.dynamo.control.*;

public class DynamoTest extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: #252525");
        gridPane.setHgap(5.0);
        gridPane.setGridLinesVisible(true);

        gridPane.add(new AnchorPane(new Alarm()),       0, 0);
        gridPane.add(new AnchorPane(new Display()),     1, 0);
        gridPane.add(new AnchorPane(new Generator()),   2, 0);
        gridPane.add(new AnchorPane(new LevelBar()),    3, 0);
        gridPane.add(new AnchorPane(new Load()),        4, 0);
        gridPane.add(new AnchorPane(new Switch()),      5, 0);
        gridPane.add(new AnchorPane(new Transformer()), 6, 0);

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}