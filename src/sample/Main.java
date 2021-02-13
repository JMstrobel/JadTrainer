package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("JadTrainer");

        primaryStage.setScene(new Scene(root, 300, 275));

        //Create boxes to hold various components in a layout.
        HBox buttonAnimationAndLogHolder = new HBox();
        VBox animationAndButtonHolder = new VBox();
        HBox buttonHolder = new HBox();

        //Create the Buttons for user input
        Image protMagicImg = new Image(getClass().getResourceAsStream("ProtMagic.png"));
        Image protMisslesImg = new Image(getClass().getResourceAsStream("ProtMissles.png"));
        Button protMagicButton = new Button("Protection from Magic", new ImageView(protMagicImg));
        Button protRangeButton = new Button("Protection from Magic", new ImageView(protMisslesImg));
        Button startStop = new Button("Start!");


        //Initialize scene and bring up the window
        Scene scene = new Scene(buttonAnimationAndLogHolder);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
