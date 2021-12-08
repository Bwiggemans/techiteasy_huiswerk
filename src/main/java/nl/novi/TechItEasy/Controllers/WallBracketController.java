package nl.novi.TechItEasy.Controllers;

import nl.novi.TechItEasy.model.WallBracket;
import nl.novi.TechItEasy.service.WallBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class WallBracketController {

    @Autowired  //link naar de repository WallBracket
    private WallBracketService wallBracketService;

    @GetMapping(value = "/wallbrackets")
    public ResponseEntity<Object> getWallBrackets(@RequestParam(name="brand", defaultValue = "")String brand){
        return ResponseEntity.ok(wallBracketService.getWallBrackets(brand)); //Jackson vertaling object => Json
    }
    @GetMapping(value = "/wallbrackets/{id}")
    public ResponseEntity<Object> getWallBracket(@PathVariable int id){
        return ResponseEntity.ok(wallBracketService.getWallBracket(id));
    }
    @DeleteMapping(value = "/wallbrackets/{id}")
    public ResponseEntity<Object> deleteWallBracket(@PathVariable("id") int id){
        wallBracketService.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/wallbrackets")
    public ResponseEntity<Object> addWallBracket(@RequestBody WallBracket wallBracket){
        int newId = wallBracketService.addWallBracket(wallBracket);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }
}
