package nl.novi.TechItEasy.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CImoduleRequastDto {

    //Attributen
    @NotBlank
    @Size(min = 1, max = 10)
    private String name;

    @NotBlank
    @Size(min = 1, max = 10)
    private String type;

    private double price;

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
