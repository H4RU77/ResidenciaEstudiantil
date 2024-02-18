package org.example;
import org.example.Estudiante;

import java.util.Arrays;

public class Extranjero extends Estudiante {
    String pais;
    int nPasaporte;
    String direccion;
    int anioEntrada;

    public Extranjero(String nombre, int nIdentificacion, int anio, String carrera, int[] evaluaciones, String pais, int nPasaporte, String direccion,int anioEntrada){
        super(nombre,nIdentificacion,anio,carrera,evaluaciones);
        this.pais = pais;
        this.nPasaporte = nPasaporte;
        this.direccion = direccion;
        this.anioEntrada = anioEntrada;

    }
    public String evFinal(){
        int contadorMal=0;
        int sumatoria =0;

        String resultado = "";
        for(int i=0;i<3;i++){
            if(evaluaciones[i]<6){
                contadorMal++;
            }
            if(contadorMal==2){
                resultado = "Mal";
                break;
            }
            sumatoria += evaluaciones[i];
        }
        if (resultado!="Mal") {
            int promedio = sumatoria / 3;
            if (promedio >= 6 && promedio <= 8) {
                resultado = "Cumplidor";
            } else if (promedio > 8) {
                resultado = "Destacado";
            }
        }

        return resultado;
    }

    public String toString() {
        return "Perfil Estudiante Extranjero\n"+"Nombre: "+nombre+", Número de identificación: "+nIdentificacion+", Año que estudia: "+anio+
                ", Carrera: "+carrera+", Evaluaciones: "+ Arrays.toString(evaluaciones)+", País: "+pais+", Número de pasaporte: "+nPasaporte+
                ", Dirección: "+direccion+", Año de entrada al país: "+anioEntrada;

    }

    public String getPais() {
        return pais;
    }
    public int getAnio() {
        return anio;
    }

}
