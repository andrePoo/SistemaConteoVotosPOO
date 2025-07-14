/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persona;
import java.time.LocalDate;

public class Candidato extends Persona {
    private int numOrden;
    public String nombres; // editable desde modo desarrollador
    private String apellidos;
    private PartidoPolitico partido;

    public Candidato(String id, String nombres, String apellidos,
                     String dni, LocalDate fechaNacimiento,
                     int numOrden, PartidoPolitico partido) {
        super(id, nombres + " " + apellidos, dni, fechaNacimiento);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numOrden = numOrden;
        this.partido = partido;
    }

    public void recibirVoto(Resultado resultado) {
        resultado.registrarVoto(this);
    }

    public void setPartido(PartidoPolitico nuevoPartido) {
        this.partido = nuevoPartido;
    }

    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    public PartidoPolitico getPartido() {
        return partido;
    }

    public int getNumOrden() {
        return numOrden;
    }

    @Override
    public String toString() {
        return numOrden + ". " + getNombreCompleto() + " (" + partido.getSigla() + ")";
    }
}