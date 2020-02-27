/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.subsystems.Climb;


public class ClimbPullUp extends Command {


  private static double setpoint = 0;
  private static Encoder encoder = new Encoder(RobotMap.ENCODER1_PORT_A, RobotMap.ENCODER1_PORT_B, true, EncodingType.k4X);
  public static double lastTimeStamp = 0;
  public static double lastError = 0;
  public static double errorSum = 0;
  public static int buttonInput = 0;
  public static boolean lifted = false;
  public ClimbPullUp(int i){
    ClimbPullUp.buttonInput = i;
    requires(Robot.climb);

  }

  // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    encoder.reset();
    errorSum = 0;
    lastError = 0;
    if (buttonInput == 0){
      setpoint = 6.9;
    }else if (buttonInput == 1) {
      setpoint = 5.75;
    }
    lastTimeStamp = Timer.getFPGATimestamp();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  if(encoder.get() * RobotMap.kDriveTick2Feet < setpoint){
    Climb.setClimbs(0.5);
  } else {
    lifted = true;
  }

  }
  @Override
  protected boolean isFinished() {
    return lifted;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    while(encoder.get() * RobotMap.kDriveTick2Feet  > 0) {
      Climb.setClimbs(-0.5);  
    }

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
  
}
