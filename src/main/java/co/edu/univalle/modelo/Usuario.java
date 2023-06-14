/*
  Archivo: Usuario.java
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

public class Usuario {
  private String idUsuario;
  private String nombreUsuario;
  private String telefono;
  private String direccion;
  private String email;

  public Usuario(String idUsuario, String nombreUsuario, String telefono, String direccion, String email) {
    this.idUsuario = idUsuario;
    this.nombreUsuario = nombreUsuario;
    this.telefono = telefono;
    this.direccion = direccion;
    this.email = email;
  }

  public String getIdUsuario() {
    return idUsuario;
  }

  public String getNombreUsuario() {
    return nombreUsuario;
  }

  public String getTelefono() {
    return telefono;
  }

  public String getDireccion() {
    return direccion;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario;
  } 

}
