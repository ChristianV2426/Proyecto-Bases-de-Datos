/*
  Archivo: DaoPrestamo.java
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

package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.*;
import java.sql.*;
import java.time.LocalDate;

public class DaoPrestamo implements DaoGeneral<Prestamo> {
  Connection conexionBD;

  public DaoPrestamo(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(Prestamo prestamo) {
    String sentenciaInsert =
      "INSERT INTO prestamo VALUES ('" +
      prestamo.getCodigoPrestamo() + "', '" +
      prestamo.getIdUsuario() + "', '" +
      prestamo.getIdEmpleado() + "', '" +
      prestamo.getFechaPrestamo() + "');";
    
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(Prestamo prestamo) {
    String sentenciaUpdate = 
      "UPDATE prestamo SET id_usuario='" + prestamo.getIdUsuario() +
      "', id_empleado='" + prestamo.getIdEmpleado() +
      "', fecha_prestamo='" + prestamo.getFechaPrestamo() +
      "' WHERE codigo_prestamo='" + prestamo.getCodigoPrestamo() + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete = "DELETE FROM prestamo WHERE codigo_prestamo='" + llavePrimaria + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT codigo_prestamo, id_usuario, nombre_usuario, codigo_presta, ISBN, titulo, num_ejemplar, fecha_prestamo, fecha_devolucion_esperada, fecha_devolucion_real " +
      "FROM prestamo NATURAL JOIN usuario NATURAL JOIN presta NATURAL JOIN ejemplar NATURAL JOIN libro ORDER BY codigo_prestamo, codigo_presta;";

    return calcularEstadoPrestamo(Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD), 10);
  }

  public String[][] obtenerPrestamosUsuario(String id_usuario) {
    String sentenciaSelect = "SELECT codigo_presta, titulo, codigo_ejemplar, fecha_prestamo, fecha_devolucion_esperada, fecha_devolucion_real " +
      "FROM prestamo NATURAL JOIN usuario NATURAL JOIN presta NATURAL JOIN ejemplar NATURAL JOIN libro " +
      "WHERE id_usuario='" + id_usuario + "' ORDER BY codigo_presta;";

    return calcularEstadoPrestamo(Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD), 6);
  }

  public String[][] calcularEstadoPrestamo(String[][] prestamos, int columnaAActualizar){
  if(prestamos == null)
    return null;
    
  String[][] prestamosConEstado = new String[prestamos.length][columnaAActualizar + 1];
  for(int i=0; i < prestamos.length; i++)
    for(int j=0; j < columnaAActualizar; j++)
      prestamosConEstado[i][j] = prestamos[i][j];

  LocalDate fechaActual = LocalDate.now();

  for(int i = 0; i < prestamos.length; i++){
    LocalDate fechaDevolucionEsperada = LocalDate.parse(prestamos[i][columnaAActualizar-2]);
    LocalDate fechaDevolucionReal;

    if (prestamos[i][columnaAActualizar-1] == null){
      fechaDevolucionReal = null;
      prestamosConEstado[i][columnaAActualizar-1] = "";
      prestamosConEstado[i][columnaAActualizar] = "";
    }
    else
      fechaDevolucionReal = LocalDate.parse(prestamos[i][columnaAActualizar-1]);
    
    if(fechaDevolucionReal == null && fechaActual.isBefore(fechaDevolucionEsperada))
      prestamosConEstado[i][columnaAActualizar] = "Vigente";
    
    else if(fechaDevolucionReal == null && fechaActual.isAfter(fechaDevolucionEsperada))
      prestamosConEstado[i][columnaAActualizar] = "En mora";

    else if(fechaDevolucionReal.isBefore(fechaDevolucionEsperada) || fechaDevolucionReal.isEqual(fechaDevolucionEsperada))
      prestamosConEstado[i][columnaAActualizar] = "Entregado";
    
    else // fechaDevolucionReal.isAfter(fechaDevolucionEsperada)
      prestamosConEstado[i][columnaAActualizar] = "Entregado con retraso";
    }

    return prestamosConEstado;
  }

  public String[][] relacionesPrestaEnPrestamo(String codigoPrestamo){
    String sentenciaSelect = "SELECT codigo_presta, titulo, codigo_ejemplar, fecha_prestamo, fecha_devolucion_esperada, fecha_devolucion_real " +
      "FROM prestamo NATURAL JOIN usuario NATURAL JOIN presta NATURAL JOIN ejemplar NATURAL JOIN libro " +
      "WHERE codigo_prestamo='" + codigoPrestamo + "' ORDER BY codigo_presta;";

    return calcularEstadoPrestamo(Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD), 6);
  }

  @Override
  public Prestamo obtenerElemento(String llavePrimaria) {
    String sentenciaSelect = "SELECT * FROM prestamo WHERE codigo_prestamo='" + llavePrimaria + "';";

    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new Prestamo(
          resultadoConsulta.getString(1),
          resultadoConsulta.getString(2),
          resultadoConsulta.getString(3),
          LocalDate.parse(resultadoConsulta.getString(4)) );
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }
  }

}
