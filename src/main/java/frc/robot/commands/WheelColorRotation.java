/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Intake;

public class WheelColorRotation extends Command {
  private boolean armMoved;
  public WheelColorRotation() {
    armMoved = false;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Rotation Starting");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(armMoved == false){
      Intake.armMove();
      armMoved = true;
    }
    if(WheelColorIdentification.colorMatch() != false){
      System.out.println("Moving");  
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
    System.out.println("Stopped");
    Intake.armReset();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
