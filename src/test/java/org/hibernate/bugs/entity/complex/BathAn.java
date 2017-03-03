package org.hibernate.bugs.entity.complex;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ghoul on 03.03.2017
 */
@Entity
@IdClass(BathAn.BathAnId.class)
public class BathAn {

    public static class BathAnId implements Serializable {
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

            BathAnId bathAnId = (BathAnId) o;

            return potDates.equals(bathAnId.potDates);
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

    @Column(name = "Cr")
    private Double cr;

    public PotDates getPotDates() {
        return potDates;
    }

    public void setPotDates(PotDates potDates) {
        this.potDates = potDates;
    }

    public Double getCr() {
        return cr;
    }

    public void setCr(Double cr) {
        this.cr = cr;
    }
}
