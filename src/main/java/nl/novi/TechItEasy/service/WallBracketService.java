package nl.novi.TechItEasy.service;

import nl.novi.TechItEasy.Exceptions.RecordNotFoundException;
import nl.novi.TechItEasy.model.WallBracket;
import nl.novi.TechItEasy.repository.WallBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WallBracketService {

    @Autowired
    private WallBracketRepository wallBracketRepository;

    public Iterable<WallBracket> getWallBrackets(String brand){
            return wallBracketRepository.findAll();
    }

    public WallBracket getWallBracket(int id){
        Optional<WallBracket> optionalWallBracket = wallBracketRepository.findById(id);

        if (optionalWallBracket.isPresent()){
            return optionalWallBracket.get();
        }
        else{
            //exception maken
            throw new RecordNotFoundException("Id does not exist!!!");
        }
    }

    public void deleteWallBracket(int id){
        if (wallBracketRepository.existsById(id)) {
            wallBracketRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public int addWallBracket(WallBracket wallBracket){

        WallBracket newWallBracket = wallBracketRepository.save(wallBracket);
        return newWallBracket.getId();
    }
}
