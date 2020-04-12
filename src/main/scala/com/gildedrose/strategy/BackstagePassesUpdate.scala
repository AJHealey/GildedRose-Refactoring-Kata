package com.gildedrose.strategy
import com.gildedrose.Item

object BackstagePassesUpdate extends UpdateStrategy {
    override def update(item: Item): Unit = {
        item.sellIn -= 1

        if (item.sellIn < 0)
            item.quality = 0

        else {
            increaseQualityOf(item)

            if (item.sellIn < 10)
                increaseQualityOf(item)

            if (item.sellIn < 5)
                increaseQualityOf(item)

        }
    }
}
