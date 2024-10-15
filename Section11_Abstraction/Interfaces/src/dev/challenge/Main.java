package dev.challenge;

import java.util.ArrayList;
import java.util.List;

public class Main {
//example string for every feature that will be matched:
// "properties" : {"type" : "POINT", "label": "Sydney Town Hall (Government)", "Marker": "RED STAR", "name": "Sydney Town Hall", "usage": "Government"}
    public static void main(String[] args) {
        //create a list of Mappable items: <Mappable> means that any class that implements Mappable can be added
        List<Mappable> mappables = new ArrayList<>();
        // add building instances to the List that's declared with parameter type of Mappable
        mappables.add(new Building("Sydney Town Hall", UsageType.GOVERNMENT));
        mappables.add(new Building("Sydney Opera House", UsageType.ENTERTAINMENT));
        mappables.add(new Building("Stadium Australia", UsageType.SPORTS));
        // add Utility Line instances to the List that's declared with parameter type of Mappable
        mappables.add(new UtilityLine("Verizon Wireless",UtilityType.FIBER_OPTIC));
        mappables.add(new UtilityLine("SoCal Edison", UtilityType.ELECTRICAL));
        mappables.add(new UtilityLine("SoCal Water Authority", UtilityType.WATER));
        mappables.add(new UtilityLine("Waste Management", UtilityType.WASTE_MANAGEMENT));
        mappables.add(new UtilityLine("Desert Gas Co.", UtilityType.GAS));

        // loop through the list and execute the static method: mapIt() for each element
        for (var m : mappables){
            Mappable.mapIt(m);
        }
//        output::
//"properties" :{{"Type": "POINT", "label": "Sydney Town Hall (GOVERNMENT) ", "marker": "RED STAR", "name":"Sydney Town Hall", "usage":"GOVERNMENT"}
//"properties" :{{"Type": "POINT", "label": "Sydney Opera House (ENTERTAINMENT) ", "marker": "GREEN TRIANGLE", "name":"Sydney Opera House", "usage":"ENTERTAINMENT"}
//"properties" :{{"Type": "POINT", "label": "Stadium Australia (SPORTS) ", "marker": "ORANGE PUSH_PIN", "name":"Stadium Australia", "usage":"SPORTS"}
//"properties" :{{"Type": "LINE", "label": "Verizon Wireless (FIBER_OPTIC) ", "marker": "GREEN DOTTED", "name":"Verizon Wireless", "utility":"FIBER_OPTIC"}
//"properties" :{{"Type": "LINE", "label": "SoCal Edison (ELECTRICAL) ", "marker": "RED DASHED", "name":"SoCal Edison", "utility":"ELECTRICAL"}
//"properties" :{{"Type": "LINE", "label": "SoCal Water Authority (WATER) ", "marker": "BLUE SOLID", "name":"SoCal Water Authority", "utility":"WATER"}
//"properties" :{{"Type": "LINE", "label": "Waste Management (WASTE_MANAGEMENT) ", "marker": "BLACK SOLID", "name":"Waste Management", "utility":"WASTE_MANAGEMENT"}
//"properties" :{{"Type": "LINE", "label": "Desert Gas Co. (GAS) ", "marker": "ORANGE SOLID", "name":"Desert Gas Co.", "utility":"GAS"}
    }
}
