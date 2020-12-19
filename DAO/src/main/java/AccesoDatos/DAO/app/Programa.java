package AccesoDatos.DAO.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import AccesoDatos.DAO.dao.ClienteDao;
import AccesoDatos.DAO.dao.ProductoDao;
import AccesoDatos.DAO.model.Cliente;
import AccesoDatos.DAO.model.Producto;
import AccesoDatos.DAO.utils.Conexion;
import AccesoDatos.DAO.utils.Leer;
import AccesoDatos.DAO.utils.OperacionesCliente;
import AccesoDatos.DAO.utils.OperacionesProducto;

public class Programa {

	public static void main(String[] args) {
		int opcion;
		ClienteDao cDao = new ClienteDao();
		ProductoDao pDao = new ProductoDao();
		
		do {
			opcion = menu();		
			try {
				Connection connect = Conexion.conectarBD();
				
				switch (opcion) {
				case 1: cDao.save(OperacionesCliente.crearCliente(), connect);
					break;
				case 2: 
					System.out.println("Escriba el codigo del cliente.");
					int id = Leer.pedirEnteroValidar();
					System.out.println();
					cDao.get(id, connect);					
					break;
				case 3: 
					List<Cliente> clientes = cDao.getAll(connect);
					for(Cliente cli: clientes) {
						System.out.print(cli.getCodigo_cliente() + " - ");
						System.out.print(cli.getNombre_cliente() + " - ");
						System.out.print(cli.getNombre_contacto() + " ");
						System.out.print(cli.getApellido_contacto() + " - ");
						System.out.print(cli.getTelefono() + " - ");
						System.out.print(cli.getFax() + " - ");
						System.out.print(cli.getLinea_direccion1() + " - ");
						System.out.print(cli.getLinea_direccion2() + " - ");
						System.out.print(cli.getCiudad() + " - ");
						System.out.print(cli.getRegion() + " - ");
						System.out.print(cli.getPais() + " - ");
						System.out.print(cli.getCodigo_postal() + " - ");
						System.out.print(cli.getCodigo_empleado_rep_ventas() + " - ");
						System.out.print(cli.getLimite_credito() + "\n");
					}
					break;
				case 4: 
					System.out.println("Escriba el nombre a buscar.");
					String busqueda = Leer.pedirCadena();
					cDao.getByName(busqueda, connect);
					break;
				case 5:
					Producto productoReemplazar = OperacionesProducto.crearProducto();
					if(productoReemplazar != null) {
						pDao.update(productoReemplazar, connect);
					}
					break;
				case 6:
					List<Producto> productos = pDao.getAll(connect);
					for(Producto pro: productos) {
						System.out.print(pro.getCodigo_producto() + " - ");
						System.out.print(pro.getNombre() + " - ");
						System.out.print(pro.getGama() + " - ");
						System.out.print(pro.getDimensiones() + " - ");
						System.out.print(pro.getProveedor() + " - ");
						System.out.print(pro.getDescripcion() + " - ");
						System.out.print(pro.getCantidad_en_stock() + " - ");
						System.out.print(pro.getPrecio_venta() + " - ");						
						System.out.print(pro.getPrecio_proveedor() + "\n");
					}
					break;
				case 0: System.out.println("Has salido.");
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {			
				e.printStackTrace();
			}	
		} while(opcion != 0);
	}

//METODOS
	public static int menu() {
		
			System.out.println("Elige una de las siguientes opciones, para salir pulse 0.");
			System.out.println("1- Añadir un cliente.");
			System.out.println("2- Mostrar un cliente.");
			System.out.println("3- Mostrar todos los clientes.");
			System.out.println("4- Buscar un cliente.");
			System.out.println("5- Editar un producto.");
			System.out.println("6- Mostrar todos los productos.");
			int opcion = Leer.pedirEnteroValidar();		
		
		return opcion;
	}
}
