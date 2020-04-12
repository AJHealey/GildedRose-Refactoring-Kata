package com.gildedrose

import com.gildedrose.strategy.{BackstagePassesUpdate, CheeseUpdate, DefaultUpdate, LegendaryUpdate, UpdateStrategy}

class GildedRose(val items: Array[Item]) {
    private val AGED_BRIE = "Aged Brie"
    private val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
    private val SULFURAS = "Sulfuras, Hand of Ragnaros"

    private val CHEESES = List(AGED_BRIE)
    private val LEGENDARY = List(SULFURAS)

    def updateQuality() {
        for (item <- items) {
            if (item.name.equals(AGED_BRIE) ) {
                increaseQualityOf(item)
            }
            else if (item.name.equals(BACKSTAGE_PASSES)) {
                increaseQualityOf(item)

                if (item.sellIn < 11) {
                    increaseQualityOf(item)
                }

                if (item.sellIn < 6) {
                    increaseQualityOf(item)
                }
            }
            else if (!item.name.equals(SULFURAS)) {
                decreaseQualityOf(item)
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) {
                if (item.name.equals(AGED_BRIE)) {
                    increaseQualityOf(item)
                }
                else if (item.name.equals(BACKSTAGE_PASSES)) {
                    item.quality = 0
                }
                else if (!item.name.equals(SULFURAS)) {
                    decreaseQualityOf(item)
                }
            }
        }
    }

    private def getUpdateStrategy(item: Item): UpdateStrategy = item.name match {
        case SULFURAS => LegendaryUpdate
        case AGED_BRIE => CheeseUpdate
        case BACKSTAGE_PASSES => BackstagePassesUpdate
        case _ => DefaultUpdate
    }

    /**
     * Increase quality of an item by 1 if possible
     * Quality cannot exceed 50
     * @param item for which the quality will be increased
     */
    private def increaseQualityOf(item: Item): Unit = {
        if (item.quality < 50) item.quality += 1
    }

    /**
     * decrease quality of an item by 1 if possible
     * Quality cannot be less than 0
     * @param item for which the quality will be increased
     */
    private def decreaseQualityOf(item: Item): Unit = {
        if (item.quality > 0) item.quality -= 1
    }
}