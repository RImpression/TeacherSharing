package com.example.teachersharing.ui.view;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.BaseAdapter;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.teachersharing.R;
import com.example.teachersharing.ui.view.fragment.FragmentContacts;
import com.example.teachersharing.ui.view.fragment.FragmentLife;
import com.example.teachersharing.ui.view.fragment.FragmentPersonnal;
import com.example.teachersharing.ui.view.fragment.FragmentTeaching;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar bottomNavigationBar;
    private FragmentContacts fragmentContacts;
    private FragmentLife fragmentLife;
    private FragmentPersonnal fragmentPersonnal;
    private FragmentTeaching fragmentTeaching;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("教学资源共享平台");
        setSupportActionBar(toolbar);

        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottomNavigation);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_teachingplan,"教案中心").setActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_contacts,"教学问题").setActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_personal,"教学管理").setActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_life,"在线教育").setActiveColor(R.color.colorPrimary))
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();

    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
//        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        fragmentTeaching = FragmentTeaching.newInstance("教案");
        transaction.replace(R.id.tb,fragmentTeaching);
        transaction.commit();

    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (fragmentTeaching == null) {
                    fragmentTeaching = FragmentTeaching.newInstance("教案");
                }
                transaction.replace(R.id.tb, fragmentTeaching);
                break;
            case 1:
                if (fragmentContacts == null) {
                    fragmentContacts = FragmentContacts.newInstance("通讯录");
                }
                transaction.replace(R.id.tb, fragmentContacts);
                break;
            case 2:
                if (fragmentPersonnal == null) {
                    fragmentPersonnal = FragmentPersonnal.newInstance("个人中心");
                }
                transaction.replace(R.id.tb, fragmentPersonnal);
                break;
            case 3:
                if (fragmentLife == null) {
                    fragmentLife = FragmentLife.newInstance("生活娱乐");
                }
                transaction.replace(R.id.tb, fragmentLife);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
