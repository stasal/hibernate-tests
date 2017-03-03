package org.hibernate.bugs.entity.complex;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ghoul on 03.03.2017
 */
@Entity
@IdClass(Pot.PotId.class)
public class Pot {

    public static class PotId implements Serializable {
        public static final Long serialVersionUID = 0L;

        private Room.RoomId room;

        private Long potId;

        public Room.RoomId getRoom() {
            return room;
        }

        public void setRoom(Room.RoomId room) {
            this.room = room;
        }

        public Long getPotId() {
            return potId;
        }

        public void setPotId(Long potId) {
            this.potId = potId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PotId potId1 = (PotId) o;

            if (!room.equals(potId1.room)) return false;
            return potId.equals(potId1.potId);
        }

        @Override
        public int hashCode() {
            int result = room.hashCode();
            result = 31 * result + potId.hashCode();
            return result;
        }
    }

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Smelter_ID", referencedColumnName = "Smelter_ID"),
            @JoinColumn(name = "Room_ID", referencedColumnName = "Room_ID")
    })
    private Room room;

    @Id
    @Column(name = "Pot_ID")
    private Long potId;

    private String name;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Long getPotId() {
        return potId;
    }

    public void setPotId(Long potId) {
        this.potId = potId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
