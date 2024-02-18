package org.example;

public abstract class Estudiante {
    protected String nombre;
    protected int nIdentificacion;
    protected int anio;
    protected String carrera;
    protected int[] evaluaciones;

    public Estudiante(String nombre, int nIdentificacion, int anio, String carrera, int[] evaluaciones){
        this.nombre = nombre;
        this.nIdentificacion = nIdentificacion;
        this.anio = anio;
        this.carrera = carrera;
        this.evaluaciones = evaluaciones;
    }

    public abstract String evFinal();



}