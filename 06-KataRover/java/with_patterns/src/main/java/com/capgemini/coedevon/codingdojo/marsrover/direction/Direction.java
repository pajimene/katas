package com.capgemini.coedevon.codingdojo.marsrover.direction;

import com.capgemini.coedevon.codingdojo.marsrover.Point;

/**
 * @author pajimene
 *
 */
public interface Direction {

  char getDirection();

  Direction turnLeft();

  Direction turnRight();

  void fordward(Point position);

  void backward(Point position);

}
