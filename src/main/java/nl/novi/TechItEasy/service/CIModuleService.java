package nl.novi.TechItEasy.service;

import nl.novi.TechItEasy.Exceptions.RecordNotFoundException;
import nl.novi.TechItEasy.model.CIModule;
import nl.novi.TechItEasy.model.Television;
import nl.novi.TechItEasy.repository.CIModuleRepository;
import nl.novi.TechItEasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CIModuleService {

    @Autowired
    private CIModuleRepository ciModuleRepository;
    @Autowired
    private TelevisionRepository televisionRepository;


    public Iterable<CIModule> getCIModules(String brand){
            return ciModuleRepository.findAll();
    }

    public CIModule getCIModule(int id){
        Optional<CIModule> optionalCIModule = ciModuleRepository.findById(id);

        if (optionalCIModule.isPresent()){
            return optionalCIModule.get();
        }
        else{
            //exception maken
            throw new RecordNotFoundException("Id does not exist!!!");
        }
    }

    public void deleteCIModule(int id){
        if (ciModuleRepository.existsById(id)) {
            ciModuleRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public int addCIModule(CIModule ciModule){

        CIModule newCImodule = ciModuleRepository.save(ciModule);
        return newCImodule.getId();
    }
    public Iterable<Television> getCIModuleTelevisions(int id){
        Optional<CIModule> optionalCIModule = ciModuleRepository.findById(id);

        if (optionalCIModule.isPresent()){
            CIModule ciModule = optionalCIModule.get();
            return ciModule.getTelevisions();
        }
        else{
            //exception maken
            throw new RecordNotFoundException("Id does not exist!!!");
        }

    }
    public void addCIModuleTelevision(int id, Television television){
        Optional<CIModule> optionalCIModule = ciModuleRepository.findById(id);

        if (optionalCIModule.isPresent()){
            CIModule ciModule = optionalCIModule.get();
            List<Television> televisions = ciModule.getTelevisions();

            televisionRepository.save(television);

            televisions.add(television);
            ciModuleRepository.save(ciModule);
        }
        else{
            //exception maken
            throw new RecordNotFoundException("Id does not exist!!!");
        }

    }


}
