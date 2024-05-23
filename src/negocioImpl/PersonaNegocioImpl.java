package negocioImpl;


import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {
	
	PersonaDao pDao = new PersonaDaoImpl();
	
		public boolean agregar(Persona p) {
			boolean estado=false;
			if(p.getDNI().trim().length() > 0 && p.getNombre().trim().length() >0 && p.getApellido().trim().length() > 0)
			{
				estado=pDao.agregar(p);
			}
			return estado;
		}
		public boolean eliminar(Persona persona_eliminar) {
			return pDao.eliminar(persona_eliminar);
		}
		public boolean modificar(Persona persona_modificar) {
			return pDao.modificar(persona_modificar);
		}
		public List<Persona> listar() {
			return pDao.listar();
		}
}
