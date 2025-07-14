/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persona;

/**
 *
 * @author andre
 */
import java.util.ArrayList;
import java.util.List;

public class RegistroOmisos {
    private List<Votante> omisos = new ArrayList<>();

    public void agregarOmisos(Votante v) { omisos.add(v); }

    public List<Votante> generarListado() { return List.copyOf(omisos); }
}
