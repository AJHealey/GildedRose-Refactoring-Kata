package com.gildedrose.strategy
import com.gildedrose.Item

object ConjuredItemUpdate extends UpdateStrategy {
    override def update(item: Item): Unit = {
        item.sellIn -= 1
        if (item.sellIn < 0)
            decreaseQualityOf(item, 4)
        else
            decreaseQualityOf(item, 2)
    }
}
