/*
  Archivo: DaoEmpleado.java
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

public class DaoEmpleado implements DaoGeneral<Empleado> {
  Connection conexionBD;

  public DaoEmpleado(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(Empleado empleado) {
    String sentenciaInsert =
      "INSERT INTO empleado VALUES ('" + 
      empleado.getIdEmpleado() + "' , '" +
      empleado.getNombreEmpleado() + "', '" +
      empleado.getCargo() + "');";
  
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }
  
  @Override
  public boolean editarElemento(Empleado empleado) {
    String sentenciaUpdate =
      "UPDATE empleado SET nombre_empleado='" + empleado.getNombreEmpleado() +
      "', cargo='" + empleado.getCargo() + 
      "' WHERE id_empleado='" + empleado.getIdEmpleado() + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete = "DELETE FROM empleado WHERE id_empleado='" + llavePrimaria + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT * FROM empleado;";

    return Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
  }

  @Override
  public Empleado obtenerElemento(String llavePrimaria) {
    String sentenciaSelect =
      "SELECT * FROM empleado WHERE id_empleado='" + llavePrimaria + "';";
    
    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new Empleado(
          resultadoConsulta.getString(1),
          resultadoConsulta.getString(2),
          resultadoConsulta.getString(3) );
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }
  }
  
}
