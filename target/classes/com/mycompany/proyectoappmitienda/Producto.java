/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoappmitienda;

/**
 *
 * @author Felipe
 */
public class Producto {
    //atributos
    private int idProducto; 
    private String nombreProducto;
    private int precioActual;
    private int unidadesDisponibles;
    private String categoria;
    
    
    //constructores
    public Producto() {
    }

    public Producto(int idProducto, String nombreProducto, int precioActual, int unidadesDisponibles, String categoria) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioActual = precioActual;
        this.unidadesDisponibles = unidadesDisponibles;
        this.categoria = categoria;
    }

    public Producto(String nombreProducto, int precioActual, int unidadesDisponibles, String categoria) {
        this.nombreProducto = nombreProducto;
        this.precioActual = precioActual;
        this.unidadesDisponibles = unidadesDisponibles;
        this.categoria = categoria;
    }

    public Producto(int idProducto, String nombreProducto, int precioActual, int unidadesDisponibles) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioActual = precioActual;
        this.unidadesDisponibles = unidadesDisponibles;
    }
    
    //getter y setter 

    public int getIdProducto() {
        return idProducto;
    }
    //no deberia usarse
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(int precioActual) {
        this.precioActual = precioActual;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

   
    
    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precioActual=" + precioActual + ", unidadesDisponibles=" + unidadesDisponibles + ", categoria=" + categoria + '}';
    }
    
    
}
