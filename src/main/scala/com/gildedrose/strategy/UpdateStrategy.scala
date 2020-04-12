package com.gildedrose.strategy

import scala.math.{max, min}
import com.gildedrose.Item

abstract class UpdateStrategy {
    private val MAXIMUM_QUALITY = 50
    private val MINIMUM_QUALITY = 0

    def update(item: Item): Unit

    /**
     * Increase quality of an item by 1 if possible
     * Quality cannot exceed 50
     * @param item for which the quality will be increased
     */
    protected def increaseQualityOf(item: Item, value: Int = 1): Unit = {
        item.quality = min(MAXIMUM_QUALITY, item.quality + value)
    }

    /**
     * decrease quality of an item by 1 if possible
     * Quality cannot be less than 0
     * @param item for which the quality will be increased
     */
    protected def decreaseQualityOf(item: Item, value: Int = 1): Unit = {
        item.quality = max(MINIMUM_QUALITY, item.quality - value)
    }

}
