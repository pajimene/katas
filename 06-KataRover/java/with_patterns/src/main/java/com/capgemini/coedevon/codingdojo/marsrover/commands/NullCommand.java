package com.capgemini.coedevon.codingdojo.marsrover.commands;

import com.capgemini.coedevon.codingdojo.marsrover.Point;
import com.capgemini.coedevon.codingdojo.marsrover.direction.Direction;

/**
 * @author pajimene
 *
 */
public class NullCommand extends Command {
  private static Command instance = null;

  public static Command getInstance() {

    if (instance == null) {
      instance = new NullCommand();
    }

    return instance;
  }

  private NullCommand() {

  }

  @Override
  public Direction execute(Point position, Direction direction) {

    return direction;
  }

  @Override
  public Direction undo(Point position, Direction direction) {

    return direction;
  }
}
