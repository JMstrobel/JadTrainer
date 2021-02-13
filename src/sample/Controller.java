package sample;

import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Controller {

    private boolean playing;
    private int successCount, failCount, totalDamage;
    private String activePrayer, targetPrayer;

    public int getSuccessCount() {
        return successCount;
    }

    public int getFailCount() {
        return failCount;
    }

    Controller(){
        playing = false;
        activePrayer = "none";
        successCount = 0;
        failCount = 0;
        totalDamage = 0;
    }
    public Controller(String initialPrayer){
        playing = false;
        activePrayer = initialPrayer;
        successCount = 0;
        failCount = 0;
        totalDamage = 0;
    }

    void startStop(MediaPlayer animationPlayer) {

        if(!playing){
            animationPlayer.play();

        }else{
            animationPlayer.pause();
        }
        playing = !playing;
    }

    void activateProtMagic(){
        activePrayer = "magic";
    }
    void activateProtMissiles(){
        activePrayer = "range";
    }

    String successCheck(String targetPrayer){
        System.out.print("Target Prayer: " + targetPrayer);
        if(activePrayer.equals(targetPrayer)) {
            successCount++;
            System.out.println(" Prayer chosen successfully. Total successes: " + successCount);
            return "Prayer set correctly. Good Job!";
        }else{
            failCount++;
            System.out.println(" Failure: " + failCount);
            successCount = 0;
            int i = ThreadLocalRandom.current().nextInt(93);
            return "Jad has hit you. You take: " + i + " damage. \nFor a total of: " + totalDamage + " damage.";

        }
    }

    String nextAttack() {

        if((int)(Math.random() * 10) % 2 == 0){
            targetPrayer = "range";
            return "range";
        }else{
           targetPrayer = "magic";
           return "magic";
        }

    }
}
