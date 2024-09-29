/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoappmitienda;

import java.util.Date;

/**
 *
 * @author Felipe
 */
public class Grupo {
    private int idGrupo;
    private Date horaLlegada;
    private Date horaSalida;
     private String horaLlegadaFormateada;
    private String horaSalidaFormateada;

    public Grupo(int idGrupo, Date horaLlegada, Date horaSalida) {
        this.idGrupo = idGrupo;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        
    }

    public Grupo() {
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegadaFormateada() {
        return horaLlegadaFormateada;
    }

    public void setHoraLlegadaFormateada(String horaLlegadaFormateada) {
        this.horaLlegadaFormateada = horaLlegadaFormateada;
    }

    public String getHoraSalidaFormateada() {
        return horaSalidaFormateada;
    }

    public void setHoraSalidaFormateada(String horaSalidaFormateada) {
        this.horaSalidaFormateada = horaSalidaFormateada;
    }
    
    @Override
    public String toString() {
        return "Grupo{" + "idGrupo=" + idGrupo + ", horaLlegada=" + horaLlegada + ", horaSalida=" + horaSalida + '}';
    }
    
    
}
