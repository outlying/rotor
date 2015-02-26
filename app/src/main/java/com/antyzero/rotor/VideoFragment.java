package com.antyzero.rotor;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VideoFragment extends Fragment {

    private int iter = 0;

    public VideoFragment() {
        setRetainInstance(true);

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    print(String.valueOf(iter));
                    iter++;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("VideoFragment.onCreated");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        print("VideoFragment.onViewCreated");
    }

    private void print(String s) {
        System.out.println("[" + this.hashCode() + "] " + s);
    }
}
