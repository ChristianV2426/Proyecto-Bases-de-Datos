/*
  Archivo: Digital.java
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

public class Digital extends Libro{
  private String url;
  private Integer tamanoBytes;
  private String formato;

  public Digital(String isbn, String titulo, Integer numPagina, Integer anioPublicacion, String idioma,
    String codigoArea, String codigoEditorial, String url, Integer tamanoBytes, String formato) {

    super(isbn, titulo, numPagina, anioPublicacion, idioma, codigoArea, codigoEditorial);
    this.url = url;
    this.tamanoBytes = tamanoBytes;
    this.formato = formato;
  }

  public Digital(Libro libro, String url, Integer tamanoBytes, String formato) {
    super(libro.getIsbn(), libro.getTitulo(), libro.getNumPagina(), libro.getAnioPublicacion(),
    libro.getIdioma(), libro.getCodigoArea(), libro.getCodigoEditorial());
    this.url = url;
    this.tamanoBytes = tamanoBytes;
    this.formato = formato;
  }

  public String getUrl() {
    return url;
  }

  public Integer getTamanoBytes() {
    return tamanoBytes;
  }

  public String getFormato() {
    return formato;
  }

  @Override
  public String toString() {
    return super.toString() + " libro digital. Url: " + url;
  }

}

