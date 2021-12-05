package nl.novi.TechItEasy.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TelevisionRequestDto {

        //Attributen
        @NotBlank
        @Size(min = 1, max = 6)
        private String type;

        @NotBlank
        @Size(min = 1, max = 10)
        private String brand;

        @NotBlank
        @Size(min = 1, max = 10)
        private String name;

        private double price;
        private double size;
        private double refreshRate;

        @NotBlank
        @Size(min = 1, max = 6)
        private String screenType;

        @NotBlank
        @Size(min = 1, max = 5)
        private String screenQuality;

        private boolean smartTv;
        private boolean voiceControl;
        private boolean hdr;
        private boolean bluetooth;
        private boolean ambilight;
        private Integer originalStock;
        private Integer sold;
        private boolean wifi;

        //Getters and setters
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
}
