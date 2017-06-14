package com.example.administrator.xyws_program.model.db;



import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;


@Entity
public class updatabloodpressure implements Serializable{
    @Id
    private Long id;
    @Property(nameInDb = "TIME")
    private String time;
    @Property(nameInDb = "EQUIPMENT")
    private String equipment;
    @Property(nameInDb = "HIGNPRESSURE")
    private String hignpressure;
    @Property(nameInDb = "LOWPRESSURE")
    private String lowpressure;

    @Generated(hash = 113336909)
    public updatabloodpressure(Long id, String time, String equipment, String hignpressure,
            String lowpressure) {
        this.id = id;
        this.time = time;
        this.equipment = equipment;
        this.hignpressure = hignpressure;
        this.lowpressure = lowpressure;
    }

    @Generated(hash = 1065989)
    public updatabloodpressure() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getHignpressure() {
        return hignpressure;
    }

    public void setHignpressure(String hignpressure) {
        this.hignpressure = hignpressure;
    }

    public String getLowpressure() {
        return lowpressure;
    }

    public void setLowpressure(String lowpressure) {
        this.lowpressure = lowpressure;
    }
}
