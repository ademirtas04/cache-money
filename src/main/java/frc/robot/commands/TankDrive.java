/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class TankDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  public TankDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      double leftStickY = Robot.m_oi.getDriverRawAxis(RobotMap.LEFT_STICK_Y);
      double rightStickY = Robot.m_oi.getDriverRawAxis(RobotMap.RIGHT_STICK_Y);

      Robot.driveTrain.setLeftMotors(leftStickY);
      Robot.driveTrain.setRightMotors(rightStickY);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
<<<<<<< HEAD
    double JoystickY = Robot.m_oi.getDriverRawAxis(RobotMap.JOYSTICK_Y);

    Robot.driveTrain.setLeftMotors(JoystickY);
    Robot.driveTrain.setRightMotors(JoystickY);
}
=======
  }
>>>>>>> parent of 9f7856d... COMPLETED DRIVETRAIN

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      Robot.driveTrain.setLeftMotors(0);
      Robot.driveTrain.setRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
