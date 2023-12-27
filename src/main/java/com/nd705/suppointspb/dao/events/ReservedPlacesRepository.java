package com.nd705.suppointspb.dao.events;

import com.nd705.suppointspb.entity.blog.Comment;
import com.nd705.suppointspb.entity.events.ReservedPlaces;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservedPlacesRepository extends JpaRepository<ReservedPlaces, Long> {
}
