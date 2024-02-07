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
        int i = 0;
        while (i < touristAttractionList.size()){
            if (touristAttractionList.get(i).getName().equalsIgnoreCase(touristAttraction.getName())){
                touristAttractionList.set(i,touristAttraction);
                return touristAttraction;
            }
            i++;
        }
        return null;
    }

    public TouristAttraction deleteTouristAttraction(TouristAttraction touristAttraction){
        int foundIndex = -1;
        TouristAttraction returnTouristAttraction = new TouristAttraction("Mistake", "Attraction, not found");

        for (int i = 0; i < touristAttractionList.size() ; i++) {
            if(touristAttractionList.get(i).getName().equalsIgnoreCase(touristAttraction.getName())){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex != -1){
            returnTouristAttraction = touristAttractionList.get(foundIndex);
            touristAttractionList.remove(foundIndex);
        }

        return returnTouristAttraction;
    }

}
