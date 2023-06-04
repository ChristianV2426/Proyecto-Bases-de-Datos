/*
  Archivo: DaoRelacionPresta.java
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
import java.time.*;

public class DaoRelacionPresta implements DaoGeneral<RelacionPresta>{
  Connection conexionBD;

  public DaoRelacionPresta(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(RelacionPresta relacionPresta) {
    String fechaDevolucionReal;
    if(relacionPresta.getFechaDevolucionReal() == null)
      fechaDevolucionReal = "NULL";
    else
      fechaDevolucionReal = relacionPresta.getFechaDevolucionReal().toString();

    String sentenciaInsert = 
      "INSERT INTO presta VALUES ('" +
      relacionPresta.getCodigoPresta() + "', '" +
      relacionPresta.getCodigoPrestamo() + "', '" +
      relacionPresta.getIsbn() + "', '" +
      relacionPresta.getNumEjemplar() + "', '" +
      relacionPresta.getFechaDevolucionEsperada() + "', " +
      fechaDevolucionReal + ");";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(RelacionPresta relacionPresta) {
    String fechaDevolucionReal;
    if(relacionPresta.getFechaDevolucionReal() == null)
      fechaDevolucionReal = "NULL";
    else
      fechaDevolucionReal = relacionPresta.getFechaDevolucionReal().toString();

    String sentenciaUpdate = 
      "UPDATE presta SET codigo_prestamo='" + relacionPresta.getCodigoPrestamo() +
      "', ISBN='" + relacionPresta.getIsbn() +
      "', num_ejemplar='" + relacionPresta.getNumEjemplar() +
      "', fecha_devolucion_esperada='" + relacionPresta.getFechaDevolucionEsperada() + 
      "', fecha_devolucion_real=" + fechaDevolucionReal +
      " WHERE codigo_presta='" + relacionPresta.getCodigoPresta() + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete = "DELETE FROM presta WHERE codigo_presta='" + llavePrimaria + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT * FROM presta;";

    return Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
  }

  @Override
  public RelacionPresta obtenerElemento(String llavePrimaria) {
    String sentenciaSelect = "SELECT * FROM presta WHERE codigo_presta='" + llavePrimaria + "';";

    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new RelacionPresta(
          resultadoConsulta.getString(1),
          resultadoConsulta.getString(2),
          resultadoConsulta.getString(3),
          Integer.valueOf(resultadoConsulta.getString(4)),
          LocalDate.parse(resultadoConsulta.getString(5)) );
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }
  }
  
}
