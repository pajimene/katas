package com.capgemini.coedevon.codingdojo.marsrover.commands;

import com.capgemini.coedevon.codingdojo.marsrover.Point;
import com.capgemini.coedevon.codingdojo.marsrover.direction.Direction;

/**
 * @author pajimene
 *
 */
public class TurnLeft extends Command {
  private static Command instance = null;

  public static Command getInstance() {

    if (instance == null) {
      instance = new TurnLeft();
    }

    return instance;
  }

  private TurnLeft() {

  }

  @Override
  public Direction execute(Point position, Direction direction) {

    return direction.turnLeft();
  }

  @Override
  public Direction undo(Point position, Direction direction) {

    return direction.turnRight();
  }
}
