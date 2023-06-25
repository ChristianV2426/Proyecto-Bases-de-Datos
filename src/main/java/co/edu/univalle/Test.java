/*
  Archivo: Test.java
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

package co.edu.univalle;

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.*;
import java.sql.*;
import java.time.*;
import java.math.BigDecimal;


public class Test {
  public static void main(String[] args) {
    String rutaArchivoCredenciales = "./credenciales.txt";

    FachadaBD fachadaBD = new FachadaBD(rutaArchivoCredenciales);
    Connection conexionBD = fachadaBD.getConexionBD();
    Biblioteca biblioteca = new Biblioteca(conexionBD);

    /* Pruebas CRUD sobre editorial */
    Editorial editorial1 = new Editorial("ED011", "Editores Santillana", "Colombia", "https:antillana.com.co/");
    System.out.println(biblioteca.getEditoriales().insertarElemento(editorial1));

    Editorial editorial2 = biblioteca.getEditoriales().obtenerElemento("ED011");
    System.out.println(editorial2);
    
    System.out.println(biblioteca.getEditoriales().obtenerTodosLosElementos() != null);

    Editorial editorial3 = new Editorial("ED011", "Editores Santillana", "Colombia", "www.santillana.com.co");
    System.out.println(biblioteca.getEditoriales().editarElemento(editorial3));

    System.out.println(biblioteca.getEditoriales().eliminarElemento("ED011"));


    /* Pruebas CRUD sobre area */
    Area area1 = new Area("AC039", "Area prueba", "Descropcion", "AC001");
    System.out.println(biblioteca.getAreas().insertarElemento(area1));
    Area area2 = biblioteca.getAreas().obtenerElemento("AC039");
    System.out.println(area2);

    System.out.println(biblioteca.getAreas().obtenerTodosLosElementos() != null);

    Area area3 = new Area("AC039", "Area prueba", "DESCRIPCION", "AC001");
    System.out.println(biblioteca.getAreas().editarElemento(area3));

    System.out.println(biblioteca.getAreas().eliminarElemento("AC039"));


    /* Pruebas CRUD sobre libro */
    Libro libro1 = new Libro("LI041", "TermodinamicaII", Integer.valueOf(550), Integer.valueOf(2015), "Español", "AC016", "ED001");
    System.out.println(biblioteca.getLibros().insertarElemento(libro1));
    Libro libro2 = biblioteca.getLibros().obtenerElemento("LI041");
    System.out.println(libro2);

    System.out.println(biblioteca.getLibros().obtenerTodosLosElementos() != null);

    Libro libro3 = new Libro("LI041", "Termodinamica Quimica", Integer.valueOf(550), Integer.valueOf(2015), "Español", "AC016", "ED001");
    System.out.println(biblioteca.getLibros().editarElemento(libro3));

    System.out.println(biblioteca.getLibros().eliminarElemento("LI041"));


    /* Pruebas CRUD sobre autor */
    Autor autor1 = new Autor("AU031", "Mario", "Jimenez");
    System.out.println(biblioteca.getAutores().insertarElemento(autor1));

    Autor autor2 = biblioteca.getAutores().obtenerElemento("AU031");
    System.out.println(autor2);

    System.out.println(biblioteca.getAutores().obtenerTodosLosElementos() != null);
    
    Autor autor3 = new Autor("AU031", "Mario Alberto", "Jimenez");
    System.out.println(biblioteca.getAutores().editarElemento(autor3));

    System.out.println(biblioteca.getAutores().eliminarElemento("AU031"));


    /* Pruebas CRUD sobre escribe */
    System.out.println(biblioteca.getLibros().insertarElemento(libro1));
    System.out.println(biblioteca.getAutores().insertarElemento(autor1));
    RelacionEscribe relacionEscribe1 = new RelacionEscribe(autor1, libro1);
    System.out.println(biblioteca.getRelacionesEscribe().insertarElemento(relacionEscribe1));

    RelacionEscribe relacionEscribe2 = biblioteca.getRelacionesEscribe().obtenerElemento("AU031, LI041");
    System.out.println(relacionEscribe2);

    System.out.println(biblioteca.getRelacionesEscribe().obtenerTodosLosElementos() != null);

    System.out.println(biblioteca.getRelacionesEscribe().eliminarElemento("AU031, LI041"));

    RelacionEscribe relacionEscribe3 = new RelacionEscribe("AU010", "LI041");
    System.out.println(biblioteca.getRelacionesEscribe().insertarElemento(relacionEscribe3));
    System.out.println(biblioteca.getRelacionesEscribe().eliminarElemento("AU010, LI041"));
    System.out.println(biblioteca.getLibros().eliminarElemento("LI041"));
    System.out.println(biblioteca.getAutores().eliminarElemento("AU031"));


    /* Pruebas CRUD sobre digital */
    System.out.println(biblioteca.getLibros().insertarElemento(libro1));
    Digital digital1 = new Digital(libro1, "LI041-URL01", "www...", Integer.valueOf(1024), "PDF");
    System.out.println(biblioteca.getDigitales().insertarElemento(digital1));

    Digital digital2 = biblioteca.getDigitales().obtenerElemento("LI041-URL01");
    
    System.out.println(biblioteca.getDigitales().obtenerTodosLosElementos() != null);

    Digital digital3 = new Digital(libro1, "LI041-URL01", "www...", Integer.valueOf(1024), "EPUB");
    System.out.println(biblioteca.getDigitales().editarElemento(digital3));

    System.out.println(biblioteca.getDigitales().eliminarElemento("LI041-URL01"));
    System.out.println(biblioteca.getLibros().eliminarElemento("LI041"));

    /* Pruebas CRUD sobre ejemplar */
    System.out.println(biblioteca.getLibros().insertarElemento(libro1));
    Ejemplar ejemplar1 = new Ejemplar(libro3, "LI041-N01", Integer.valueOf(1), "null", "null", "null", "null", Boolean.valueOf(true));
    System.out.println(biblioteca.getEjemplares().insertarElemento(ejemplar1));

    Ejemplar ejemplar2 = biblioteca.getEjemplares().obtenerElemento("LI041-N01");
    System.out.println(ejemplar2);

    System.out.println(biblioteca.getEjemplares().obtenerTodosLosElementos() != null);

    Ejemplar ejemplar3 = new Ejemplar(libro3, "LI041-N01", Integer.valueOf(1), "100", "101", "103", "SAL5", Boolean.valueOf(true));
    System.out.println(biblioteca.getEjemplares().editarElemento(ejemplar3));

    System.out.println(biblioteca.getEjemplares().eliminarElemento("LI041-N01"));
    System.out.println(biblioteca.getLibros().eliminarElemento("LI041"));


    /* Pruebas CRUD sobre usuario */
    Usuario usuario1 = new Usuario("US021", "Elizabeth Giraldo", "", "", "");
    System.out.println(biblioteca.getUsuarios().insertarElemento(usuario1));

    Usuario usuario2 = biblioteca.getUsuarios().obtenerElemento("US021");
    System.out.println(usuario2);

    System.out.println(biblioteca.getUsuarios().obtenerTodosLosElementos() != null);

    Usuario usuario3 = new Usuario("US021", "Elizabeth Giraldo", "3190011243", "Direccion", "Email");
    System.out.println(biblioteca.getUsuarios().editarElemento(usuario3));

    System.out.println(biblioteca.getUsuarios().eliminarElemento("US021"));


    /* Pruebas CRUD sobre contraseña usuarios */
    System.out.println(biblioteca.getUsuarios().insertarElemento(usuario1));
    ContrasenaUsuario contrasenaUsuario1 = new ContrasenaUsuario(usuario1, "ContrasenaUsuario21");
    System.out.println(biblioteca.getContrasenasUsuarios().insertarElemento(contrasenaUsuario1));

    ContrasenaUsuario contrasenaUsuario2 = biblioteca.getContrasenasUsuarios().obtenerElemento("US021");
    System.out.println(contrasenaUsuario2);

    System.out.println(biblioteca.getContrasenasUsuarios().obtenerTodosLosElementos() != null);

    ContrasenaUsuario contrasenaUsuario3 = new ContrasenaUsuario(usuario1, "ContrasenaUsuario0021");
    System.out.println(biblioteca.getContrasenasUsuarios().editarElemento(contrasenaUsuario3));

    System.out.println(biblioteca.getContrasenasUsuarios().eliminarElemento("US021"));
    System.out.println(biblioteca.getUsuarios().eliminarElemento("US021"));


    /* Pruebas CRUD sobre estudiante */
    Estudiante estudiante1 = new Estudiante(usuario1, "Ing Sistemas", "Universidad del Valle");
    System.out.println(biblioteca.getUsuarios().insertarElemento(usuario1));
    System.out.println(biblioteca.getEstudiantes().insertarElemento(estudiante1));

    Estudiante estudiante2 = biblioteca.getEstudiantes().obtenerElemento("US021");
    System.out.println(estudiante2);

    System.out.println(biblioteca.getEstudiantes().obtenerTodosLosElementos() != null);

    Estudiante estudiante3 = new Estudiante(usuario1, "Ingenieria de sistemas", "Univalle");
    System.out.println(biblioteca.getEstudiantes().editarElemento(estudiante3));

    System.out.println(biblioteca.getEstudiantes().eliminarElemento("US021"));
    System.out.println(biblioteca.getUsuarios().eliminarElemento("US021"));


    /* Pruebas CRUD sobre profesor */
    Usuario usuario4 = new Usuario("US022", "Karen Torres", "", "", "");
    Profesor profesor1 = new Profesor(usuario4, "Facultad Ingneieria", "");
    System.out.println(biblioteca.getUsuarios().insertarElemento(usuario4));
    System.out.println(biblioteca.getProfesores().insertarElemento(profesor1));

    Profesor profesor2 = biblioteca.getProfesores().obtenerElemento("US022");
    System.out.println(profesor2);

    System.out.println(biblioteca.getProfesores().obtenerTodosLosElementos() != null);

    Profesor profesor3 = new Profesor(usuario4, "Facultad Ingenieria", "PhD");
    System.out.println(biblioteca.getProfesores().editarElemento(profesor3));

    System.out.println(biblioteca.getProfesores().eliminarElemento("US022"));
    System.out.println(biblioteca.getUsuarios().eliminarElemento("US022"));


    /* Pruebas CRUD sobre empleado */
    Empleado empleado1 = new Empleado("EM011", "Paola Lopez", "", Boolean.FALSE);
    System.out.println(biblioteca.getEmpleados().insertarElemento(empleado1));

    Empleado empleado2 = biblioteca.getEmpleados().obtenerElemento("EM011");
    System.out.println(empleado2);

    System.out.println(biblioteca.getEmpleados().obtenerTodosLosElementos() != null);

    Empleado empleado3 = new Empleado("EM011", "Paola Lopez", "Bibliotecaria", Boolean.FALSE);
    System.out.println(biblioteca.getEmpleados().editarElemento(empleado3));
    
    System.out.println(biblioteca.getEmpleados().eliminarElemento("EM011"));

    /* Pruebas CRUD sobre contraseñas empleados */
    System.out.println(biblioteca.getEmpleados().insertarElemento(empleado1));
    ContrasenaEmpleado contrasenaEmpleado1 = new ContrasenaEmpleado(empleado1, "ContrasenaEmpleado11");
    System.out.println(biblioteca.getContrasenasEmpleados().insertarElemento(contrasenaEmpleado1));

    ContrasenaEmpleado contrasenaEmpleado2 = biblioteca.getContrasenasEmpleados().obtenerElemento("EM011");
    System.out.println(contrasenaEmpleado2);

    System.out.println(biblioteca.getContrasenasEmpleados().obtenerTodosLosElementos() != null);

    ContrasenaEmpleado contrasenaEmpleado3 = new ContrasenaEmpleado(empleado1, "ContrasenaEmpleado0011");
    System.out.println(biblioteca.getContrasenasEmpleados().editarElemento(contrasenaEmpleado3));

    System.out.println(biblioteca.getContrasenasEmpleados().eliminarElemento("EM011"));
    System.out.println(biblioteca.getEmpleados().eliminarElemento("EM011"));


    /* Pruebas CRUD sobre solicitud */
    Solicitud solicitud1 = new Solicitud("CS013", "US001", LocalDate.parse("2021-05-01"), "Solicitud de libro", "En espera");
    System.out.println(biblioteca.getSolicitudes().insertarElemento(solicitud1));

    Solicitud solicitud2 = biblioteca.getSolicitudes().obtenerElemento("CS013");
    System.out.println(solicitud2);

    System.out.println(biblioteca.getSolicitudes().obtenerTodosLosElementos() != null);

    Solicitud solicitud3 = new Solicitud("CS013", "US001", LocalDate.parse("2021-05-01"), "Solicitud de libro de física", "Rechazada");
    System.out.println(biblioteca.getSolicitudes().editarElemento(solicitud3));

    System.out.println(biblioteca.getSolicitudes().eliminarElemento("CS013"));

    /* Pruebas CRUD sobre areas_interes_profesor */
    AreaInteres areaInteres1 = new AreaInteres("US020", "AC001");
    System.out.println(biblioteca.getAreasInteres().insertarElemento(areaInteres1));

    AreaInteres areaInteres2 = biblioteca.getAreasInteres().obtenerElemento("US020, AC001");
    System.out.println(areaInteres2);
    
    System.out.println(biblioteca.getAreasInteres().obtenerTodosLosElementos() != null);

    System.out.println(biblioteca.getAreasInteres().eliminarElemento("US020, AC001"));


    /* Pruebas CRUD sobre pide */
    RelacionPide relacionPide1 = new RelacionPide("CS001", "LI040");
    System.out.println(biblioteca.getRelacionesPide().insertarElemento(relacionPide1));

    RelacionPide relacionPide2 = biblioteca.getRelacionesPide().obtenerElemento("CS001, LI040");
    System.out.println(relacionPide2);

    System.out.println(biblioteca.getRelacionesPide().obtenerTodosLosElementos() != null);

    System.out.println(biblioteca.getRelacionesPide().eliminarElemento("CS001, LI040"));


    /* Pruebas CRUD sobre descarga */
    Descarga descarga1 = new Descarga("DS011", "US001", "LI030-URL01", LocalDateTime.parse("2021-05-01T10:00:00"), "");
    System.out.println(biblioteca.getDescargas().insertarElemento(descarga1));

    Descarga descarga2 = biblioteca.getDescargas().obtenerElemento("DS011");
    System.out.println(descarga2);

    System.out.println(biblioteca.getDescargas().obtenerTodosLosElementos() != null);

    Descarga descarga3 = new Descarga("DS011", "US001", "LI030-URL01", LocalDateTime.parse("2022-05-01T12:53:36"), "IP");
    System.out.println(biblioteca.getDescargas().editarElemento(descarga3));

    System.out.println(biblioteca.getDescargas().eliminarElemento("DS011"));


    /* Pruebas CRUD sobre prestamo */
    Prestamo prestamo1 = new Prestamo("PR016", "US016", "EM009", LocalDate.parse("2021-05-01"));
    System.out.println(biblioteca.getPrestamos().insertarElemento(prestamo1));

    Prestamo prestamo2 = biblioteca.getPrestamos().obtenerElemento("PR016");
    System.out.println(prestamo2);

    System.out.println(biblioteca.getPrestamos().obtenerTodosLosElementos() != null);

    Prestamo prestamo3 = new Prestamo("PR016", "US016", "EM001", LocalDate.parse("2019-04-20"));
    System.out.println(biblioteca.getPrestamos().editarElemento(prestamo3));

    System.out.println(biblioteca.getPrestamos().eliminarElemento("PR016"));

    
    /* Pruebas CRUD sobre presta */
    RelacionPresta relacionPresta1 = new RelacionPresta("PT022", "PR015", "LI010-N01", LocalDate.parse("2021-05-01"));
    System.out.println(biblioteca.getRelacionesPresta().insertarElemento(relacionPresta1));

    RelacionPresta relacionPresta2 = biblioteca.getRelacionesPresta().obtenerElemento("PT022");
    System.out.println(relacionPresta2);

    System.out.println(biblioteca.getRelacionesPresta().obtenerTodosLosElementos() != null);

    RelacionPresta relacionPresta3 = new RelacionPresta("PT022", "PR015", "LI010-N01", LocalDate.parse("2018-06-01"));
    System.out.println(biblioteca.getRelacionesPresta().editarElemento(relacionPresta3));

    /* Pruebas CRUD sobre multa */
    Multa multa1 = new Multa("MU012", "PT022", LocalDate.parse("2021-05-10"), BigDecimal.valueOf(Double.parseDouble("4200")), "Multa por no devolver el libro a tiempo", Boolean.parseBoolean("FALSE"));
    System.out.println(biblioteca.getMultas().insertarElemento(multa1));
    Multa multa2= new Multa("MU013", "PT022", LocalDate.parse("2021-05-10"), BigDecimal.valueOf(Double.parseDouble("4200")), "Multa por no devolver el libro a tiempo", Boolean.parseBoolean("TRUE"));
    System.out.println(biblioteca.getMultas().insertarElemento(multa2));

    Multa multa3 = biblioteca.getMultas().obtenerElemento("MU001");
    System.out.println(multa3);
    Multa multa4 = biblioteca.getMultas().obtenerElemento("MU012");
    System.out.println(multa4);
    Multa multa5 = biblioteca.getMultas().obtenerElemento("MU013");
    System.out.println(multa5);

    System.out.println(biblioteca.getMultas().obtenerTodosLosElementos() != null);

    Multa multa6 = new Multa("MU012", "PT022", LocalDate.parse("2021-05-20"), BigDecimal.valueOf(Double.parseDouble("50000")), "Multa por no devolver el libro a tiempo", Boolean.parseBoolean("TRUE"));
    System.out.println(biblioteca.getMultas().editarElemento(multa6));

    System.out.println(biblioteca.getMultas().eliminarElemento("MU012"));
    System.out.println(biblioteca.getMultas().eliminarElemento("MU013"));
    System.out.println(biblioteca.getRelacionesPresta().eliminarElemento("PT022"));


    System.out.println("Prueba");
    System.out.println(biblioteca.getEjemplares().ejemplaresDisponibles("LI010"));

    // String[][] libros = biblioteca.getLibros().obtenerTodosLosElementos();
    // System.out.println(libros.length);

    // String[][] prestamosUsuario = biblioteca.getPrestamos().obtenerPrestamosUsuario("US015");
    // ManejadorArchivos.imprimirArregloEnConsola(prestamosUsuario);

    // String[][] multasUsuario = biblioteca.getMultas().obtenerMultasUsuario("US002");
    // ManejadorArchivos.imprimirArregloEnConsola(multasUsuario);

    // String[][] descargas = biblioteca.getDescargas().obtenerTodosLosElementos();
    // ManejadorArchivos.imprimirArregloEnConsola(descargas);

    // String[][] solicitudes = biblioteca.getSolicitudes().obtenerTodosLosElementos();
    // ManejadorArchivos.imprimirArregloEnConsola(solicitudes);

    // String[][] multas = biblioteca.getMultas().obtenerTodosLosElementos();
    // ManejadorArchivos.imprimirArregloEnConsola(multas);

    // String [][] librosDisponibles =     biblioteca.getLibros().obtenerLibrosDisponibles("LI010");
    // ManejadorArchivos.imprimirArregloEnConsola(librosDisponibles);


    biblioteca.getContrasenasUsuarios().encriptarContrasenas();
    System.out.println(biblioteca.getContrasenasUsuarios().validarContrasena("US002", "ContrasenaUsuario2"));

    biblioteca.getContrasenasEmpleados().encriptarContrasenas();
    System.out.println(biblioteca.getContrasenasEmpleados().validarContrasena("EM001", "ContrasenaEmpleado1"));

    System.out.println(biblioteca.getSerialLibro());
    System.out.println(biblioteca.getSerialUsuario());
    System.out.println(biblioteca.getSerialEmpleado());
    System.out.println(biblioteca.getSerialSolicitud());
    System.out.println(biblioteca.getSerialDescarga());
    System.out.println(biblioteca.getSerialPrestamo());
    System.out.println(biblioteca.getSerialMulta());



    // // Descomentar el siguiente bloque de código para obtener un archivo de texto plano con la información más relevante de la base de datos
    // /*
    // JFileChooser fileChooser = new JFileChooser();
    // fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    // int seleccion = fileChooser.showOpenDialog(null);

    // if(seleccion != JFileChooser.CANCEL_OPTION){
    //     String ruta = fileChooser.getSelectedFile().getAbsolutePath();
    //     if(ManejadorArchivos.guardarEnArchivoTextoPlano(biblioteca, ruta)){
    //         JOptionPane.showMessageDialog(null,"¡El resumen de la base de datos se guardó correctamente en un archivo de texto plano!", "Operación realizada con éxito", JOptionPane.INFORMATION_MESSAGE);
    //     } else {
    //         JOptionPane.showMessageDialog(null,"¡Hubo un problema al guardar el estado de la aplicación en un archivo de texto plano!" +
    //         "\nAsegurese de haber seleccionado una carpeta de destino correcta. \nSi considera que este es un error, por favor póngase en contacto con el administrador del sistema.", "Operación fallida", JOptionPane.ERROR_MESSAGE);
    //     }
    // }
    // */

    biblioteca.cerrarConexion();
  
  }
}
