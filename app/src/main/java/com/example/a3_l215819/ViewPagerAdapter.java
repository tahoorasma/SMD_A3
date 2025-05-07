package com.example.a3_l215819;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.smdassignment3.fragments.*;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new ScheduleFragment();
            case 1: return new PastFragment();
            case 2: return new NotificationFragment();
            case 3: return new ProfileFragment();
            default: return new ScheduleFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
