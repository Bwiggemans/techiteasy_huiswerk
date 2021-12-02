package nl.novi.TechItEasy.service;

import nl.novi.TechItEasy.Exceptions.RecordNotFoundException;
import nl.novi.TechItEasy.model.Television;
import nl.novi.TechItEasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelevisionService {

    @Autowired
    private TelevisionRepository televisionRepository;

    public Iterable<Television> getTelevisions(String brand){
        if (brand.isEmpty()){
            return televisionRepository.findAll();
        }
        else {
            return televisionRepository.findAllByBrandContainingIgnoreCase(brand);
        }
    }

    public Television getTelevision(int id){
        Optional<Television> optionalTelevision = televisionRepository.findById(id);

        if (optionalTelevision.isPresent()){
            return optionalTelevision.get();
        }
        else{
            //exception maken
            throw new RecordNotFoundException("Id does not exist!!!");
        }
    }

    public void deleteTelevision(int id){
        televisionRepository.deleteById(id);
    }

    public int addTelevision(Television television){
        Television newTelevision = televisionRepository.save(television);
        return newTelevision.getId();
    }

    public void updateTelevision(int id, Television television){
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
    }

    public void partialUpdateTelevision(int id, Television television){
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
    }
}
