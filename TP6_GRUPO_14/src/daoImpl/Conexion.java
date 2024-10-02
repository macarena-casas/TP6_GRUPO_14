package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import daoImpl.Conexion;
import entidad.Persona;

public class Conexion {
	
    private static final String URL = "jdbc:mysql://localhost:3306/bdpersonas?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

	
 
 public Conexion() {
     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
     } catch (ClassNotFoundException e) {
         e.printStackTrace();
     }
 }
	
 public Connection getConexion() {
     Connection conexion = null;
     try {
         conexion = DriverManager.getConnection(URL, USER, PASSWORD);
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return conexion;
 }
 
 public int agregarpersona (Persona pers) {
		String query = "insert into personas(Dni,Nombre,Apellido)values('"+pers.getDni()+"','"+pers.getNombre()+"','"+pers.getApellido()+"') ";
		Connection cn = null ;
		int filas = 0;
		try {
			cn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	
	}
	 
}
