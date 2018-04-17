package com.capgemini.coedevon.codingdojo.marsrover;

/**
 * @author pajimene
 *
 */
public class Rover {

  public final static int LIMIT_Y = 99;

  public final static int LIMIT_X = 99;

  private int y = 0;

  private int x = 0;

  private char direction = 'N';

  public int getPositionX() {

    return this.x;
  }

  /**
   * @return
   */
  public int getPositionY() {

    return this.y;
  }

  /**
   * @return
   */
  public char getDirection() {

    return this.direction;
  }

  /**
   * @param string
   */
  public void sendCommand(char command) {

    if (command == 'F')
      fordward();
    else if (command == 'B')
      backward();
    else if (command == 'L')
      turnLeft();
    else if (command == 'R')
      turnRight();

  }

  private void backward() {

    switch (this.direction) {
      case 'N':
        this.y--;
        break;
      case 'E':
        this.x--;
        break;
      case 'S':
        this.y++;
        break;
      case 'W':
        this.x++;
        break;
    }

    checkExceededLimits();
  }

  /**
   *
   */
  private void checkExceededLimits() {

    if (this.x < 0)
      this.x += LIMIT_X + 1;
    else if (this.y < 0)
      this.y += LIMIT_Y + 1;
    if (this.x > LIMIT_X)
      this.x -= LIMIT_X + 1;
    else if (this.y > LIMIT_Y)
      this.y -= LIMIT_Y + 1;

  }

  private void fordward() {

    switch (this.direction) {
      case 'N':
        this.y++;
        break;
      case 'E':
        this.x++;
        break;
      case 'S':
        this.y--;
        break;
      case 'W':
        this.x--;
        break;
    }

    checkExceededLimits();
  }

  private void turnRight() {

    switch (this.direction) {
      case 'N':
        this.direction = 'E';
        break;
      case 'E':
        this.direction = 'S';
        break;
      case 'S':
        this.direction = 'W';
        break;
      case 'W':
        this.direction = 'N';
        break;
    }
  }

  private void turnLeft() {

    switch (this.direction) {
      case 'N':
        this.direction = 'W';
        break;
      case 'W':
        this.direction = 'S';
        break;
      case 'S':
        this.direction = 'E';
        break;
      case 'E':
        this.direction = 'N';
        break;
    }
  }

}
