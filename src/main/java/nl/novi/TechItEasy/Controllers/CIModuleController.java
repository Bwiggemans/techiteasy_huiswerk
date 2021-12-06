package nl.novi.TechItEasy.Controllers;

import nl.novi.TechItEasy.model.CIModule;
import nl.novi.TechItEasy.model.Television;
import nl.novi.TechItEasy.service.CIModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class CIModuleController {

    @Autowired  //link naar de repository CIModule
    private CIModuleService ciModuleService;

    @GetMapping(value = "/cimodules")
    public ResponseEntity<Object> getCIModules(@RequestParam(name="brand", defaultValue = "")String brand){
        return ResponseEntity.ok(ciModuleService.getCIModules(brand)); //Jackson vertaling object => Json
    }
    @GetMapping(value = "/cimodules/{id}")
    public ResponseEntity<Object> getCIModule(@PathVariable int id){
        return ResponseEntity.ok(ciModuleService.getCIModule(id));
    }
    @DeleteMapping(value = "/cimodules/{id}")
    public ResponseEntity<Object> deleteCIModule(@PathVariable("id") int id){
        ciModuleService.deleteCIModule(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/cimodules")
    public ResponseEntity<Object> addCIModule(@RequestBody CIModule ciModule){
        int newId = ciModuleService.addCIModule(ciModule);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }
    @GetMapping(value = "/cimodules/{id}/televisions")
    public ResponseEntity<Object> getCIModuleTelevisions(@PathVariable int id){
        return ResponseEntity.ok(ciModuleService.getCIModuleTelevisions(id));
    }
    @PostMapping(value = "/cimodules/{id}/televisions")
    public ResponseEntity<Object> addCIModuleTelevision(@PathVariable int id, @RequestBody Television television){
        ciModuleService.addCIModuleTelevision(id, television);
        return ResponseEntity.created(null).build();
    }

}
