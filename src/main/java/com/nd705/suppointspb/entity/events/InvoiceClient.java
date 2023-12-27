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
        name = "client_invoice"
)
public class InvoiceClient {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "invoice_amount")
    private Double invoiceAmount;

    @Column(name = "ts_issued")
    @CreationTimestamp
    private LocalDateTime tsIssued;

    @Column(name = "ts_paid")
    private LocalDateTime tsPaid;

    @Column(name = "ts_canceled")
    private LocalDateTime tsCanceled;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name="client_id")
    private Client client;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name="reservation_id")
    private Reservation reservation;

}
