package daoImpl;

import java.sql.CallableStatement;
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
	private static final String modificar = "CALL SPModificarPersona(?, ?, ?)";
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
		PreparedStatement statement;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    boolean isDeleteExitoso = false;
	    try {
	        statement = conexion.prepareStatement(eliminar);
	        statement.setString(1, persona_eliminar.getDNI());
	        if (statement.executeUpdate() > 0) {
	            conexion.commit();
	            isDeleteExitoso = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            conexion.rollback();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    }
	    return isDeleteExitoso;
	}

	@Override
	public boolean modificar(Persona persona_modificar) {
	    Connection conexion = null;
	    CallableStatement callst = null;
	    boolean SPExitoso = false;
	    try {
	        conexion = Conexion.getConexion().getSQLConexion();
	        callst = conexion.prepareCall(modificar);
	        callst.setString(1, persona_modificar.getDNI());
	        callst.setString(2, persona_modificar.getNombre());
	        callst.setString(3, persona_modificar.getApellido());
	        if (callst.executeUpdate() > 0) {
	            conexion.commit();
	            SPExitoso = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            if (conexion != null) {
	                conexion.rollback();
	            }
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    } finally {
	        try {
	            if (callst != null) {
	                callst.close();
	            }
	            if (conexion != null) {
	                conexion.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return SPExitoso;
	}


	@Override
	public List<Persona> listar() {
		PreparedStatement statement;
		ResultSet rs;
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(listar);
			rs = statement.executeQuery();
			while(rs.next())
			{
				personas.add(getPersona(rs));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	public Persona getPersona(ResultSet rs) throws SQLException
	{
		String DNI = rs.getString("DNI");
		String nombre = rs.getString("Nombre");
		String apellido = rs.getString("Apellido");
		return new Persona(DNI, nombre, apellido);
	}
}
