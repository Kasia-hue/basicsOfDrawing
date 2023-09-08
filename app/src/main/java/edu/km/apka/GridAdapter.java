package edu.km.apka;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    Context context;
    ArrayList<Integer> image;

    public GridAdapter(Context context, ArrayList<Integer> image) {
        this.context = context;
        this.image = image;
    }

    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view_image,
                viewGroup, false);

        ImageView imageView = view.findViewById(R.id.imageView);

        imageView.setImageResource(image.get(i));
        return view;
    }
}

