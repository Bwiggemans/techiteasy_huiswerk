package nl.novi.TechItEasy.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class WallBracketRequestDto {

    //Atrributen
    @NotBlank
    @Size(min = 1, max = 15)
    private String size;

    @NotBlank
    @Size(min = 1, max = 15)
    private String name;

    private boolean ajustable;
    private double price;

    //Getters and setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAjustable() {
        return ajustable;
    }

    public void setAjustable(boolean ajustable) {
        this.ajustable = ajustable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
