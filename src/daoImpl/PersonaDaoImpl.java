package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao {

	private static final String agregar = "INSERT INTO personas(DNI, Nombre, Apellido) VALUES(?, ?, ?)";
	private static final String eliminar = "DELETE FROM personas WHERE DNI = ?";
	private static final String modificar = "UPDATE Personas set DNI=? , Nombre=? , Apellido=? Where DNI=?";
	private static final String listar = "SELECT * FROM personas";
	
	@Override
	public boolean agregar(Persona persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(agregar);
			statement.setString(1, persona.getDNI());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}

	@Override
	public boolean eliminar(Persona persona_eliminar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Persona persona_modificar, Persona persona_modificada) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
