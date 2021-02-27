package bi.infinity.seeds_management_system;


import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.SearchView;

import androidx.annotation.RequiresApi;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main,menu);
        searchBar= findViewById(R.id.menu_search);
        searchBar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                searchBar.setIconified(false);
            }
        });

        searchBar.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean b)
            {
                if(!b)
                {
                    if(searchBar.getQuery().toString().length() < 1)
                    {
                        searchBar.setIconified(true); //close the search editor and make search icon again
                    }

                    searchBar.clearFocus();

                }
            }
        });
        return true ;

    }

}