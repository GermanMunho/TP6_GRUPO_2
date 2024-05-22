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

	private static final String agregar = "call SPAgregarPersona(?, ?, ?)";
	private static final String eliminar = "call SPEliminarPersona(?)";
	private static final String modificar = "call SPModificarPersona(?, ?, ?)";
	private static final String listar = "SELECT * FROM personas";

	@Override
	public boolean agregar(Persona persona) {
		Connection conexion = null;
		CallableStatement callst = null;
		boolean isInsertExitoso = false;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			callst = conexion.prepareCall(agregar);
			callst.setString(1, persona.getDNI());
			callst.setString(2, persona.getNombre());
			callst.setString(3, persona.getApellido());
			if (callst.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}
		} catch (SQLException e) {
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
		Connection conexion = null;
		CallableStatement callst = null;
		boolean isDeleteExitoso = false;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			callst = conexion.prepareCall(eliminar);
			callst.setString(1, persona_eliminar.getDNI());
			if (callst.executeUpdate() > 0) {
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
		} 
		return SPExitoso;
	}

	@Override
	public List<Persona> listar() {
		PreparedStatement statement;
		ResultSet rs;
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(listar);
			rs = statement.executeQuery();
			while (rs.next()) {
				personas.add(getPersona(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personas;
	}

	public Persona getPersona(ResultSet rs) throws SQLException {
		String DNI = rs.getString("DNI");
		String nombre = rs.getString("Nombre");
		String apellido = rs.getString("Apellido");
		return new Persona(DNI, nombre, apellido);
	}
}
