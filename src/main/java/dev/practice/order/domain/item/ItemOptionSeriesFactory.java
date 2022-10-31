package dev.practice.order.domain.item;

import java.util.List;

import dev.practice.order.domain.item.optiongroup.ItemOptionGroup;

public interface ItemOptionSeriesFactory {
    List<ItemOptionGroup> store(ItemCommand.RegisterItemRequest request, Item item);
}
