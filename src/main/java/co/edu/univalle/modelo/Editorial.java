/*
  Archivo: Editorial.java
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

public class Editorial {
  private String codigoEditorial;
  private String nombreEditorial;
  private String paisOrigen;
  private String paginaWeb;

  public Editorial(String codigoEditorial, String nombreEditorial, String paisOrigen, String paginaWeb) {
    this.codigoEditorial = codigoEditorial;
    this.nombreEditorial = nombreEditorial;
    this.paisOrigen = paisOrigen;
    this.paginaWeb = paginaWeb;
  }

  public String getCodigoEditorial() {
    return codigoEditorial;
  }

  public String getNombreEditorial() {
    return nombreEditorial;
  }

  public String getPaisOrigen() {
    return paisOrigen;
  }

  public String getPaginaWeb() {
    return paginaWeb;
  }

  @Override
  public String toString() {
    return "codigoEditorial=" + codigoEditorial + ", nombreEditorial=" + nombreEditorial;
  }

}

