package com.capgemini.coedevon.codingdojo.marsrover.commands;

import com.capgemini.coedevon.codingdojo.marsrover.Point;
import com.capgemini.coedevon.codingdojo.marsrover.direction.Direction;

/**
 * @author pajimene
 *
 */
public abstract class Command {

  public abstract Direction execute(Point position, Direction direction);

  public abstract Direction undo(Point position, Direction direction);

  /**
   * @param charCommand
   * @return
   */
  public static Command CreateCommand(char charCommand) {

    switch (charCommand) {
      case 'F':
        return Fordward.getInstance();
      case 'B':
        return Backward.getInstance();
      case 'L':
        return TurnLeft.getInstance();
      case 'R':
        return TurnRight.getInstance();
      default:
        return NullCommand.getInstance();
    }

  }
}
