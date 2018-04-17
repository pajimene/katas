package com.capgemini.coedevon.codingdojo.marsrover;

/**
 * @author pajimene
 *
 */
public class Point {
  public final static int LIMIT_Y = 99;

  public final static int LIMIT_X = 99;

  private int x;

  private int y;

  public Point() {
    this.x = 0;
    this.y = 0;
  }

  public void translate(int deltaX, int deltaY) {

    this.x += deltaX;
    this.y += deltaY;

    checkExceededLimits();
  }

  /**
  *
  */
  private void checkExceededLimits() {

    if (this.x < 0)
      this.x += LIMIT_X + 1;
    else if (this.y < 0)
      this.y += LIMIT_Y + 1;
    if (this.x > LIMIT_X)
      this.x -= LIMIT_X + 1;
    else if (this.y > LIMIT_Y)
      this.y -= LIMIT_Y + 1;

  }

  public int getX() {

    return this.x;
  }

  public int getY() {

    return this.y;
  }
}
