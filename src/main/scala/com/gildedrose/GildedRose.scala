package com.gildedrose

import com.gildedrose.strategy.{BackstagePassesUpdate, CheeseUpdate, DefaultUpdate, LegendaryUpdate, UpdateStrategy}

class GildedRose(val items: Array[Item]) {
    private val AGED_BRIE = "Aged Brie"
    private val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
    private val SULFURAS = "Sulfuras, Hand of Ragnaros"

    def updateQuality() {
        items.foreach(item => applyStrategyFor(item))
    }

    private def applyStrategyFor(item: Item): Unit = item.name match {
        case SULFURAS => LegendaryUpdate.update(item)
        case AGED_BRIE => CheeseUpdate.update(item)
        case BACKSTAGE_PASSES => BackstagePassesUpdate.update(item)
        case _ => DefaultUpdate.update(item)
    }
}
