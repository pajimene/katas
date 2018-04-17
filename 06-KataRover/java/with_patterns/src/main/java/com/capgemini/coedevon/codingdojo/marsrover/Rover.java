package com.capgemini.coedevon.codingdojo.marsrover;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.coedevon.codingdojo.marsrover.commands.Command;
import com.capgemini.coedevon.codingdojo.marsrover.direction.Direction;
import com.capgemini.coedevon.codingdojo.marsrover.direction.North;

/**
 * @author pajimene
 *
 */
public class Rover {

  private List<Command> commandHistory;

  private Point position;

  private Direction direction;

  public Rover() {
    this.commandHistory = new ArrayList<>();
    this.position = new Point();
    this.direction = North.getInstance();
  }

  public int getPositionX() {

    return this.position.getX();
  }

  /**
   * @return
   */
  public int getPositionY() {

    return this.position.getY();
  }

  /**
   * @return
   */
  public char getDirection() {

    return this.direction.getDirection();
  }

  /**
   * @param string
   */
  public void sendCommand(char charCommand) {

    Command command = Command.CreateCommand(charCommand);
    this.commandHistory.add(command);
    this.direction = command.execute(this.position, this.direction);

  }

  /**
   * @param string
   */
  public void undoCommand() {

    Command command = this.commandHistory.get(this.commandHistory.size() - 1);
    this.commandHistory.remove(this.commandHistory.size() - 1);

    this.direction = command.undo(this.position, this.direction);

  }

}
