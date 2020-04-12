package com.gildedrose.strategy
import com.gildedrose.Item

object CheeseUpdate extends UpdateStrategy {
    override def update(item: Item): Unit = {
        item.sellIn -= 1

        if (item.sellIn < 0)
            increaseQualityOf(item, 2)
        else
            increaseQualityOf(item)
    }
}
