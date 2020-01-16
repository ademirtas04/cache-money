/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command that uses an example subsystem.
 */
public class TankDrive extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  public TankDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    requires(Robot.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      double speed = -Robot.m_oi.getDriverRawAxis(RobotMap.LEFT_STICK_Y);
      double turn = Robot.m_oi.getDriverRawAxis(RobotMap.RIGHT_STICK_X);

      double left = speed + turn;
      double right = speed - turn;

      Robot.driveTrain.setLeftMotors(left);
      Robot.driveTrain.setRightMotors(-right);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = -Robot.m_oi.getDriverRawAxis(RobotMap.LEFT_STICK_Y);
    double turn = Robot.m_oi.getDriverRawAxis(RobotMap.RIGHT_STICK_X);

     double left = speed + turn;
     double right = speed - turn;

     Robot.driveTrain.setLeftMotors(left);
     Robot.driveTrain.setRightMotors(-right);

  }
  // Called once the command ends or is interrupted.
  @Override
  public void end() {
      Robot.driveTrain.setLeftMotors(0);
      Robot.driveTrain.setRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
