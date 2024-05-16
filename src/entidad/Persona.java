package entidad;

public class Persona {

	private String DNI;
	private String Nombre;
	private String Apellido;
	
	public Persona() {}
	
	public Persona(String dni, String nombre, String apellido) {
		this.DNI = dni;
		this.Nombre = nombre;
		this.Apellido = apellido;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dni) {
		DNI = dni;
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

	@Override
	public String toString() {
		return "Persona [DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido=" + Apellido + "]";
	}
	
	
}
