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
        name = "reserved_places"
)
public class ReservedPlaces {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name="timetable_id")
    private Timetable timetable;

    @Column(name = "qnty")
    private int qnty;

    @Column(name = "price")
    private double price;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name="reservation_id")
    private Reservation reservation;
}
