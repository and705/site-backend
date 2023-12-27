package com.nd705.suppointspb.dao.site;

import com.nd705.suppointspb.entity.blog.Comment;
import com.nd705.suppointspb.entity.site.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<Faq, Long> {
}
