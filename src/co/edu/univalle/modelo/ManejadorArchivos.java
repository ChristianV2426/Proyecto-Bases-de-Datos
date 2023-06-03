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

  public static boolean guardarEnArchivoTextoPlano(Biblioteca biblioteca, String rutaDirectorio){
    String[][] editoriales = biblioteca.getEditoriales().obtenerTodosLosElementos();
    String[][] areas = biblioteca.getAreas().obtenerTodosLosElementos();
    boolean operacionRealizada = false;

    LocalDateTime fechaYHora = LocalDateTime.now();
    String identificador = String.valueOf(
        fechaYHora.getYear() + "-" + fechaYHora.getMonthValue() + "-" +  fechaYHora.getDayOfMonth() + " -- " +
        fechaYHora.getHour() + "h " + fechaYHora.getMinute() + "m " + fechaYHora.getSecond() + "s" );

    PrintWriter escritorDeArchivo = null;
    String pieDePagina = "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
    String configuracionImpresion = "%-40s";
    try{
      escritorDeArchivo = new PrintWriter(new FileWriter(rutaDirectorio + "/Copia Seguridad " + identificador + ".txt"));

      escritorDeArchivo.print("Fecha: " + fechaYHora.getYear() + "-" + fechaYHora.getMonthValue() + "-" +  fechaYHora.getDayOfMonth());
      escritorDeArchivo.print("\n\n");

      // Datos de las Editoriales
      escritorDeArchivo.print("------------------------------------------------------------------------------------------------ LISTA DE EDITORIALES -------------------------------------------------------------------------------------------------\n\n");
      String[] columnasEditoriales = {"codigo_editorial", "nombre_editorial", "pais_origen", "pagina_web"};
      for(String columna : columnasEditoriales)
        escritorDeArchivo.printf(configuracionImpresion, columna);
      
      escritorDeArchivo.print("\n");
      
      if(editoriales != null){
        for(String[] editorial : editoriales){
          for(String dato : editorial){
            if (dato != null && dato.length()>35){
              escritorDeArchivo.printf(configuracionImpresion, dato.substring(0, 30)+"...");
              continue;
            }

            escritorDeArchivo.printf(configuracionImpresion, dato);
          }
          escritorDeArchivo.print("\n");
        }
      }
      escritorDeArchivo.print("\n" + pieDePagina + "\n\n\n");

      // Datos de las Areas
      escritorDeArchivo.print("------------------------------------------------------------------------------------------------ LISTA DE AREAS -------------------------------------------------------------------------------------------------\n\n");
      String[] columnasAreas = {"codigo_area", "nombre_area", "descripcion_area", "area_padre"};
      for(String columna : columnasAreas)
        escritorDeArchivo.printf(configuracionImpresion, columna);
      
      escritorDeArchivo.print("\n");
      
      if(areas != null){
        for(String[] area : areas){
          for(String dato : area){
            if (dato != null && dato.length()>35){
              escritorDeArchivo.printf(configuracionImpresion, dato.substring(0, 30)+"...");
              continue;
            }

            escritorDeArchivo.printf(configuracionImpresion, dato);
          }
          escritorDeArchivo.print("\n");
        }
      }
      escritorDeArchivo.print("\n" + pieDePagina + "\n\n\n");

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
