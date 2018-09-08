package com.example.androidhrd.listfragment_demo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidhrd.listfragment_demo.callback.ItemClickCallback;

public class ListFragment extends android.support.v4.app.ListFragment {
    TextView textView;
    //public  ListFragment(){}
    //String[] values={"Apple","Samsung","Nokai","Huvie","Oppo"};
    String[] values;
    ItemClickCallback callback;

    public void setValues(String[] values) {
        this.values = values;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback= (ItemClickCallback) context;
    }

    private static ListFragment fragment;
    public static ListFragment newInstance(String name){
        Bundle bundle=new Bundle();
        bundle.putString("name",name);

        if(fragment==null)
            fragment=new ListFragment();

        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.list_fragment_layout,container,false);
        return view;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //bind data here
        ArrayAdapter<String>  adapter =new ArrayAdapter<String>(
                getActivity(),android.R.layout.simple_list_item_1,values
        );

        setListAdapter(adapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        callback.itemClickWithString(values[position]);
        //Toast.makeText(getActivity(), values[position], Toast.LENGTH_SHORT).show();
    }
}
