package nl.novi.TechItEasy.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<String> getTelevisions(){
        return televisionBrand;
    }
    @GetMapping(value = "/televisions/{id}")
    public String getTelevision(@PathVariable int id){
        return televisionBrand.get(id);
    }
    @DeleteMapping(value = "/televisions/{id}")
    public String deleteTelevision(@PathVariable int id){
        televisionBrand.remove(id);
        return "Television deleted";
    }
    @PostMapping("/televisions")
    public String addTelevision(@RequestBody String television) {
        televisionBrand.add(television);
        return "Added";
    }
    @PutMapping("televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody String television) {
        televisionBrand.set(id, television);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("televisions/{id}")
    public ResponseEntity<Object> partialTelevision(@PathVariable int id, @RequestBody String television) {
        televisionBrand.set(id, television);
        return ResponseEntity.noContent().build();
    }

}
