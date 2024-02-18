package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Estudiante> estudiantes= new ArrayList<>();
    public static void menu(){
        int opcion=1;
        while(opcion!=0) {
            System.out.println("Seleccione una opción: ");
            System.out.println("0. Salir");
            System.out.println("1. Incluir a un nuevo estudiante");
            System.out.println("2. Conocer cuántos becados mexicanos obtuvieron evaluación de Bien");
            System.out.println("3. Obtener cuantos estudiantes proceden de un país especificado");
            System.out.println("4. Obtener cuántos estudiantes Extranjeros pertenecen a un año dado");
            System.out.println("Opción: ");
            opcion = scan.nextInt();

            switch (opcion){
                case 0:
                    break;
                case 1: agregarEstudiante();
                    break;
                case 2: nEvalBienMex();
                    break;
                case 3: nPais();
                    break;
                case 4: nAnioExt();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public static void agregarEstudiante(){
        int n; int opcion;
        System.out.println("Ingrese el número de estudiantes que desee agregar: ");
        n= scan.nextInt();
        for(int i=0; i<n;i++){
            System.out.println("Seleccione el tipo de perfil: ");
            System.out.println("1. Estudiante Extranjero");
            System.out.println("2. Estudiante Mexicano");
            System.out.println("Opcion: ");
            opcion = scan.nextInt();

            switch(opcion){
                case 1: llenarExtranjero();
                    break;
                case 2: llenarMexicano();
                    break;
                default:
                    System.out.println("Opción no válida"); i=i-1;
            }

        }
    }
    public static void llenarExtranjero(){
        String nombre;int nIdentificacion;int anio;String carrera;int[] evaluaciones =new int[3];
        String pais;int nPasaporte;String direccion;int anioEntrada;
        System.out.println("Ingrese los siguientes datos del estudiante: ");
        System.out.println("Nombre: ");
        scan.nextLine();
        nombre=scan.nextLine();
        System.out.println("Número de identificación: ");
        nIdentificacion=scan.nextInt();
        System.out.println("Año que cursa: ");
        anio=scan.nextInt();
        System.out.println("Carrera: ");
        scan.nextLine();
        carrera=scan.nextLine();
        System.out.println("Evaluaciones: ");
        for(int i=0; i<=2;i++){
            System.out.println("Evaluación "+(i+1)+": ");
            evaluaciones[i]=scan.nextInt();
        }
        System.out.println("País: ");
        scan.nextLine();
        pais=scan.nextLine();
        System.out.println("Número de pasaporte: ");
        nPasaporte=scan.nextInt();
        System.out.println("Dirección: ");
        scan.nextLine();
        direccion=scan.nextLine();
        System.out.println("Año de entrada al país: ");
        anioEntrada=scan.nextInt();

        Extranjero e = new Extranjero(nombre,nIdentificacion,anio,carrera,evaluaciones, pais,nPasaporte,direccion,anioEntrada);
        // agregar el estudiante extranjero dentro del arreglo estudiantes
        estudiantes.add(e);
        System.out.println("Nuevo perfil de estudiante extranjero creado");
    }

    public static void llenarMexicano(){
        String nombre;int nIdentificacion;int anio;String carrera;int[] evaluaciones =new int[3];
        String direccion;
        System.out.println("Ingrese los siguientes datos del estudiante: ");
        System.out.println("Nombre: ");
        scan.nextLine();
        nombre=scan.nextLine();
        System.out.println("Número de identificación: ");
        nIdentificacion=scan.nextInt();
        System.out.println("Año que cursa: ");
        anio=scan.nextInt();
        System.out.println("Carrera: ");
        scan.nextLine();
        carrera=scan.nextLine();
        System.out.println("Evaluaciones: ");
        for(int i=0; i<=2;i++){
            System.out.println("Evaluación "+(i+1)+": ");
            evaluaciones[i]=scan.nextInt();
        }

        System.out.println("Dirección: ");
        scan.nextLine();
        direccion=scan.nextLine();


        Mexicano m = new Mexicano(nombre,nIdentificacion,anio,carrera,evaluaciones,direccion);
        // agregar el estudiante mexicano dentro del arreglo estudiantes
        estudiantes.add(m);
        System.out.println("Nuevo perfil de estudiante mexicano creado");
    }


    public static void nEvalBienMex(){
        int contadorBien=0;
        for(Estudiante estudiante: estudiantes){
            if(estudiante instanceof Mexicano){
                if(((Mexicano)estudiante).evFinal()=="Bien"){
                    contadorBien++;
                }
            }
        }
        System.out.println("La cantidad de estudiantes Mexicanos que obtuvieron la evaluación de 'Bien' fue: "+contadorBien);
    }

    public static void nPais(){
        String pais = "";
        int contadorPais=0;
        System.out.println("Ingrese el país del que desea conocer la cantidad de estudiantes: ");
        scan.nextLine();
        pais= scan.nextLine();
        if(pais.equalsIgnoreCase("Mexico") ){
            for(Estudiante estudiante: estudiantes){
                if(estudiante instanceof Mexicano){
                    contadorPais++;
                }
            }
        }else{
            for(Estudiante estudiante: estudiantes){
                if(estudiante instanceof Extranjero){
                   if( ((Extranjero)estudiante).getPais().equalsIgnoreCase(pais)){
                       contadorPais++;
                   }
                }
            }
        }

        System.out.println("La cantidad de estudiantes de "+pais+" es: "+contadorPais);

    }

    public static void nAnioExt(){
        int anio; int contAnio=0;
        System.out.println("Ingrese el año del que desea conocer la cantidad de estudiantes extranjeros: ");
        anio= scan.nextInt();
        for(Estudiante estudiante: estudiantes){
            if(estudiante instanceof Extranjero && ((Extranjero)estudiante).getAnio()==anio){
                contAnio++;
            }
        }
        System.out.println("La cantidad de estudiantes del año "+anio+" es: "+contAnio);
    }



    public static void main(String[] args) {
        menu();
    }
}