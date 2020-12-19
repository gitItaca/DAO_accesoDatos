package AccesoDatos.DAO.exceptions;

public class EmptyException extends Exception{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Tiene que rellenar todos los datos para poder crear o editar.";
	}

}
