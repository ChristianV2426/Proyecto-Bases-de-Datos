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
  private Integer numEjemplar;
  private String estante;
  private String numCajon;
  private String numPasillo;
  private String nombreSala;
  private static int numeroColumnas = 5;

  public Ejemplar(String isbn, String titulo, Integer numPagina, Integer anioPublicacion, String idioma,
  String codigoArea, String codigoEditorial, Integer numEjemplar, String estante, String numCajon,
  String numPasillo, String nombreSala) {

    super(isbn, titulo, numPagina, anioPublicacion, idioma, codigoArea, codigoEditorial);
    this.numEjemplar = numEjemplar;
    this.estante = estante;
    this.numCajon = numCajon;
    this.numPasillo = numPasillo;
    this.nombreSala = nombreSala;
  }

  public Ejemplar(Libro libro, Integer numEjemplar, String estante, String numCajon,
    String numPasillo, String nombreSala) {

    super(libro.getIsbn(), libro.getTitulo(), libro.getNumPagina(), libro.getAnioPublicacion(), libro.getIdioma(),
      libro.getCodigoArea(), libro.getCodigoEditorial());
      
    this.numEjemplar = numEjemplar;
    this.estante = estante;
    this.numCajon = numCajon;
    this.numPasillo = numPasillo;
    this.nombreSala = nombreSala;
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

  public static int getNumeroColumnas(){
    return numeroColumnas;
  }

  @Override
  public String toString() {
    return super.toString() + " libro físico. Ejemplar número: " + numEjemplar;
  }

}
