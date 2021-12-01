package nl.novi.TechItEasy.Exceptions;

import org.springframework.stereotype.Service;

import java.io.Serial;

public class RecordNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    //constructor leeg
    public RecordNotFoundException(){
        super();
    }

    public RecordNotFoundException(String message){
        super(message);
    }
}
