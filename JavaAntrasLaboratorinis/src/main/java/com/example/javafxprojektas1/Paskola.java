package com.example.javafxprojektas1;

public class Paskola {
    private float suma;
    private int terminasMetai;
    private int terminasMenesiai;
    private boolean linijinisGrafikas;
    private boolean anuitetoGrafikas;
    private float metinisProcentas;
    private float galutinePaskolosSuma;
    private LinijinisGrafikas LGrafikas1 = new LinijinisGrafikas();
    private AnuitetoGrafikas AGrafikas1 = new AnuitetoGrafikas();
    Paskola(){
        suma = 0;
        terminasMenesiai = 0;
        terminasMetai = 0;
        linijinisGrafikas = false;
        anuitetoGrafikas = false;
        metinisProcentas = 0;
        galutinePaskolosSuma = 0;
    }
    public void setSuma(float suma){

        this.suma = suma;
    }
    float getSuma(){
        return suma;
    }
    float getTerminasMetai(){
        return terminasMetai;
    }
    void setTerminasMetai(int terminasMetai){
        this.terminasMetai = terminasMetai;
    }
    float getTerminasMenesiai(){
        return terminasMenesiai;
    }
    void setTerminasMenesiai(int terminasMenesiai){
        this.terminasMenesiai= terminasMenesiai;
    }
    float getMetinisProcentas(){
        return metinisProcentas;
    }
    void setLinijinisGrafikas(boolean x){
        if(x == true) {
            linijinisGrafikas = true;
            anuitetoGrafikas = false;
        }
    }
    void setAnuitetoGrafikas(boolean x){
        if(x == true){
            anuitetoGrafikas = true;
            linijinisGrafikas = false;
        }
    }
    boolean returnGrafikasType(){
        return linijinisGrafikas;
    }
    void setMetinisProcentas(float metinisProcentas){
        this.metinisProcentas = metinisProcentas;
    }
    void doTheCounting(){
        int galutinisMenSk = (terminasMetai * 12) + terminasMenesiai;
        if(linijinisGrafikas == true){
            LGrafikas1.readInfo(metinisProcentas, suma, galutinisMenSk);
            LGrafikas1.countSomething();
            galutinePaskolosSuma = LGrafikas1.getGalutineKreditoSuma();
        }
        else {
            AGrafikas1.readInfo(metinisProcentas, suma, galutinisMenSk);
            AGrafikas1.countSomething();
            galutinePaskolosSuma = AGrafikas1.getGalutineKreditoSuma();
        }
    }
     LinijinisGrafikas getTheLGraph(){
        return LGrafikas1;
    }
    float getGalutinePaskolosSuma(){
        return galutinePaskolosSuma;
    }
    AnuitetoGrafikas getTheAGraph(){
        return AGrafikas1;
    }
}
