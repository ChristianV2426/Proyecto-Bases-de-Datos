/*
  Archivo: Descarga.java
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

import java.time.LocalDateTime;

public class Descarga {
  private String codigoDescarga;
  private String idUsuario;
  private String isbn;
  private String url;
  private LocalDateTime fechaDescargaConHora;
  private String numIp;
  private static int numeroColumnas = 6;

  public Descarga(String codigoDescarga, String idUsuario, String isbn, String url, LocalDateTime fechaDescargaConHora, String numIp) {
    this.codigoDescarga = codigoDescarga;
    this.idUsuario = idUsuario;
    this.isbn = isbn;
    this.url = url;
    this.fechaDescargaConHora = fechaDescargaConHora;
    this.numIp = numIp;
  }

  public Descarga(String codigoDescarga, Usuario usuario, Digital digital, LocalDateTime fechaDescargaConHora, String numIp) {
    this.codigoDescarga = codigoDescarga;
    this.idUsuario = usuario.getIdUsuario();
    this.isbn = digital.getIsbn();
    this.url = digital.getUrl();
    this.fechaDescargaConHora = fechaDescargaConHora;
    this.numIp = numIp;
  }

  public String getCodigoDescarga() {
    return codigoDescarga;
  }

  public String getIdUsuario() {
    return idUsuario;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getUrl() {
    return url;
  }

  public LocalDateTime getFechaDescargaConHora() {
    return fechaDescargaConHora;
  }

  public String getNumIp() {
    return numIp;
  }

  public static int getNumeroColumnas() {
    return numeroColumnas;
  }

  @Override
  public String toString() {
    return "codigoDescarga=" + codigoDescarga + ", idUsuario=" + idUsuario + ", isbn=" + isbn + ", url=" + url
      + ", fechaDescargaConHora=" + fechaDescargaConHora + ", numIp=" + numIp;
  }
  
}
