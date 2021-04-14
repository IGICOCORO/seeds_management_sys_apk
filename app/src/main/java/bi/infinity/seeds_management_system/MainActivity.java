package bi.infinity.seeds_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import bi.infinity.seeds_management_system.Fragments.HomeFragmementNew;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       getSupportFragmentManager().beginTransaction()
               .replace(R.id.fragment_container, new HomeFragmementNew())
               .addToBackStack(null)
               .commit();

    }
}