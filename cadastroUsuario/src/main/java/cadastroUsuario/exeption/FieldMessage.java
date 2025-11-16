package cadastroUsuario.exeption;

public class FieldMessage {
	private String field;
	private String message;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public FieldMessage(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}
	public FieldMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
