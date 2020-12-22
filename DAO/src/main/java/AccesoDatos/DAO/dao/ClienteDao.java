package AccesoDatos.DAO.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import AccesoDatos.DAO.model.Cliente;
import AccesoDatos.DAO.utils.Leer;


public class ClienteDao implements Dao<Cliente>{
	
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public ClienteDao() {		
	}

	@Override
	public void get(int id, Connection connect) {
		try {
			Statement stmt = connect.createStatement();
	    	ResultSet resultSet = stmt.executeQuery("SELECT * FROM cliente WHERE codigo_cliente = " + id);

	    	while (resultSet.next()) {
	    		System.out.print(resultSet.getInt("codigo_cliente") + " - ");
	    		System.out.print(resultSet.getString("nombre_cliente") + " - ");
	    		System.out.print(resultSet.getString("nombre_contacto") + " - ");
	    		System.out.print(resultSet.getString("apellido_contacto") + " - ");
	    		System.out.print(resultSet.getString("telefono") + " - ");
	    		System.out.print(resultSet.getString("fax") + " - ");
	    		System.out.print(resultSet.getString("linea_direccion1") + " - ");
	    		System.out.print(resultSet.getString("linea_direccion2") + " - ");
	    		System.out.print(resultSet.getString("ciudad") + " - ");
	    		System.out.print(resultSet.getString("region") + " - ");
	    		System.out.print(resultSet.getString("pais") + " - ");
	    		System.out.print(resultSet.getString("codigo_postal") + " - ");
	    		System.out.print(resultSet.getInt("codigo_empleado_rep_ventas") + " - ");
	    		System.out.print(resultSet.getDouble("limite_credito")+ "\n");   
			}
	    	resultSet.close();
	    	stmt.close();
		} catch (SQLException e) {
			System.out.println("Problema en la conexion con el metodo get");		
			e.printStackTrace();
		}		
	}
	
	public void getByName(String nombre, Connection connect) {
		try {
			Statement stmt = connect.createStatement();
	    	ResultSet resultSet = stmt.executeQuery("SELECT * FROM cliente WHERE nombre_cliente=\"" + nombre +"\""
	    			+ " OR nombre_contacto = \"" + nombre + "\" OR apellido_contacto = \"" + nombre + "\"");

	    	while (resultSet.next()) {
	    		System.out.print(resultSet.getInt("codigo_cliente") + " - ");
	    		System.out.print(resultSet.getString("nombre_cliente") + " - ");
	    		System.out.print(resultSet.getString("nombre_contacto") + " - ");
	    		System.out.print(resultSet.getString("apellido_contacto") + " - ");
	    		System.out.print(resultSet.getString("telefono") + " - ");
	    		System.out.print(resultSet.getString("fax") + " - ");
	    		System.out.print(resultSet.getString("linea_direccion1") + " - ");
	    		System.out.print(resultSet.getString("linea_direccion2") + " - ");
	    		System.out.print(resultSet.getString("ciudad") + " - ");
	    		System.out.print(resultSet.getString("region") + " - ");
	    		System.out.print(resultSet.getString("pais") + " - ");
	    		System.out.print(resultSet.getString("codigo_postal") + " - ");
	    		System.out.print(resultSet.getInt("codigo_empleado_rep_ventas") + " - ");
	    		System.out.print(resultSet.getDouble("limite_credito") + "\n");   
			}
	    	resultSet.close();
	    	stmt.close();
		} catch (SQLException e) {
			System.out.println("Problema en la conexion con el metodo getByName");		
			e.printStackTrace();
		}		
		System.out.println();
	}

	@Override
	public List<Cliente> getAll(Connection connect) {
		try {
			Statement stmt = connect.createStatement();
	    	ResultSet resultSet = stmt.executeQuery("SELECT * FROM cliente ORDER BY nombre_cliente");

	    	while (resultSet.next()) {
		        int codigo_cliente = resultSet.getInt("codigo_cliente");
		        String nombre_cliente = resultSet.getString("nombre_cliente");
		        String nombre_contacto = resultSet.getString("nombre_contacto");
		        String apellido_contacto = resultSet.getString("apellido_contacto");
		        String telefono = resultSet.getString("telefono");
		        String fax = resultSet.getString("fax");
		        String linea_direccion1 = resultSet.getString("linea_direccion1");
		        String linea_direccion2 = resultSet.getString("linea_direccion2");
		        String ciudad = resultSet.getString("ciudad");
		        String region = resultSet.getString("region");
		        String pais = resultSet.getString("pais");
		        String codigo_postal = resultSet.getString("codigo_postal");
		        int codigo_empleado_rep_ventas = resultSet.getInt("codigo_empleado_rep_ventas");
		        Double limite_credito = resultSet.getDouble("limite_credito");
		        
		        Cliente cliente = new Cliente(codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono,
		        		fax, linea_direccion1, linea_direccion2, ciudad, region, pais, codigo_postal, codigo_empleado_rep_ventas, limite_credito);
		        clientes.add(cliente);
			}
	    	resultSet.close();
	    	stmt.close();
		} catch (SQLException e) {
			System.out.println("Problema en la conexion con el metodo getAll");		
			e.printStackTrace();
		}		
		return clientes;
	}

	
	public void save(Cliente cliente, Connection connect) {
		try {
			String sql = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
			
			preparedStatement.setInt(1, cliente.getCodigo_cliente());	//El numero indica el interrogante que es en el sql.
			preparedStatement.setString(2, cliente.getNombre_cliente());
			preparedStatement.setString(3, cliente.getNombre_contacto());
			preparedStatement.setString(4, cliente.getApellido_contacto());
			preparedStatement.setString(5, cliente.getTelefono());
			preparedStatement.setString(6, cliente.getFax());
			preparedStatement.setString(7, cliente.getLinea_direccion1());
			preparedStatement.setString(8, cliente.getLinea_direccion2());
			preparedStatement.setString(9, cliente.getCiudad());
			preparedStatement.setString(10, cliente.getRegion());
			preparedStatement.setString(11, cliente.getPais());
			preparedStatement.setString(12, cliente.getCodigo_postal());
			preparedStatement.setInt(13, cliente.getCodigo_empleado_rep_ventas());
			preparedStatement.setDouble(14, cliente.getLimite_credito());
			
			preparedStatement.execute();
		    preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("Problema en la conexion con el metodo save.");
			e.printStackTrace();
		}
		clientes.add(cliente);	
	}

	@Override 
	public void update(Cliente cliente, Connection connect) {
		System.out.println("Escriba el codigo del cliente que quiera modificar.");
		int codCli = Leer.pedirEnteroValidar();
		try {
			String sql = "UPDATE cliente SET codigo_cliente = ?, nombre_cliente = ?, nombre_contacto = ?, apellido_contacto = ?,"
					+ " telefono = ?, fax = ?, linea_direccion1 = ?, linea_direccion2 = ?, ciudad = ?, region = ?, pais = ?,"
					+ " codigo_postal = ?, codigo_empleado_rep_ventas = ?, limite_credito = ? "
					+ "WHERE codigo_cliente = ?";

			PreparedStatement preparedStatement = connect.prepareStatement(sql);

			preparedStatement.setInt(1, cliente.getCodigo_cliente());
			preparedStatement.setString(2, cliente.getNombre_cliente());
			preparedStatement.setString(3, cliente.getNombre_contacto());
			preparedStatement.setString(4, cliente.getApellido_contacto());
			preparedStatement.setString(5, cliente.getTelefono());
			preparedStatement.setString(6, cliente.getFax());
			preparedStatement.setString(7, cliente.getLinea_direccion1());
			preparedStatement.setString(8, cliente.getLinea_direccion2());
			preparedStatement.setString(9, cliente.getCiudad());
			preparedStatement.setString(10, cliente.getRegion());
			preparedStatement.setString(11, cliente.getPais());
			preparedStatement.setString(12, cliente.getCodigo_postal());
			preparedStatement.setInt(13, cliente.getCodigo_empleado_rep_ventas());
			preparedStatement.setDouble(14, cliente.getLimite_credito());
			preparedStatement.setInt(15, codCli);
			
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println("Problema en la conexion con el metodo update.");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int t, Connection connect) {
		try {
			String sql = "DELETE FROM cliente WHERE codigo_cliente = ?";
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setInt(1, t);
			
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("Problema en la conexion con el metodo delete.");
			e.printStackTrace();
		}
		
	}

}
