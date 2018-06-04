package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;

public class Controller {

    @FXML
    Button button;

    @FXML
    Label time;

    static Long startTime= new Long(0);

    boolean flag = true;

    public void play(javafx.event.ActionEvent event){
        System.out.println("test");



        Long endTime = new Long(0);
        Long duration = new Long(0);

        if(flag){
            this.startTime = System.nanoTime();
            button.setStyle("-fx-background-color: lawngreen");
            flag = false;
        }else{
            endTime = System.nanoTime();
            button.setStyle("-fx-background-color: red");
            duration = (endTime - this.startTime);
            Long result = duration/1000000;
            time.setText(result.toString());
            flag = true;
        }
    }
}
