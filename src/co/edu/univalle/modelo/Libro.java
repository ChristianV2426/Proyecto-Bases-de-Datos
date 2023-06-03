/*
  Archivo: Libro.java
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

public class Libro {

  private String isbn;
  private String titulo;
  private Integer numPagina;
  private Integer anioPublicacion;
  private String idioma;
  private String codigoArea;
  private String codigoEditorial;
  private static int numeroColumnas = 7;

  public Libro(String isbn, String titulo, Integer numPagina, Integer anioPublicacion, String idioma, String codigoArea, String codigoEditorial) {
    this.isbn = isbn;
    this.titulo = titulo;
    this.numPagina = numPagina;
    this.anioPublicacion = anioPublicacion;
    this.idioma = idioma;
    this.codigoArea = codigoArea;
    this.codigoEditorial = codigoEditorial;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getTitulo() {
    return titulo;
  }

  public Integer getNumPagina() {
    return numPagina;
  }

  public Integer getAnioPublicacion() {
    return anioPublicacion;
  }

  public String getIdioma() {
    return idioma;
  }

  public String getCodigoArea() {
    return codigoArea;
  }

  public String getCodigoEditorial() {
    return codigoEditorial;
  }

  public static int getNumeroColumnas(){
    return numeroColumnas;
  }

  @Override
  public String toString() {
    return "isbn=" + isbn + ", titulo=" + titulo;
  }
  
}
