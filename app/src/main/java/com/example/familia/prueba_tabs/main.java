package com.example.familia.prueba_tabs;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class main extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        vpAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        vpAdapter.addFragments(new HomeFragment(), "Home");
        vpAdapter.addFragments(new TopFreeFragment(), "Top Free");
        vpAdapter.addFragments(new TopPaidFragment(), "Top Paid");
        viewPager.setAdapter(vpAdapter);
        //tabLayout.setupWithViewPager(viewPager);


        int imgIds[] = {R.drawable.letrai, R.drawable.grad, R.drawable.nota};

        for (int i = 0; i < vpAdapter.getCount(); i++) {
            tabLayout.addTab(tabLayout.newTab().setIcon(imgIds[i]));
        }
        //Por último se sincroniza el TabLayout con el ViewPager
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
