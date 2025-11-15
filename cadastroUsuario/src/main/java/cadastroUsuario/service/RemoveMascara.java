package cadastroUsuario.service;

public class RemoveMascara {
	
	public static String removeMacara(String value) {
		return value.replaceAll("[^0-9]", "");
	}

}
