/*
  Archivo: Test.java
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

package co.edu.univalle;

import co.edu.univalle.modelo.Area;
import co.edu.univalle.modelo.Editorial;
import co.edu.univalle.modelo.ManejadorArchivos;
import co.edu.univalle.persistencia.*;
import java.sql.*;


public class Test {
  public static void main(String[] args) {
    FachadaBD fachadaBD = new FachadaBD();
    Connection conexionBD = fachadaBD.getConexionBD();
    Biblioteca biblioteca = new Biblioteca(conexionBD);

    /* Pruebas CRUD sobre Editorial */
    Editorial editorial1 = new Editorial("ED011", "Editores Santillana", "Colombia", "https://santillana.com.co/");
    System.out.println(biblioteca.getEditoriales().insertarElemento(editorial1));

    Editorial editorial2 = biblioteca.getEditoriales().obtenerElemento("ED011");
    System.out.println(editorial2);
    
    System.out.println(biblioteca.getEditoriales().obtenerTodosLosElementos() != null);

    Editorial editorial3 = new Editorial("ED011", "Editores Santillana", "Colombia", "www.santillana.com.co");
    System.out.println(biblioteca.getEditoriales().editarElemento(editorial3));

    System.out.println(biblioteca.getEditoriales().eliminarElemento("ED011"));


    /* Pruebas CRUD sobre Area */
    Area area1 = new Area("AC039", "Area prueba", "Descropcion", "AC001");
    System.out.println(biblioteca.getAreas().insertarElemento(area1));
    Area area2 = biblioteca.getAreas().obtenerElemento("AC039");
    System.out.println(area2);

    System.out.println(biblioteca.getAreas().obtenerTodosLosElementos() != null);

    Area area3 = new Area("AC039", "Area prueba", "DESCRIPCION", "AC001");
    System.out.println(biblioteca.getAreas().editarElemento(area3));

    System.out.println(biblioteca.getAreas().eliminarElemento("AC039"));

    

    System.out.println(ManejadorArchivos.guardarEnArchivoTextoPlano(biblioteca, "C:/Users/ChristianV/Desktop/Lenguajes/SQL/Proyecto"));

    fachadaBD.closeConexionBD(conexionBD);

  }
}
