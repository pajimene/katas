package com.capgemini.coedevon.codingdojo.marsrover.direction;

import com.capgemini.coedevon.codingdojo.marsrover.Point;

/**
 * @author pajimene
 *
 */
public class South implements Direction {

  private static Direction instance = null;

  public static Direction getInstance() {

    if (instance == null) {
      instance = new South();
    }

    return instance;
  }

  private South() {

  }

  @Override
  public char getDirection() {

    return 'S';
  }

  @Override
  public Direction turnLeft() {

    return East.getInstance();
  }

  @Override
  public Direction turnRight() {

    return West.getInstance();
  }

  @Override
  public void fordward(Point position) {

    position.translate(0, -1);
  }

  @Override
  public void backward(Point position) {

    position.translate(0, 1);
  }

}
