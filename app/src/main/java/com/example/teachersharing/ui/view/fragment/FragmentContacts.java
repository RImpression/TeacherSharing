package com.example.teachersharing.ui.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teachersharing.R;
import com.example.teachersharing.ui.adapter.MFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RImpression on 2016/9/24 0024.
 */
public class FragmentContacts extends Fragment {
    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    public static FragmentContacts newInstance(String param1) {
        FragmentContacts fragment = new FragmentContacts();
        Bundle args = new Bundle();
        args.putString("args1",param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_contacts,container,false);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager();
    }

    private void setUpViewPager() {
        viewPager = (ViewPager) getView().findViewById(R.id.viewpager);
        tabLayout = (TabLayout) getView().findViewById(R.id.tabLayout);
        List<String> titles = new ArrayList<>();
        titles.add("关注");
        titles.add("通讯录");
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentAttention());
        fragments.add(new FragmentFriend());

        MFragmentPagerAdapter adapter = new MFragmentPagerAdapter(getActivity().getSupportFragmentManager(),fragments,titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);
    }
}
