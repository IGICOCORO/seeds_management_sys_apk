package bi.infinity.seeds_management_system;



import android.content.ClipData;
import android.os.Bundle;

import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity {
     private Toolbar toolbar;
    private SearchView searchBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout_menu);
        TabLayout tabHome = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewpager);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager());

        toolbar = findViewById(R.id.main_toolbar);
        toolbar.setTitle("Semences");
        getSupportActionBar();


        viewPager.setAdapter(pageAdapter);
        tabHome.setupWithViewPager(viewPager);

        tabHome.getTabAt(0).setText("Semences").setIcon(R.drawable.ic_home);
        tabHome.getTabAt(1).setText("Stock").setIcon(R.drawable.ic_store);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
       finish();

    }


}