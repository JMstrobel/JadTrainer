package sample;

import javafx.application.Application;
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
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;


public class JadTrainerWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Controller controller = new Controller();
        primaryStage.setTitle("JadTrainer");
        Media jadMagic = new Media(new File("resource/JadMagic.mp4").toURI().toString());
        Media jadRange = new Media(new File("resource/JadRange.mp4").toURI().toString());


        final MediaPlayer magicPlayer = new MediaPlayer(jadMagic);
        final MediaPlayer rangePlayer = new MediaPlayer(jadRange);


        MediaView animationArea = new MediaView();
        if(controller.nextAttack().equals("range")){
            animationArea.setMediaPlayer(rangePlayer);
        }else{
            animationArea.setMediaPlayer(magicPlayer);
        }

        animationArea.setFitHeight(224);
        animationArea.setFitWidth(204);

        magicPlayer.setOnEndOfMedia(() -> {
            controller.successCheck("magic");
            magicPlayer.stop();
            if(controller.nextAttack().equals("range")){
                animationArea.setMediaPlayer(rangePlayer);
                rangePlayer.play();
            }else{
                animationArea.setMediaPlayer(magicPlayer);
                magicPlayer.play();
            }
        });

        rangePlayer.setOnEndOfMedia(() -> {
            controller.successCheck("range");
            rangePlayer.stop();
            if(controller.nextAttack().equals("range")){
                animationArea.setMediaPlayer(rangePlayer);
                rangePlayer.play();
            }else{
                animationArea.setMediaPlayer(magicPlayer);
                magicPlayer.play();
            }
        });

        //Create boxes to hold various components in a layout.
        HBox buttonAnimationAndLogHolder = new HBox();
        VBox animationAndButtonHolder = new VBox();
        HBox buttonHolder = new HBox();

        //Create the Buttons for user input
        Image protMagicImg = new Image(new FileInputStream("resource/ProtMagic.png"));
        Image protMisslesImg = new Image(new FileInputStream("resource/ProtMissles.png"));
        Button protMagicButton = new Button("", new ImageView(protMagicImg));
        Button protRangeButton = new Button("", new ImageView(protMisslesImg));
        Button startStop = new Button("Start");


        startStop.setOnAction(actionEvent -> {
            controller.startStop(animationArea.getMediaPlayer());
            if(startStop.getText().equals("Start")){
                startStop.setText("Stop");
            }else{
                startStop.setText("Start");
            }
        });
        protMagicButton.setOnAction(actionEvent -> {controller.activateProtMagic();});
        protRangeButton.setOnAction(actionEvent -> {controller.activateProtMissiles();});

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
