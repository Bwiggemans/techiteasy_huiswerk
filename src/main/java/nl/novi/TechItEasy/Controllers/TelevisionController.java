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
        televisionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/televisions")
    public ResponseEntity<Object> addTelevision(@RequestBody Television television){
        Television newTelevision = televisionRepository.save(television);
        int newId = newTelevision.getId();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }
    @PutMapping(value = "/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody Television television){
        Television existingTelevision = televisionRepository.findById(id).orElse(null);

        if (!television.getType().isEmpty()){
            existingTelevision.setType(television.getType());
        }
        if (!television.getBrand().isEmpty()){
            existingTelevision.setBrand(television.getBrand());
        }
        if (!television.getName().isEmpty()){
            existingTelevision.setName(television.getName());
        }
        if (!television.getScreenType().isEmpty()){
            existingTelevision.setScreenType(television.getScreenType());
        }
        if (!television.getScreenQuality().isEmpty()){
            existingTelevision.setScreenQuality(television.getScreenQuality());
        }

        televisionRepository.save(existingTelevision);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/televisions/{id}")
    public ResponseEntity<Object> partialUpdateTelevision(@PathVariable int id, @RequestBody Television television){
        Television existingTelevision = televisionRepository.findById(id).orElse(null);

        if (!(television.getType()==null) && !television.getType().isEmpty()){
            existingTelevision.setType(television.getType());
        }
        if (!(television.getBrand()==null) && !television.getBrand().isEmpty()){
            existingTelevision.setBrand(television.getBrand());
        }
        if (!(television.getName()==null) && !television.getName().isEmpty()){
            existingTelevision.setName(television.getName());
        }
        if (!(television.getScreenType()==null) && !television.getScreenType().isEmpty()){
            existingTelevision.setScreenType(television.getScreenType());
        }
        if (!(television.getScreenQuality()==null) && !television.getScreenQuality().isEmpty()){
            existingTelevision.setScreenQuality(television.getScreenQuality());
        }

        televisionRepository.save(existingTelevision);
        return ResponseEntity.noContent().build();
    }

}
