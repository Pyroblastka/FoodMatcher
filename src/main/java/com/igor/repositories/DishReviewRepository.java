package com.igor.repositories;

import com.igor.entities.DishReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishReviewRepository extends JpaRepository<DishReview, Long> {

}
