package com.example.soly.gallerycomponent.CustomGallery;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.soly.gallerycomponent.R;

import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryComponent extends Fragment {
    WrapContentHeightViewPager vp_gallery;
    EditText et_setSec;
    Button btn_start;
    LinearLayout ll_SliderDots;
    ViewPagerAdapter viewPagerAdapter;
    private int dotsCounts;
    private ImageView[] dots;
    private Long period;
    private long longPeriod = 1000L;

    public GalleryComponent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);
        intiUI(rootView);
        setImages();
        setDots();

        return rootView;
    }


    public void intiUI(View view) {
        vp_gallery = (WrapContentHeightViewPager) view.findViewById(R.id.vp_gallery);
        vp_gallery.setPageTransformer(true, new DepthPageTransformer());
        et_setSec = (EditText) view.findViewById(R.id.et_setSec);
        btn_start = (Button) view.findViewById(R.id.btn_start);
        ll_SliderDots = (LinearLayout) view.findViewById(R.id.ll_SliderDots);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTransitionTime();
            }
        });


    }

    public void getTransitionTime() {

        if (et_setSec.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Please Enter  Transition Time", Toast.LENGTH_LONG).show();
        }
        else {
            period = Long.parseLong(et_setSec.getText().toString());

            Log.d("sec===>", period.toString());
            String s = period.toString();
            if (s.equals("0")) {
                Toast.makeText(getContext(), "Please Enter valid Transition Time", Toast.LENGTH_LONG).show();
            } else {
                period = period * 1000L;
                Log.d("sec1===>", period.toString());
                Timer timer = new Timer();
                timer.scheduleAtFixedRate(new MyTimerTask(), 2000, period);
            }



        }
    }

    public void setImages() {

        viewPagerAdapter = new ViewPagerAdapter(getContext());
        vp_gallery.setAdapter(viewPagerAdapter);
    }


    public void setDots() {
        dotsCounts = viewPagerAdapter.getCount();

        dots = new ImageView[dotsCounts];
        for (int i = 0; i < dotsCounts; i++) {
            dots[i] = new ImageView(getContext());

            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.nonactivedot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            ll_SliderDots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.activedot));

        vp_gallery.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotsCounts; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.nonactivedot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.activedot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public class MyTimerTask extends TimerTask {


        @Override
        public void run() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (vp_gallery.getCurrentItem() == 0) {
                        vp_gallery.setCurrentItem(1);
                    } else if (vp_gallery.getCurrentItem() == 1) {
                        vp_gallery.setCurrentItem(2);
                    }
                    else if(vp_gallery.getCurrentItem()== 2){
                        vp_gallery.setCurrentItem(3);
                    }
                    else if(vp_gallery.getCurrentItem()== 3){
                        vp_gallery.setCurrentItem(4);
                    }

                    else {
                        vp_gallery.setCurrentItem(0);
                    }

                }
            });

        }


    }
}
