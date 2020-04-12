package com.gildedrose.strategy
import com.gildedrose.Item

object CheeseUpdate extends UpdateStrategy {
    override def update(item: Item): Unit = {
        item.sellIn -= 1
        increaseQualityOf(item)
        if (item.sellIn < 0)
            increaseQualityOf(item)
    }
}
