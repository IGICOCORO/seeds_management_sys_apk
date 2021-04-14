package bi.infinity.seeds_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class UserChoiceActivity extends AppCompatActivity {
    private ImageButton farmer;
    private ImageButton grower_seed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choice_activity);
        farmer = findViewById(R.id.farmer);
        grower_seed = findViewById(R.id.grower_seed);
        grower_seed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserChoiceActivity.this,LoginActivity.class);
                startActivity(i);

            }
        });
    }
}