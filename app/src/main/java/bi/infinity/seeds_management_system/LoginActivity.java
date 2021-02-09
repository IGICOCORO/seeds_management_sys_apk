package bi.infinity.seeds_management_system;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;

public class LoginActivity extends AppCompatActivity {

    private EditText field_login_username, field_login_password;
    private ProgressBar login_progress;
    private SharedPreferences sessionPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
performLogin();

    }

    public void performLogin() {

        field_login_username = findViewById(R.id.field_login_username);
        field_login_password = findViewById(R.id.field_login_password);
        login_progress = findViewById(R.id.login_progress);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
