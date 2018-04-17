package com.capgemini.coedevon.codingdojo.marsrover.direction;

/**
 * @author pajimene
 *
 */
public class West implements Direction {

  @Override
  public char getDirection() {

    return 'W';
  }

  @Override
  public Direction turnLeft() {

    return new South();
  }

  @Override
  public Direction turnRight() {

    return new North();

  }

}
