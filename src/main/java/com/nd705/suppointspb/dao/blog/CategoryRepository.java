package com.nd705.suppointspb.dao.blog;

import com.nd705.suppointspb.entity.blog.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
