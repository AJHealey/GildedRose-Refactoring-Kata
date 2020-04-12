package com.gildedrose

class GildedRose(val items: Array[Item]) {
    private val AGED_BRIE = "Aged Brie"
    private val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
    private val SULFURAS = "Sulfuras, Hand of Ragnaros"



    def updateQuality() {
        for (item <- items) {
            if (item.name.equals(AGED_BRIE) || item.name.equals(BACKSTAGE_PASSES)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1

                    if (item.name.equals(BACKSTAGE_PASSES)) {
                        if (item.sellIn < 11) {
                            increaseQualityOf(item)
                        }

                        if (item.sellIn < 6) {
                            increaseQualityOf(item)
                        }
                    }
                }
            }
            else if (!item.name.equals(SULFURAS)) {
                decreaseQualityOf(item)
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(BACKSTAGE_PASSES)) {
                            if (!item.name.equals(SULFURAS)) {
                                decreaseQualityOf(item)
                            }

                    } else {
                        item.quality = 0
                    }
                } else {
                    increaseQualityOf(item)
                }
            }
        }
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