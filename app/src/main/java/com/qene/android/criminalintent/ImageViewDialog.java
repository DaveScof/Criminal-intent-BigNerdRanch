package com.qene.android.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;


/**
 * Created by davescof on 3/24/17.
 */

public class ImageViewDialog extends DialogFragment {
    private final static String ARG_PHOTO_FILE = "photoFile";
    private final static String ARG_CRIME_TITLE = "crimeTitle";

    public static final int IMAGE_SCALE = 10;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String crimeTitle = getArguments().getString(ARG_CRIME_TITLE);
        File photoFile = (File) getArguments().getSerializable(ARG_PHOTO_FILE);

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_image,null);


        ImageView imageView = (ImageView) view.findViewById(R.id.dialog_imageView);
        Point size = new Point();
        getActivity().getWindowManager().getDefaultDisplay().getSize(size);
        Bitmap crimePhoto = PictureUtils.getScaledBitMap(photoFile.getPath(),size.x * IMAGE_SCALE, size.y * IMAGE_SCALE);

        imageView.setImageBitmap(crimePhoto);

        return new AlertDialog.Builder(getActivity())
                .setTitle(crimeTitle)
                .setView(view)
                .create();
    }

    public static ImageViewDialog newInstance (String crimeTitle, File photoFile){
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_TITLE, crimeTitle);
        args.putSerializable(ARG_PHOTO_FILE, photoFile);

        ImageViewDialog imageViewDialog = new ImageViewDialog();
        imageViewDialog.setArguments(args);
        return imageViewDialog;
    }
}
