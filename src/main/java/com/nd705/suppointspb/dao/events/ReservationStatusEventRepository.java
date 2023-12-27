package com.nd705.suppointspb.dao.events;

import com.nd705.suppointspb.entity.events.ReservationStatusEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationStatusEventRepository extends JpaRepository<ReservationStatusEvent, Long> {
}
