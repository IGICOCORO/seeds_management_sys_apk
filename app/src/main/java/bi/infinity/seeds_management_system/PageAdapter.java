package bi.infinity.seeds_management_system;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import bi.infinity.seeds_management_system.Fragments.HomeFragment;
import bi.infinity.seeds_management_system.Fragments.SeedsFragment;

public class PageAdapter extends FragmentStatePagerAdapter {

    Fragment[] fragments = new Fragment[]{
            new HomeFragment(), new SeedsFragment()
    };

    public PageAdapter(FragmentManager fm) {
        super(fm);
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
