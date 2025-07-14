/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persona;

/**
 *
 * @author andre
 */
public class PartidoPolitico {
    private String nombre;
    private String sigla;

    public PartidoPolitico(String nombre, String sigla) {
        this.nombre = nombre;
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }

    public String obtenerResumen() {
        return sigla + " - " + nombre;
    }
}