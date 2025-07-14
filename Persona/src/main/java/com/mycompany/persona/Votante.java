/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persona;
import java.time.LocalDate;
/**
 *
 * @author andre
 */
public class Votante extends Persona {
    private String direccion;
    private boolean habilitado;

    public Votante(String id, String nombre, String dni, LocalDate fechaNac,
                   String direccion, boolean habilitado) {
        super(id, nombre, dni, fechaNac);
        this.direccion = direccion;
        this.habilitado = habilitado;
    }

    public boolean emitirVoto(MesaElectoral mesa, Candidato candidato) {
        if (!habilitado || !mesa.isHabilitada()) return false;
        return mesa.registrarVoto(candidato);
    }

    public boolean verificarHabilitacion() { return habilitado; }
}
