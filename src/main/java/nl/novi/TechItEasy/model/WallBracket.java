package nl.novi.TechItEasy.model;

import javax.persistence.*;

@Entity
@Table(name = "wallbrackets")
public class WallBracket {

    //Attributen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String size;
    private String name;
    private boolean ajustable;
    private double price;

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
