package bi.infinity.seeds_management_system;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import bi.infinity.seeds_management_system.Fragments.HomeFragment;
import bi.infinity.seeds_management_system.Fragments.SeedsFragment;

public class PageAdapter extends FragmentStatePagerAdapter {

    private Context context;
    Fragment[] fragments = new Fragment[]{
            new HomeFragment(context), new SeedsFragment(context)
    };

    public PageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
