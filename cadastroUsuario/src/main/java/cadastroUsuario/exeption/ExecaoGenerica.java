package cadastroUsuario.exeption;

public class ExecaoGenerica extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ExecaoGenerica(String message, Throwable cause) {
		super(message, cause);
	}

	public ExecaoGenerica(String message) {
		super(message);
	}
	
	

}
