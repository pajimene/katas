package com.capgemini.coedevon.codingdojo.marsrover.commands;

import com.capgemini.coedevon.codingdojo.marsrover.Point;
import com.capgemini.coedevon.codingdojo.marsrover.direction.Direction;

/**
 * @author pajimene
 *
 */
public class Backward extends Command {
  private static Command instance = null;

  public static Command getInstance() {

    if (instance == null) {
      instance = new Backward();
    }

    return instance;
  }

  private Backward() {

  }

  @Override
  public Direction execute(Point position, Direction direction) {

    direction.backward(position);
    return direction;
  }

  @Override
  public Direction undo(Point position, Direction direction) {

    direction.fordward(position);
    return direction;
  }

}
