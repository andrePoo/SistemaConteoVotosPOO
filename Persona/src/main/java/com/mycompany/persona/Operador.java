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
public class Operador extends Persona {
    private String nivelAcceso;
    private String usuario;
    private String clave;

    public Operador(String id, String nombre, String dni, LocalDate fechaNac,
                    String usuario, String clave, String nivelAcceso) {
        super(id, nombre, dni, fechaNac);
        this.usuario = usuario;
        this.clave = clave;
        this.nivelAcceso = nivelAcceso;
    }

    public void registrarActa(ActaElectoral acta) {
        acta.firmarActa();
    }

    public boolean validaMesa(MesaElectoral mesa) {
        return mesa != null && mesa.isHabilitada();
    }
}