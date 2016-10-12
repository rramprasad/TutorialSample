package com.exinnos.tutorialsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * @author Lakeba.
 */
public class SlidingImagesFragment extends Fragment {

    private static final String ARG_PARAM1 = "arg_param1";
    private int mImageDrawable;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sliding_images,container,false);

        ImageView tutorialImageView = (ImageView) rootView.findViewById(R.id.tutorial_imageview);
        tutorialImageView.setImageResource(mImageDrawable);

        return rootView;
    }

    public static SlidingImagesFragment newInstance(int tutorialImageDrawable) {
        SlidingImagesFragment slidingImagesFragment = new SlidingImagesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_PARAM1,tutorialImageDrawable);
        slidingImagesFragment.setArguments(bundle);
        return slidingImagesFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            mImageDrawable = getArguments().getInt(ARG_PARAM1);
        }
    }
}
