package com.capgemini.coedevon.codingdojo.marsrover.direction;

/**
 * @author pajimene
 *
 */
public class South implements Direction {

  @Override
  public char getDirection() {

    return 'S';
  }

  @Override
  public Direction turnLeft() {

    return new East();
  }

  @Override
  public Direction turnRight() {

    return new West();
  }

}
