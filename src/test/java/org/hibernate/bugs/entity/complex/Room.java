package org.hibernate.bugs.entity.complex;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ghoul on 03.03.2017
 */
@Entity
@IdClass(Room.RoomId.class)
public class Room {

    public static class RoomId implements Serializable {
        public static final Long serialVersionUID = 0L;

        private Long smelter;

        private Long roomId;

        public Long getSmelter() {
            return smelter;
        }

        public void setSmelter(Long smelter) {
            this.smelter = smelter;
        }

        public Long getRoomId() {
            return roomId;
        }

        public void setRoomId(Long roomId) {
            this.roomId = roomId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RoomId roomId1 = (RoomId) o;

            if (!smelter.equals(roomId1.smelter)) return false;
            return roomId.equals(roomId1.roomId);
        }

        @Override
        public int hashCode() {
            int result = smelter.hashCode();
            result = 31 * result + roomId.hashCode();
            return result;
        }
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "Smelter_ID", referencedColumnName = "Smelter_ID")
    private Smelter smelter;

    @Id
    @Column(name = "Room_ID")
    private Long roomId;

    @Column(name = "Name")
    private String name;

    public Smelter getSmelter() {
        return smelter;
    }

    public void setSmelter(Smelter smelter) {
        this.smelter = smelter;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
