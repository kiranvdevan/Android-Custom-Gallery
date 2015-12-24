package com.kiranpv.customgallerysample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by kiranpv on 24/12/15.
 */
public class ImageAdapter extends BaseAdapter {
    int mGalleryItemBackground;

    public ImageAdapter(Context context) {
        mContext = context;

    }

    public int getCount() {
        return allFiles.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView,
                        ViewGroup parent) {

        ImageView myImageView = new ImageView(mContext);

        if (convertView != null)
            myImageView = (ImageView) convertView;
        else {
            myImageView = new ImageView(mContext);
            myImageView.setLayoutParams(new GridView.LayoutParams(60, 60));
            myImageView.setAdjustViewBounds(false);
            myImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        }

        Bitmap bitmapImage = BitmapFactory.decodeFile(folder + "/" + allFiles[position]);
        BitmapDrawable drawableImage = new BitmapDrawable(bitmapImage);
        myImageView.setImageDrawable(drawableImage);

        return myImageView;

    }

    private Context mContext;

    File folder = new File(Environment.getExternalStorageDirectory().getPath()+"/files/Pictures/");
    String[] allFiles = folder.list();


}
