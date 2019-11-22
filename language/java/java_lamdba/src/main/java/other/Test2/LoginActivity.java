package other.Test2;

public class LoginActivity extends base {

	public void result() {
		SharedPreferences a = getSharedPreferences();

		SharedPreferences b = getSharedPreferences();

		System.out.println(a == b);

	}

	public static void main(String[] args) {
		LoginActivity loginActivity = new LoginActivity();
		loginActivity.result();
	}
}
