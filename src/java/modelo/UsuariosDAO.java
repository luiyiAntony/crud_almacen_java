package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author blablabla
 */
public class UsuariosDAO {

	Connection conexion;

	public UsuariosDAO() {
		Conexion con = new Conexion();
		conexion = con.getConexion();
	}

	public List<Usuarios> listarUsuarios() {
		PreparedStatement ps;
		ResultSet rs;

		List<Usuarios> lista = new ArrayList<>();

		try {
			ps = conexion.prepareStatement("SELECT id, Username, Password, Email, FirstName, LastName, RegistrationDate, UserRole, AccountStatus FROM users;");
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("Username");
				String password = rs.getString("Password");
				String email = rs.getString("Email");
				String firstname = rs.getString("FirstName");
				String lastname = rs.getString("LastName");
				String registrationdate = rs.getString("RegistrationDate");
				String userrole = rs.getString("UserRole");
				String accountstatus = rs.getString("AccountStatus");
				Usuarios usuario = new Usuarios(id, username, password, email, firstname, lastname, registrationdate, userrole, accountstatus);
				lista.add(usuario);
			}
			return lista;
		} catch(SQLException e) {
			System.out.println(e.toString());
			return null;
		}
	}

}
