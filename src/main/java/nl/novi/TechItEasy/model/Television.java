package nl.novi.TechItEasy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    private double refreshRate;
    private String screenType;
    private String screenQuality;
    private boolean smartTv;
    private boolean voiceControl;
    private boolean hdr;
    private boolean bluetooth;
    private boolean ambilight;
    private Integer originalStock;
    private Integer sold;
    private boolean wifi;

    @OneToOne(mappedBy = "television")
    RemoteControl remoteControl;

    @JsonIgnoreProperties("televisions")
    @ManyToOne
    @JoinColumn(name = "cimodule_id", referencedColumnName = "id")
    private CIModule owner;

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
    public double getRefreshRate() {
        return refreshRate;
    }
    public void setRefreshRate(double refreshRate) {
        this.refreshRate = refreshRate;
    }
    public String getScreenType() {
        return screenType;
    }
    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }
    public String getScreenQuality() {
        return screenQuality;
    }
    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }
    public boolean isSmartTv() {
        return smartTv;
    }
    public void setSmartTv(boolean smartTv) {
        this.smartTv = smartTv;
    }
    public boolean isVoiceControl() {
        return voiceControl;
    }
    public void setVoiceControl(boolean voiceControl) {
        this.voiceControl = voiceControl;
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
    public Integer getOriginalStock() {
        return originalStock;
    }
    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }
    public Integer getSold() {
        return sold;
    }
    public void setSold(Integer sold) {
        this.sold = sold;
    }
    public boolean isWifi() {
        return wifi;
    }
    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }
    public CIModule getOwner() {
        return owner;
    }
    public void setOwner(CIModule owner) {
        this.owner = owner;
    }

    public RemoteControl getRemoteControl() {
        return remoteControl;
    }

    public void setRemoteControl(RemoteControl remoteControl) {
        this.remoteControl = remoteControl;
    }
}
