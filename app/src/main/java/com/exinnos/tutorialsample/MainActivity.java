package com.exinnos.tutorialsample;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int tutorialImages[] = {R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager tutorialViewPager = (ViewPager) findViewById(R.id.tutorial_viewpager);

        tutorialViewPager.setAdapter(new TutorialViewPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tutorial_tablayout);
        tabLayout.setSelectedTabIndicatorHeight(0);

        tabLayout.setupWithViewPager(tutorialViewPager);

        for (int i = 0; i < tutorialImages.length; i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if(tab != null){
                tab.setIcon(getResources().getDrawable(R.drawable.circle_icon_small));
            }
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setIcon(getResources().getDrawable(R.drawable.circle_icon_large));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(getResources().getDrawable(R.drawable.circle_icon_small));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tab.setIcon(getResources().getDrawable(R.drawable.circle_icon_large));
            }
        });

        TabLayout.Tab firstTab = tabLayout.getTabAt(0);
        if(firstTab != null){
            firstTab.select();
        }
    }

    private class TutorialViewPagerAdapter extends FragmentStatePagerAdapter {


        public TutorialViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return SlidingImagesFragment.newInstance(tutorialImages[position]);
        }

        @Override
        public int getCount() {
            return tutorialImages.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }
}
