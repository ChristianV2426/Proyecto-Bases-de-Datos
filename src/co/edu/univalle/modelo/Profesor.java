/*
  Archivo: Profesor.java
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

public class Profesor extends Usuario {
  private String dependencia;
  private String titulo;
  private static int numeroColumnas = 2;
  
  public Profesor(String idUsuario, String nombreUsuario, String telefono, String direccion, String email, String dependencia, String titulo) {
    super(idUsuario, nombreUsuario, telefono, direccion, email);
    this.dependencia = dependencia;
    this.titulo = titulo;
  }

  public Profesor(Usuario usuario, String dependencia, String titulo) {
    super(usuario.getIdUsuario(), usuario.getNombreUsuario(), usuario.getTelefono(), usuario.getDireccion(), usuario.getEmail());
    this.dependencia = dependencia;
    this.titulo = titulo;
  }

  public String getDependencia() {
    return dependencia;
  }

  public String getTitulo() {
    return titulo;
  }

  public static int getNumeroColumnas(){
    return numeroColumnas;
  }

  @Override
  public String toString() {
    return super.toString() + " tipo de usuario: Profesor.";
  }

}
