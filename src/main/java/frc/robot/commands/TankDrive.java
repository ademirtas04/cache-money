/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
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
  // variables and mapping out buttons for the controller when it starts
  public void initialize() {

  }

  //variables and mapping out buttons called 50 times per second
  @Override
  public void execute() {

  }
  // When the stop button is hit, the motors turn off
  @Override
  public void end() {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public static void move(double left, double right){
    DriveTrain.setLeftMotors(left);
    DriveTrain.setRightMotors(right);
  }

}
