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

import java.math.BigDecimal;
import java.time.*;

public class Multa {
  private String codigoMulta;
  private String codigoPresta;
  private LocalDate fechaMulta;
  private BigDecimal valorMulta;
  private String descripcionMulta;
  private Boolean estadoMulta;

  public Multa(String codigoMulta, String codigoPresta, LocalDate fechaMulta, BigDecimal valorMulta, String descripcionMulta, Boolean estadoMulta) {
    this.codigoMulta = codigoMulta;
    this.codigoPresta = codigoPresta;
    this.fechaMulta = fechaMulta;
    this.valorMulta = valorMulta;
    this.descripcionMulta = descripcionMulta;
    this.estadoMulta = estadoMulta;
  }

  public Multa(String codigoMulta, RelacionPresta relacionPresta, Ejemplar ejemplar, LocalDate fechaMulta, BigDecimal valorMulta, String descripcionMulta, Boolean estadoMulta) {
    this.codigoMulta = codigoMulta;
    this.codigoPresta = relacionPresta.getCodigoPrestamo();
    this.fechaMulta = fechaMulta;
    this.valorMulta = valorMulta;
    this.descripcionMulta = descripcionMulta;
    this.estadoMulta = estadoMulta;
  }

  public String getCodigoMulta() {
    return codigoMulta;
  }

  public String getCodigoPresta() {
    return codigoPresta;
  }

  public LocalDate getFechaMulta() {
    return fechaMulta;
  }

  public BigDecimal getValorMulta() {
    return valorMulta;
  }

  public String getDescripcionMulta() {
    return descripcionMulta;
  }

  public Boolean getEstadoMulta() {
    return estadoMulta;
  }

  public void setEstadoMulta(Boolean estado) {
    this.estadoMulta = estado;
  }

  @Override
  public String toString() {
    String stringEstadoMulta;
    if(estadoMulta)
      stringEstadoMulta = "Pagada";
    else
      stringEstadoMulta = "No pagada";

    return "codigoMulta=" + codigoMulta + ", codigoPresta=" + codigoPresta + ", fechaMulta=" + fechaMulta +
      ", valorMulta=" + valorMulta + ", descripcionMulta=" + descripcionMulta + ", estadoMulta=" + stringEstadoMulta;
  }

}
