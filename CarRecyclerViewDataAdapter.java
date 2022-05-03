package com.sari3food.sari3fooooooooood;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;


public class CarRecyclerViewDataAdapter extends RecyclerView.Adapter<CarRecyclerViewItemHolder>  {
    private AdapterCallback mAdapterCallback;


    LinearLayout bottomSheet;

    viewchosenstoreitemscene1tab1 h1;
    BottomSheetBehavior<LinearLayout> bottomSheetBehavior ;


    private List<CarRecyclerViewItem> carItemList;

    public CarRecyclerViewDataAdapter(List<CarRecyclerViewItem> carItemList,Context context) {
        this.carItemList = carItemList;
        try {
            this.mAdapterCallback = ((AdapterCallback) context);
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement AdapterCallback.");
        }
    }

    @Override
    public CarRecyclerViewItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Get LayoutInflater object.
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Inflate the RecyclerView item layout xml.
        View carItemView = layoutInflater.inflate(R.layout.activity_card_view_item, parent, false);

        ImageButton plusbutton6=carItemView.findViewById(R.id.button6);
        final TextView txtv=carItemView.findViewById(R.id.textView9);
        final TextView txtv1=carItemView.findViewById(R.id.card_view_image_title);
        plusbutton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapterCallback.onMethodCallback(txtv1.getText().toString());

            }
        });
        ImageButton plusbutton7=carItemView.findViewById(R.id.button7);
        plusbutton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapterCallback.onMethodCallback2(txtv1.getText().toString());
            }
        });

        // Get car title text view object.
        final TextView carTitleView = (TextView)carItemView.findViewById(R.id.card_view_image_title);
        // Get car image view object.
        final ImageView carImageView = (ImageView)carItemView.findViewById(R.id.card_view_image);
        // When click the image.
        carImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get car title text.
                String carTitle = carTitleView.getText().toString();
                // Create a snackbar and show it.
                Snackbar snackbar = Snackbar.make(carImageView, "You click " + carTitle +" image", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        // Create and return our custom Car Recycler View Item Holder object.
        CarRecyclerViewItemHolder ret = new CarRecyclerViewItemHolder(carItemView);
        return ret;
    }



    @Override
    public void onBindViewHolder(CarRecyclerViewItemHolder holder, int position) {
        if(carItemList!=null) {
            // Get car item dto in list.
            CarRecyclerViewItem carItem = carItemList.get(position);

            if(carItem != null) {
                // Set car item title.
                holder.getCarTitleText().setText(carItem.getCarName());
                // Set car image resource id.
                holder.getCarImageView().setImageResource(carItem.getCarImageId());

            }
        }
    }


    @Override
    public int getItemCount() {
        int ret = 0;
        if(carItemList!=null)
        {
            ret = carItemList.size();
        }
        return ret;
    }
    public static interface AdapterCallback {
        void onMethodCallback(String txt);
        void onMethodCallback2(String txt);
    }


}
