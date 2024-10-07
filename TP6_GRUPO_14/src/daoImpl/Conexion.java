package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    private Connection conexion;
    private PreparedStatement comando;
    private ResultSet lector;
    private String url = "jdbc:mysql://localhost:3306/bdpersonas"; 
    private String user = "root"; 
    private String password = "root"; 
	public static Conexion instancia;


    public ResultSet getLector() {
        return lector;
    }

    
    public Conexion() {
        try { 
            this.conexion = DriverManager.getConnection(url, user, password);
            this.conexion.setAutoCommit(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

   
    public void setearSp(String sp) throws SQLException {
        comando = conexion.prepareStatement("{call " + sp + "}");
    }

	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.conexion;
	}
	
	
    public void setearConsulta(String consulta) throws SQLException {
        comando = conexion.prepareStatement(consulta);
    }

    
    public void ejecutarLectura() throws SQLException {
        try {
            lector = comando.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    
    public void cerrarConexion() {
        try {
            if (lector != null && !lector.isClosed()) {
                lector.close();
            }
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public void setearParametros(int index, String str) throws SQLException {
        comando.setObject(index, str);
    }

    
    public void ejecutarAccion() throws SQLException {
        try {
            comando.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
