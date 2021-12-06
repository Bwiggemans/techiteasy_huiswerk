package nl.novi.TechItEasy.service;

import nl.novi.TechItEasy.Exceptions.RecordNotFoundException;
import nl.novi.TechItEasy.model.CIModule;
import nl.novi.TechItEasy.repository.CIModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CIModuleService {

    @Autowired
    private CIModuleRepository ciModuleRepository;

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

}
