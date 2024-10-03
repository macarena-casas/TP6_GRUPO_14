package main;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Personadao;
import daoImpl.Conexion;

import entidad.Persona;
import presentacion.vista.Vista_principal;

public class Principal {

	public static void main(String[] args) {
		
		Vista_principal frame = new Vista_principal();
		frame.setVisible(true);
		
		/*Conexion conexion = new Conexion();
        try {
        	// Agregar
            conexion.setearSp("agregarPersona(?,?,?)");
            conexion.setearParametros(1, "11");
            conexion.setearParametros(2, "Don");
            conexion.setearParametros(3, "Cirilio");
            conexion.ejecutarAccion();

            // Consulta
            conexion.setearConsulta("SELECT * FROM personas");
            conexion.ejecutarLectura();
            ResultSet rs = conexion.getLector();
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
            //Borrar
            //PD: al momento de hacer la eliminacion, hay que ver si solamente se elimina por dni. yo arme el sp para que pida 3 datos pero podemos hacerlo para que borre solo pidiendo el dni...
            conexion.setearSp("eliminarPersona(?,?,?)");
            conexion.setearParametros(1, "11");
            conexion.setearParametros(2, "Don");
            conexion.setearParametros(3, "Cirilio");
            conexion.ejecutarAccion();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }*/
		
		
	
	}

}
