package entidad;

public class Persona {


	private String Nombre;
	private String Apellido;
	private String Dni;
	
	
	
	public Persona() {
	
		Nombre = "Nombre no Ingresado ";
		Apellido = "Apellido no Ingresado";
		Dni = "sin DNI";
	
	}

	public Persona( String dni,String nombre, String apellido) {
	
		Nombre = nombre;
		Apellido = apellido;
		Dni = dni;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	@Override
	public String toString() {
		return "Persona: " + Nombre + ", " + Apellido + ", " + Dni;
	}

	
	
	
}
