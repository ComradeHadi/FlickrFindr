package com.comradehadi.flickrfindr.screens;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.comradehadi.flickrfindr.R;
import com.comradehadi.flickrfindr.data.ImageGalleryItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = ImageFragment.class.getSimpleName();

    private ImageGalleryItem mItem;
    private ImageView mPhoto;
    private Button mBackButton;

    public ImageFragment() {
        // Required empty public constructor
    }



    public void closeImagePage(){

        getFragmentManager().beginTransaction().remove(new ImageFragment()).commitAllowingStateLoss();
        Log.e("clikc", "BACK BUTTON");
        Toast.makeText(getContext(), "CLICK", Toast.LENGTH_LONG).show();


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        mItem = (ImageGalleryItem) getActivity().getIntent().getSerializableExtra("item");
        mPhoto = (ImageView) view.findViewById(R.id.photo);
        mBackButton = (Button) view.findViewById(R.id.backButton);
        Glide.with(getContext()).load(mItem.getUrl()).thumbnail(0.5f).into(mPhoto);
        return view;
    }


    @Override
    public void onClick(View view) {

        Log.e("clikc", "Click");
        Toast.makeText(getContext(), "CLICK", Toast.LENGTH_LONG).show();

        switch (view.getId()){
            case R.id.backButton:
                getFragmentManager().beginTransaction().remove(new ImageFragment()).commitAllowingStateLoss();
                Log.e("clikc", "BACK BUTTON");

                break;

                default:
        }
    }
}
