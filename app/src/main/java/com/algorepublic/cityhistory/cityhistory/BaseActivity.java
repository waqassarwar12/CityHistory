package com.algorepublic.cityhistory.cityhistory;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

import Model.SelectCityModel;


public class BaseActivity extends FragmentActivity {
    AQuery aq;
    private BaseClass base;
    static int p;
    private ArrayList<SelectCityModel> arrayList = new ArrayList<>();
    ArrayList<CityDetails> details;
    ListView CityListView;
    ArrayList<String> cityName =  new ArrayList<>();
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CityListView = (ListView) findViewById(R.id.city_list);
        aq = new AQuery(BaseActivity.this);
        base = ((BaseClass)getApplicationContext());
        url= base.City_URL;
        Log.e("url", base.City_URL);

        AjaxCallback<String> jsonObj = new AjaxCallback<String>();
        jsonObj.url(url).type(String.class).weakHandler(BaseActivity.this, "CityResults");
        aq.ajax(jsonObj);

    }



    public void CityResults(String url, String json, AjaxStatus status){


        Log.e("Result","/"+json);
        Gson gson = new Gson();

        SelectCityModel[] obj  = gson.fromJson(json,
                SelectCityModel[].class);

        arrayList = new ArrayList<>(Arrays.asList(obj));
        Log.e(" size ", arrayList.toString());
        updateList();
    }


    private void updateList() {
        Log.e("check", "/" + "check");

        aq.id(R.id.city_list).itemClicked(new SelectCityListner());
        SelectCityModel._obj = arrayList;
        details=GetResults();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(BaseActivity.this,android.R.layout.simple_list_item_activated_1,cityName);
        CityListView.setAdapter(adapter);

    }

    public class SelectCityListner implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }
    private ArrayList<CityDetails> GetResults() {
        ArrayList<CityDetails> results = new ArrayList<CityDetails>();

        for (p = 0; p < arrayList.size(); p++) {
            Log.e("LOg","/"+arrayList.get(0).results.get(p).name);
//            cityName.add(SelectCityModel._obj.get(0).results.get(p).name);
//            CityDetails item_details = new CityDetails();
//            item_details.setName(SelectCityModel._obj.get(0).results.get(p).name);
//            item_details.setDomain(SelectCityModel._obj.get(p).getDomain());
//            item_details.setId(SelectCityModel._obj.get(p).getId());
//            results.add(item_details);

        }
        return results;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
