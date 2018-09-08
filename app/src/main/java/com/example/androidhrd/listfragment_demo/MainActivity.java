package com.example.androidhrd.listfragment_demo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.androidhrd.listfragment_demo.callback.ItemClickCallback;

public class MainActivity extends AppCompatActivity
implements ItemClickCallback{

    String[] values={"Apple","Samsung","Nokai","Huvie","Oppo"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction t =fragmentManager.beginTransaction();
        //send data to fragment
        ListFragment listFragment=ListFragment.newInstance("List Fragment");
        listFragment.setValues(values);

        t.add(R.id.container,listFragment);
        t.commit();
    }

    private static final String TAG = "MainActivity";
    @Override
    public void itemClickWithString(String data) {
        Log.e(TAG, "itemClickWithString: "+data);
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

        FragmentTransaction t= getSupportFragmentManager().beginTransaction();
        DetailFragment detailFragment= DetailFragment.newInstance();
        detailFragment.setData(data);
        t.replace(R.id.container,detailFragment);
        t.addToBackStack(null);
        t.commit();
    }
}
