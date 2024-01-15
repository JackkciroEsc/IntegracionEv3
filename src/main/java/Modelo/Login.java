package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import UTIL.Conn;

public class Login {
	
	public static boolean validar(String user, String pass) {
	    if (notEmptyAndNotNull(user) && notEmptyAndNotNull(pass)) {
	        Connection con = null;
	        PreparedStatement Prep = null;
	        ResultSet Result = null;
	        boolean resp = false;
	        String sql = "SELECT * FROM usuario WHERE username = ? AND password = ?";
	        try {
	            con = Conn.getConnection();
	            Prep = con.prepareStatement(sql);
	            Prep.setString(1, user);
	            Prep.setString(2, pass);
	            Result = Prep.executeQuery();
	            resp = Result.next();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	closeResources(Result, Prep, con);
	        }
	        return resp;
	    }
	    return false;
	}

	private static boolean notEmptyAndNotNull(String str) {
	    return str != null && !str.trim().isEmpty();
	}


	public static Persona datos(String username) throws ClassNotFoundException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String sql = "SELECT p.* FROM usuario u JOIN persona p ON u.Rut = p.Rut WHERE u.username = ?";
	    
	    try {
	        con = Conn.getConnection();
	        ps = con.prepareStatement(sql);
	        ps.setString(1, username);
	        rs = ps.executeQuery();
	        return mapPersonaFromResultSet(rs);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeResources(rs, ps, con);
	    }
	    
	    return null;
	}
	
	private static Persona mapPersonaFromResultSet(ResultSet rs) throws SQLException {
	    if (rs != null && rs.next()) {
	        Persona persona = new Persona();
	        persona.setRut(rs.getString("Rut"));
	        persona.setNombre(rs.getString("Nombre"));
	        persona.setApellido(rs.getString("Apellido"));
	        persona.setTelefono(rs.getString("Telefono"));
	        persona.setFechaIngreso(rs.getDate("FechaIngreso"));
	        return persona;
	    }
	    return null;
	}

	private static void closeResources(ResultSet Result, PreparedStatement Prep, Connection con) {
	    try {
	        if (Result != null) Result.close();
	        if (Prep != null) Prep.close();
	        if (con != null) con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
