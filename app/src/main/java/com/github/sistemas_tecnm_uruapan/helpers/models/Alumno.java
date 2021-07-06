package com.github.sistemas_tecnm_uruapan.helpers.models;

public class Alumno
{
    String id;
    String nombre;
    String carrera;

    String telefono;
    int status;



    public Alumno(String id, String carrera, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;

        status=0;
    }
    public Alumno(String id, String nombre, String carrera, String grupo,int status) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;

        this.status=status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
