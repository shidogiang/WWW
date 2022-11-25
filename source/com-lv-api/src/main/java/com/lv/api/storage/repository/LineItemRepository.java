package com.lv.api.storage.repository;

import com.lv.api.storage.model.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LineItemRepository extends JpaRepository<LineItem, Long>, JpaSpecificationExecutor<LineItem> {
    LineItem findByCartIdAndProductId(Long cartId, Long customerId);
}