package nl.novi.TechItEasy.service;

import nl.novi.TechItEasy.Exceptions.RecordNotFoundException;
import nl.novi.TechItEasy.dto.RemoteControlRequestDto;
import nl.novi.TechItEasy.model.RemoteControl;
import nl.novi.TechItEasy.repository.RemoteControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RemoteControlService {

    @Autowired
    private RemoteControlRepository remoteControlRepository;

    public Iterable<RemoteControl> getRemoteControls(String brand){
            return remoteControlRepository.findAll();
    }

    public RemoteControl getRemoteControl(int id){
        Optional<RemoteControl> optionalRemoteControl = remoteControlRepository.findById(id);

        if (optionalRemoteControl.isPresent()){
            return optionalRemoteControl.get();
        }
        else{
            //exception maken
            throw new RecordNotFoundException("Id does not exist!!!");
        }
    }

    public void deleteRemoteControl(int id){
        if (remoteControlRepository.existsById(id)) {
            remoteControlRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public int addRemoteControl(RemoteControlRequestDto remoteControlRequestDto){

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCompatibleWith(remoteControlRequestDto.getCompatibleWith());
        remoteControl.setBatteryType(remoteControlRequestDto.getBatteryType());
        remoteControl.setName(remoteControlRequestDto.getName());
        remoteControl.setBrand(remoteControlRequestDto.getBrand());
        remoteControl.setPrice(remoteControlRequestDto.getPrice());
        remoteControl.setOriginalStock(remoteControlRequestDto.getOriginalStock());

        RemoteControl newRemoteControl = remoteControlRepository.save(remoteControl);
        return newRemoteControl.getId();
    }
}
