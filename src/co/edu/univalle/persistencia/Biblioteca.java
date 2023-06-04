/*
  Archivo: Biblioteca.java
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

package co.edu.univalle.persistencia;

import java.sql.*;

public class Biblioteca {
  private DaoEditorial editoriales;
  private DaoArea areas;
  private DaoLibro libros;
  private DaoAutor autores;
  private DaoRelacionEscribe relacionesEscribe;
  private DaoDigital digitales;
  private DaoEjemplar ejemplares;
  private DaoUsuario usuarios;
  private DaoEstudiante estudiantes;
  private DaoProfesor profesores;
  private DaoAreaInteres areasInteres;
  private DaoEmpleado empleados;
  private DaoSolicitud solicitudes;
  private DaoRelacionPide relacionesPide;
  private DaoDescarga descargas;
  private DaoPrestamo prestamos;
  private DaoRelacionPresta relacionesPresta;
  private DaoMulta multas;

  public Biblioteca(Connection conexionBD) {
    this.editoriales = new DaoEditorial(conexionBD);
    this.areas = new DaoArea(conexionBD);
    this.libros = new DaoLibro(conexionBD);
    this.autores = new DaoAutor(conexionBD);
    this.relacionesEscribe = new DaoRelacionEscribe(conexionBD);
    this.digitales = new DaoDigital(conexionBD);
    this.ejemplares = new DaoEjemplar(conexionBD);
    this.usuarios = new DaoUsuario(conexionBD);
    this.estudiantes = new DaoEstudiante(conexionBD);
    this.profesores = new DaoProfesor(conexionBD);
    this.areasInteres = new DaoAreaInteres(conexionBD);
    this.empleados = new DaoEmpleado(conexionBD);
    this.solicitudes = new DaoSolicitud(conexionBD);
    this.relacionesPide = new DaoRelacionPide(conexionBD);
    this.descargas = new DaoDescarga(conexionBD);
    this.prestamos = new DaoPrestamo(conexionBD);
    this.relacionesPresta = new DaoRelacionPresta(conexionBD);
    this.multas = new DaoMulta(conexionBD);
  }

  public DaoEditorial getEditoriales() {
    return editoriales;
  }

  public DaoArea getAreas() {
    return areas;
  }

  public DaoLibro getLibros() {
    return libros;
  }

  public DaoAutor getAutores() {
    return autores;
  }

  public DaoRelacionEscribe getRelacionesEscribe() {
    return relacionesEscribe;
  }

  public DaoDigital getDigitales() {
    return digitales;
  }

  public DaoEjemplar getEjemplares() {
    return ejemplares;
  }

  public DaoUsuario getUsuarios() {
    return usuarios;
  }

  public DaoEstudiante getEstudiantes() {
    return estudiantes;
  }

  public DaoProfesor getProfesores() {
    return profesores;
  }

  public DaoAreaInteres getAreasInteres() {
    return areasInteres;
  }

  public DaoEmpleado getEmpleados() {
    return empleados;
  }

  public DaoSolicitud getSolicitudes() {
    return solicitudes;
  }

  public DaoRelacionPide getRelacionesPide() {
    return relacionesPide;
  }

  public DaoDescarga getDescargas() {
    return descargas;
  }

  public DaoPrestamo getPrestamos() {
    return prestamos;
  }

  public DaoRelacionPresta getRelacionesPresta() {
    return relacionesPresta;
  }

  public DaoMulta getMultas() {
    return multas;
  }

}
