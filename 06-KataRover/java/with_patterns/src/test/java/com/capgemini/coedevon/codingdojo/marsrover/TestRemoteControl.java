package com.capgemini.coedevon.codingdojo.marsrover;

import org.junit.Assert;
import org.junit.Test;

/**
 * jUnit Test Mars Rover
 */
public class TestRemoteControl {

  @Test
  public void trace_complex_path_results_correct_position() {

    Rover rover = new Rover();
    rover.sendCommand('F'); // 0,1,N
    rover.sendCommand('R'); // 0,1,E
    rover.sendCommand('F'); // 1,1,E
    rover.undoCommand(); // 0,1,E
    rover.sendCommand('L'); // 0,1,N
    rover.sendCommand('B'); // 0,0,N
    rover.sendCommand('B'); // 0,99,N
    rover.sendCommand('R'); // 0,99,E
    rover.sendCommand('L'); // 0,99,N
    rover.undoCommand(); // 0,99,E
    rover.sendCommand('L'); // 0,99,N
    rover.sendCommand('F'); // 0,0,N
    rover.undoCommand(); // 0,99,N
    rover.sendCommand('F'); // 0,0,N
    rover.sendCommand('L'); // 0,0,W
    rover.undoCommand(); // 0,0,N

    executeCommands(rover, 0, 0, 'N');

  }

  @Test
  public void turn_right_and_undo_results_initial_position() {

    Rover rover = new Rover();
    rover.sendCommand('R');
    rover.undoCommand();

    executeCommands(rover, 0, 0, 'N');

  }

  @Test
  public void turn_left_and_undo_results_initial_position() {

    Rover rover = new Rover();
    rover.sendCommand('L');
    rover.undoCommand();

    executeCommands(rover, 0, 0, 'N');

  }

  @Test
  public void back_and_undo_results_initial_position() {

    Rover rover = new Rover();
    rover.sendCommand('B');
    rover.undoCommand();

    executeCommands(rover, 0, 0, 'N');

  }

  @Test
  public void forward_and_undo_results_initial_position() {

    Rover rover = new Rover();
    rover.sendCommand('F');
    rover.undoCommand();

    executeCommands(rover, 0, 0, 'N');

  }

  @Test
  public void turn_left_fordward_backward_turn_right_results_initial_position() {

    Rover rover = new Rover();
    rover.sendCommand('L');
    rover.sendCommand('F');
    rover.sendCommand('B');
    rover.sendCommand('R');

    executeCommands(rover, 0, 0, 'N');

  }

  @Test
  public void backward_and_fordward_results_initial_position() {

    Rover rover = new Rover();
    rover.sendCommand('B');
    rover.sendCommand('F');

    executeCommands(rover, 0, 0, 'N');

  }

  @Test
  public void turn_left_fordward_results_exceeded_limits() {

    Rover rover = new Rover();
    rover.sendCommand('L');
    rover.sendCommand('F');

    executeCommands(rover, Point.LIMIT_X, 0, 'W');

  }

  @Test
  public void backward_results_exceeded_limits() {

    Rover rover = new Rover();
    rover.sendCommand('B');

    executeCommands(rover, 0, Point.LIMIT_Y, 'N');

  }

  @Test
  public void forward_turn_right_fordward_backward_turn_left_backward_results_initial_position_orientation() {

    Rover rover = new Rover();
    rover.sendCommand('F');
    rover.sendCommand('R');
    rover.sendCommand('F');
    rover.sendCommand('B');
    rover.sendCommand('L');
    rover.sendCommand('B');

    executeCommands(rover, 0, 0, 'N');

  }

  @Test
  public void forward_turn_right_fordward_results_translate_north_east_and_change_orientation() {

    Rover rover = new Rover();
    rover.sendCommand('F');
    rover.sendCommand('R');
    rover.sendCommand('F');

    executeCommands(rover, 1, 1, 'E');

  }

  @Test
  public void forward_and_turn_right_results_translate_north_and_change_orientation() {

    Rover rover = new Rover();
    rover.sendCommand('F');
    rover.sendCommand('R');

    executeCommands(rover, 0, 1, 'E');

  }

  @Test
  public void turn_right_twice_results_change_orientation_twice() {

    Rover rover = new Rover();
    rover.sendCommand('R');
    rover.sendCommand('R');

    executeCommands(rover, 0, 0, 'S');

  }

  @Test
  public void turn_left_twice_results_change_orientation_twice() {

    Rover rover = new Rover();
    rover.sendCommand('L');
    rover.sendCommand('L');

    executeCommands(rover, 0, 0, 'S');

  }

  @Test
  public void turn_right_results_change_orientation() {

    Rover rover = new Rover();
    rover.sendCommand('R');

    executeCommands(rover, 0, 0, 'E');

  }

  @Test
  public void turn_left_results_change_orientation() {

    Rover rover = new Rover();
    rover.sendCommand('L');

    executeCommands(rover, 0, 0, 'W');

  }

  @Test
  public void one_step_forward_results_translate_one_north() {

    Rover rover = new Rover();
    rover.sendCommand('F');

    executeCommands(rover, 0, 1, 'N');

  }

  @Test
  public void none_movements_results_initial_position() {

    Rover rover = new Rover();

    executeCommands(rover, 0, 0, 'N');
  }

  private void executeCommands(Rover rover, int x, int y, char direction) {

    Assert.assertEquals(x, rover.getPositionX());
    Assert.assertEquals(y, rover.getPositionY());
    Assert.assertEquals(direction, rover.getDirection());

  }

}
