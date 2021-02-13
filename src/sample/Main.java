package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("JadTrainer");
        Media jadMagic = new Media(new File("resource/JadMagic.mp4").toURI().toString());
        Media jadRange = new Media(new File("resource/JadRange.mp4").toURI().toString());


        final MediaPlayer animationPlayer = new MediaPlayer(jadMagic);
        //animationPlayer.setOnEndOfMedia(actionEvent -> {animationPlayer.play();});
        MediaView animationArea = new MediaView(animationPlayer);
        animationArea.setFitHeight(224);
        animationArea.setFitWidth(204);

        //Create boxes to hold various components in a layout.
        HBox buttonAnimationAndLogHolder = new HBox();
        VBox animationAndButtonHolder = new VBox();
        HBox buttonHolder = new HBox();

        //Create the Buttons for user input
        Image protMagicImg = new Image(new FileInputStream("resource/ProtMagic.png"));
        Image protMisslesImg = new Image(new FileInputStream("resource/ProtMissles.png"));
        Button protMagicButton = new Button("", new ImageView(protMagicImg));
        Button protRangeButton = new Button("", new ImageView(protMisslesImg));
        Button startStop = new Button("Start!");

        startStop.setOnAction(actionEvent -> {animationPlayer.play();});
        //Add buttons to appropriate boxes
        buttonHolder.getChildren().addAll(protMagicButton, protRangeButton, startStop);
        animationAndButtonHolder.getChildren().addAll(animationArea, buttonHolder);
        buttonAnimationAndLogHolder.getChildren().addAll(animationAndButtonHolder);

        //Initialize scene and bring up the window
        Scene scene = new Scene(buttonAnimationAndLogHolder);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
