package bi.infinity.seeds_management_system;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class LoginActivity extends Activity {
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ProgressBar login_progressBar = findViewById(R.id.login_progressBar);
        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_progressBar.setVisibility(View.VISIBLE);
                Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(i);

            }
        });

    }
}