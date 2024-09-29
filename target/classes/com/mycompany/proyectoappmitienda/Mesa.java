/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoappmitienda;

import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class Mesa {
    //atributos
    private int idMesa;
    private int numeroMesa;
    private int idTienda;
    private Grupo grupo;

    public Mesa(int idMesa, int numeroMesa, int idTienda) {
        this.idMesa = idMesa;
        this.numeroMesa = numeroMesa;
        this.idTienda = idTienda;
        this.grupo = new Grupo();
    }

    public Mesa() {
    }

    public Mesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
    
    

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    
    
    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }
    
    
    
}
