/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Intake;

public class Autonomous extends Command {
  //declareing variables
  private static double setpoint = 0;
  private static Encoder encoder = new Encoder(0, 1, true, EncodingType.k4X);
  public static double lastTimeStamp = 0;
  public static double lastError = 0;
  public static double errorSum = 0;
  
  public Autonomous() {
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //This line allows the timer to start when we hit start autonomous and not when we first deploy the code
  }

  // Called repeatedly when this Command is scheduled to run
  @Override

  public void execute() {

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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

  public static void autoStart(){
    encoder.reset();
    errorSum = 0;
    lastError = 0;
    lastTimeStamp = Timer.getFPGATimestamp();
  }
  
  public static void autoLine(int buttonInput){
    if (buttonInput == 0){
      setpoint = 10;
    }else if (buttonInput == 1) {
      setpoint = 0;
    }
    //get sensor position
    double sensorPosition = encoder.get() * RobotMap.kDriveTick2Feet;

    //calculations
    double error = setpoint - sensorPosition;
    double dt = Timer.getFPGATimestamp() - lastTimeStamp;
    
    if(Math.abs(error) < RobotMap.iLimit){
      errorSum += error * dt;
    }

    double errorRate = (error - lastError) / dt; 

    double outputSpeed = RobotMap.kP * error + RobotMap.kI * errorSum + RobotMap.kD * errorRate;
    //output to motors
    TankDrive.move(outputSpeed, -outputSpeed);
    lastTimeStamp = Timer.getFPGATimestamp();
    lastError = error;
  }

  public static void autoSequence(){
    autoLine(0);
    double startTime = Timer.getFPGATimestamp();
    Intake.IntakeMove();
    while(Timer.getFPGATimestamp() - startTime < 5){
    }
    Intake.IntakeReset();
    autoLine(1);
  }
}
