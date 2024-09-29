/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoappmitienda;

/**
 *
 * @author Felipe
 */
public class Persona {
    //atributos
    private String idDNIPersona;
    private String nombre;
    private String apeliido;
    private String tipoDNI;
    private int numeroMesa;

    public Persona() {
    }

    public Persona(String idDNIPersona, String nombre, String apeliido, String tipoDNI) {
        this.idDNIPersona = idDNIPersona;
        this.nombre = nombre;
        this.apeliido = apeliido;
        this.tipoDNI = tipoDNI;
    }

    
    
    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    
    public String getIdDNIPersona() {
        return idDNIPersona;
    }

    public void setIdDNIPersona(String idDNIPersona) {
        this.idDNIPersona = idDNIPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApeliido() {
        return apeliido;
    }

    public void setApeliido(String apeliido) {
        this.apeliido = apeliido;
    }

    public String getTipoDNI() {
        return tipoDNI;
    }

    public void setTipoDNI(String tipoDNI) {
        this.tipoDNI = tipoDNI;
    }

    @Override
    public String toString() {
        return "Persona{" + "idDNIPersona=" + idDNIPersona + ", nombre=" + nombre + ", apeliido=" + apeliido + ", tipoDNI=" + tipoDNI + ", numeroMesa=" + numeroMesa + '}';
    }
    
    
    
}
