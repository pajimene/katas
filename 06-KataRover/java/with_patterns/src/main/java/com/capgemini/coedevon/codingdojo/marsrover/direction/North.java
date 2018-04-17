package com.capgemini.coedevon.codingdojo.marsrover.direction;

import com.capgemini.coedevon.codingdojo.marsrover.Point;

/**
 * @author pajimene
 *
 */
public class North implements Direction {

  private static Direction instance = null;

  public static Direction getInstance() {

    if (instance == null) {
      instance = new North();
    }

    return instance;
  }

  private North() {

  }

  @Override
  public char getDirection() {

    return 'N';
  }

  @Override
  public Direction turnLeft() {

    return West.getInstance();
  }

  @Override
  public Direction turnRight() {

    return East.getInstance();

  }

  @Override
  public void fordward(Point position) {

    position.translate(0, 1);

  }

  @Override
  public void backward(Point position) {

    position.translate(0, -1);

  }

}
