package nl.novi.TechItEasy.Controllers;

import nl.novi.TechItEasy.model.Television;
import nl.novi.TechItEasy.service.TelevisionService;
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
    private TelevisionService televisionService;

    @GetMapping(value = "/televisions")
    public ResponseEntity<Object> getTelevisions(@RequestParam(name="brand", defaultValue = "")String brand){
        return ResponseEntity.ok(televisionService.getTelevisions(brand)); //Jackson vertaling object => Json
    }
    @GetMapping(value = "/televisions/{id}")
    public ResponseEntity<Object> getTelevision(@PathVariable int id){
        return ResponseEntity.ok(televisionService.getTelevision(id));
    }
    @DeleteMapping(value = "/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable("id") int id){
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/televisions")
    public ResponseEntity<Object> addTelevision(@RequestBody Television television){
        int newId = televisionService.addTelevision(television);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }
    @PutMapping(value = "/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody Television television){
        televisionService.updateTelevision(id, television);

        return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/televisions/{id}")
    public ResponseEntity<Object> partialUpdateTelevision(@PathVariable int id, @RequestBody Television television){
        televisionService.partialUpdateTelevision(id, television);

        return ResponseEntity.noContent().build();
    }
}
