package nl.novi.TechItEasy.Controllers;

import nl.novi.TechItEasy.model.RemoteControl;
import nl.novi.TechItEasy.service.RemoteControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class RemoteControlController {

    @Autowired  //link naar de repository RemoteControl
    private RemoteControlService remoteControlService;

    @GetMapping(value = "/remotecontrollers")
    public ResponseEntity<Object> getRemoteControls(@RequestParam(name="brand", defaultValue = "")String brand){
        return ResponseEntity.ok(remoteControlService.getRemoteControls(brand)); //Jackson vertaling object => Json
    }
    @GetMapping(value = "/remotecontrollers/{id}")
    public ResponseEntity<Object> getRemoteControl(@PathVariable int id){
        return ResponseEntity.ok(remoteControlService.getRemoteControl(id));
    }
    @DeleteMapping(value = "/remotecontrollers/{id}")
    public ResponseEntity<Object> deleteRemoteControl(@PathVariable("id") int id){
        remoteControlService.deleteRemoteControl(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/remotecontrollers")
    public ResponseEntity<Object> addRemoteControl(@RequestBody RemoteControl remoteControl){
        int newId = remoteControlService.addRemoteControl(remoteControl);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

}
