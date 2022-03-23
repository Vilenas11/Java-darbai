package com.example.javatreciaslaboratorinis;

import java.util.ArrayList;

public class Grupe {
    private String grupesPavadinimas;
    private ArrayList<Mokinys> mokiniuSarasas = new ArrayList<>();
    public void makeANewStudent(String Vardas){
        Mokinys mokinukas = new Mokinys(Vardas);
        mokiniuSarasas.add(mokinukas);
    }
    Grupe(String meow){
        grupesPavadinimas = meow;
    }
    String GetPavadinimas(){
        return grupesPavadinimas;
    }
   public ArrayList<Mokinys> getMokiniuSarasas(){
        return mokiniuSarasas;
   }
   public void setMokinioPayment(int index, float sumele, int menesiuks){//index tai kelinta mokini FORUI
        mokiniuSarasas.get(index).setMokejima(sumele, menesiuks);
    }


}
