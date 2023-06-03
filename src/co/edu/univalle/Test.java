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

import co.edu.univalle.modelo.*;
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


    /* Pruebas CRUD sobre Libro */
    Libro libro1 = new Libro("LI041", "TermodinamicaII", Integer.valueOf(550), Integer.valueOf(2015), "Español", "AC016", "ED001");
    System.out.println(biblioteca.getLibros().insertarElemento(libro1));
    Libro libro2 = biblioteca.getLibros().obtenerElemento("LI041");
    System.out.println(libro2);

    System.out.println(biblioteca.getLibros().obtenerTodosLosElementos() != null);

    Libro libro3 = new Libro("LI041", "Termodinamica Quimica", Integer.valueOf(550), Integer.valueOf(2015), "Español", "AC016", "ED001");
    System.out.println(biblioteca.getLibros().editarElemento(libro3));

    System.out.println(biblioteca.getLibros().eliminarElemento("LI041"));


    /* Pruebas CRUD sobre Autor */
    Autor autor1 = new Autor("AU031", "Mario", "Jimenez");
    System.out.println(biblioteca.getAutores().insertarElemento(autor1));

    Autor autor2 = biblioteca.getAutores().obtenerElemento("AU031");
    System.out.println(autor2);

    System.out.println(biblioteca.getAutores().obtenerTodosLosElementos() != null);
    
    Autor autor3 = new Autor("AU031", "Mario Alberto", "Jimenez");
    System.out.println(biblioteca.getAutores().editarElemento(autor3));

    System.out.println(biblioteca.getAutores().eliminarElemento("AU031"));


    /* Pruebas CRUD sobre escribe */
    System.out.println(biblioteca.getLibros().insertarElemento(libro1));
    System.out.println(biblioteca.getAutores().insertarElemento(autor1));
    RelacionEscribe relacionEscribe1 = new RelacionEscribe(autor1, libro1);
    System.out.println(biblioteca.getRelacionesEscribe().insertarElemento(relacionEscribe1));

    RelacionEscribe relacionEscribe2 = biblioteca.getRelacionesEscribe().obtenerElemento("AU031, LI041");
    System.out.println(relacionEscribe2);

    System.out.println(biblioteca.getRelacionesEscribe().eliminarElemento("AU031, LI041"));

    RelacionEscribe relacionEscribe3 = new RelacionEscribe("AU010", "LI041");
    System.out.println(biblioteca.getRelacionesEscribe().insertarElemento(relacionEscribe3));
    System.out.println(biblioteca.getRelacionesEscribe().eliminarElemento("AU010, LI041"));
    System.out.println(biblioteca.getLibros().eliminarElemento("LI041"));
    System.out.println(biblioteca.getAutores().eliminarElemento("AU031"));


    /* Pruebas CRUD sobre digital */
    System.out.println(biblioteca.getLibros().insertarElemento(libro1));
    Digital digital1 = new Digital(libro1, "www...", Integer.valueOf(1024), "PDF");
    System.out.println(biblioteca.getDigitales().insertarElemento(digital1));

    Digital digital2 = biblioteca.getDigitales().obtenerElemento("LI041, www...");
    System.out.println(digital2);

    System.out.println(biblioteca.getDigitales().obtenerTodosLosElementos() != null);

    Digital digital3 = new Digital(libro1, "www...", Integer.valueOf(1024), "EPUB");
    System.out.println(biblioteca.getDigitales().editarElemento(digital3));

    System.out.println(biblioteca.getDigitales().eliminarElemento("LI041, www..."));
    System.out.println(biblioteca.getLibros().eliminarElemento("LI041"));

    /* Pruebas CRUD sobre ejemplar */
    System.out.println(biblioteca.getLibros().insertarElemento(libro1));
    Ejemplar ejemplar1 = new Ejemplar(libro3, Integer.valueOf(1), "null", "null", "null", "null");
    System.out.println(biblioteca.getEjemplares().insertarElemento(ejemplar1));

    Ejemplar ejemplar2 = biblioteca.getEjemplares().obtenerElemento("LI041, 1");
    System.out.println(ejemplar2);

    System.out.println(biblioteca.getEjemplares().obtenerTodosLosElementos() != null);

    Ejemplar ejemplar3 = new Ejemplar(libro3, Integer.valueOf(1), "100", "101", "103", "SAL5");
    System.out.println(biblioteca.getEjemplares().editarElemento(ejemplar3));

    System.out.println(biblioteca.getEjemplares().eliminarElemento("LI041, 1"));
    System.out.println(biblioteca.getLibros().eliminarElemento("LI041"));
    

    //System.out.println(ManejadorArchivos.guardarEnArchivoTextoPlano(biblioteca, "C:/Users/ChristianV/Desktop/Lenguajes/SQL/Proyecto"));

    fachadaBD.closeConexionBD(conexionBD);

  }
}
