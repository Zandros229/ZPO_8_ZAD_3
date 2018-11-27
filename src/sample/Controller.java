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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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
        Field[] colors = Color.class.getFields();
        ArrayList<ColorMyClass> list=new ArrayList<ColorMyClass>();
        for(int i = 1; i < colors.length; i+= 2) {
            Field f = colors[i];
            if(/*Modifier.isStatic(f.getModifiers()) && Modifier.isPublic(f.getModifiers())&&*/f.getName().equals(f.getName().toUpperCase())) {
                try {
                    Color c = (Color) f.get(f);
                    int[] rgb = {c.getRed(), c.getGreen(), c.getBlue()};
                    int[] value={(int)sliderR.getValue(),(int)sliderG.getValue(),(int)sliderB.getValue()};
                    list.add(new ColorMyClass(f.getName(),getDistance(rgb,value)));
                    //System.out.println(list.get(0));
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }
        }
        Collections.sort(list);
        colorLabel.setText(list.get(0).name);
    }
    private Integer getDistance(int[] a, int[] b){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1])+Math.abs(a[2]-b[2]);
    }
}
