/*
  Archivo: Estudiante.java
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

public class Estudiante extends Usuario {
  private String carrera;
  private String universidad;
  
  public Estudiante(String idUsuario, String nombreUsuario, String telefono, String direccion, String email, String carrera, String universidad) {
    super(idUsuario, nombreUsuario, telefono, direccion, email);
    this.carrera = carrera;
    this.universidad = universidad;
  }

  public Estudiante(Usuario usuario, String carrera, String universidad) {
    super(usuario.getIdUsuario(), usuario.getNombreUsuario(), usuario.getTelefono(), usuario.getDireccion(), usuario.getEmail());
    this.carrera = carrera;
    this.universidad = universidad;
  }

  public String getCarrera() {
    return carrera;
  }

  public String getUniversidad() {
    return universidad;
  }
  
  @Override
  public String toString() {
    return super.toString() + " tipo de usuario: Estudiante.";
  }

}
