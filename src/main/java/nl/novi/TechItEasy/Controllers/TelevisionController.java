package nl.novi.TechItEasy.Controllers;

import nl.novi.TechItEasy.model.Television;
import nl.novi.TechItEasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {

    //Attributen
    private List<Television> televisions = new ArrayList<>();

    //Constructor
    public TelevisionController() {
        Television television1 = new Television();
        television1.setBrand("Panasonic");
        television1.setName("QLed24");
        television1.setPrice(495.95);
        television1.setAvailablePrice(475.95);
        televisions.add(television1);

        Television television2 = new Television();
        television2.setBrand("Sony");
        television2.setName("QLed65");
        television2.setPrice(595.95);
        television2.setAvailablePrice(575.95);
        televisions.add(television2);
    }

    @Autowired  //link naar de repository Television
    private TelevisionRepository televisionRepository;

    @GetMapping(value = "/televisions")
    public ResponseEntity<Object> getTelevisions(){
        return ResponseEntity.ok(televisionRepository.findAll()); //Jackson vertaling object => Json
    }
    @GetMapping(value = "/televisions/{id}")
    public ResponseEntity<Object> getTelevision(@PathVariable int id){
        return ResponseEntity.ok(televisionRepository.findById(id));
    }
    @DeleteMapping(value = "/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable("id") int id){
        televisions.remove(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/televisions")
    public ResponseEntity<Object> addTelevision(@RequestBody Television television){
        televisions.add(television);

        int newId = televisions.size() - 1;

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping(value = "/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody Television television){
        televisions.set(id, television);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/televisions/{id}")
    public ResponseEntity<Object> partialUpdateTelevision(@PathVariable int id, @RequestBody Television television){
        Television existingTelevision = televisions.get(id);
        if (!(television.getType()==null) && !television.getType().isEmpty()){
            existingTelevision.setType(television.getType());
        }
        if (!(television.getBrand()==null) && !television.getBrand().isEmpty()){
            existingTelevision.setBrand(television.getBrand());
        }
        if (!(television.getName()==null) && !television.getName().isEmpty()){
            existingTelevision.setName(television.getName());
        }
        televisions.set(id, existingTelevision);
        return ResponseEntity.noContent().build();
    }

}
