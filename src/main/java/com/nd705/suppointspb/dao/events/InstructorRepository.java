package com.nd705.suppointspb.dao.events;

import com.nd705.suppointspb.entity.blog.Comment;
import com.nd705.suppointspb.entity.events.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
