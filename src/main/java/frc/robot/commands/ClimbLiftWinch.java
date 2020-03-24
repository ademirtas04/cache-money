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

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


public class ClimbLiftWinch extends Command {


  public static double startTime = 0;
  public static boolean done = false;
  private VictorSPX liftMotor;
  private VictorSPX winchMotor;
  private double direction = 0;
  public ClimbLiftWinch(VictorSPX liftMotor, VictorSPX winchMotor, int d){
    System.out.println("Constructing");
    this.liftMotor = liftMotor;
    this.winchMotor = winchMotor;  
    this.direction = d;
    requires(Robot.timeClimb);

  }

  // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Initialize: Begin");
    System.out.println("Initialize: Lift Motor = " + liftMotor.getDeviceID());
    System.out.println("Initialize: Winch Motor = " + winchMotor.getDeviceID());
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
    if (Timer.getFPGATimestamp() - startTime < 4.5){
      setSpeed(1.0 * direction);
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

  protected void setSpeed(double speed){
    this.winchMotor.set(ControlMode.PercentOutput, -0.63 * speed);
  }

}
