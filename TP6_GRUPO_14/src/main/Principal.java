package main;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Personadao;
import daoImpl.Conexion;

import entidad.Persona;
import presentacion.controlador.ControladorPrincipal;
import presentacion.vista.VistaPrincipal;

public class Principal {

	public static void main(String[] args) {
		
		VistaPrincipal frame = new VistaPrincipal();
		ControladorPrincipal controladorPrincipal = new ControladorPrincipal(frame);
		controladorPrincipal.inicializar();
		Conexion conexion = null;
//        try {
//        	// Agregar
//        	conexion = new Conexion();
//            conexion.setearSp("agregarPersona(?,?,?)");
//            conexion.setearParametros(1, "12");
//            conexion.setearParametros(2, "Don");
//            conexion.setearParametros(3, "Cirilio");
//            conexion.ejecutarAccion();
//
//            // Consulta
//            conexion.setearConsulta("SELECT * FROM personas");
//            conexion.ejecutarLectura();
//            ResultSet rs = conexion.getLector();
//            while (rs.next()) {
//                System.out.println(rs.getString("nombre") + " " + rs.getString("apellido"));
//            }
//            //Borrar
//            //PD: al momento de hacer la eliminacion, hay que ver si solamente se elimina por dni. yo arme el sp para que pida 3 datos pero podemos hacerlo para que borre solo pidiendo el dni...
//            conexion.setearSp("eliminarPersona(?,?,?)");
//            conexion.setearParametros(1, "11");
//            conexion.setearParametros(2, "Don");
//            conexion.setearParametros(3, "Cirilio");
//            conexion.ejecutarAccion();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            conexion.cerrarConexion();
//        }
		
		
	
	}

}
