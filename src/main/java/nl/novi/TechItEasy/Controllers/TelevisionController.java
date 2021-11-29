package nl.novi.TechItEasy.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {

    //Attributen
    private List<String> televisionBrand = new ArrayList<>();

    //Constructor
    public TelevisionController() {
        televisionBrand.add("Sony");
        televisionBrand.add("Panasonic");
        televisionBrand.add("Loewe");
        televisionBrand.add("Salora");
        televisionBrand.add("Sharp");
        televisionBrand.add("Philips");
        televisionBrand.add("AKAI");
    }

    @GetMapping(value = "/televisions")
    public List<String> getTelevisionBrand(){
        return televisionBrand;
    }
}
