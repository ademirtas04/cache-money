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
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Intake;

public class ArmDump extends Command {
  private double startTime;
  
  public ArmDump() {
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override

  public void execute() {
    Arm.armMove();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Timer.getFPGATimestamp() - startTime > RobotMap.CONSTANT_ARM_TIMER || Intake.getAngle() == RobotMap.IDEAL_DUMP_ANGLE){
      return true;
    } else {
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

}
