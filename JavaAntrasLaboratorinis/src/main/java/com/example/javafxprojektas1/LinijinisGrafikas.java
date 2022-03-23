package com.example.javafxprojektas1;

public class LinijinisGrafikas extends Grafikas{
    public float kreditoSuma = suma/terminasMenesiais;
    public float palukanuSuma = ((suma/100)*metinesPalukanos)/12;
    public float kreditoMinusas = ((kreditoSuma / 100) * metinesPalukanos)/12;
    void countSomething(){
        kreditoSuma = suma/terminasMenesiais;
        palukanuSuma = ((suma/100)*metinesPalukanos)/12;
        kreditoMinusas = ((kreditoSuma / 100) * metinesPalukanos)/12;
       // System.out.print(kreditoSuma + "\n");
        for(int i = 0 ; i < terminasMenesiais; i++){
            kreditas.add(kreditoSuma);
            //System.out.println(kreditoSuma);
            palukanos.add(palukanuSuma);
            menImoka.add(kreditoSuma + palukanuSuma);
            //System.out.println(menImoka.get(i));
            kreditoSumaGalutine+=menImoka.get(i);
            //if((i+1)%12 == 0)
                palukanuSuma -= kreditoMinusas;
        }
    }

}
