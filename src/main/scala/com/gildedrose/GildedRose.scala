package com.gildedrose

import com.gildedrose.strategy.{BackstagePassesUpdate, CheeseUpdate, ConjuredItemUpdate, DefaultUpdate, LegendaryUpdate, UpdateStrategy}

class GildedRose(val items: Array[Item]) {
    private val AGED_BRIE = "Aged Brie"
    private val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
    private val SULFURAS = "Sulfuras, Hand of Ragnaros"

    private val LEGENDARY_ITEMS = List(SULFURAS)
    private val CHEESES = List(AGED_BRIE)

    def updateQuality() {
        items.foreach(item => applyStrategyFor(item))
    }

    private def applyStrategyFor(item: Item): Unit = {
        if (LEGENDARY_ITEMS.contains(item.name))
            LegendaryUpdate.update(item)

        else if (CHEESES.contains(item.name))
            CheeseUpdate.update(item)

        else if (item.name.equals(BACKSTAGE_PASSES))
            BackstagePassesUpdate.update(item)

        else if (item.name.toLowerCase.startsWith("conjured"))
            ConjuredItemUpdate.update(item)

        else
            DefaultUpdate.update(item)
    }
}
