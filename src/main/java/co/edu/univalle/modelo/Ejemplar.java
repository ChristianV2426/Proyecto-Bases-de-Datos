/*
  Archivo: Ejemplar.java
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

public class Ejemplar extends Libro {
  private String codigoEjemplar;
  private Integer numEjemplar;
  private String estante;
  private String numCajon;
  private String numPasillo;
  private String nombreSala;
  private Boolean disponible;

  public Ejemplar(String isbn, String titulo, Integer numPagina, Integer anioPublicacion, String idioma,
  String codigoArea, String codigoEditorial, String codigoEjemplar, Integer numEjemplar, String estante, String numCajon,
  String numPasillo, String nombreSala, Boolean disponible) {

    super(isbn, titulo, numPagina, anioPublicacion, idioma, codigoArea, codigoEditorial);
    this.codigoEjemplar = codigoEjemplar;
    this.numEjemplar = numEjemplar;
    this.estante = estante;
    this.numCajon = numCajon;
    this.numPasillo = numPasillo;
    this.nombreSala = nombreSala;
    this.disponible = disponible;
  }

  public Ejemplar(Libro libro, String codigoEjemplar, Integer numEjemplar, String estante, String numCajon,
    String numPasillo, String nombreSala, Boolean disponible) {

    super(libro.getIsbn(), libro.getTitulo(), libro.getNumPagina(), libro.getAnioPublicacion(), libro.getIdioma(),
      libro.getCodigoArea(), libro.getCodigoEditorial());
    
    this.codigoEjemplar = codigoEjemplar;
    this.numEjemplar = numEjemplar;
    this.estante = estante;
    this.numCajon = numCajon;
    this.numPasillo = numPasillo;
    this.nombreSala = nombreSala;
    this.disponible = disponible;
  }
  
  public String getCodigoEjemplar() {
    return codigoEjemplar;
  }

  public Integer getNumEjemplar() {
    return numEjemplar;
  }

  public String getEstante() {
    return estante;
  }

  public String getNumCajon() {
    return numCajon;
  }

  public String getNumPasillo() {
    return numPasillo;
  }

  public String getNombreSala() {
    return nombreSala;
  }

  public Boolean getDisponible() {
    return disponible;
  }

  public void setDisponible(Boolean disponible) {
    this.disponible = disponible;
  }

  @Override
  public String toString() {
    return super.toString() + " libro físico. Ejemplar con código: " + codigoEjemplar;
  }

}
