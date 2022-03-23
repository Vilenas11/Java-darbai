package com.example.javafxprojektas1;
import java.lang.Math;
public class AnuitetoGrafikas extends Grafikas{
    public float i;
    public float anuitetoKoeficientas;
    public float anuitetoPermoka;
    public float galutineSuma;
    public float menesioImoka;
    void countSomething(){
        i = (metinesPalukanos/12)*0.01f;
        anuitetoKoeficientas = (float)((i*Math.pow(1+i, terminasMenesiais))/(Math.pow(1+i,terminasMenesiais)-1));
        anuitetoKoeficientas = anuitetoKoeficientas * 100;
        System.out.println(anuitetoKoeficientas);
        anuitetoPermoka = suma*anuitetoKoeficientas;
        kreditoSumaGalutine = anuitetoPermoka+suma;
        menesioImoka = kreditoSumaGalutine / terminasMenesiais;
        for(int i =0; i<terminasMenesiais; i++){
            menImoka.add(menesioImoka);
        }

    }
}
