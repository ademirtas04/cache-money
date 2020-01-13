/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import frc.robot.RobotMap;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveTrain;

public class NewMove extends Command {
  double m_time,  m_lSpeed, m_rSpeed;

  /**
   * Creates a new NewMove.
   */
  public NewMove(double time, double lSpeed, double rSpeed) {
    m_time = time;
    m_lSpeed=lSpeed;
    requires(Robot.driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

 


  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.driveTrain.setLeftMotors(m_lSpeed);
    Robot.driveTrain.setRightMotors(m_rSpeed);
    setTimeout(m_time);
  }

 

 

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interruoted.
  @Override
  public void end() {
    Robot.driveTrain.setLeftMotors(0);
    Robot.driveTrain.setRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isTimedOut();
    
  }
}
