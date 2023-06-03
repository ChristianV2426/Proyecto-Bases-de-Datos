/*
  Archivo: Prestamo.java
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

import java.time.LocalDate;

public class Prestamo {
  private String codigoPrestamo;
  private String idUsuario;
  private String idEmpleado;
  private LocalDate fechaPrestamo;
  private static int numeroColumnas = 4;

  public Prestamo(String codigoPrestamo, String idUsuario, String idEmpleado, LocalDate fechaPrestamo) {
    this.codigoPrestamo = codigoPrestamo;
    this.idUsuario = idUsuario;
    this.idEmpleado = idEmpleado;
    this.fechaPrestamo = fechaPrestamo;
  }

  public Prestamo(String codigoPrestamo, Usuario usuario, Empleado empleado, LocalDate fechaPrestamo) {
    this.codigoPrestamo = codigoPrestamo;
    this.idUsuario = usuario.getIdUsuario();
    this.idEmpleado = empleado.getIdEmpleado();
    this.fechaPrestamo = fechaPrestamo;
  }

  public String getCodigoPrestamo() {
    return codigoPrestamo;
  }

  public String getIdUsuario() {
    return idUsuario;
  }

  public String getIdEmpleado() {
    return idEmpleado;
  }

  public LocalDate getFechaPrestamo() {
    return fechaPrestamo;
  }

  public static int getNumeroColumnas(){
    return numeroColumnas;
  }

  @Override
  public String toString() {
    return "Prestamo [codigoPrestamo=" + codigoPrestamo + ", idUsuario=" + idUsuario + ", idEmpleado=" + idEmpleado
      + ", fechaPrestamo=" + fechaPrestamo;
  }

}
