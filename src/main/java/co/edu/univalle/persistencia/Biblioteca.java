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
  private Connection conexionBD;
  private DaoEditorial editoriales;
  private DaoArea areas;
  private DaoLibro libros;
  private DaoAutor autores;
  private DaoRelacionEscribe relacionesEscribe;
  private DaoDigital digitales;
  private DaoEjemplar ejemplares;
  private DaoUsuario usuarios;
  private DaoContrasenaUsuario contrasenasUsuarios;
  private DaoEstudiante estudiantes;
  private DaoProfesor profesores;
  private DaoAreaInteres areasInteres;
  private DaoEmpleado empleados;
  private DaoContrasenaEmpleado contrasenasEmpleados;
  private DaoSolicitud solicitudes;
  private DaoRelacionPide relacionesPide;
  private DaoDescarga descargas;
  private DaoPrestamo prestamos;
  private DaoRelacionPresta relacionesPresta;
  private DaoMulta multas;
  private Integer serialLibro;
  private Integer serialUsuario;
  private Integer serialEmpleado;
  private Integer serialSolicitud;
  private Integer serialDescarga;
  private Integer serialPrestamo;
  private Integer serialMulta;

  public Biblioteca(Connection conexionBD) {
    this.conexionBD = conexionBD;
    this.editoriales = new DaoEditorial(conexionBD);
    this.areas = new DaoArea(conexionBD);
    this.libros = new DaoLibro(conexionBD);
    this.autores = new DaoAutor(conexionBD);
    this.relacionesEscribe = new DaoRelacionEscribe(conexionBD);
    this.digitales = new DaoDigital(conexionBD);
    this.ejemplares = new DaoEjemplar(conexionBD);
    this.usuarios = new DaoUsuario(conexionBD);
    this.contrasenasUsuarios = new DaoContrasenaUsuario(conexionBD);
    this.estudiantes = new DaoEstudiante(conexionBD);
    this.profesores = new DaoProfesor(conexionBD);
    this.areasInteres = new DaoAreaInteres(conexionBD);
    this.empleados = new DaoEmpleado(conexionBD);
    this.contrasenasEmpleados = new DaoContrasenaEmpleado(conexionBD);
    this.solicitudes = new DaoSolicitud(conexionBD);
    this.relacionesPide = new DaoRelacionPide(conexionBD);
    this.descargas = new DaoDescarga(conexionBD);
    this.prestamos = new DaoPrestamo(conexionBD);
    this.relacionesPresta = new DaoRelacionPresta(conexionBD);
    this.multas = new DaoMulta(conexionBD);
  
    contrasenasUsuarios.encriptarContrasenas();
    contrasenasEmpleados.encriptarContrasenas();
    this.inicializarSeriales();
  }

  public void inicializarSeriales() {
    String selectSerialLibro = "SELECT MAX(substring(ISBN, 3)) FROM libro;";
    String selectSeriallUsuario = "SELECT MAX(substring(id_usuario, 3)) FROM usuario;";
    String selectSerialEmpleado = "SELECT MAX(substring(id_empleado, 3)) FROM empleado;";
    String selectSerialSolicitu = "SELECT MAX(substring(codigo_solicitud, 3)) FROM solicitud;";
    String selectSerialDescarga = "SELECT MAX(substring(codigo_descarga, 3)) FROM descarga;";
    String selectSerialPrestamo = "SELECT MAX(substring(codigo_prestamo, 3)) FROM prestamo;";
    String selectSerialMulta = "SELECT MAX(substring(codigo_multa, 3)) FROM multa;";

    try{
      Statement sentenciaSQL = conexionBD.createStatement();
      
      ResultSet serialLibroBD = sentenciaSQL.executeQuery(selectSerialLibro);
      serialLibroBD.next();
      serialLibro = serialLibroBD.getInt(1) + 1;

      ResultSet serialUsuarioBD = sentenciaSQL.executeQuery(selectSeriallUsuario);
      serialUsuarioBD.next();
      serialUsuario = serialUsuarioBD.getInt(1) + 1;

      ResultSet serialEmpleadoBD = sentenciaSQL.executeQuery(selectSerialEmpleado);
      serialEmpleadoBD.next();
      serialEmpleado = serialEmpleadoBD.getInt(1) + 1;

      ResultSet serialSolicitudBD = sentenciaSQL.executeQuery(selectSerialSolicitu);
      serialSolicitudBD.next();
      serialSolicitud = serialSolicitudBD.getInt(1) + 1;

      ResultSet serialDescargaBD = sentenciaSQL.executeQuery(selectSerialDescarga);
      serialDescargaBD.next();
      serialDescarga = serialDescargaBD.getInt(1) + 1;

      ResultSet serialPrestamoBD = sentenciaSQL.executeQuery(selectSerialPrestamo);
      serialPrestamoBD.next();
      serialPrestamo = serialPrestamoBD.getInt(1) + 1;

      ResultSet serialMultaBD = sentenciaSQL.executeQuery(selectSerialMulta);
      serialMultaBD.next();
      serialMulta = serialMultaBD.getInt(1) + 1;

    } catch (Exception error) {

      System.out.println("No se pudo ejecutar la sentencia SELECT para inicializar los seriales de la Base de Datos.\nError: " + error.getMessage());;
    }
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

  public DaoContrasenaUsuario getContrasenasUsuarios() {
    return contrasenasUsuarios;
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

  public DaoContrasenaEmpleado getContrasenasEmpleados() {
    return contrasenasEmpleados;
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

  public String getSerialLibro() {
    if(serialLibro < 10)
      return "LI00" + serialLibro;

    else if (serialLibro < 100)
      return "LI0" + serialLibro;

    else
      return "LI" + serialLibro;
    }

  public String getSerialUsuario() {
    if(serialUsuario < 10)
      return "US00" + serialUsuario;
    
    else if (serialUsuario < 100)
      return "US0" + serialUsuario;

    else
      return "US" + serialUsuario;
  }

  public String getSerialEmpleado() {
    if(serialEmpleado < 10)
      return "EM00" + serialEmpleado;
    
    else if (serialEmpleado < 100)
      return "EM0" + serialEmpleado;

    else
      return "EM" + serialEmpleado;
  }

  public String getSerialSolicitud() {
    if(serialSolicitud < 10)
      return "CS00" + serialSolicitud;
    
    else if (serialSolicitud < 100)
      return "CS0" + serialSolicitud;

    else
      return "CS" + serialSolicitud;
  }

  public String getSerialDescarga() {
    if(serialDescarga < 10)
      return "DS00" + serialDescarga;
    
    else if (serialDescarga < 100)
      return "DS0" + serialDescarga;

    else
      return "DS" + serialDescarga;
  }

  public String getSerialPrestamo() {
    if(serialPrestamo < 10)
      return "PR00" + serialPrestamo;
    
    else if (serialPrestamo < 100)
      return "PR0" + serialPrestamo;

    else
      return "PR" + serialPrestamo;
  }

  public String getSerialMulta() {
    if(serialMulta < 10)
      return "MU00" + serialMulta;
    
    else if (serialMulta < 100)
      return "MU0" + serialMulta;

    else
      return "MU" + serialMulta;
  }

  public void sumarSerialLibro() {
    serialLibro++;
  }

  public void restarSerialLibro() {
    serialLibro--;
  }

  public void sumarSerialUsuario() {
    serialUsuario++;
  }

  public void restarSerialUsuario() {
    serialUsuario--;
  }

  public void sumarSerialEmpleado() {
    serialEmpleado++;
  }

  public void restarSerialEmpleado() {
    serialEmpleado--;
  }

  public void sumarSerialSolicitud() {
    serialSolicitud++;
  }

  public void restarSerialSolicitud() {
    serialSolicitud--;
  }

  public void sumarSerialDescarga() {
    serialDescarga++;
  }

  public void restarSerialDescarga() {
    serialDescarga--;
  }

  public void sumarSerialPrestamo() {
    serialPrestamo++;
  }

  public void restarSerialPrestamo() {
    serialPrestamo--;
  }

  public void sumarSerialMulta() {
    serialMulta++;
  }

  public void restarSerialMulta() {
    serialMulta--;
  }

  public void cerrarConexion(){
    try{
      conexionBD.close();
      System.out.println("Conexión con la base de datos cerrada con éxito");

    } catch (SQLException error) {
      System.out.println("Error al cerrar la base de datos. Error: " + error.getMessage());
    }
  }

}
