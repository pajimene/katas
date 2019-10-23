package com.capgemini.coedevon.codingdojo.gildedrose;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ConjuredItemTest extends AbstractGildedRoseTest {

  protected static final String CONJURED_ITEM = "Conjured";

  @Test
  public void conjuredDecreaseQualityTwoPerDay() {

    testItemQuality(CONJURED_ITEM, 10, 10, -2);

  }

  @Test
  public void conjuredDecreaseQualityTwoPerDayOnExpired() {

    testItemQuality(CONJURED_ITEM, 0, 10, -2);

  }

}
