package com.nd705.suppointspb.entity.events;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "events"
)
public class Event {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "start_point")
    private String startPoint;

    @Column(name = "stop_point")
    private String stopPoint;

    @Column(name = "map_link")
    private String mapLink;

    @Column(name = "duration")
    private Double duration;

    @Column(name = "lenhth")
    private Double length;

    @Column(name = "difficulty")
    private Double difficulty;

    @Column(name = "child_available")
    private Boolean child_available;

    @Column(name = "is_active")
    private Boolean isActive;

    // TODO: 19.12.2023 main foto, album, rewiew  



}
