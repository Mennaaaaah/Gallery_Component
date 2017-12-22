package com.example.soly.gallerycomponent.CustomGallery;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.soly.gallerycomponent.R;

/**
 * Created by soly on 12/21/2017.
 */
public class ViewPagerAdapter extends PagerAdapter  {
    private Context mContext;
    private LayoutInflater layoutInflater;
    ImageView imageView;
    ViewPager viewPager;

    private  int [] imgArray  ={ R.drawable.img7,R.drawable.img11,R.drawable.img10,R.drawable.img12,R.drawable.img33};

    public ViewPagerAdapter(Context context) {
        this.mContext = context;
    }


    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.customlayout,null);
        imageView = (ImageView)view.findViewById(R.id.imgView);
        imageView.setImageResource(imgArray[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }



        });

        viewPager = (ViewPager)container;
        viewPager.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);

    }

    @Override
    public int getCount() {
        return imgArray.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }



}
