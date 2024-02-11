package com.example.touristguideapi.controller;


import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.service.TouristServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    private TouristServices touristService;

    public TouristController(){
        touristService = new TouristServices();
    }

    @GetMapping()
    public ResponseEntity<List<TouristAttraction>> getAttractions(){
        List attractionList = touristService.getTouristAttractions();
        return new ResponseEntity<List<TouristAttraction>>(attractionList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttraction(@PathVariable String name){
        TouristAttraction touristAttraction = touristService.getTouristAttraction(name);
        if (touristAttraction == null){
            return new ResponseEntity<>(touristAttraction, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction newTouristAttraction = touristService.addTouristAttraction(touristAttraction);
        return new ResponseEntity<>(newTouristAttraction,HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction updatedTouristAttraction = touristService.updateTouristAttraction(touristAttraction);
        if (updatedTouristAttraction != null)
        return new ResponseEntity<>(updatedTouristAttraction,HttpStatus.OK);
        else
            return new ResponseEntity<>(new TouristAttraction("Error", "Tourist Attraction not found"),HttpStatus.NOT_FOUND);
    }

    @GetMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteTouristAttraction(@PathVariable String name){
        TouristAttraction deletedTouristAttraction = touristService.deleteTouristAttraction(name);
        return new ResponseEntity<>(deletedTouristAttraction,HttpStatus.OK);
    }

}
