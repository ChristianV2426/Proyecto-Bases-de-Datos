/*
  Archivo: RelacionPresta.java
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

import java.time.LocalDate;

public class RelacionPresta {
  private String codigoPresta;
  private String codigoPrestamo;
  private String isbn;
  private Integer numEjemplar;
  private LocalDate fechaDevolucionEsperada;
  private LocalDate fechaDevolucionReal;

  public RelacionPresta(String codigoPresta, String codigoPrestamo, String isbn, Integer numEjemplar, LocalDate fechaDevolucionEsperada) {
    this.codigoPresta = codigoPresta;
    this.codigoPrestamo = codigoPrestamo;
    this.isbn = isbn;
    this.numEjemplar = numEjemplar;
    this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    this.fechaDevolucionReal = null;
  }

  public RelacionPresta(String codigoPresta, Prestamo prestamo, Ejemplar ejemplar, LocalDate fechaDevolucionEsperada) {
    this.codigoPresta = codigoPresta;
    this.codigoPrestamo = prestamo.getCodigoPrestamo();
    this.isbn = ejemplar.getIsbn();
    this.numEjemplar = ejemplar.getNumEjemplar();
    this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    this.fechaDevolucionReal = null;
  }

  public String getCodigoPresta() {
    return codigoPresta;
  }

  public String getCodigoPrestamo() {
    return codigoPrestamo;
  }

  public String getIsbn() {
    return isbn;
  }

  public Integer getNumEjemplar() {
    return numEjemplar;
  }

  public LocalDate getFechaDevolucionEsperada() {
    return fechaDevolucionEsperada;
  }

  public LocalDate getFechaDevolucionReal() {
    return fechaDevolucionReal;
  }

  public void setFechaDevolucionReal(LocalDate fechaDevolucionReal) {
    this.fechaDevolucionReal = fechaDevolucionReal;
  }

  @Override
  public String toString() {
    return "RelacionPresta [codigoPresta=" + codigoPresta + ", codigoPrestamo=" + codigoPrestamo + ", isbn=" + isbn + ", numEjemplar=" + numEjemplar 
      + ", fechaDevolucionEsperada=" + fechaDevolucionEsperada + ", fechaDevolucionReal=" + fechaDevolucionReal;
  }
  
}
