package com.example.javatreciaslaboratorinis;

public class Mokinys extends zmogus{
    private Float mokejimai[] = new Float[12];
    Mokinys(String varduks){
        super(varduks);
    }
    String getMokinioVardas(){
        return vardas;
    }
    void setMokejima(Float suma, int kuri){
        mokejimai[kuri] = suma;
    }
    Float getMokinioMokejima(int menesis){
        return mokejimai[menesis];
    };
    @Override public void kazkaDaryti(){
        System.out.println("As abstrktus");
    }
}
