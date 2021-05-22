package models;

import lombok.Data;

import java.util.UUID;

@Data
public class Lane {
    private UUID id;
    private String name;
    private boolean isOccupied;

    public Lane(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.isOccupied = false;
    }
}
