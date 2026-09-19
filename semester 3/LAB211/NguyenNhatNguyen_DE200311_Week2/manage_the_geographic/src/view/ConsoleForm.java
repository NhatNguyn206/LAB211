package view;

import model.EastAsiaCountries;

import java.util.ArrayList;

public class ConsoleForm {
    public EastAsiaCountries inputInformation() {
        EastAsiaCountries eastAsiaCountries = new EastAsiaCountries();

        System.out.println("Enter code of country:");
        eastAsiaCountries.setCountryCode(DataInput.inputString());
        System.out.println("Enter name of country:");
        eastAsiaCountries.setCountryName(DataInput.inputString());
        System.out.println("Enter total Area:");
        eastAsiaCountries.setTotalArea(DataInput.inputPositiveFloat());
        System.out.println("Enter terrain of country:");
        eastAsiaCountries.setCountryTerrain(DataInput.inputString());

        return eastAsiaCountries;

    }
    public void displayRecently(EastAsiaCountries countries) {
        System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
        System.out.printf(countries.toString() + "\n");
    }
    public String enterNameToSearch() {
        System.out.println("Enter the name you want to search for: ");
        String name = DataInput.inputString();
        return name;
    }
    public void displayList(ArrayList<EastAsiaCountries> eastAsiaCountryList) {
        System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountries e : eastAsiaCountryList) {
            System.out.printf(e.toString() + "\n");
        }
    }
}
