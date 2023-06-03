/*
  Archivo: RelacionEscribe.java
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

public class RelacionEscribe {
  private String codigoAutor;
  private String isbn;

  public RelacionEscribe(String codigoAutor, String isbn) {
    this.codigoAutor = codigoAutor;
    this.isbn = isbn;
  }

  public RelacionEscribe(Autor autor, Libro libro) {
    this.codigoAutor = autor.getCodigoAutor();
    this.isbn = libro.getIsbn();
  }

  public String getCodigoAutor() {
    return codigoAutor;
  }

  public String getisbn() {
    return isbn;
  }

  @Override
  public String toString() {
    return "codigoAutor=" + codigoAutor + ", isbn=" + isbn;
  }

}
