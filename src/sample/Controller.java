package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;

import java.awt.Color;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

import static java.awt.Color.getColor;

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
HashMap<String, Double> colors=new HashMap<String, Double>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchorPane.setStyle("-fx-background-color: rgb(" + sliderR.getValue() + "," + sliderG.getValue() + ", " + sliderB.getValue() + ");");
        colorName();
        sliderR.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                anchorPane.setStyle("-fx-background-color: rgb(" + newValue + "," + sliderG.getValue() + ", " + sliderB.getValue() + ");");
                colorName();
            }
        });
        sliderG.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                anchorPane.setStyle("-fx-background-color: rgb(" + sliderR.getValue() + "," + newValue + ", " + sliderB.getValue() + ");");
                colorName();
            }
        });
        sliderB.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                anchorPane.setStyle("-fx-background-color: rgb(" + newValue + "," + sliderG.getValue() + ", " + newValue + ");");
                colorName();

            }
        });
        checkBoxColor.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    colorLabel.setVisible(newValue);
                    colorName();
               
            }
        });
    }
    private void colorName(){
        String temp;
        String[] c={"RED","BLACK","GREY","GREEN","BLUE","WHITE","YELLOW","LIGHTGREY","DARKGERY","PINK","ORANGE","CYAN","MAGENTA"};
        try {
            Class cl = Class.forName("Color");
            //Method method = cl.getMethod(c[i]);
            for (int i = 0; i < c.length; i++) {
                temp = c[i];
                //Color color = new Color(cl.getMethod(c[i]), Color.getColor(temp).getGreen(), getColor(temp).getBlue());
                //colors.put(temp, (Math.abs(sliderR.getValue() - color.getRed())) + Math.abs(sliderG.getValue() - color.getGreen()) + (Math.abs(sliderB.getValue() - color.getBlue())));
            }
            List<Double> mapValues = new ArrayList<Double>(colors.values());
            Collections.sort(mapValues);
            for (int i = 0; i < colors.size(); i++) {
                if (colors.get(c[i]) == mapValues.get(0))
                    colorLabel.setText(c[i]);
            }
        } catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Zła klasa");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
