package com.algorepublic.cityhistory.cityhistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.androidquery.AQuery;

import java.util.ArrayList;

/**
 * Created by waqas on 6/19/15.
 */
public class SelectCityAdapter extends BaseAdapter {

    AQuery aqAdapter;
    Context ctx;
    BaseClass base;
    LayoutInflater l_Inflater;
    BaseClass baseClass;
    private static ArrayList<CityDetails> cityDetailsrrayList;
    public SelectCityAdapter(Context ctx, ArrayList<CityDetails> results) {
        super();
        this.ctx = ctx;
        baseClass = ((BaseClass)ctx.getApplicationContext());
        l_Inflater = LayoutInflater.from(ctx);
        cityDetailsrrayList = new ArrayList<>();
        cityDetailsrrayList.addAll(results);
    }

    @Override
    public int getCount() {
        return cityDetailsrrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return cityDetailsrrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i,  View convertView, ViewGroup viewGroup) {


        View v ;
        ViewHolder holder;
        LayoutInflater mInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = mInflater.inflate(R.layout.activity_main, null);

        aqAdapter = new AQuery(v);
        holder = new ViewHolder();

        holder.city_Name = (ListView) v.findViewById(R.id.city_list);

        v.setTag(holder);

        return v;
    }

    static class ViewHolder {
        ListView city_Name;

    }
}
