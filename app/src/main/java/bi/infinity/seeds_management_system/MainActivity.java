package bi.infinity.seeds_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import bi.infinity.seeds_management_system.Fragments.AddFragmentPlant;
import bi.infinity.seeds_management_system.Fragments.FragmentStock;
import bi.infinity.seeds_management_system.Fragments.HomeFragmementNew;
import bi.infinity.seeds_management_system.Fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       getSupportFragmentManager().beginTransaction()
               .replace(R.id.fragment_container, new AddFragmentPlant())
               .addToBackStack(null)
               .commit();

    }
}