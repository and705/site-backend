package com.nd705.suppointspb.dao.events;

import com.nd705.suppointspb.entity.blog.Comment;
import com.nd705.suppointspb.entity.events.ReservationStatusCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationStatusCatalogRepository extends JpaRepository<ReservationStatusCatalog, Long> {
}
