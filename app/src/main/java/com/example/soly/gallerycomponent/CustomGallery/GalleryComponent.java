package com.example.soly.gallerycomponent.CustomGallery;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.soly.gallerycomponent.R;

/**
 * Created by soly on 12/22/2017.
 */
public class GalleryComponent extends LinearLayout {
    ViewPagerAdapter viewPagerAdapter;
    WrapContentHeightViewPager vp_gallery;
    private  int [] imgArray  ={ R.drawable.img7,R.drawable.img11,R.drawable.img10,R.drawable.img12,R.drawable.img33};
    public GalleryComponent(Context context ,AttributeSet attributeSet) {
        super(context, attributeSet);

        setOrientation(LinearLayout.VERTICAL);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.fragment_gallery, this, true);

        //setImages(imgArray);
    }

//    public void setImages(int [] images) {
//
//        viewPagerAdapter = new ViewPagerAdapter(getContext(),images);
//        vp_gallery.setAdapter(viewPagerAdapter);
//
//    }
}

