package com.capgemini.coedevon.codingdojo.gildedrose;

class GildedRose {
  private static final int TRIPLE_THRESHOLD_QUALITY = 5;

  private static final int DOUBLE_THRESHOLD_QUALITY = 10;

  private static final int MAX_QUALITY = 50;

  private static final int MIN_QUALITY = 0;

  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

  private static final String AGED_BRIE = "Aged Brie";

  private static final String CONJURED = "Conjured";

  Item[] items;

  public GildedRose(Item[] items) {

    this.items = items;
  }

  public void updateQuality() {

    for (int i = 0; i < this.items.length; i++) {

      Item item = this.items[i];

      updateQuality(item);

      updateSellIn(item);

      updateQualityIfExpired(item);
    }
  }

  /**
   * @param item
   */
  private void updateQualityIfExpired(Item item) {

    boolean expired = item.getSellIn() < 0;
    if (!expired)
      return;

    if (isAgedBrie(item)) {
      increaseQuality(item);
    }

    else if (isPasses(item)) {
      setZeroQuality(item);
    }

    else if (isNotConjured(item)) {
      decreaseQuality(item);
    }
  }

  private void updateSellIn(Item item) {

    if (isSulfuras(item))
      return;

    decreaseSellIn(item);
  }

  /**
   * @param item
   */
  private void updateQuality(Item item) {

    if (isSulfuras(item))
      return;

    if (isPasses(item)) {
      updateQualityPasses(item);
    }

    else if (isAgedBrie(item)) {
      increaseQuality(item);
    }

    else if (isConjured(item)) {

      updateQualityConjured(item);
    }

    else {
      decreaseQuality(item);
    }
  }

  private void updateQualityConjured(Item item) {

    decreaseQuality(item);
    decreaseQuality(item);
  }

  private void updateQualityPasses(Item item) {

    boolean belowDoubleThresholdQuality = item.getSellIn() <= DOUBLE_THRESHOLD_QUALITY;
    boolean belowTripleThresholdQuality = item.getSellIn() <= TRIPLE_THRESHOLD_QUALITY;

    increaseQuality(item);

    if (isPasses(item)) {
      if (belowDoubleThresholdQuality) {
        increaseQuality(item);
      }

      if (belowTripleThresholdQuality) {
        increaseQuality(item);
      }
    }
  }

  private boolean isSulfuras(Item item) {

    boolean isNotSulfuras = item.getName().equals(SULFURAS);
    return isNotSulfuras;
  }

  private boolean isNotConjured(Item item) {

    boolean isNotConjured = !isConjured(item);
    return isNotConjured;
  }

  private boolean isConjured(Item item) {

    boolean isConjured = item.getName().equals(CONJURED);
    return isConjured;
  }

  private boolean isPasses(Item item) {

    boolean isPasses = item.getName().equals(BACKSTAGE_PASSES);
    return isPasses;
  }

  private boolean isAgedBrie(Item item) {

    return !isNotAgedBrie(item);
  }

  private boolean isNotAgedBrie(Item item) {

    boolean isNotAgedBrie = !item.getName().equals(AGED_BRIE);
    return isNotAgedBrie;
  }

  private void decreaseQuality(Item item) {

    boolean notMinQuality = item.getQuality() > MIN_QUALITY;

    if (notMinQuality) {
      item.setQuality(item.getQuality() - 1);
    }
  }

  private void increaseQuality(Item item) {

    boolean notMaxQuality = item.getQuality() < MAX_QUALITY;
    if (notMaxQuality) {
      item.setQuality(item.getQuality() + 1);
    }
  }

  private void decreaseSellIn(Item item) {

    item.setSellIn(item.getSellIn() - 1);
  }

  private void setZeroQuality(Item item) {

    item.setQuality(item.getQuality() - item.getQuality());
  }
}
