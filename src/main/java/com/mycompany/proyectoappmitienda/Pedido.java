/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoappmitienda;

import java.sql.Date;

/**
 *
 * @author Felipe
 */
public class Pedido {
    private int idPedido ;
    private int numeroMesa;
    private int idGrupo;
    private String nombre;
    private String fechaPedido;
    private int total;
    private int estado;

    public Pedido() {
    }

    
    
    //,  nombre, apellido, fechaPedido, estado, SUM(pedido_producto.precioFacturado) AS 'Total'
   
    
    public Pedido(int idPedido, int numeroMesa, int idGrupo, String nombre, String fechaPedido, int total, int estado) {
        this.idPedido = idPedido;
        this.numeroMesa = numeroMesa;
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.estado = estado;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", numeroMesa=" + numeroMesa + ", idGrupo=" + idGrupo + ", nombre=" + nombre + ", fechaPedido=" + fechaPedido + ", total=" + total + ", estado=" + estado + '}';
    }

    
}