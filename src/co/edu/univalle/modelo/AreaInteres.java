/*
  Archivo: AreaInteres.java
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

public class AreaInteres {
  private String idUsuario;
  private String codigoArea;
  private static int numeroColumnas = 2;

  public AreaInteres(String idUsuario, String codigoArea) {
    this.idUsuario = idUsuario;
    this.codigoArea = codigoArea;
  }

  public AreaInteres(Usuario usuario, Area area){
    this.idUsuario = usuario.getIdUsuario();
    this.codigoArea = area.getCodigoArea();
  }

  public String getIdUsuario() {
    return idUsuario;
  }

  public String getCodigoArea() {
    return codigoArea;
  }

  public static int getNumeroColumnas() {
    return numeroColumnas;
  }

  @Override
  public String toString() {
    return "idUsuario=" + idUsuario + ", codigoArea=" + codigoArea;
  }

}
