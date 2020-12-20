package AccesoDatos.DAO.exceptions;

public class EmptyException extends Exception{
	
	@Override
	public String getMessage() {
		return "Tiene que rellenar todos los datos para poder crear o editar.";
	}

}
