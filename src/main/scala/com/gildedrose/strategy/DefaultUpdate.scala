package com.gildedrose.strategy
import com.gildedrose.Item

object DefaultUpdate extends UpdateStrategy {
    override def update(item: Item): Unit = {
        item.sellIn -= 1
        decreaseQualityOf(item)
        if (item.sellIn < 0)
            decreaseQualityOf(item)
    }
}
