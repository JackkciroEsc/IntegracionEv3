package Modelo;

public class Persona {
    private String rut;
    private String nombre;
    private String apellido;
    private String telefono;
    private java.util.Date fechaIngreso;

    public Persona() {
    }

    public Persona(String rut, String nombre, String apellido, String telefono, java.util.Date fechaIngreso) {
    	if (rut == null || rut.trim().isEmpty()) {
            throw new IllegalArgumentException("El rut no puede ser nulo o estar vacío");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o estar vacío");
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede ser nulo o estar vacío");
        }
        if (telefono == null || telefono.trim().isEmpty() || telefono.length() < 8) {
            throw new IllegalArgumentException("El número de teléfono debe tener al menos 8 dígitos");
        }
    	
    	this.rut = rut;
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setTelefono(telefono);
        this.setFechaIngreso(fechaIngreso);
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public java.util.Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(java.util.Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
