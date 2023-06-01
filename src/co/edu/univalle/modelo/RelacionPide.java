/*
  Archivo: RelacionPide.java
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

public class RelacionPide {
  private String codigoSolicitud;
  private String isbn;

  public RelacionPide(String codigoSolicitud, String isbn) {
    this.codigoSolicitud = codigoSolicitud;
    this.isbn = isbn;
  }

  public RelacionPide(Solicitud solicitud, Libro libro) {
    this.codigoSolicitud = solicitud.getCodigoSolicitud();
    this.isbn = libro.getIsbn();
  }

  public String getCodigoSolicitud() {
    return codigoSolicitud;
  }

  public String getIsbn() {
    return isbn;
  }

  @Override
  public String toString() {
    return "codigoSolicitud=" + codigoSolicitud + ", isbn=" + isbn;
  }

}
