package Model;

import java.util.ArrayList;

/**
 * Created by waqas on 6/18/15.
 */
public class SelectCityModel {

    private SelectCityModel(){}

    public static ArrayList<SelectCityModel> _obj = new ArrayList<SelectCityModel>();
    public String count;
    public String next;
    public String previous;



    public ArrayList <results> results = new ArrayList<results>();

    public class results{
        public String id;
        public String name;
        public String domain;

    }

}
