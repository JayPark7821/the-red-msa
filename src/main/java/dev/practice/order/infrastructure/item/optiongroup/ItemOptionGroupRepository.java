package dev.practice.order.infrastructure.item.optiongroup;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.practice.order.domain.item.optiongroup.ItemOptionGroup;

public interface ItemOptionGroupRepository extends JpaRepository<ItemOptionGroup, Long> {
}
