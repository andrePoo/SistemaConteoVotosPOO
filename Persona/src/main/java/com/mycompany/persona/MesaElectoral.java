/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persona;

/**
 *
 * @author andre
 */
import java.util.HashMap;
import java.util.Map;

public class MesaElectoral {
    private String codigo;
    private String ubicacion;
    private boolean habilitada;
    private Map<Candidato, Integer> votos = new HashMap<>();

    public MesaElectoral(String codigo, String ubicacion) {
        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.habilitada = true;
    }

    public boolean registrarVoto(Candidato cand) {
        if (!habilitada) return false;
        votos.merge(cand, 1, Integer::sum);
        return true;
    }

    public ActaElectoral generarActa() {
        return new ActaElectoral(codigo, contarVotos());
    }

    public int contarVotos() {
        return votos.values().stream().mapToInt(Integer::intValue).sum();
    }

    public boolean validarMesa() { return habilitada; }
    public boolean isHabilitada() { return habilitada; }
}
