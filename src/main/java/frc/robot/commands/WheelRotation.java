/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.subsystems.Intake;

public class WheelRotation extends Command {
  private double startTime;
  private double currentTime;
  private double r;
  private boolean armMoved;
  public WheelRotation(double rotations) {
    this.r = rotations;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(this.armMoved == false){
      Intake.armMove();
      this.armMoved = true;
    }
    currentTime = Timer.getFPGATimestamp();
    if(currentTime - startTime < RobotMap.SINGLE_ROTATION_TIME*this.r){
      System.out.println("MOVING");
    } else {
      this.end();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("STOPPING");
    Intake.armReset();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
