package com.capgemini.coedevon.codingdojo.marsrover.direction;

/**
 * @author pajimene
 *
 */
public class East implements Direction {

  @Override
  public char getDirection() {

    return 'E';
  }

  @Override
  public Direction turnLeft() {

    return new North();
  }

  @Override
  public Direction turnRight() {

    return new South();

  }

}
