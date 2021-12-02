package nl.novi.TechItEasy.model;

import javax.persistence.*;

@Entity
@Table(name = "televisions")
public class Television {

    //Attributen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Primary key
    private String type;
    private String brand;
    private String name;
    private double price;
    private double size;
    private double refreshrate;
    private String screentype;
    private String screenquality;
    private boolean smarttv;
    private boolean voicecontrol;
    private boolean hdr;
    private boolean bluetooth;
    private boolean ambilight;
    private Integer originalstock;
    private Integer sold;

    //constructor in springboot niet nodig

    //Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        this.size = size;
    }
    public double getRefreshrate() {
        return refreshrate;
    }
    public void setRefreshrate(double refreshrate) {
        this.refreshrate = refreshrate;
    }
    public String getScreentype() {
        return screentype;
    }
    public void setScreentype(String screentype) {
        this.screentype = screentype;
    }
    public String getScreenquality() {
        return screenquality;
    }
    public void setScreenquality(String screenquality) {
        this.screenquality = screenquality;
    }
    public boolean isSmarttv() {
        return smarttv;
    }
    public void setSmarttv(boolean smarttv) {
        this.smarttv = smarttv;
    }
    public boolean isVoicecontrol() {
        return voicecontrol;
    }
    public void setVoicecontrol(boolean voicecontrol) {
        this.voicecontrol = voicecontrol;
    }
    public boolean isHdr() {
        return hdr;
    }
    public void setHdr(boolean hdr) {
        this.hdr = hdr;
    }
    public boolean isBluetooth() {
        return bluetooth;
    }
    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }
    public boolean isAmbilight() {
        return ambilight;
    }
    public void setAmbilight(boolean ambilight) {
        this.ambilight = ambilight;
    }
    public Integer getOriginalstock() {
        return originalstock;
    }
    public void setOriginalstock(Integer originalstock) {
        this.originalstock = originalstock;
    }
    public Integer getSold() {
        return sold;
    }
    public void setSold(Integer sold) {
        this.sold = sold;
    }
}
