package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	
	
	@Test
	public void exampleTest() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by one
		assertEquals("Failed quality for Dexterity Vest", 19, quality);
	}
	
	@Test
    public void testNormalItemQualityDecreaseAfterSellIn() {
        GildedRose gildedRose = new GildedRose();
        Item normalItem = new Item("+5 Dexterity Vest", 0, 20);
        gildedRose.setItem(normalItem);

        gildedRose.oneDay();

        assertEquals(18, normalItem.getQuality());
    }
	
	@Test
    public void testAgedBrieQualityIncrease() {
        GildedRose gildedRose = new GildedRose();
        Item agedBrie = new Item("Aged Brie", 2, 0);
        gildedRose.setItem(agedBrie);

        gildedRose.oneDay();

        assertEquals(1, agedBrie.getQuality());
    }
	
	@Test
    public void testSulfurasQualityUnchanged() {
        GildedRose gildedRose = new GildedRose();
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        gildedRose.setItem(sulfuras);

        gildedRose.oneDay();

        assertEquals(80, sulfuras.getQuality());
    }
	
	@Test
    public void testBackstagePassesQualityIncrease() {
        GildedRose gildedRose = new GildedRose();
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        gildedRose.setItem(backstagePasses);

        gildedRose.oneDay();

        assertEquals(21, backstagePasses.getQuality());
    }

    @Test
    public void testBackstagePassesQualityIncrease10Days() {
        GildedRose gildedRose = new GildedRose();
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        gildedRose.setItem(backstagePasses);

        gildedRose.oneDay();

        assertEquals(22, backstagePasses.getQuality());
    }
    
    @Test
    public void testBackstagePassesQualityIncrease4Days() {
        GildedRose gildedRose = new GildedRose();
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20);
        gildedRose.setItem(backstagePasses);

        gildedRose.oneDay();

        assertEquals(23, backstagePasses.getQuality());
    }
    
    @Test
    public void testBackstageConcert() {
        GildedRose gildedRose = new GildedRose();
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20);
        gildedRose.setItem(backstagePasses);

        gildedRose.oneDay();

        assertEquals(0, backstagePasses.getQuality());
    }
    
    
    @Test
    public void testAgedBriedSelInnLessthanzero() {
    	GildedRose gildedRose = new GildedRose();
    	Item agedBried = new Item("Aged Brie", -1, 30);
    	gildedRose.setItem(agedBried);
    	gildedRose.oneDay();
    	
    	assertEquals(32, agedBried.getQuality());
    }

    @Test
    public void testAgedBrieMaxQualityNotExceeded() {
        GildedRose gildedRose = new GildedRose();
        Item agedBrie = new Item("Aged Brie", 5, 50);
        gildedRose.setItem(agedBrie);

        gildedRose.oneDay();

        assertEquals(50, agedBrie.getQuality());
    }

    @Test
    public void testConjuredItemQualityNeverNegative() {
        GildedRose gildedRose = new GildedRose();
        Item conjuredItem = new Item("Conjured Mana Cake", 5, 0);
        gildedRose.setItem(conjuredItem);

        gildedRose.oneDay();

        assertEquals(0, conjuredItem.getQuality());
    }

    @Test
    public void testConjuredItemQualityDecreaseAfterSellInToZero() {
        GildedRose gildedRose = new GildedRose();
        Item conjuredItem = new Item("Conjured Mana Cake", 0, 1);
        gildedRose.setItem(conjuredItem);

        gildedRose.oneDay();

        assertEquals(0, conjuredItem.getQuality());
    }
    
    // task 3 loop testing
    @Test
    public void testUpdateQuality_QualityLessThan50() {
        GildedRose gildedRose = new GildedRose();
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        gildedRose.setItem(item);

        gildedRose.oneDay();

        assertTrue(item.getQuality() <= 50);
    }
    
    @Test
    public void testUpdateQuality_QualityLessThan50test2() {
        GildedRose gildedRose = new GildedRose();
        Item item = new Item("Aged Brie", -1, 49);
        gildedRose.setItem(item);

        gildedRose.oneDay();

        assertTrue(item.getQuality() < 51 );
        
    }
    
    
    @Test
    public void testUpdateQuality_QualityAlways80() {
        GildedRose gildedRose = new GildedRose();
        Item item = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        gildedRose.setItem(item);

        gildedRose.oneDay();

        assertEquals(80 ,item.getQuality());
    }
}
