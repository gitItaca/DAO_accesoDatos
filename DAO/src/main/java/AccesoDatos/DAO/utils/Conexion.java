package AccesoDatos.DAO.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public static Connection conectarBD() throws SQLException{
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Jardineria?serverTimezone=UTC", "admin", "4DM1n4DM1n.");
	    return connect;
	}
	
	public static void cerrarConexionBD(Connection connect) throws SQLException{
		connect.close();
	}
	//teoricamente es mejor abrir y cerrar la conexion en el mismo metodo, pero de momento lo creo así para poder unar 1 sola conexion centralizada.
	//lo mas eficiente es un pool de conexiones
}
