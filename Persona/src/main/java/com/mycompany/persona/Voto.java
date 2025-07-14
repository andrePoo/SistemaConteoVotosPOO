/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persona;

/**
 *
 * @author andre
 */
import java.time.LocalDateTime;
import java.util.UUID;

public class Voto {
    private String idVoto = UUID.randomUUID().toString();
    private LocalDateTime timestamp = LocalDateTime.now();

    public boolean validarVoto() {
        return timestamp != null; // Reglas reales irían aquí
    }
}
