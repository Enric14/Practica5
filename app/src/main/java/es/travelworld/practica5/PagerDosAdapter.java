package es.travelworld.practica5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerDosAdapter extends FragmentStateAdapter {
    public PagerDosAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            default:
            case 0:
                return new MainTresFragment();
            case 1:
                return new HomeOneFragment();
            case 2:
                return new HomeTwoFragment();
            case 3:
                return new HomeThreeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
