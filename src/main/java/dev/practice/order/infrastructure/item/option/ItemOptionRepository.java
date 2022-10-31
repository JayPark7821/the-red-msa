package dev.practice.order.infrastructure.item.option;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.practice.order.domain.item.option.ItemOption;

public interface ItemOptionRepository extends JpaRepository<ItemOption, Long> {
}
