/*
  Archivo: ContrasenaUsuario.java
  Bases de Datos - 750006C - Grupo 01
  Proyecto - Biblioteca UniversidUsuarioad del Valle

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

public class ContrasenaUsuario {
  private String idUsuario;
  private String contrasena;

  public ContrasenaUsuario(String idUsuario, String contrasena) {
    this.idUsuario = idUsuario;
    this.contrasena = contrasena;
  }

  public ContrasenaUsuario(Usuario usuario, String contrasena) {
    this.idUsuario = usuario.getIdUsuario();
    this.contrasena = contrasena;
  }

  public String getIdUsuario() {
    return idUsuario;
  }

  public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }

  @Override
  public String toString() {
    return "idUsuario=" + idUsuario + ", contrasena=" + contrasena;
  }
  
}
