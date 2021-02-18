package bi.infinity.seeds_management_system;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout_menu);
        TabLayout tabHome = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewpager);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pageAdapter);
        tabHome.setupWithViewPager(viewPager);

        tabHome.getTabAt(0).setText("Seeds");
        tabHome.getTabAt(1).setText("Stock");

    }

}