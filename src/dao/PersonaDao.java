package dao;


import java.util.List;

import entidad.Persona;


public interface PersonaDao {
	
	public boolean agregar(Persona persona);
	public boolean eliminar(Persona persona_eliminar);
	public boolean modificar(Persona persona_modificar);
	public List<Persona> listar();
}
