package com.capgemini.coedevon.codingdojo.gildedrose;

/**
 * @author pajimene
 *
 */
public class Halloween {

  private static final int MINIMUM_CHILDS = 2;

  public static final String THANK_YOU = "Thank you, stranger!";

  public static final String TRICK_OR_TREAT = "Trick or treat!";

  public String trickOrTreat(int childs, String[][] items) {

    if (childs < MINIMUM_CHILDS)
      return TRICK_OR_TREAT;

    if (items.length != childs)
      return TRICK_OR_TREAT;

    int candys = countCandys(items[0]);
    int maxCandys = candys;
    int minCandys = candys;

    for (int i = 1; i < childs; i++) {
      candys = countCandys(items[i]);

      maxCandys = Math.max(maxCandys, candys);
      minCandys = Math.min(minCandys, candys);
    }

    if (maxCandys < 2)
      return TRICK_OR_TREAT;

    if (maxCandys == minCandys)
      return THANK_YOU;

    return TRICK_OR_TREAT;

  }

  private int countCandys(String[] items) {

    int candys = 0;

    for (String item : items) {
      if ("candy".equals(item))
        candys++;
    }

    return candys;
  }

}
