package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class Controller {

    @FXML
    Button button;

    @FXML
    Label time;

    @FXML
    Button resetGame;


    boolean flag = false;
    boolean flagStartGame = false;


    private Long startTime;
    private Long startTimeGame;


    public void play(javafx.event.ActionEvent event){


        if (flagStartGame) {
            if (flag) {
                endGame();
                flagStartGame = !flagStartGame;
            }  else if (!flag) {
                countGame();
            }
        }else if(!flagStartGame){
            playAgain();
        }

    }

    private void playAgain() {
        button.setStyle("-fx-background-color: blue");
        button.setText("Najpierw Rozpocznij gre");
        time.setText("");
    }

    private void countGame() {
        startTime = System.currentTimeMillis();
        Random random = new Random();
        final int randomTime = (random.nextInt(9000)+2);
        Long resultRandomTime = startTime + randomTime;
        Long timeToLoop;
        do {
            timeToLoop = System.currentTimeMillis();
        } while (resultRandomTime > timeToLoop);
        startTimeGame = System.currentTimeMillis();
        button.setText("Klikaj !!!");
        time.setText("");
        button.setStyle("-fx-background-color: green");
        flag = !flag;
    }

    private void endGame() {
        Long endTime = System.currentTimeMillis();
        button.setStyle("-fx-background-color: red");
        Long resultTime = (endTime - startTimeGame);
        button.setText("Koniec gry");
        time.setText(resultTime.toString());
        flag = !flag;
    }

    public void resetGame(javafx.event.ActionEvent actionEvent) {
        button.setStyle("");
        button.setText("Kliknij, nastepnie zareaguj \n po zmienie koloru");
        flagStartGame = true;
    }
}
