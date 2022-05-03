package com.sari3food.sari3fooooooooood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Tab1Fragment extends Fragment {

    item_firstscene_tab1 listView[];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.first_scene_tab1, container, false);



        listView = new item_firstscene_tab1[] {
                new item_firstscene_tab1("مواد غدائية", R.drawable.defaultprofile),
                new item_firstscene_tab1("Info", android.R.drawable.ic_dialog_info),
                new item_firstscene_tab1("Delete", android.R.drawable.ic_delete),
                new item_firstscene_tab1("Dialer", android.R.drawable.ic_dialog_dialer),
                new item_firstscene_tab1("Alert", android.R.drawable.ic_dialog_alert),
                new item_firstscene_tab1("Map", android.R.drawable.ic_dialog_map),
                new item_firstscene_tab1("Email", android.R.drawable.ic_dialog_email),
                new item_firstscene_tab1("Info", android.R.drawable.ic_dialog_info),
                new item_firstscene_tab1("Delete", android.R.drawable.ic_delete),
                new item_firstscene_tab1("Dialer", android.R.drawable.ic_dialog_dialer),
                new item_firstscene_tab1("Alert", android.R.drawable.ic_dialog_alert),
                new item_firstscene_tab1("Map", android.R.drawable.ic_dialog_map)
        };

        RecyclerView recyclerView =  view.findViewById(R.id.recyclerView);
        list_adapter_firstscene_tab1 adapter = new list_adapter_firstscene_tab1(listView,getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);


        return  view;
    }
}
