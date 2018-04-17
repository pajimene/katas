package com.capgemini.coedevon.codingdojo.marsrover.direction;

/**
 * @author pajimene
 *
 */
public class North implements Direction {

  @Override
  public char getDirection() {

    return 'N';
  }

  @Override
  public Direction turnLeft() {

    return new West();
  }

  @Override
  public Direction turnRight() {

    return new East();

  }

}
