package com.example.gameofcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

/**
 * Created by Mohru on 21.05.2017.
 */

public class PhotoLoader {

    public static Bitmap loadBitmapFromAssets(Context context, String path) {
        Bitmap bitmap = null;

        try {
            InputStream ioStream = context.getAssets().open("photos/" + path + ".jpg");
            bitmap = BitmapFactory.decodeStream(ioStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
