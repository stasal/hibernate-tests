package org.hibernate.bugs.entity.complex;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ghoul on 03.03.2017
 */
@Entity
@IdClass(PotBath.PotBathId.class)
public class PotBath {

    public static class PotBathId implements Serializable {
        public static final Long serialVersionUID = 0L;

        private PotDates.PotDatesId potDates;

        public PotDates.PotDatesId getPotDates() {
            return potDates;
        }

        public void setPotDates(PotDates.PotDatesId potDates) {
            this.potDates = potDates;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PotBathId potBathId = (PotBathId) o;

            return potDates.equals(potBathId.potDates);
        }

        @Override
        public int hashCode() {
            return potDates.hashCode();
        }
    }

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Smelter_ID", referencedColumnName = "Smelter_ID"),
            @JoinColumn(name = "Room_ID", referencedColumnName = "Room_ID"),
            @JoinColumn(name = "Pot_ID", referencedColumnName = "Pot_ID"),
            @JoinColumn(name = "Date_Trunc", referencedColumnName = "Date_Trunc")
    })
    private PotDates potDates;

    @Column(name = "Metal_Height")
    private Long metalHeight;

    @Column(name = "Smelter_ID", insertable = false, updatable = false)
    private Long smelterId;

    @Column(name = "Room_ID", insertable = false, updatable = false)
    private Long roomId;

    @Column(name = "Pot_ID", insertable = false, updatable = false)
    private Long potId;

    @Column(name = "Date_Trunc", insertable = false, updatable = false)
    private Date date;

    public PotDates getPotDates() {
        return potDates;
    }

    public void setPotDates(PotDates potDates) {
        this.potDates = potDates;
    }

    public Long getMetalHeight() {
        return metalHeight;
    }

    public void setMetalHeight(Long metalHeight) {
        this.metalHeight = metalHeight;
    }

    public Long getSmelterId() {
        return smelterId;
    }

    public void setSmelterId(Long smelterId) {
        this.smelterId = smelterId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getPotId() {
        return potId;
    }

    public void setPotId(Long potId) {
        this.potId = potId;
    }
}
