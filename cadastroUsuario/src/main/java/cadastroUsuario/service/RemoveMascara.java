package cadastroUsuario.service;

public class RemoveMascara {
	
	public static String removeMacara(String value) {
		if (value == null) return null;
		return value.replaceAll("[^0-9]", "");
	}

}
