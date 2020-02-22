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
  private static Encoder encoder = new Encoder(0, 1, true, EncodingType.k4X);
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
    lastTimeStamp = Timer.getFPGATimestamp();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (buttonInput == 0){
      setpoint = 6.9;
    }else if (buttonInput == 1) {
      setpoint = 5.75;
    }
    //get sensor position
    double sensorPosition = encoder.get() * RobotMap.kDriveTick2Feet;

    //calculations
    double error = setpoint - sensorPosition;
    if(error != 0){
      double dt = Timer.getFPGATimestamp() - lastTimeStamp;
      
      if(Math.abs(error) < RobotMap.iLimit){
        errorSum += error * dt;
      }

      double errorRate = (error - lastError) / dt; 

      double outputSpeed = RobotMap.kP * error + RobotMap.kI * errorSum + RobotMap.kD * errorRate;

      Climb.setMotor(outputSpeed);
      lastTimeStamp = Timer.getFPGATimestamp();
      lastError = error;
    } else {
      lifted = true;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return lifted;
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
