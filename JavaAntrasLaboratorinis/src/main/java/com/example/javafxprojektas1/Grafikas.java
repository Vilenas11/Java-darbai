package com.example.javafxprojektas1;
import java.util.ArrayList;

public class Grafikas {
    public ArrayList<Float> palukanos = new ArrayList<>();
    public ArrayList<Float> kreditas = new ArrayList<>();
    public ArrayList<Float> menImoka =new ArrayList<>();
    public float terminasMenesiais;
    public float suma;
    public float kreditoSumaGalutine;
    public float metinesPalukanos;
    void readInfo(float pal, float sum, int men){
        terminasMenesiais = men;
        metinesPalukanos = pal;
        suma = sum;
        kreditoSumaGalutine= 0;
    }
    ArrayList<Float> getMenImoka(){
        return menImoka;
    }
    float getGalutineKreditoSuma(){
        return kreditoSumaGalutine;
    }
}

