package modelo;

/**
 *
 * @author blablabla
 */
public class Usuarios {
	private int id;
	private String username, password, email, firstname, lastname, registrationdate, userrole, accountstatus;

	public Usuarios(int id, String username, String password, String email, String firstname, String lastname, String registrationdate, String userrole, String accountstatus) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.registrationdate = registrationdate;
		this.userrole = userrole;
		this.accountstatus = accountstatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(String registrationdate) {
		this.registrationdate = registrationdate;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public String getAccountstatus() {
		return accountstatus;
	}

	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}
}
