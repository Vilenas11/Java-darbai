package com.example.javatreciaslaboratorinis;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.util.Callback;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    ///
    //Duomenys
    ///
    private ArrayList<Mokinys> mokiniuSaraselis = new ArrayList<>();
    private ArrayList<Grupe> GrupiuSarasasHehe = new ArrayList<Grupe>();
    GrupiuSarasas grupiuSarasas = new GrupiuSarasas();
    @FXML
    private TreeTableView<Grupe> Lentele;
    @FXML
    private TreeTableColumn<Grupe, String> LenteleGrupeColumn;
    @FXML
    private TreeTableColumn<Grupe, String> LenteleStudentasColumn;
    @FXML
    private TreeTableColumn<Grupe, Number> LenteleMokejimasColumn;
    @FXML
    private TextField NustatytiMokinioMokejimaText;
    @FXML
    private TextField nustatytiMokejimaGrupeiText;
    @FXML
    private TextField SukurtiNaujaGrupeText;//
    @FXML
    private MenuButton LentelesMenuoMenuButton;
    @FXML
    private TextField PridetiMokiniPrieGrupesText;
    ////
    // Combo Boxai
    ////
    @FXML
    private ComboBox<String> NustatytiMokinioMokejimaMokCombo;//
    @FXML
    private ComboBox<String> LentelesMenuoCombo;//
    @FXML
    private ComboBox<String> NustatyMokejimaGrupeiCombo2;//
    @FXML
    private ComboBox<String> NustatytiMokinioMokejimaCombo2;//
    @FXML
    private ComboBox<String> NustatytiMokejimaGrupeiCombo;//
    @FXML
    private ComboBox<String> PridetiMokiniPrieGrupesCombo;//
    @FXML
    private ComboBox<String> NustatytiMokinioMokejimaCombo;
    ////
    // Metodai
    ////
    @FXML
    public void initialize(){
        LentelesMenuoCombo.getItems().removeAll(LentelesMenuoCombo.getItems());
        LentelesMenuoCombo.getItems().addAll("Sausis", "Vasaris", "Kovas", "Balandis","Geguze", "Birzelis", "Liepa", "Rugpjutis", "Rugsejis", "Spalis", "Lapkritis", "Gruodis");
        NustatyMokejimaGrupeiCombo2.getItems().removeAll(NustatyMokejimaGrupeiCombo2.getItems());
        NustatyMokejimaGrupeiCombo2.getItems().addAll("Sausis", "Vasaris", "Kovas", "Balandis","Geguze", "Birzelis", "Liepa", "Rugpjutis", "Rugsejis", "Spalis", "Lapkritis", "Gruodis");
        NustatytiMokinioMokejimaCombo2.getItems().removeAll(NustatytiMokinioMokejimaCombo2.getItems());
        NustatytiMokinioMokejimaCombo2.getItems().addAll("Sausis", "Vasaris", "Kovas", "Balandis","Geguze", "Birzelis", "Liepa", "Rugpjutis", "Rugsejis", "Spalis", "Lapkritis", "Gruodis");
    }
    @FXML
    void RodytiDuomenis(ActionEvent event) {
       // int menuoIndexas = LentelesMenuoCombo.getSelectionModel().getSelectedIndex();
       // GrupiuSarasasHehe = grupiuSarasas.returnGrupiuSaraselis();
        //ArrayList<TreeItem<Grupe>> meow = new ArrayList<TreeItem<Grupe>>();
       /* for(int i=0; i<GrupiuSarasasHehe.size(); i++){
            TreeItem<Grupe> per1 = new TreeItem<>(GrupiuSarasasHehe.get(i));
           meow.add(per1);

        }
        for(int i=0; i<meow.size(); i++){
            Lentele.setRoot(meow.get(i));
        }*/


    }
    @FXML
    void issaugotiIFaila(ActionEvent event) throws FileNotFoundException {
        int skaicius = LentelesMenuoCombo.getSelectionModel().getSelectedIndex();
        grupiuSarasas.writeToCsv(skaicius);
    }
    @FXML
    void SukurtiNaujaGrupe(ActionEvent event) {
        /*gaidys = SukurtiNaujaGrupeText.getText();
        TreeItem<String> meow1 = new TreeItem<>("KATINAS1");
        TreeItem<String> meow2 = new TreeItem<>("KATINAS2");
        TreeItem<String> root = new TreeItem<>(gaidys);
        root.getChildren().setAll(meow1, meow2);
        LenteleGrupeColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<String, String> stringStringCellDataFeatures) {
               return new SimpleStringProperty(stringStringCellDataFeatures.getValue().getValue());
            }
        });
        Lentele.setRoot(root);
        */

        grupiuSarasas.makeANewGroup(SukurtiNaujaGrupeText.getText());
        NustatykVisusComboBoxus();
        grupiuSarasas.isCoutinkGrupes();
    }
    void NustatykVisusComboBoxus(){
        GrupiuSarasasHehe = grupiuSarasas.returnGrupiuSaraselis();
        for(int i =GrupiuSarasasHehe.size()-1; i<GrupiuSarasasHehe.size(); i++){
            PridetiMokiniPrieGrupesCombo.getItems().addAll(GrupiuSarasasHehe.get(i).GetPavadinimas());
            NustatytiMokejimaGrupeiCombo.getItems().addAll(GrupiuSarasasHehe.get(i).GetPavadinimas());
            NustatytiMokinioMokejimaCombo.getItems().addAll(GrupiuSarasasHehe.get(i).GetPavadinimas());
        }
        //PridetiMokiniPrieGrupesCombo.getItems().addAll(SukurtiNaujaGrupeText.getText());
        //NustatytiMokejimaGrupeiCombo.getItems().addAll(SukurtiNaujaGrupeText.getText());
        //NustatytiMokinioMokejimaCombo.getItems().addAll(SukurtiNaujaGrupeText.getText());
    }
    @FXML
    void NustatykMokiniuComboBoxus(ActionEvent event){
        NustatytiMokinioMokejimaMokCombo.getItems().removeAll(NustatytiMokinioMokejimaMokCombo.getItems());
        GrupiuSarasasHehe = grupiuSarasas.returnGrupiuSaraselis();
        int grupesIndexas = NustatytiMokinioMokejimaCombo.getSelectionModel().getSelectedIndex();
        mokiniuSaraselis = GrupiuSarasasHehe.get(grupesIndexas).getMokiniuSarasas();
        for(int i =0; i<mokiniuSaraselis.size(); i++){
            NustatytiMokinioMokejimaMokCombo.getItems().addAll(mokiniuSaraselis.get(i).getMokinioVardas());
        }
    }
    @FXML
    void PridetiMokiniPrieGrupesFunkcija(ActionEvent event) {
        int selectedIndex = PridetiMokiniPrieGrupesCombo.getSelectionModel().getSelectedIndex();
        grupiuSarasas.AddAStudentToAGroup(selectedIndex, PridetiMokiniPrieGrupesText.getText());
    }
    @FXML
    void NustatytiMokejimaGrupei(ActionEvent event) {
        int selectedIndex = NustatyMokejimaGrupeiCombo2.getSelectionModel().getSelectedIndex(); //menesio
        int selectedIndex2 = NustatytiMokejimaGrupeiCombo.getSelectionModel().getSelectedIndex();//grupes
        float f=Float.parseFloat(nustatytiMokejimaGrupeiText.getText());
        grupiuSarasas.AddAPaymentForTheWholeGroup(selectedIndex2,f,selectedIndex);
    }
    @FXML
    void NustatytiMokinioMokejimaFunkcija(ActionEvent event) {
        int selectedIndex1 = NustatytiMokinioMokejimaCombo.getSelectionModel().getSelectedIndex();//grupes
        int selectedIndex2 = NustatytiMokinioMokejimaMokCombo.getSelectionModel().getSelectedIndex();// mokinio
        int monthValue = NustatytiMokinioMokejimaCombo2.getSelectionModel().getSelectedIndex();
        float value = Float.parseFloat(NustatytiMokinioMokejimaText.getText());
        grupiuSarasas.AddAPaymentForAnIndividualStudent(selectedIndex1, selectedIndex2,monthValue,value);
    }

}