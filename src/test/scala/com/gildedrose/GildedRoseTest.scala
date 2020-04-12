package com.gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GildedRoseTest  extends AnyFlatSpec with Matchers {
    "Common item" should "decrease in quality" in {
        val items = Array[Item](new Item("foo", 5, 3))
        val app = new GildedRose(items)
        app.updateQuality()
        app.items(0).name should equal ("foo")
        app.items(0).quality should equal (2)
        app.items(0).sellIn should equal (4)
    }

    it should "never decrease in quality below zero" in {
        val items = Array[Item](
            new Item("foo", 5, 0),
            new Item("bar", 0, 0))
        val app = new GildedRose(items)
        app.updateQuality()

        app.items(0).name should equal ("foo")
        app.items(0).quality should equal (0)
        app.items(0).sellIn should equal (4)

        app.items(1).name should equal ("bar")
        app.items(1).quality should equal (0)
        app.items(1).sellIn should equal (-1)
    }

    "Aged Brie" should "increase in quality by 1 before expiration" in {
        val items = Array[Item](new Item("Aged Brie", 5, 10))
        val app = new GildedRose(items)

        for(i <- 1 to 5) {
            app.updateQuality()
            app.items(0).quality should equal(10 + i)
            app.items(0).sellIn should equal(5 - i)
        }
    }

    it should "increase in quality by 2 after expiration" in {
        val items = Array[Item](new Item("Aged Brie", 0, 10))
        val app = new GildedRose(items)

        app.updateQuality()
        app.items(0).quality should equal(12)
        app.items(0).sellIn should equal(-1)
    }

    "Sulfuras" should "never decrease in any value" in {
        val items = Array[Item](new Item("Sulfuras, Hand of Ragnaros", 0, 80))
        val app = new GildedRose(items)

        app.updateQuality()
        app.items(0).quality should equal(80)
        app.items(0).sellIn should equal(0)
    }

    "Backstage passes" should "increases normally when sellin > 10" in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 15, 12))
        val app = new GildedRose(items)

        app.updateQuality()
        app.items(0).quality should equal(13)
        app.items(0).sellIn should equal(14)
    }

    it should "increase by 2 when sellin <= 10 but > 5" in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 10, 12))
        val app = new GildedRose(items)

        app.updateQuality()
        app.items(0).quality should equal(14)
        app.items(0).sellIn should equal(9)
    }

    it should "increase by 3 when sellin <= 5 but > 0" in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 5, 12))
        val app = new GildedRose(items)

        app.updateQuality()
        app.items(0).quality should equal(15)
        app.items(0).sellIn should equal(4)
    }

    it should "drop to zero after the concert" in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 0, 15))
        val app = new GildedRose(items)

        app.updateQuality()
        app.items(0).quality should equal(0)
        app.items(0).sellIn should equal(-1)
    }

}