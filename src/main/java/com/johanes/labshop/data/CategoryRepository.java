package com.johanes.labshop.data;

import com.johanes.labshop.Objects.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
