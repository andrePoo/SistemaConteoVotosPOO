/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persona;

import java.time.LocalDate;
import java.time.Period;

public abstract class Persona {
    protected String id;
    protected String nombre;
    protected String dni;
    protected LocalDate fechaNacimiento;

    public Persona(String id, String nombre, String dni, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    /** Valida el DNI usando una regla de 8 dígitos numéricos */
    public boolean validarIdentidad() {
        return dni != null && dni.matches("\\d{8}");
    }
}
