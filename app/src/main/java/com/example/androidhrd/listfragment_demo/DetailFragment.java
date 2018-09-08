package com.example.androidhrd.listfragment_demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment  extends Fragment{

    private  static DetailFragment detailFragment;
    private TextView textView;
    private  String data;

    public void setData(String data) {
        this.data = data;
    }

    public  static DetailFragment newInstance(){
        if (detailFragment==null)
            detailFragment=new DetailFragment();

        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.detail_fragment_layout,container,false);
        textView=view.findViewById(R.id.textView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView.setText(data);
    }
}
