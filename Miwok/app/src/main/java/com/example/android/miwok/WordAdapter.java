package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int backgroundID;
    public WordAdapter(Activity context, ArrayList<Word> word,int resourceID) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, word);
        backgroundID = resourceID;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        LinearLayout lin = (LinearLayout) listItemView.findViewById(R.id.textLayout);
        int color = ContextCompat.getColor(getContext(),backgroundID);
        lin.setBackgroundColor(color);

        Word local_word = getItem(position);
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        //miwokTextView.setBackgroundColor(backgroundID);
        miwokTextView.setText(local_word.getMiwok());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        //defaultTextView.setBackgroundColor(backgroundID);
        defaultTextView.setText(local_word.getEnglish());

        ImageView image = (ImageView) listItemView.findViewById(R.id.image);

        if(local_word.hasImage()) {
            image.setImageResource(local_word.getImageID());
            image.setVisibility(View.VISIBLE);
        }else{
            image.setVisibility(View.GONE);
        }
        return listItemView;
    }
}

