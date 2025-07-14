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
import java.util.*;

public class Main {

    // === Variables globales ===
    private static final Scanner sc = new Scanner(System.in);
    private static boolean programaActivo = true;

    private static int votosC1 = 0;
    private static int votosC2 = 0;
    private static int votosNulos = 0;

    public static void main(String[] args) {

        System.out.println("=== Bienvenidos a las Elecciones de Ingeniería de Sistemas ===");

        // --- 1) Autenticación de apertura de mesa ---
        autenticarApertura();

        // --- 2) Candidatos y partidos fijos ---
        PartidoPolitico partido1 = new PartidoPolitico("Partido Morado", "PM");
        PartidoPolitico partido2 = new PartidoPolitico("Somos Ingenieros", "SI");

        Candidato candidato1 = new Candidato("C1", "Bruno", "Díaz", "11111111",
                LocalDate.of(1990, 1, 1), 1, partido1);

        Candidato candidato2 = new Candidato("C2", "Roberto", "Tello", "22222222",
                LocalDate.of(1991, 2, 2), 2, partido2);

        // --- 3) Única mesa de votación (puedes agregar más) ---
        MesaElectoral mesa = new MesaElectoral("M001", "Pabellón A");

        // --- 4) Bucle principal de votantes ---
        while (programaActivo) {

            System.out.println("\nIngrese los datos del votante:");

            String nombre   = pedirTexto("Nombre: ");
            String apellido = pedirTexto("Apellido: ");
            String dni      = pedirDniValido();

            // --- 4.1) ¿Es el desarrollador? → menú especial ---
            if (esDesarrollador(nombre, apellido, dni)) {
                menuDesarrollador(candidato1, candidato2, partido1, partido2);
                continue;   // vuelve al inicio del while
            }

            // --- 4.2) Registro normal de voto ---
            Votante votante = new Votante("V-" + UUID.randomUUID(),
                    nombre + " " + apellido, dni,
                    LocalDate.of(2000, 1, 1),
                    "Dirección genérica", true);

            System.out.println("\nCandidatos:");
            System.out.println("1. " + candidato1);
            System.out.println("2. " + candidato2);
            System.out.print("Seleccione su candidato (1 o 2): ");
            String opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1" -> { votante.emitirVoto(mesa, candidato1); votosC1++; }
                case "2" -> { votante.emitirVoto(mesa, candidato2); votosC2++; }
                default  -> {
                    System.out.println("Voto nulo registrado.");
                    votosNulos++;
                }
            }

            // --- 4.3) ¿Registrar otro votante? ---
            System.out.print("¿Desea registrar otro votante? (s/n): ");
            String continuar = sc.nextLine().trim().toLowerCase();
            if (!continuar.equals("s")) {
                mostrarResultadosFinales(candidato1, candidato2);
                programaActivo = false;     // cierra aplicación
            }
        }
    }

    // ==========================================================
    // === Métodos auxiliares ===================================
    // ==========================================================

    private static void autenticarApertura() {
        boolean autorizado = false;
        while (!autorizado) {
            System.out.println("\n>> Identificación para abrir la mesa <<");
            String nombre   = pedirTexto("Nombre: ");
            String apellido = pedirTexto("Apellido: ");
            String dni      = pedirDniValido();

            if (esMesa(nombre, apellido, dni) || esDesarrollador(nombre, apellido, dni)) {
                System.out.println("Acceso concedido. ¡Mesa abierta!");
                autorizado = true;
            } else {
                System.out.println("Credenciales inválidas. Solo Sergio Monroy o Andre Quispe pueden abrir la mesa.");
            }
        }
    }

    private static boolean esMesa(String nombre, String apellido, String dni) {
        return nombre.equalsIgnoreCase("Sergio")
            && apellido.equalsIgnoreCase("Monroy")
            && dni.equals("74078761");
    }

    private static boolean esDesarrollador(String nombre, String apellido, String dni) {
        return nombre.equalsIgnoreCase("Andre")
            && apellido.equalsIgnoreCase("Quispe")
            && dni.equals("72493839");
    }

    private static String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    private static String pedirDniValido() {
        String dni;
        do {
            System.out.print("DNI (8 dígitos): ");
            dni = sc.nextLine().trim();
            if (!dni.matches("\\d{8}"))
                System.out.println("DNI inválido. Debe tener exactamente 8 dígitos.");
        } while (!dni.matches("\\d{8}"));
        return dni;
    }

    // ==========================================================
    // === Modo desarrollador ===================================
    // ==========================================================

    private static void menuDesarrollador(
            Candidato c1, Candidato c2,
            PartidoPolitico p1, PartidoPolitico p2) {

        System.out.println("\n[🛠  MODO DESARROLLADOR  🛠]");
        boolean salir = false;

        while (!salir) {
            System.out.println("""
                [1] Ver resultados actuales
                [2] Editar nombre de candidato 1
                [3] Editar nombre de candidato 2
                [4] Editar nombre del partido 1
                [5] Editar nombre del partido 2
                [6] Agregar votos manualmente
                [7] Cerrar programa
                [0] Volver a votación
                """);
            System.out.print("Seleccione una opción: ");
            String opc = sc.nextLine().trim();

            switch (opc) {
                case "1" -> mostrarResultadosParciales(c1, c2);
                case "2" -> { System.out.print("Nuevo nombre C1: "); c1.nombres = sc.nextLine().trim(); }
                case "3" -> { System.out.print("Nuevo nombre C2: "); c2.nombres = sc.nextLine().trim(); }
                case "4" -> {
                    System.out.print("Nuevo nombre Partido 1: ");
                    p1 = new PartidoPolitico(sc.nextLine().trim(), p1.getSigla());
                    c1.setPartido(p1);
                }
                case "5" -> {
                    System.out.print("Nuevo nombre Partido 2: ");
                    p2 = new PartidoPolitico(sc.nextLine().trim(), p2.getSigla());
                    c2.setPartido(p2);
                }
                case "6" -> {
                    System.out.print("¿A qué candidato? (1 o 2): ");
                    String cual = sc.nextLine().trim();
                    System.out.print("¿Cuántos votos?: ");
                    int n = Integer.parseInt(sc.nextLine());
                    if (cual.equals("1")) votosC1 += n;
                    else if (cual.equals("2")) votosC2 += n;
                    else votosNulos += n;
                    System.out.println(n + " votos agregados.");
                }
                case "7" -> {
                    mostrarResultadosFinales(c1, c2);
                    programaActivo = false;
                    salir = true;
                }
                case "0" -> salir = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    // ==========================================================
    // === Impresión de resultados ==============================
    // ==========================================================

    private static void mostrarResultadosParciales(Candidato c1, Candidato c2) {
        System.out.println("\n=== RESULTADOS PARCIALES ===");
        System.out.printf("%s (%s): %d votos%n",
                c1.getNombreCompleto(), c1.getPartido().obtenerResumen(), votosC1);
        System.out.printf("%s (%s): %d votos%n",
                c2.getNombreCompleto(), c2.getPartido().obtenerResumen(), votosC2);
        System.out.println("Votos nulos: " + votosNulos);
    }

    private static void mostrarResultadosFinales(Candidato c1, Candidato c2) {
        System.out.println("\n=== RESULTADOS FINALES ===");
        System.out.printf("%s (%s): %d votos%n",
                c1.getNombreCompleto(), c1.getPartido().obtenerResumen(), votosC1);
        System.out.printf("%s (%s): %d votos%n",
                c2.getNombreCompleto(), c2.getPartido().obtenerResumen(), votosC2);
        System.out.println("Votos nulos: " + votosNulos);

        // Ganador
        if (votosC1 > votosC2)
            System.out.printf("Ganador: %s del %s%n",
                    c1.getNombreCompleto(), c1.getPartido().obtenerResumen());
        else if (votosC2 > votosC1)
            System.out.printf("Ganador: %s del %s%n",
                    c2.getNombreCompleto(), c2.getPartido().obtenerResumen());
        else
            System.out.println("Resultado: EMPATE");
    }
}