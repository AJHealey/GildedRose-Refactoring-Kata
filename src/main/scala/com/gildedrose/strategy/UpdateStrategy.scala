package com.gildedrose.strategy

import com.gildedrose.Item

abstract class UpdateStrategy {
    def update(item: Item): Unit

    /**
     * Increase quality of an item by 1 if possible
     * Quality cannot exceed 50
     * @param item for which the quality will be increased
     */
    protected def increaseQualityOf(item: Item): Unit = {
        if (item.quality < 50) item.quality += 1
    }

    /**
     * decrease quality of an item by 1 if possible
     * Quality cannot be less than 0
     * @param item for which the quality will be increased
     */
    protected def decreaseQualityOf(item: Item): Unit = {
        if (item.quality > 0) item.quality -= 1
    }

}
