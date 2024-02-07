package com.example.touristguideapi.repository;


import com.example.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    private List<TouristAttraction> touristAttractionList = new ArrayList<TouristAttraction>(List.of(
            new TouristAttraction("Tivoli", "Forlystelsespark i hjertet af København"),
            new TouristAttraction("Amalienborg", "Hjem for de kongelige"),
            new TouristAttraction("Den lille havfrue", "Stedet alle japanere skal tage billeder"),
            new TouristAttraction("Aalborg", "Nordens Paris")
    ));

    public List<TouristAttraction> getTouristAttractionList() {
        return touristAttractionList;
    }

    public TouristAttraction getTouristAttraction(String name) {
        for (TouristAttraction attraction : touristAttractionList) {
            if (attraction.getName().toLowerCase().contains(name.toLowerCase())) {
                return attraction;
            }
        }
        return null;
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction){
        touristAttractionList.add(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction updateTouristAttraction(TouristAttraction touristAttraction){
        for(TouristAttraction ta: touristAttractionList){
            if (ta.getName().equalsIgnoreCase(touristAttraction.getName())){
                ta.setDescription(touristAttraction.getDescription());
                return ta;
            }
        }
        return null;
    }

    public TouristAttraction deleteTouristAttraction(String name){
        for (TouristAttraction ta: touristAttractionList){
            if(ta.getName().equalsIgnoreCase(name)){
                touristAttractionList.remove(ta);
                return ta;
            }
        }
        return null;
    }

}
