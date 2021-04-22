package bi.infinity.seeds_management_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import bi.infinity.seeds_management_system.Fragments.AddFragmentPlant;
import bi.infinity.seeds_management_system.Fragments.FragmentStock;
import bi.infinity.seeds_management_system.Fragments.HomeFragmementNew;
import bi.infinity.seeds_management_system.Fragments.HomeFragment;
import bi.infinity.seeds_management_system.Fragments.SeedsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new HomeFragmementNew())
                .commit();
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        Log.i("===onBackPressed====", "onBackPressed");
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @SuppressLint("NonConstantResourceId")
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.action_home:
                            selectedFragment = new HomeFragmementNew();
                            break;
                        case R.id.action_stock:
                            selectedFragment = new FragmentStock();
                            break;
                        case R.id.action_add:
                            selectedFragment = new AddFragmentPlant();
                            break;

                    }
                    if (selectedFragment != null) {
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container, selectedFragment)
                                .commit();
                    }
                    return true;
                }


            };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragmementNew()).commit();
                break;
            case R.id.nav_stock:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentStock()).commit();
                break;
            case R.id.nav_add:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AddFragmentPlant()).commit();
                break;
        }
        return true;
    }
}