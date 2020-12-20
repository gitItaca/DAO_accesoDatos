package AccesoDatos.DAO.exceptions;

public class DuplicateCodeException extends Exception{

	public String getMessage() {
		return "El codigo que ha escrito esta duplicado.";
	}
}
