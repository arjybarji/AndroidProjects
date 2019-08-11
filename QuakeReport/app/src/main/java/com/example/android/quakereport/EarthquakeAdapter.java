package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.quakereport.Earthquake;
import com.example.android.quakereport.R;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private int backgroundID;
    private static final String LOCATION_SEPERATOR = " of ";


    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> quakes,int resourceID) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, quakes);
        backgroundID = resourceID;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }


        Earthquake quake = getItem(position);
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        double mag = quake.getMagnitude();
        DecimalFormat formatter = new DecimalFormat("0.0");
        magnitudeView.setText("" + formatter.format(mag));
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(quake.getMagnitude());
        magnitudeCircle.setColor(ContextCompat.getColor(getContext(),magnitudeColor));


        TextView locationView = (TextView) listItemView.findViewById(R.id.location);
        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.locationOffset);
        String originalLocation = quake.getLocation();
        String location;
        String locationOffset;

        if(originalLocation.contains(LOCATION_SEPERATOR)){
            String parts[] = originalLocation.split(LOCATION_SEPERATOR);
            locationOffset = parts[0] + LOCATION_SEPERATOR;
            location = parts[1];
        }else{
            locationOffset = getContext().getString(R.string.near_the);
            location = originalLocation;
        }

        locationView.setText(location);
        locationOffsetView.setText(locationOffset);

        Date dateObject = new Date(quake.getDate());

        String formattedDate = formatDate(dateObject);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(formattedDate);

        String formattedTime = formatTime(dateObject);
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        timeView.setText(formattedTime);





        return listItemView;
    }

    private String formatDate(Date dateObject){
        SimpleDateFormat df = new SimpleDateFormat("LLL dd, yyyy");
        return df.format(dateObject);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat df = new SimpleDateFormat("h:mm a");
        return df.format(dateObject);
    }

    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceID;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch(magnitudeFloor){
            case 0:
            case 1:
              magnitudeColorResourceID = R.color.magnitude1;
              break;
            case 2:
                magnitudeColorResourceID = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceID = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceID = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceID = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceID = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceID = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceID = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceID = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceID = R.color.magnitude10plus;
                break;
        }
        return magnitudeColorResourceID;
    }
}

