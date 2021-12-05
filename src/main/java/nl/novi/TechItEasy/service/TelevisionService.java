package nl.novi.TechItEasy.service;

import nl.novi.TechItEasy.Exceptions.RecordNotFoundException;
import nl.novi.TechItEasy.dto.TelevisionRequestDto;
import nl.novi.TechItEasy.model.Television;
import nl.novi.TechItEasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (televisionRepository.existsById(id)) {
            televisionRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public int addTelevision(TelevisionRequestDto televisionRequestDto){

        Television television = new Television();
        television.setType(televisionRequestDto.getType());
        television.setBrand(televisionRequestDto.getBrand());
        television.setName(televisionRequestDto.getName());
        television.setScreenType(televisionRequestDto.getScreenType());
        television.setScreenQuality(televisionRequestDto.getScreenQuality());
        television.setPrice(televisionRequestDto.getPrice());
        television.setSize(televisionRequestDto.getSize());
        television.setRefreshRate(televisionRequestDto.getRefreshRate());
        television.setSmartTv(televisionRequestDto.isSmartTv());
        television.setWifi(televisionRequestDto.isWifi());
        television.setVoiceControl(televisionRequestDto.isVoiceControl());
        television.setHdr(televisionRequestDto.isHdr());
        television.setBluetooth(televisionRequestDto.isBluetooth());
        television.setAmbilight(televisionRequestDto.isAmbilight());
        television.setOriginalStock(televisionRequestDto.getOriginalStock());
        television.setSold(televisionRequestDto.getSold());

        Television newTelevision = televisionRepository.save(television);
        return newTelevision.getId();
    }

    public void updateTelevision(int id, Television television) {
        if (!televisionRepository.existsById(id)) {
            throw new RecordNotFoundException("No television found");
        }
        Television storedTelevision = televisionRepository.findById(id).orElse(null);
        storedTelevision.setAmbilight(television.isAmbilight());
        storedTelevision.setSize(television.getSize());
        storedTelevision.setBluetooth(television.isBluetooth());
        storedTelevision.setBrand(television.getBrand());
        storedTelevision.setHdr(television.isHdr());
        storedTelevision.setId(storedTelevision.getId());
        storedTelevision.setName(television.getName());
        storedTelevision.setOriginalStock(television.getOriginalStock());
        storedTelevision.setPrice(television.getPrice());
        storedTelevision.setRefreshRate(television.getRefreshRate());
        storedTelevision.setScreenType(television.getScreenType());
        storedTelevision.setScreenQuality(television.getScreenQuality());
        storedTelevision.setSmartTv(television.isSmartTv());
        storedTelevision.setSold(television.getSold());
        storedTelevision.setType(television.getType());
        storedTelevision.setVoiceControl(television.isVoiceControl());
        storedTelevision.setWifi(television.isWifi());

        televisionRepository.save(storedTelevision);
    }
    public void partialUpdateTelevision(int id, Television television){
        if (!televisionRepository.existsById(id)) {
            throw new RecordNotFoundException("No television found");
        }

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
        if (!(television.isAmbilight() == false)){
            existingTelevision.setAmbilight(television.isAmbilight());
        }
        if ((television.getPrice()) != (existingTelevision.getPrice())){
            existingTelevision.setPrice(television.getPrice());
        }
        if ((television.getSize()) != (existingTelevision.getSize())){
            existingTelevision.setSize(television.getSize());
        }
        if ((television.getRefreshRate()) != (existingTelevision.getRefreshRate())){
            existingTelevision.setRefreshRate(television.getRefreshRate());
        }
        if (!(television.isSmartTv() == false)){
            existingTelevision.setSmartTv(television.isSmartTv());
        }
        if (!(television.isVoiceControl() == false)){
            existingTelevision.setVoiceControl(television.isVoiceControl());
        }
        if (!(television.isHdr() == false)){
            existingTelevision.setHdr(television.isHdr());
        }
        if (!(television.isBluetooth() == false)){
            existingTelevision.setBluetooth(television.isBluetooth());
        }
        if ((television.getOriginalStock()) != (existingTelevision.getOriginalStock())){
            existingTelevision.setOriginalStock(television.getOriginalStock());
        }
        if ((television.getSold()) != (existingTelevision.getSold())){
            existingTelevision.setSold(television.getSold());
        }
        if (!(television.isWifi() == false)){
            existingTelevision.setWifi(television.isWifi());
        }

        televisionRepository.save(existingTelevision);
    }
}
