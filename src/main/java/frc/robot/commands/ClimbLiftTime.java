/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Climb;


public class ClimbLiftTime extends Command {


  public static double startTime = 0;
  public static boolean done = false;
  private VictorSPX liftMotor;
  private VictorSPX winchMotor;
  private double timeout;
  private double direction = 0;
  public ClimbLiftTime(VictorSPX liftMotor, VictorSPX winchMotor, int d, double timeout){
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
    double currentTime = Timer.getFPGATimestamp();
    System.out.println("Execute: Current Time = " +  currentTime);
    if (currentTime - startTime < timeout){
      Climb.setSpeed(1.0 * direction, winchMotor, liftMotor);
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
    Climb.setSpeed(0, this.winchMotor, this.liftMotor);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

}
