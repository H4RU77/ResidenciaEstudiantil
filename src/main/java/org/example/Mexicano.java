package org.example;

import java.util.Arrays;

public class Mexicano extends Estudiante {
    private String direccion;
    public Mexicano(String nombre, int nIdentificacion, int anio, String carrera, int[] evaluaciones, String direccion){
        super(nombre,nIdentificacion,anio,carrera,evaluaciones);
        this.direccion = direccion;
    }

    public String evFinal(){
        int contadorMal=0;
        int sumatoria =0;

        String resultado = "";
        for(int i=0;i<3;i++){
            if(evaluaciones[i]<6){
                contadorMal++;
            }
            if(contadorMal==1){
                resultado = "Mal";
                break;
            }
            sumatoria += evaluaciones[i];
        }
        if (resultado!="Mal") {
            int promedio = sumatoria / 3;
            if (promedio >= 6 && promedio < 9) {
                resultado = "Regular";
            } else if (promedio >= 8) {
                resultado = "Bien";
            }
        }

        return resultado;
    }

    @Override
    public String toString() {
        return "Perfil Estudiante Mexicano\n"+"Nombre: "+nombre+", Número de identificación: "+nIdentificacion+", Año que estudia: "+anio+
                ", Carrera: "+carrera+", Evaluaciones: "+ Arrays.toString(evaluaciones)+", Dirección: "+direccion;

    }


}
