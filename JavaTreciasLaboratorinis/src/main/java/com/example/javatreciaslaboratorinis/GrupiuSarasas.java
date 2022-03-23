package com.example.javatreciaslaboratorinis;

import java.io.*;
import java.util.ArrayList;

public class GrupiuSarasas {
    private ArrayList<Grupe> GrupiuSaraselis = new ArrayList<Grupe>();
    public void makeANewGroup(String pavadinimas){
        Grupe grupele = new Grupe(pavadinimas);
        GrupiuSaraselis.add(grupele);
    }
    void isCoutinkGrupes(){
        for(int i=0; i<GrupiuSaraselis.size(); i++)
        System.out.println(GrupiuSaraselis.get(i).GetPavadinimas());
    }
    ArrayList<Grupe> returnGrupiuSaraselis(){
        return GrupiuSaraselis;
    }
    public void AddAStudentToAGroup(int index, String vardux){
        GrupiuSaraselis.get(index).makeANewStudent(vardux);
    }
    ArrayList<Mokinys> getMokiniuSarasasOfAGroup(int index){
        return GrupiuSaraselis.get(index).getMokiniuSarasas();
    }
    public void AddAPaymentForTheWholeGroup(int index, float value, int month) {
        for (int i = 0; i <GrupiuSaraselis.get(index).getMokiniuSarasas().size(); i++) {
            GrupiuSaraselis.get(index).setMokinioPayment(i, value, month);
        }
    }
    public void AddAPaymentForAnIndividualStudent(int grupesIndex, int mokinioIndex, int month, float value){
        GrupiuSaraselis.get(grupesIndex).setMokinioPayment(mokinioIndex,value,month);
    }
    public void writeToCsv(int sk) throws FileNotFoundException {
        /*File csvFile = new File("grupes.csv");
        PrintWriter out = new PrintWriter(csvFile);*/

        try{
            FileWriter fw = new FileWriter("grupes.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for(int i=0; i<GrupiuSaraselis.size(); i++){
                pw.println(GrupiuSaraselis.get(i).GetPavadinimas());
                System.out.println(GrupiuSaraselis.get(i).GetPavadinimas());
                for(int j=0; j<GrupiuSaraselis.get(i).getMokiniuSarasas().size(); j++){
                    //System.out.println(GrupiuSaraselis.get(i).getMokiniuSarasas().get(j).getMokinioVardas());
                    pw.println(GrupiuSaraselis.get(i).getMokiniuSarasas().get(j).getMokinioVardas()+","+GrupiuSaraselis.get(i).getMokiniuSarasas().get(j).getMokinioMokejima(sk));
                    //System.out.print(GrupiuSaraselis.get(i).getMokiniuSarasas().get(j).getMokinioMokejima(sk));
                    //pw.println(GrupiuSaraselis.get(i).getMokiniuSarasas().get(j).getMokinioMokejima(sk));
                }
            }
            pw.flush();
            pw.close();
        }
        catch(Exception e){

        }

    }
}
