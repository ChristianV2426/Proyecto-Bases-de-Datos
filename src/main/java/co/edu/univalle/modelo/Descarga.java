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
  private String codigoDigital;
  private LocalDateTime fechaDescargaConHora;
  private String numIp;

  public Descarga(String codigoDescarga, String idUsuario, String codigoDigital, LocalDateTime fechaDescargaConHora, String numIp) {
    this.codigoDescarga = codigoDescarga;
    this.idUsuario = idUsuario;
    this.codigoDigital = codigoDigital;
    this.fechaDescargaConHora = fechaDescargaConHora;
    this.numIp = numIp;
  }

  public Descarga(String codigoDescarga, Usuario usuario, Digital digital, LocalDateTime fechaDescargaConHora, String numIp) {
    this.codigoDescarga = codigoDescarga;
    this.idUsuario = usuario.getIdUsuario();
    this.codigoDigital = digital.getCodigoDigital();
    this.fechaDescargaConHora = fechaDescargaConHora;
    this.numIp = numIp;
  }

  public String getCodigoDescarga() {
    return codigoDescarga;
  }

  public String getIdUsuario() {
    return idUsuario;
  }

  public String getCodigoDigital() {
    return codigoDigital;
  }

  public LocalDateTime getFechaDescargaConHora() {
    return fechaDescargaConHora;
  }

  public String getNumIp() {
    return numIp;
  }

  @Override
  public String toString() {
    return "codigoDescarga=" + codigoDescarga + ", idUsuario=" + idUsuario + ", codigoDigital="
        + codigoDigital + ", fechaDescargaConHora=" + fechaDescargaConHora + ", numIp=" + numIp;
  }
  
}
