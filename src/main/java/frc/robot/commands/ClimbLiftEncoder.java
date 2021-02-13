/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.subsystems.Climb;


public class ClimbLiftEncoder extends Command {


  //private static Encoder encoder = new Encoder(RobotMap.ENCODER1_PORT_A, RobotMap.ENCODER1_PORT_B, true, EncodingType.k4X);
  public static double startTime = 0;
  public static boolean done = false;
  private Encoder liftEncoder;
  
  private Encoder winchEncoder;
  private VictorSPX liftMotor;
  private VictorSPX winchMotor;
  private int direction=0;
  private double minsetpoint;
  private double maxsetpoint;
  public ClimbLiftEncoder(Encoder encoder1, Encoder encoder2, VictorSPX lift, VictorSPX winch, int d, double minsetpoint, double maxsetpoint){
    System.out.println("Constructing");
  liftEncoder.setDistancePerPulse(1./2048.); //sets distance to 1 rotation per 2048 pulses(1 encoder rotation)
  liftEncoder.setMaxPeriod(.1);
  liftEncoder.setMinRate(10);
  liftEncoder.setSamplesToAverage(5);
    this.liftEncoder = encoder1;
    this.winchEncoder = encoder2;
    this.liftMotor = lift;
    this.winchMotor = winch;
    if(d==0){
      liftEncoder.reset();
      winchEncoder.reset();
    } else {
      this.direction = d;
    }
    this.minsetpoint = minsetpoint;
    this.maxsetpoint = maxsetpoint;
    
    requires(Robot.encoderClimb);

  }

  // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Initialize: Begin");
    System.out.println("Initialize: Winch Motor = " + winchMotor.getDeviceID());
    System.out.println("Initialize: Lift Motor = " + liftMotor.getDeviceID());
    liftEncoder.reset();
    System.out.println("Initialize: Start Time = " + startTime);
    done=false;  
    System.out.println("Initialize: Done");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("Execute: Start Time = " + startTime);
    //System.out.println("Execute: Winch Encoder value = " + winchEncoder.get() * RobotMap.kDriveTick2Feet);
  System.out.println("Execute: Lift Encoder value = " + liftEncoder.getDistance());//liftEncoder.get() * RobotMap.kDriveTick2Feet);
  /*
    if(Math.abs(liftEncoder.get() - winchEncoder.get()) < 0.1 && ((direction == 1 && winchEncoder.get() * RobotMap.kDriveTick2Feet < maxsetpoint) || (direction == -1 && winchEncoder.get() * RobotMap.kDriveTick2Feet > minsetpoint))){
       Climb.setSpeed(1 * direction, winchMotor, liftMotor);
    } else {
      System.out.println("Execute: Setting done to true");
      done = true;
    }
  */
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
    Climb.setSpeed(0, winchMotor,liftMotor);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }  
}
