package com.lv.api.storage.repository;

import com.lv.api.storage.model.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long>, JpaSpecificationExecutor<ProductReview> {
    ProductReview findByProductIdAndCustomerId(Long productId, Long customerId);
}
