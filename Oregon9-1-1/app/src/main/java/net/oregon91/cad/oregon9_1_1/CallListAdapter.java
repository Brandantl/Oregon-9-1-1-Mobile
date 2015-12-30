package net.oregon91.cad.oregon9_1_1;

/**
 * Created by Brandan on 12/28/2015.
 */

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import cad.oregon911.net.Incident;
import cad.oregon911.net.utils;


public class CallListAdapter extends ArrayAdapter<Incident> {

    public CallListAdapter(Context context, ArrayList<Incident> calllist) {
        super(context, R.layout.custom_call_list_row, calllist);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_call_list_row, parent, false);

        // Get Data from class
        int    single_callNumber = getItem(position).getCallInfo().getCallNumber();
        String single_callSum = getItem(position).getCallInfo().getCallSum();
        String single_station = getItem(position).getCallInfo().getStation();
        String single_timedate = getItem(position).getCallInfo().getTs().ToString();
        String single_address = getItem(position).getCallInfo().getAddress();
        String single_units = "<font color=\"" + utils.unitColor[utils.unitStatus.DISPATCHED.ordinal()] + "\">" + getItem(position).getCallInfo().getUnits() + "</font>";

        // Get Textview
        TextView text_callSum = (TextView) customView.findViewById(R.id.call_text);
        TextView text_address = (TextView) customView.findViewById(R.id.call_address);
        TextView text_station = (TextView) customView.findViewById(R.id.call_station);
        TextView text_timedate = (TextView) customView.findViewById(R.id.call_timedate);
        TextView text_unitlist = (TextView) customView.findViewById(R.id.call_unitlist);

        LinearLayout  call_banner = (LinearLayout) customView.findViewById(R.id.call_banner);

        text_callSum.setText(single_callSum);
        text_address.setText(single_address);
        text_station.setText(single_station);
        text_timedate.setText(single_timedate);
        text_unitlist.setText(Html.fromHtml(single_units));

        return customView;
    }
}
