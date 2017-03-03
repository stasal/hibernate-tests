package org.hibernate.bugs.entity.complex;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ghoul on 03.03.2017
 */
@Entity
@IdClass(PotDates.PotDatesId.class)
public class PotDates {

    public static class PotDatesId implements Serializable {
        public static final Long serialVersionUID = 0L;

        private Pot.PotId pot;

        private Date date;

        public Pot.PotId getPot() {
            return pot;
        }

        public void setPot(Pot.PotId pot) {
            this.pot = pot;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PotDatesId that = (PotDatesId) o;

            if (!pot.equals(that.pot)) return false;
            return date.equals(that.date);
        }

        @Override
        public int hashCode() {
            int result = pot.hashCode();
            result = 31 * result + date.hashCode();
            return result;
        }
    }

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Smelter_ID", referencedColumnName = "Smelter_ID"),
            @JoinColumn(name = "Room_ID", referencedColumnName = "Room_ID"),
            @JoinColumn(name = "Pot_ID", referencedColumnName = "Pot_ID")
    })
    private Pot pot;

    @Id
    @Column(name = "Date_Trunc")
    private Date date;

    @Column(name = "Age")
    private Long age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PotDates potDates = (PotDates) o;

        if (!pot.equals(potDates.pot)) return false;
        if (!date.equals(potDates.date)) return false;
        return age.equals(potDates.age);
    }

    @Override
    public int hashCode() {
        int result = pot.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }

    public Pot getPot() {
        return pot;

    }

    public void setPot(Pot pot) {
        this.pot = pot;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
