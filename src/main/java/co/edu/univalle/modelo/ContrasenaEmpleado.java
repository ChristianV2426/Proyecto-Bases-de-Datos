/*
  Archivo: ContrasenaEmpleado.java
  Bases de Datos - 750006C - Grupo 01
  Proyecto - Biblioteca UniversidEmpleadoad del Valle

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

public class ContrasenaEmpleado {
  private String idEmpleado;
  private String contrasena;

  public ContrasenaEmpleado(String idEmpleado, String contrasena) {
    this.idEmpleado = idEmpleado;
    this.contrasena = contrasena;
  }

  public ContrasenaEmpleado(Empleado empleado, String contrasena) {
    this.idEmpleado = empleado.getIdEmpleado();
    this.contrasena = contrasena;
  }

  public String getIdEmpleado() {
    return idEmpleado;
  }

  public String getContrasena() {
    return contrasena;
  }

  @Override
  public String toString() {
    return "idEmpleado=" + idEmpleado + ", contrasena=" + contrasena;
  }
  
}