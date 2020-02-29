/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.subsystems.Climb;


public class ClimbTestWinch extends Command {


  //private static Encoder encoder = new Encoder(RobotMap.ENCODER1_PORT_A, RobotMap.ENCODER1_PORT_B, true, EncodingType.k4X);
  public static double startTime = 0;
  public static boolean done = false;
  private Encoder encoder;
  private VictorSPX motor;
  private int direction=0;
  private double setpoint;
  private double timeout;
  public ClimbTestWinch(Encoder encoder, VictorSPX motor, int d, double setpoint, double timeout){
    System.out.println("Constructing");
    this.encoder = encoder;
    this.motor = motor;
    if(d==0){
      encoder.reset();
    } else {
      this.direction = d;
    }
    this.setpoint = setpoint;
    this.timeout = timeout;
    
    requires(Robot.winchClimb);

  }

  // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Initialize: Begin");
    System.out.println("Initialize: Motor = " + motor.getDeviceID());
    //encoder.reset();
    startTime = Timer.getFPGATimestamp(); 
    System.out.println("Initialize: Start Time = " + startTime);
    done=false;  
    System.out.println("Initialize: Done");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("Execute: Current Time = " +  Timer.getFPGATimestamp());
    System.out.println("Execute: Start Time = " + startTime);
    if (Timer.getFPGATimestamp() - startTime < timeout && Math.abs(encoder.get() * RobotMap.kDriveTick2Feet) < setpoint){
      System.out.println("Execute: Encoder value = " + encoder.get() * RobotMap.kDriveTick2Feet);
      setSpeed(1 * direction);
    } else {
      System.out.println("Execute: Setting done to true");
      done = true;
    }
  }
  @Override
  protected boolean isFinished() {
    System.out.println("isFinished: done = " + done);
    return done;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("End: done");
    setSpeed(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

  //Helper methods
  protected void setSpeed(double speed){
    this.motor.set(ControlMode.PercentOutput, speed);
  }
  
}
