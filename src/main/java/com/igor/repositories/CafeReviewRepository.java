package com.igor.repositories;

import com.igor.entities.CafeReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeReviewRepository extends JpaRepository<CafeReview, Long> {
}
