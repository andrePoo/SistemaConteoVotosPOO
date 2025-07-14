/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persona;

/**
 *
 * @author andre
 */
public class ActaElectoral {
    private String idActa;
    private int totalVotos;
    private boolean firmada;

    public ActaElectoral(String idMesa, int totalVotos) {
        this.idActa = "ACT-" + idMesa;
        this.totalVotos = totalVotos;
        this.firmada = false;
    }

    public void firmarActa() { this.firmada = true; }

    public String imprimirResumen() {
        return (firmada ? "✔ " : "✘ ") + idActa + " — Total votos: " + totalVotos;
    }
}