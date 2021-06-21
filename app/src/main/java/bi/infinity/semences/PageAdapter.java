package bi.infinity.semences;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import bi.infinity.semences.Fragments.AchatFragment;
import bi.infinity.semences.Fragments.StockFragment;
import bi.infinity.semences.Fragments.HomeFragment;


public class PageAdapter extends FragmentStatePagerAdapter {

    private Context context;
    Fragment[] fragments = new Fragment[]{
            new HomeFragment(), new StockFragment(),new AchatFragment()
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