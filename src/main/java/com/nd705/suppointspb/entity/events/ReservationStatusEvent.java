package com.nd705.suppointspb.entity.events;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "reservation_status_events"
)
public class ReservationStatusEvent {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "details")
    private String details;

    @Column(name = "ts_created")
    @CreationTimestamp
    private LocalDateTime tsCreated;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name="reservation_id")
    private Reservation reservation;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name="reservation_status_catalog_id")
    private ReservationStatusCatalog reservationStatusCatalog;

}
