/*
  Archivo: ManejadorArchivos.java
  Bases de Datos - 750006C - Grupo 01
  Proyecto - Biblioteca Universidad del Valle

  Autores: 
  John Freddy Belalcazar Rojas - john.freddy.belalcazar@correounivalle.edu.co - 2182464-3743 
  Santiago Gonzalez Galvez - santiago.galvez@correounivalle.edu.co - 2183392-3743 
  Juan Camilo Narvaez Tascon - juan.narvaez.tascon@correounivalle.edu.co - 2140112-3743 
  Christian David Vargas Gutierrez - vargas.christian@correounivalle.edu.co - 2179172-3743

  Profesor:
  Ph.D. Oswaldo Solarte

  Licencia: GNU-GPL
*/

package co.edu.univalle.modelo;

import co.edu.univalle.persistencia.*;

import java.time.*;
import java.io.*;

public class ManejadorArchivos {
  public static void imprimirArregloEnConsola(String[][] arreglo) {
    String configuracionImpresion = "%-30s";

    if(arreglo == null)
      System.out.println("No hay nada para imprimir en consola.");;  

    int filas = arreglo.length;
    int columnas = arreglo[0].length;
    
    for(int fila = 0; fila < filas; fila++){
      for(int columna = 0; columna < columnas; columna++)
        System.out.printf(configuracionImpresion, arreglo[fila][columna]);
      System.out.println();
    }
  }

  public static void funcionEscritora(String[][] arreglo, String[] nombreColumnas, PrintWriter escritorDeArchivo) {
    String configuracionImpresion = "%-34s";
    for(String columna : nombreColumnas)
      escritorDeArchivo.printf(configuracionImpresion, columna);
  
    escritorDeArchivo.print("\n");

    if(arreglo != null){
      for(String[] fila : arreglo){
        for(String dato : fila){
          if (dato != null && dato.length()>30){
            escritorDeArchivo.printf(configuracionImpresion, dato.substring(0, 28)+"...");
            continue;
          }

          escritorDeArchivo.printf(configuracionImpresion, dato);
        }
        escritorDeArchivo.print("\n");
      }
    }


  }

  public static boolean guardarEnArchivoTextoPlano(Biblioteca biblioteca, String rutaDirectorio){
    
    String[] columnasEstudiantes = {"id_usuario", "nombre_usuario", "carrera", "universidad", "email"};
    String[][] estudiantes = biblioteca.getEstudiantes().obtenerTodosLosElementos();

    String[] columnasProfesores = {"id_usuario", "nombre_usuario", "dependencia", "titulo", "email"};
    String[][] profesores = biblioteca.getProfesores().obtenerTodosLosElementos();

    String[] columnasEmpleados = {"id_empleado", "nombre_empleado", "cargo"};
    String[][] empleados = biblioteca.getEmpleados().obtenerTodosLosElementos();

    String[] columnasDigitales = {"ISBN", "titulo", "URL", "formato", "nombre_editorial", "nombre_area"};
    String[][] digitales = biblioteca.getDigitales().obtenerTodosLosElementos();

    String[] columnasEjemplares = {"ISBN", "titulo", "num_ejemplar", "nombre_editorial", "nombre_area", "num_pagina"};
    String[][] ejemplares = biblioteca.getEjemplares().obtenerTodosLosElementos();

    String[] columnaSolicitud = {"codigo_solicitud", "fecha_solicitud", "id_usuario", "nombre_usuario", "ISBN", "titulo", "descripcion"};
    String[][] solicitudes = biblioteca.getSolicitudes().obtenerTodosLosElementos();

    String[] columnaDescarga = {"codigo_descarga", "ISBN", "titulo", "URL", "id_usuario", "nombre_usuario", "fecha_descarga_con_hora", "num_ip"};
    String[][] descargas = biblioteca.getDescargas().obtenerTodosLosElementos();

    String[] columnaPrestamo = {"codigo_prestamo", "id_usuario", "nombre_usuario", "ISBN", "titulo", "num_ejemplar", "fecha_prestamo", "fecha_devolucion_esperada", "fecha_devolucion_real"};
    String[][] prestamos = biblioteca.getPrestamos().obtenerTodosLosElementos();

    String[] columnaMulta = {"codigo_multa", "id_usuario", "nombre_usuario", "ISBN", "titulo", "num_ejemplar", "fecha_devolucion_esperada", "fecha_devolucion_real", "valor_multa", "descripcion_multa"};
    String[][] multas = biblioteca.getMultas().obtenerTodosLosElementos();

    LocalDateTime fechaYHora = LocalDateTime.now();
    String identificador = String.valueOf(
      fechaYHora.getYear() + "-" + fechaYHora.getMonthValue() + "-" +  fechaYHora.getDayOfMonth() + " -- " +
      fechaYHora.getHour() + "h " + fechaYHora.getMinute() + "m " + fechaYHora.getSecond() + "s" );

    boolean operacionRealizada = false;
    PrintWriter escritorDeArchivo = null;
    
    try{
      escritorDeArchivo = new PrintWriter(new FileWriter(rutaDirectorio + "/Copia Seguridad " + identificador + ".txt"));

      escritorDeArchivo.print("Fecha: " + fechaYHora.getYear() + "-" + fechaYHora.getMonthValue() + "-" +  fechaYHora.getDayOfMonth());
      escritorDeArchivo.print("\n\n");
      
      // Datos de los estudiantes
      escritorDeArchivo.print("LISTA DE ESTUDIANTES\n\n");
      funcionEscritora(estudiantes, columnasEstudiantes, escritorDeArchivo);
      escritorDeArchivo.print("\n\n\n");

      // Datos de los profesores
      escritorDeArchivo.print("LISTA DE PROFESORES\n\n");
      funcionEscritora(profesores, columnasProfesores, escritorDeArchivo);
      escritorDeArchivo.print("\n\n\n");

      // Datos de los empleados
      escritorDeArchivo.print("LISTA DE EMPLEADOS\n\n");
      funcionEscritora(empleados, columnasEmpleados, escritorDeArchivo);
      escritorDeArchivo.print("\n\n\n");

      // Datos de los digitales
      escritorDeArchivo.print("LISTA DE LIBROS DIGITALES\n\n");
      funcionEscritora(digitales, columnasDigitales, escritorDeArchivo);
      escritorDeArchivo.print("\n\n\n");

      // Datos de los ejemplares
      escritorDeArchivo.print("LISTA DE EJEMPLARES FISICOS\n\n");
      funcionEscritora(ejemplares, columnasEjemplares, escritorDeArchivo);
      escritorDeArchivo.print("\n\n\n");

      // Datos de las solicitudes
      escritorDeArchivo.print("LISTA DE SOLICITUDES\n\n");
      funcionEscritora(solicitudes, columnaSolicitud, escritorDeArchivo);
      escritorDeArchivo.print("\n\n\n");

      // Datos de las descargas
      escritorDeArchivo.print("LISTA DE DESCARGAS\n\n");
      funcionEscritora(descargas, columnaDescarga, escritorDeArchivo);
      escritorDeArchivo.print("\n\n\n");

      // Datos de los prestamos
      escritorDeArchivo.print("LISTA DE PRESTAMOS\n\n");
      funcionEscritora(prestamos, columnaPrestamo, escritorDeArchivo);
      escritorDeArchivo.print("\n\n\n");

      // Datos de las multas
      escritorDeArchivo.print("LISTA DE MULTAS\n\n");
      funcionEscritora(multas, columnaMulta, escritorDeArchivo);
      escritorDeArchivo.print("\n\n\n");
      
      operacionRealizada = true;

    } catch (IOException exception){
        System.out.println("Error alistando el archivo de texto plano.");
        // System.out.println("Error alistando el archivo de texto plano. " + exception.getMessage());

    } finally {
        if(escritorDeArchivo != null){
            try{
                escritorDeArchivo.close();

            } catch (Exception exception){
                System.out.println("Error cerrando el archivo plano.");
                // System.out.println("Error cerrando el archivo plano. " + exception.getMessage());
            }
        }
    }
    return operacionRealizada;
  }

}
