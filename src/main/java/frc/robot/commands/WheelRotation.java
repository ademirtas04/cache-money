/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.WheelArm;

public class WheelRotation extends Command {
  private double startTime = 0;
  private boolean armMoved = false;
  public WheelRotation() {
    requires(Robot.wheelArm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(!(89.5 < WheelArm.getArmAngle() && WheelArm.getArmAngle() < 90)){
      WheelArm.armMove();
    } else{
      if(startTime == 0){
        startTime = Timer.getFPGATimestamp();
      }
      if(Timer.getFPGATimestamp() - startTime < RobotMap.TIME_FOR_ONE_ROTATION*4){
        WheelArm.wheelMove(0.75);
      } else {
        armMoved = true;
      }
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return armMoved;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("STOPPING");
    WheelArm.armReset();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
