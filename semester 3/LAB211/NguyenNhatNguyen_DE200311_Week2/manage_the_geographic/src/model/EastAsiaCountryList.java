package model;

import java.util.ArrayList;
import java.util.Collections;

public class EastAsiaCountryList {
    private ArrayList<EastAsiaCountries> eastAsiaCountryArrayList = new ArrayList<>();

    public ArrayList<EastAsiaCountries> getEastAsiaCountryArrayList() {
        return eastAsiaCountryArrayList;
    }

    public void setEastAsiaCountryArrayList(ArrayList<EastAsiaCountries> eastAsiaContryArrayList) {
        this.eastAsiaCountryArrayList = eastAsiaContryArrayList;
    }

    public void addCountryInformation(EastAsiaCountries country){
        eastAsiaCountryArrayList.add(country);
    }
    public EastAsiaCountries getRecentlyEnteredInformation(){
        if (eastAsiaCountryArrayList.size()>0){
            return eastAsiaCountryArrayList.get(eastAsiaCountryArrayList.size()-1);
        }
        return null;
    }
    public ArrayList <EastAsiaCountries> searchInformationByName(String name){
        name = name.toLowerCase();
        ArrayList <EastAsiaCountries> result = new ArrayList<>();
        for (EastAsiaCountries e : eastAsiaCountryArrayList){
            if (e.getCountryName().toLowerCase().contains(name)){
                result.add(e);
            }
        }
        return result;
    }

    public ArrayList <EastAsiaCountries> sortInformationByAscendingOrder(){
        ArrayList <EastAsiaCountries> result = new ArrayList<>(eastAsiaCountryArrayList);
        Collections.sort(result, (c1,c2) ->{
            return c1.getCountryName().compareTo(c2.getCountryName());
        });
        return result;
    }

}
