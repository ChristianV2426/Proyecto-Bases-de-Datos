/*
  Archivo: Empleado.java
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

public class Empleado {
  private String idEmpleado;
  private String nombreEmpleado;
  private String cargo;
  private static int numeroColumnas = 3;
  
  public Empleado(String idEmpleado, String nombreEmpleado, String cargo) {
    this.idEmpleado = idEmpleado;
    this.nombreEmpleado = nombreEmpleado;
    this.cargo = cargo;
  }

  public String getIdEmpleado() {
    return idEmpleado;
  }

  public String getNombreEmpleado() {
    return nombreEmpleado;
  }

  public String getCargo() {
    return cargo;
  }

  public static int getNumeroColumnas(){
    return numeroColumnas;
  }

  @Override
  public String toString() {
    return "idEmpleado=" + idEmpleado + ", nombreEmpleado=" + nombreEmpleado;
  }

}
