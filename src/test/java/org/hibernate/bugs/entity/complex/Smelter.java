package org.hibernate.bugs.entity.complex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author ghoul on 03.03.2017
 */
@Entity
public class Smelter {

    @Id
    @Column(name = "Smelter_ID")
    private Long smelterId;

    @Column(name = "Name")
    private String name;

    public Long getSmelterId() {
        return smelterId;
    }

    public void setSmelterId(Long smelterId) {
        this.smelterId = smelterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
