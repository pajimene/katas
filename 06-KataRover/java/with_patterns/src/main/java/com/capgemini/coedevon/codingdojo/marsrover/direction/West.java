package com.capgemini.coedevon.codingdojo.marsrover.direction;

import com.capgemini.coedevon.codingdojo.marsrover.Point;

/**
 * @author pajimene
 *
 */
public class West implements Direction {

  private static Direction instance = null;

  public static Direction getInstance() {

    if (instance == null) {
      instance = new West();
    }

    return instance;
  }

  private West() {

  }

  @Override
  public char getDirection() {

    return 'W';
  }

  @Override
  public Direction turnLeft() {

    return South.getInstance();
  }

  @Override
  public Direction turnRight() {

    return North.getInstance();

  }

  @Override
  public void fordward(Point position) {

    position.translate(-1, 0);
  }

  @Override
  public void backward(Point position) {

    position.translate(1, 0);

  }

}
