package net.oregon91.cad.oregon9_1_1;

/**
 * Created by Brandan on 12/28/2015.
 */

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import cad.oregon911.net.Incident;
import cad.oregon911.net.unit;
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
        char single_county = getItem(position).getCallInfo().getCounty();
        char single_type = getItem(position).getCallInfo().getType();
        String single_station = getItem(position).getCallInfo().getStation();
        String single_timedate = getItem(position).getCallInfo().getTs().ToString();
        String single_address = getItem(position).getCallInfo().getAddress();

        String single_units = new String();

        ArrayList<unit> unitList = getItem(position).getUnitList();
        for (int i = 0; i < unitList.size(); i++) {
            unit thing = unitList.get(i);
            single_units += "<font color=\"" + utils.unitColor[utils.getUnitStatus(thing).ordinal()] + "\">" + thing.getName() + "</font>, ";
        }

        // Removes the last ,
        if (single_units.length() > 2)
            single_units = single_units.substring(0, single_units.length()-2);

        // Get Textview
        TextView text_callSum = (TextView) customView.findViewById(R.id.call_text);
        TextView text_address = (TextView) customView.findViewById(R.id.call_address);
        TextView text_station = (TextView) customView.findViewById(R.id.call_station);
        TextView text_timedate = (TextView) customView.findViewById(R.id.call_timedate);
        TextView text_unitlist = (TextView) customView.findViewById(R.id.call_unitlist);

        // Hidden identifers
        TextView hidden_callNumber = (TextView) customView.findViewById(R.id.callNumber);
        TextView hidden_county = (TextView) customView.findViewById(R.id.county);
        TextView hidden_type = (TextView) customView.findViewById(R.id.type);


        LinearLayout  call_banner = (LinearLayout) customView.findViewById(R.id.call_banner);

        if (single_type == 'P') {
            call_banner.setBackgroundColor(Color.parseColor(utils.callHeaderColor[utils.agency.WCCCA_POLICE.ordinal()]));
        } else if (single_county == 'W') {
            call_banner.setBackgroundColor(Color.parseColor(utils.callHeaderColor[utils.agency.WCCCA.ordinal()]));
        } else if (single_county == 'C') {
            call_banner.setBackgroundColor(Color.parseColor(utils.callHeaderColor[utils.agency.CCOM.ordinal()]));
        }

        text_callSum.setText(single_callSum);
        text_address.setText(single_address);
        text_station.setText(single_station);
        text_timedate.setText(single_timedate);
        text_unitlist.setText(Html.fromHtml(single_units));

        // Hidden set.
        hidden_callNumber.setText(String.valueOf(single_callNumber));
        hidden_county.setText(String.valueOf(single_county));
        hidden_type.setText(String.valueOf(single_type));

        // Hidden is to identify help IntMan find the call. This does not show up on the UI.

        return customView;
    }
}
