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
    String url = "jdbc:postgresql://localhost:5432/biblioteca";
    String usuario = "postgres";
    String password = "password";
    FachadaBD fachadaBD = new FachadaBD(url, usuario, password);
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


    /* Pruebas CRUD sobre usuario */
    Usuario usuario1 = new Usuario("US021", "Elizabeth Giraldo", "", "", "");
    System.out.println(biblioteca.getUsuarios().insertarElemento(usuario1));

    Usuario usuario2 = biblioteca.getUsuarios().obtenerElemento("US021");
    System.out.println(usuario2);

    System.out.println(biblioteca.getUsuarios().obtenerTodosLosElementos() != null);

    Usuario usuario3 = new Usuario("US021", "Elizabeth Giraldo", "3190011243", "Direccion", "Email");
    System.out.println(biblioteca.getUsuarios().editarElemento(usuario3));

    System.out.println(biblioteca.getUsuarios().eliminarElemento("US021"));
    

    /* Pruebas CRUD sobre estudiante */
    Estudiante estudiante1 = new Estudiante(usuario1, "Ing Sistemas", "Universidad del Valle");
    System.out.println(biblioteca.getUsuarios().insertarElemento(usuario1));
    System.out.println(biblioteca.getEstudiantes().insertarElemento(estudiante1));

    Estudiante estudiante2 = biblioteca.getEstudiantes().obtenerElemento("US021");
    System.out.println(estudiante2);

    System.out.println(biblioteca.getEstudiantes().obtenerTodosLosElementos() != null);

    Estudiante estudiante3 = new Estudiante(usuario1, "Ingenieria de sistemas", "Univalle");
    System.out.println(biblioteca.getEstudiantes().editarElemento(estudiante3));

    System.out.println(biblioteca.getEstudiantes().eliminarElemento("US021"));


    /* Pruebas CRUD sobre profesor */
    Profesor profesor1 = new Profesor(usuario1, "Facultad Ingneieria", "");
    System.out.println(biblioteca.getProfesores().insertarElemento(profesor1));

    Profesor profesor2 = biblioteca.getProfesores().obtenerElemento("US021");
    System.out.println(profesor2);

    System.out.println(biblioteca.getProfesores().obtenerTodosLosElementos() != null);

    Profesor profesor3 = new Profesor(usuario3, "Facultad Ingenieria", "PhD");
    System.out.println(biblioteca.getProfesores().editarElemento(profesor3));

    System.out.println(biblioteca.getProfesores().eliminarElemento("US021"));
    System.out.println(biblioteca.getUsuarios().eliminarElemento("US021"));


    /* Pruebas CRUD sobre empleado */
    Empleado empleado1 = new Empleado("EM011", "Paola Lopez", "");
    System.out.println(biblioteca.getEmpleados().insertarElemento(empleado1));

    Empleado empleado2 = biblioteca.getEmpleados().obtenerElemento("EM011");
    System.out.println(empleado2);

    System.out.println(biblioteca.getEmpleados().obtenerTodosLosElementos() != null);

    Empleado empleado3 = new Empleado("EM011", "Paola Lopez", "Bibliotecaria");
    System.out.println(biblioteca.getEmpleados().editarElemento(empleado3));
    
    System.out.println(biblioteca.getEmpleados().eliminarElemento("EM011"));

    //System.out.println(ManejadorArchivos.guardarEnArchivoTextoPlano(biblioteca, "C:/Users/ChristianV/Desktop/Lenguajes/SQL/Proyecto"));

    fachadaBD.closeConexionBD(conexionBD);

  }
}
