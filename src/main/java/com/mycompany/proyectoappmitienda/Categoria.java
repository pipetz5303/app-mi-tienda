/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoappmitienda;

/**
 *
 * @author Felipe
 */
public class Categoria {
    //atributos
    private int id;
    private  String nombre;
   
    //constructor

    public Categoria() {
        
    }

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    
    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }
    
   
    
    
    
}
