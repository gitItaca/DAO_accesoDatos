package AccesoDatos.DAO.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import AccesoDatos.DAO.model.Producto;
import AccesoDatos.DAO.utils.Leer;

public class ProductoDao implements Dao<Producto>{
	private static ArrayList<Producto> productos = new ArrayList<Producto>();

	@Override
	public void get(int id, Connection connect) {
		try {
			Statement stmt = connect.createStatement();
	    	ResultSet resultSet = stmt.executeQuery("SELECT * FROM producto WHERE codigo_producto = " + id);

	    	while (resultSet.next()) {
	    		System.out.print(resultSet.getString("codigo_producto") + " - ");
	    		System.out.print(resultSet.getString("nombre") + " - ");
	    		System.out.print(resultSet.getString("gama") + " - ");
	    		System.out.print(resultSet.getString("dimensiones") + " - ");
	    		System.out.print(resultSet.getString("proveedor") + " - ");
	    		System.out.print(resultSet.getString("descripcion") + " - ");
	    		System.out.print(resultSet.getString("cantidad_en_stock") + " - ");
	    		System.out.print(resultSet.getString("precio_venta") + " - ");
	    		System.out.print(resultSet.getString("precio_proveedor") + "\n");	    		  
			}
	    	resultSet.close();
	    	stmt.close();
		} catch (SQLException e) {
			System.out.println("Problema en la conexion con el metodo get de productoDao");		
			e.printStackTrace();
		}		
	}

	@Override
	public List<Producto> getAll(Connection connect) {
		try {
			Statement stmt = connect.createStatement();
	    	ResultSet resultSet = stmt.executeQuery("SELECT * FROM producto");

	    	while (resultSet.next()) {
		        String codigo_producto = resultSet.getString("codigo_producto");
		        String nombre = resultSet.getString("nombre");
		        String gama = resultSet.getString("gama");
		        String dimensiones = resultSet.getString("dimensiones");
		        String proveedor = resultSet.getString("proveedor");
		        String descripcion = resultSet.getString("descripcion");
		        int cantidad_en_stock = resultSet.getInt("cantidad_en_stock");
		        double precio_venta = resultSet.getDouble("precio_venta");
		        double precio_proveedor = resultSet.getDouble("precio_proveedor");
		         
		        Producto producto = new Producto(codigo_producto, nombre, gama, dimensiones, proveedor,
		    			descripcion, cantidad_en_stock, precio_venta, precio_proveedor);
		        productos.add(producto);
			}
	    	resultSet.close();
	    	stmt.close();
		} catch (SQLException e) {
			System.out.println("Problema en la conexion con el metodo getAll de ProductoDao");		
			e.printStackTrace();
		}		
		return productos;
	}

	@Override
	public void save(Producto producto, Connection connect) {
		try {
			String sql = "INSERT INTO producto VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
			
			preparedStatement.setString(1, producto.getCodigo_producto());	//El numero indica el interrogante que es en el sql.
			preparedStatement.setString(2, producto.getNombre());
			preparedStatement.setString(3, producto.getGama());
			preparedStatement.setString(4, producto.getDimensiones());
			preparedStatement.setString(5, producto.getProveedor());
			preparedStatement.setString(6, producto.getDescripcion());
			preparedStatement.setInt(7, producto.getCantidad_en_stock());
			preparedStatement.setDouble(8, producto.getPrecio_venta());
			preparedStatement.setDouble(9, producto.getPrecio_proveedor());
			
			preparedStatement.execute();
		    preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("Problema en la conexion con el metodo save de productoDao.");
			e.printStackTrace();
		}
		productos.add(producto);	
		
	}

	@Override
	public void update(Producto producto, Connection connect) {
		System.out.println("Escriba el codigo del producto que quiera modificar.");
		String codPro = Leer.pedirCadena();
		try {
			String sql = "UPDATE producto SET codigo_producto = ?, nombre = ?, gama = ?, dimensiones = ?,"
					+ " proveedor = ?, descripcion = ?, cantidad_en_stock = ?, precio_venta = ?, precio_proveedor = ?"
					+ "WHERE codigo_producto = ?";

			PreparedStatement preparedStatement = connect.prepareStatement(sql);

			preparedStatement.setString(1, producto.getCodigo_producto());
			preparedStatement.setString(2, producto.getNombre());
			preparedStatement.setString(3, producto.getGama());
			preparedStatement.setString(4, producto.getDimensiones());
			preparedStatement.setString(5, producto.getProveedor());
			preparedStatement.setString(6, producto.getDescripcion());
			preparedStatement.setInt(7, producto.getCantidad_en_stock());
			preparedStatement.setDouble(8, producto.getPrecio_venta());
			preparedStatement.setDouble(9, producto.getPrecio_proveedor());
			preparedStatement.setString(10, codPro);
			
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("Problema en la conexion con el metodo update de productoDao.");
			e.printStackTrace();
		}		
	}

	@Override
	public void delete(int t, Connection connect) {
		try {
			String sql = "DELETE FROM producto WHERE codigo_producto = ?";
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setInt(1, t);
			
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("Problema en la conexion con el metodo delete de productoDao.");
			e.printStackTrace();
		}
		
	}

}
