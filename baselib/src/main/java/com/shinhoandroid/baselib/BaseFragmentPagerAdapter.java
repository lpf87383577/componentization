package com.shinhoandroid.baselib;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author Liupengfei
 * @describe TODO
 * @date on 2019/7/16 15:04
 */
public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {

    private FragmentManager mfragmentManager;
    private List<Fragment> mlist;

    public BaseFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        mfragmentManager = fm;
        this.mlist = list;
    }

    @Override
    public Fragment getItem(int arg0) {
        //显示第几个页面
        return mlist.get(arg0);
    }

    @Override
    public int getCount() {
        //有几个页面
        return mlist.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        String name = ""+ container.getId() + position;
        Fragment fragment = mfragmentManager.findFragmentByTag(name);

        if(fragment != null) {
            mfragmentManager.beginTransaction()
                    .attach(fragment)
                    .commit();

        } else {
            fragment = getItem(position);
            mfragmentManager.beginTransaction()
                    .add(container.getId(), fragment, name)
                    .commit();
        }
        return fragment;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        String name = ""+ container.getId() + position;
        Fragment fragment = mfragmentManager.findFragmentByTag(name);
        if(fragment != null) {
            mfragmentManager.beginTransaction()
                    .detach(fragment);
        }
    }
}
