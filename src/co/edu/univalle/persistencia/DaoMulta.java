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
import java.math.BigDecimal;

public class DaoMulta implements DaoGeneral<Multa> {
  Connection conexionBD;

  public DaoMulta(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(Multa multa) {
    String sentenciaInsert = 
      "INSERT INTO multa VALUES ('" +
      multa.getCodigoMulta() + "', '" +
      multa.getCodigoPresta() + "', '" +
      multa.getFechaMulta() + "', '" +
      multa.getValorMulta() + "', '" +
      multa.getDescripcionMulta() + "');";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(Multa multa) {
    String sentenciaUpdate = 
      "UPDATE multa SET codigo_presta='" + multa.getCodigoPresta() +
      "', fecha_multa='" + multa.getFechaMulta() +
      "', valor_multa='" + multa.getValorMulta() +
      "', descripcion_multa='" + multa.getDescripcionMulta() +
      "' WHERE codigo_multa='" + multa.getCodigoMulta() + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete = "DELETE FROM multa WHERE codigo_multa='" + llavePrimaria + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT codigo_multa, id_usuario, nombre_usuario, ISBN, titulo, num_ejemplar, fecha_devolucion_esperada, fecha_devolucion_real, valor_multa, descripcion_multa " +
      " FROM multa NATURAL JOIN presta NATURAL JOIN prestamo NATURAL JOIN usuario NATURAL JOIN libro;";
    
    return Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
  }

  @Override
  public Multa obtenerElemento(String llavePrimaria) {
    String sentenciaSelect = "SELECT * FROM multa WHERE codigo_multa='" + llavePrimaria + "';";

    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new Multa(
          resultadoConsulta.getString(1),
          resultadoConsulta.getString(2),
          LocalDate.parse(resultadoConsulta.getString(3)),
          BigDecimal.valueOf(Double.parseDouble(resultadoConsulta.getString(4))),
          resultadoConsulta.getString(5) );
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }
  } 
  
}
