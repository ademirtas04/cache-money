/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.pixy.Pixy2;
import frc.robot.pixy.links.I2CLink;
import frc.robot.pixy.links.Link;

public class WheelColorIdentification extends Command {
  Link i2c = new I2CLink();
  Pixy2 cam = new Pixy2(i2c);
  public WheelColorIdentification() {
    

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    cam.getCCC();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    cam.getCCC();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }
  // Called once after isFinished returns true
  @Override
  protected void end() {
    cam.close();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
