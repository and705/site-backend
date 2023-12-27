package com.nd705.suppointspb.entity.events;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "reservations"
)
public class Reservation {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name="client_id")
    private Client client;

    @Column(name = "ts_created")
    @CreationTimestamp
    private LocalDateTime tsReservationCreated;

    @Column(name = "ts_updated")
    @UpdateTimestamp
    private LocalDateTime tsReservationUpdated;

    @Column(name = "discount_percent")
    private Double discountPercent;

    @Column(name = "total_price")
    private Double totalPrice;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name="sales_channel_id")
    private SalesChannel salesChannel;

}
