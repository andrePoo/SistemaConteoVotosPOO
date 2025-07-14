/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persona;

/**
 *
 * @author andre
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Eleccion {
    private LocalDate fecha;
    private String tipo;
    private boolean activa;
    private final List<MesaElectoral> mesas = new ArrayList<>();
    private RegistroOmisos registroOmisos = new RegistroOmisos();

    public Eleccion(LocalDate fecha, String tipo) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.activa = true;
    }

    public void agregarMesa(MesaElectoral mesa) { mesas.add(mesa); }
    public void crearEleccion()  { activa = true; }
    public void modificarEleccion(LocalDate nuevaFecha, String nuevoTipo) {
        this.fecha = nuevaFecha; this.tipo = nuevoTipo;
    }
    public void cerrarEleccion() { activa = false; }
}
