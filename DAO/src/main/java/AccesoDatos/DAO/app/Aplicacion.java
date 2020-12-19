package AccesoDatos.DAO.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import AccesoDatos.DAO.dao.ClienteDao;
import AccesoDatos.DAO.dao.ProductoDao;
import AccesoDatos.DAO.model.Cliente;
import AccesoDatos.DAO.model.Producto;
import AccesoDatos.DAO.utils.Conexion;
import AccesoDatos.DAO.utils.OperacionesCliente;
import AccesoDatos.DAO.utils.OperacionesProducto;

public class Aplicacion {

	public static void main(String[] args) {
				
		ClienteDao cDao = new ClienteDao();
		ProductoDao pDao = new ProductoDao();
		
		try {
			Connection connect = Conexion.conectarBD();
			try {
//				pDao.update(OperacionesProducto.crearProducto(), connect);
//				pDao.update(OperacionesProducto.crearProductoPruebas("10101", "Prueba2", "Frutales", "1,2", "Antonio", "Producto de prueba", 10, 3, 1), connect);
//				pDao.save(OperacionesProducto.crearProductoPruebas("10101", "Prueba", "Frutales", "1,2", "Antonio", "Producto de prueba", 10, 3, 1), connect);
				List<Producto> productos = pDao.getAll(connect);
				for(Producto pro:productos) {
					System.out.print(pro.getCodigo_producto() + " - ");
					System.out.print(pro.getNombre() + "\n");
				}
//				cDao.delete(93, connect);
				//Funciona ClienteDao.save();
//				cDao.save(OperacionesCliente.crearClientePruebas(95, "Pool", "Clara", "Sofia", "000767676", "976767676", "Direccion1", "Direccion2", "Zaragoza", "Zaragoza", "Espana", "88888", 12, 0), connect);
				//Funciona ClienteDao.update();
//				cDao.update(OperacionesCliente.crearClientePruebas(91, "Vivo", "Sten", "Beo", "876767675", "999999999", "Direccion1", "Direccion2", "Zaragoza", "Zaragoza", "Espana", "88888", 12, 0), connect);
				//Funciona ClienteDao.getAll()
//				List<Cliente> clientes = cDao.getAll(connect);
//				for(Cliente cli: clientes) {
//					System.out.print(cli.getCodigo_cliente() + " ");
//					System.out.print(cli.getNombre_cliente() + "\n");
//				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			Conexion.cerrarConexionBD(connect);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	
	
	}

}
