package com.capgemini.coedevon.codingdojo.marsrover.direction;

import com.capgemini.coedevon.codingdojo.marsrover.Point;

/**
 * @author pajimene
 *
 */
public class East implements Direction {

  private static Direction instance = null;

  public static Direction getInstance() {

    if (instance == null) {
      instance = new East();
    }

    return instance;
  }

  private East() {

  }

  @Override
  public char getDirection() {

    return 'E';
  }

  @Override
  public Direction turnLeft() {

    return North.getInstance();
  }

  @Override
  public Direction turnRight() {

    return South.getInstance();

  }

  @Override
  public void fordward(Point position) {

    position.translate(1, 0);
  }

  @Override
  public void backward(Point position) {

    position.translate(-1, 0);

  }

}
