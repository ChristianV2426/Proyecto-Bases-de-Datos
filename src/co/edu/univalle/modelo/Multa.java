/*
  Archivo: Multa.java
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

public class Multa {
  private String codigoMulta;
  private String codigoPrestamo;
  private String isbn;
  private Integer numEjemplar;
  private LocalDate fechaMulta;
  private Double valorMulta;
  private String descripcionMulta;
  private static int numeroColumnas = 7;

  public Multa(String codigoMulta, String codigoPrestamo, String isbn, Integer numEjemplar, LocalDate fechaMulta, Double valorMulta, String descripcionMulta) {
    this.codigoMulta = codigoMulta;
    this.codigoPrestamo = codigoPrestamo;
    this.isbn = isbn;
    this.numEjemplar = numEjemplar;
    this.fechaMulta = fechaMulta;
    this.valorMulta = valorMulta;
    this.descripcionMulta = descripcionMulta;
  }

  public Multa(String codigoMulta, Prestamo prestamo, Ejemplar ejemplar, LocalDate fechaMulta, Double valorMulta, String descripcionMulta) {
    this.codigoMulta = codigoMulta;
    this.codigoPrestamo = prestamo.getCodigoPrestamo();
    this.isbn = ejemplar.getIsbn();
    this.numEjemplar = ejemplar.getNumEjemplar();
    this.fechaMulta = fechaMulta;
    this.valorMulta = valorMulta;
    this.descripcionMulta = descripcionMulta;
  }

  public String getCodigoMulta() {
    return codigoMulta;
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

  public LocalDate getFechaMulta() {
    return fechaMulta;
  }

  public Double getValorMulta() {
    return valorMulta;
  }

  public String getDescripcionMulta() {
    return descripcionMulta;
  }

  public static int getNumeroColumnas(){
    return numeroColumnas;
  }

  @Override
  public String toString() {
    return "Multa [codigoMulta=" + codigoMulta + ", codigoPrestamo=" + codigoPrestamo + ", isbn=" + isbn
      + ", numEjemplar=" + numEjemplar + ", fechaMulta=" + fechaMulta + ", valorMulta=" + valorMulta;
  }

}
