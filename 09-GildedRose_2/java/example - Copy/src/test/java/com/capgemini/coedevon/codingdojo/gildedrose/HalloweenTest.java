package com.capgemini.coedevon.codingdojo.gildedrose;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author pajimene
 *
 */
public class HalloweenTest {

  @Test
  public void testNoChildren() {

    checkAssert(0, new String[][] {}, Halloween.TRICK_OR_TREAT);
    checkAssert(1, new String[][] {}, Halloween.TRICK_OR_TREAT);
  }

  @Test
  public void twoChildrenWithTwoCandys() {

    checkAssert(2, new String[][] { { "candy", "candy" }, { "candy", "candy" } }, Halloween.THANK_YOU);

  }

  @Test
  public void twoChildrenWithOneSet() {

    checkAssert(2, new String[][] { { "candy" } }, Halloween.TRICK_OR_TREAT);
    checkAssert(2, new String[][] { { "candy" }, {} }, Halloween.TRICK_OR_TREAT);

  }

  @Test
  public void twoChildrenWithOneCandy() {

    checkAssert(2, new String[][] { { "candy" }, { "candy" } }, Halloween.TRICK_OR_TREAT);

  }

  @Test
  public void twoChildrenWithTwoCandysAndMore() {

    checkAssert(2, new String[][] { { "candy", "candy" }, { "candy", null, "candy", "apple" } }, Halloween.THANK_YOU);

  }

  private void checkAssert(int childs, String[][] items, String expected) {

    Halloween halloween = new Halloween();
    String messageChilds = halloween.trickOrTreat(childs, items);

    Assert.assertEquals(expected, messageChilds);

  }

}
