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
  private String codigoEjemplar;
  private LocalDate fechaDevolucionEsperada;
  private LocalDate fechaDevolucionReal;

  public RelacionPresta(String codigoPresta, String codigoPrestamo, String codigoEjemplar, LocalDate fechaDevolucionEsperada) {
    this.codigoPresta = codigoPresta;
    this.codigoPrestamo = codigoPrestamo;
    this.codigoEjemplar = codigoEjemplar;
    this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    this.fechaDevolucionReal = null;
  }

  public RelacionPresta(String codigoPresta, Prestamo prestamo, Ejemplar ejemplar, LocalDate fechaDevolucionEsperada) {
    this.codigoPresta = codigoPresta;
    this.codigoPrestamo = prestamo.getCodigoPrestamo();
    this.codigoEjemplar = ejemplar.getCodigoEjemplar();
    this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    this.fechaDevolucionReal = null;
  }

  public String getCodigoPresta() {
    return codigoPresta;
  }

  public String getCodigoPrestamo() {
    return codigoPrestamo;
  }

  public String getCodigoEjemplar() {
    return codigoEjemplar;
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
    return "codigoPresta=" + codigoPresta + ", codigoPrestamo=" + codigoPrestamo + ", codigoEjemplar="
        + codigoEjemplar + ", fechaDevolucionEsperada=" + fechaDevolucionEsperada + ", fechaDevolucionReal=" + fechaDevolucionReal;
  }
  
}
