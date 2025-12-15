package ma.projet.bean;

public class Utilisateur implements Identifiable {
    private static int counter = 0;
    private final int id = ++counter;
    private String login;
    private String password;
    private Profile profile;
    
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", login=" + login + ", password=" + password + ", profile=" + profile + "]";
	}

	public Utilisateur(String login, String password, Profile profile) {
		super();
		this.login = login;
		this.password = password;
		this.profile = profile;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Utilisateur.counter = counter;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
