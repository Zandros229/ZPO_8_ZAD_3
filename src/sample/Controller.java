package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
@FXML
    Slider sliderR;
@FXML
    Slider sliderG;
@FXML
    Slider sliderB;
@FXML
    CheckBox checkBoxColor;
@FXML
    Label colorLabel;
@FXML
    AnchorPane anchorPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchorPane.setStyle("-fx-background-color: rgb(" + sliderR.getValue() + "," + sliderG.getValue() + ", " + sliderB.getValue() + ");");
        sliderR.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                anchorPane.setStyle("-fx-background-color: rgb(" + newValue + "," + sliderG.getValue() + ", " + sliderB.getValue() + ");");
            }
        });
        sliderG.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                anchorPane.setStyle("-fx-background-color: rgb(" + sliderR.getValue() + "," + newValue + ", " + sliderB.getValue() + ");");
            }
        });
        sliderB.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                anchorPane.setStyle("-fx-background-color: rgb(" + newValue + "," + sliderG.getValue() + ", " + newValue + ");");
            }
        });
        checkBoxColor.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue=true){
                    colorLabel.setText(colorName());
                }
            }
        });
    }
    private String colorName(){
        
        return "black";
    }

}
