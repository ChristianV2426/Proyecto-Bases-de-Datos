/*
  Archivo: Autor.java
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

public class Autor {
  private String codigoAutor;
  private String primerNombre;
  private String segundoNombre;
  private String primerApellido;
  private String segundoApellido;

  public Autor(String codigoAutor, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {
    this.codigoAutor = codigoAutor;
    this.primerNombre = primerNombre;
    this.segundoNombre = segundoNombre;
    this.primerApellido = primerApellido;
    this.segundoApellido = segundoApellido;
  }

  public Autor(String codigoAutor, String primerNombre, String primerApellido) {
    this.codigoAutor = codigoAutor;
    this.primerNombre = primerNombre;
    this.segundoNombre = "";
    this.primerApellido = primerApellido;
    this.segundoApellido = "";
  }

  public String getCodigoAutor() {
    return codigoAutor;
  }

  public String getPrimerNombre() {
    return primerNombre;
  }

  public String getSegundoNombre() {
    return segundoNombre;
  }

  public String getPrimerApellido() {
    return primerApellido;
  }

  public String getSegundoApellido() {
    return segundoApellido;
  }

  @Override
  public String toString() {
    return "codigoAutor=" + codigoAutor + ", primerNombre=" + primerNombre + ", primerApellido=" + primerApellido;
  }

}
