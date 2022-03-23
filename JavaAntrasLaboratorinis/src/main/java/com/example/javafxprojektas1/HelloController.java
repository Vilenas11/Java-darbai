package com.example.javafxprojektas1;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
//import javafx.scene.input.InputMethodEvent;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {
    Paskola paskola1 = new Paskola();
    LinijinisGrafikas l1 = new LinijinisGrafikas();
    AnuitetoGrafikas a1 = new AnuitetoGrafikas();
    ArrayList<Float> menImokaL;
    ArrayList<Float> menImokaA;
    float suma, metProcentai;
    int metai, menesiai;
    @FXML
    private TextField MetinisProcentasLabel;
    private NumberAxis xAxis = new NumberAxis();
    private NumberAxis yAxis = new NumberAxis();
    @FXML
    private LineChart lineChart = new LineChart(xAxis, yAxis);
    @FXML
    private TextField PaskolosSumaLabel;

    @FXML
    private TextField PaskolosTerminasMenesiaiLabel;

    @FXML
    private TextField PaskolosTerminasMetaiLabel;
    @FXML
    private Label welcomeText;
    @FXML
    private RadioButton RadioButtonLinijinis;
    @FXML
    private RadioButton RadioButtonAnuiteto;
    @FXML
    private ToggleGroup grafikas;
    @FXML
    void display(ActionEvent event) {
        if(RadioButtonLinijinis.isSelected()) paskola1.setLinijinisGrafikas(true);
    }
    @FXML
    void display2(ActionEvent event) {
        if(RadioButtonAnuiteto.isSelected()) paskola1.setAnuitetoGrafikas(true);
    }
    @FXML
    void doTheGraph(ActionEvent event){
        l1 = paskola1.getTheLGraph();
        a1 = paskola1.getTheAGraph();
        menImokaL = l1.getMenImoka();
        menImokaA = a1.getMenImoka();
        lineChart.getData().clear();
        XYChart.Series series = new XYChart.Series();
        if(paskola1.returnGrafikasType() == true){
            for(int i =0; i<menImokaL.size(); i=i+12){
                // System.out.println(menImokaL.get(i));
                series.getData().add(new XYChart.Data(i+1, menImokaL.get(i)));
            }

        }
        else{

            for(int i =0; i<menImokaA.size(); i=i+12){
                // System.out.println(menImokaL.get(i));
                series.getData().add(new XYChart.Data(i+1, menImokaA.get(i)));
            }
        }

        lineChart.getData().add(series);
    }
    @FXML
    void StoreTheInformation(ActionEvent event){
       suma = Float.parseFloat(PaskolosSumaLabel.getText());
       paskola1.setSuma(suma);
       //System.out.println("suma "+paskola1.getSuma());
       metai = Integer.parseInt(PaskolosTerminasMetaiLabel.getText());
       paskola1.setTerminasMetai(metai);
        //System.out.println("metai "+paskola1.getTerminasMetai());
       menesiai = Integer.parseInt(PaskolosTerminasMenesiaiLabel.getText());
       paskola1.setTerminasMenesiai(menesiai);
        //System.out.println("men "+paskola1.getTerminasMenesiai());
       metProcentai = Float.parseFloat(MetinisProcentasLabel.getText());
       paskola1.setMetinisProcentas(metProcentai);
        //System.out.println("metproc " + paskola1.getMetinisProcentas());
       paskola1.doTheCounting();
       welcomeText.setText("Paskolos suma: " + String.valueOf(paskola1.getGalutinePaskolosSuma()));
    }

}