package AccesoDatos.DAO.utils;

import AccesoDatos.DAO.model.Producto;

import java.sql.Connection;
import java.util.List;

import AccesoDatos.DAO.dao.ProductoDao;
import AccesoDatos.DAO.exceptions.*;

public class OperacionesProducto {
	
	public OperacionesProducto(Connection connection) {
	}	
	
//METODOS
	public static Producto crearProducto(Connection connect) throws Exception{	
//			ProductoDao pDao = new ProductoDao();
//			List<Producto> productosSaved = pDao.getAll(connect);
			
			System.out.println("Datos dobre el producto nuevo:");
			System.out.println("Escriba el codigo del producto.");
			String codigo_producto = Leer.pedirCadena();
			System.out.println("Escriba el nombre del producto.");
			String nombre = Leer.pedirCadena();
			System.out.println("Escriba la gama del producto.");
			String gama = Leer.pedirCadena();
			System.out.println("Escriba las dimensiones del producto.");
			String dimensiones = Leer.pedirCadena();
			System.out.println("Escriba el proveedor.");
			String proveedor = Leer.pedirCadena();
			System.out.println("Escriba la descripcion del producto.");
			String descripcion = Leer.pedirCadena();	
			System.out.println("Escriba la cantidad que hay en stock.");
			int cantidad_en_stock = Leer.pedirEnteroValidar();
			System.out.println("Escriba el precio de venta.");
			double precio_venta = Leer.pedirDecimal();
			System.out.println("Escriba el precio del proveedor.");
			double precio_proveedor = Leer.pedirDecimal();
			
			if (codigo_producto.isEmpty() && nombre.isEmpty() && gama.isEmpty() && dimensiones.isEmpty()
					&& proveedor.isEmpty() && descripcion.isEmpty()) {
				throw new EmptyException();
			}else {
				if(precio_venta == 0 || precio_proveedor == 0) {
					throw new ZeroPriceException();
				}else {
					return new Producto(codigo_producto, nombre, gama, dimensiones, proveedor,
		    			descripcion, cantidad_en_stock, precio_venta, precio_proveedor);
				}
			}
		}
	
	public static Producto crearProductoPruebas(String codigo_producto, String nombre, String gama, String dimensiones, String proveedor,
			String descripcion, int cantidad_en_stock, double precio_venta, double precio_proveedor) throws Exception{
		
		return new Producto(codigo_producto, nombre, gama, dimensiones, proveedor,
				descripcion, cantidad_en_stock, precio_venta, precio_proveedor);
	}
	
}
