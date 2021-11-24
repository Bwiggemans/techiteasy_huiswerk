package nl.novi.TechItEasy.Controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {

    //Attributen
    private List<String> televisionBrand = new ArrayList<>();

    //Constructor
    public TelevisionController() {
        televisionBrand.add("Siemens");
        televisionBrand.add("Samsung");
        televisionBrand.add("Philips");
        televisionBrand.add("LG");
        televisionBrand.add("Sony");
        televisionBrand.add("Panasonic");
        televisionBrand.add("Loewe");
        televisionBrand.add("Salora");
        televisionBrand.add("Sharp");
    }
}
