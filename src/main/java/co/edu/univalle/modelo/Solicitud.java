/*
  Archivo: Solicitud.java
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

public class Solicitud {
  private String codigoSolicitud;
  private String idUsuario;
  private LocalDate fechaSolicitud;
  private String descripcion;
  private String estadoSolicitud;
  
  public Solicitud(String codigoSolicitud, String idUsuario, LocalDate fechaSolicitud, String descripcion, String estadoSolicitiud) {
    this.codigoSolicitud = codigoSolicitud;
    this.idUsuario = idUsuario;
    this.fechaSolicitud = fechaSolicitud;
    this.descripcion = descripcion;
    this.estadoSolicitud = estadoSolicitiud;
  }

  public Solicitud(String codigoSolicitud, Usuario usuario, LocalDate fechaSolicitud, String descripcion, String estadoSolicitud) {
    this.codigoSolicitud = codigoSolicitud;
    this.idUsuario = usuario.getIdUsuario();
    this.fechaSolicitud = fechaSolicitud;
    this.descripcion = descripcion;
    this.estadoSolicitud = estadoSolicitud;
  }

  public String getCodigoSolicitud() {
    return codigoSolicitud;
  }

  public String getIdUsuario() {
    return idUsuario;
  }

  public LocalDate getFechaSolicitud() {
    return fechaSolicitud;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public String getEstadoSolicitud() {
    return estadoSolicitud;
  }

  @Override
  public String toString() {
    return "codigoSolicitud=" + codigoSolicitud + ", idUsuario=" + idUsuario +
      ", fechaSolicitud=" + fechaSolicitud + ", estadoSolicitud=" + estadoSolicitud;
  }

}
