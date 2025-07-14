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

public class Resultado {
    private Map<Candidato, Integer> votos = new HashMap<>();

    public void registrarVoto(Candidato c) {
        votos.merge(c, 1, Integer::sum);
    }

    public Candidato obtenerGanador() {
        return votos.entrySet().stream()
              .max(Map.Entry.comparingByValue())
              .map(Map.Entry::getKey)
              .orElse(null);
    }

    public String generarReporte() {
        StringBuilder sb = new StringBuilder("= REPORTE DE VOTOS =\n");
        votos.forEach((c, n) -> sb.append(c).append(": ").append(n).append('\n'));
        Candidato ganador = obtenerGanador();
        sb.append("\nGanador: ").append(ganador != null ? ganador : "Empate/—");
        return sb.toString();
    }
}
