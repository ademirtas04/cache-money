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
import frc.robot.subsystems.DriveTrain;


public class TestEncoder extends Command {


  public static double startTime = 0;
  public static boolean done = false;
  public boolean initialized = false;
  public Encoder rightEncoder = new Encoder(RobotMap.ENCODER_RIGHT_MOTORS_A, RobotMap.ENCODER_RIGHT_MOTORS_B, true, EncodingType.k4X);
  public Encoder leftEncoder = new Encoder(RobotMap.ENCODER_LEFT_MOTORS_A, RobotMap.ENCODER_LEFT_MOTORS_B, true, EncodingType.k4X);
  public int direction=0;
  private double minsetpoint;
  private double maxsetpoint;
  private int iterations = 0;
  private double setpoint = 2;
  private double previousDistance = 0;
  private double distance = 0;
  private double rate = 0;
  private double lastTimestamp = 0;
  private double firstValue = 0;
  
  public TestEncoder(){
    System.out.println("Constructing");
    requires(Robot.driveTrain);

  }

  @Override
  public void start() {
  
  }

  @Override
  public void cancel(){
    Climb.getLiftMotor().set(ControlMode.PercentOutput, 0);
    leftEncoder.reset();
    rightEncoder.reset();
    super.cancel();
    //once we get to testing PID, set all the values here to 0
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

    //Test Two: Testing if encoder counts the absolute value of the distance traveled or is direction-based
    /*
    if(iterations < 10) {
      Climb.getLiftMotor().set(ControlMode.PercentOutput, 0.75); // remember to comment out the other set
    } else if (iterations < 20 && iterations >= 10) {
      Climb.getLiftMotor().set(ControlMode.PercentOutput, -0.75);
    
    */
  public void returnEncoderValues(){
    rightEncoder.setDistancePerPulse(1);
    leftEncoder.setDistancePerPulse(1);
    if(leftEncoder.getDistance() > -1.75 * RobotMap.CONVERSION_RATE){
      DriveTrain.move(0.2,0.2);                                                                                                                                                 
    }
    if(firstValue == 0) {
      firstValue = leftEncoder.getDistance();
    }
    //Test One: Testing if encoder counts revolutions, rate, and sees what the motor's -1.0 to 1.0 sets the velocity to
    if(!(leftEncoder.getStopped() && rightEncoder.getStopped())){
      System.out.println("Left Motor Distance Per Pulse: " + leftEncoder.getDistancePerPulse());
      System.out.println("Right Motor Distance Per Pulse: " + rightEncoder.getDistancePerPulse());
      System.out.println("Left Motor Distance: " + leftEncoder.getDistance());
      System.out.println("Right Motor Distance: " + rightEncoder.getDistance());
      System.out.println("First Value: " + firstValue); 
      System.out.println("Left Motor Rate: " + leftEncoder.getRate());
      System.out.println("Left Motor Rate: " + rightEncoder.getRate());
      System.out.println("Iterations: " + iterations);
    }
    if(rightEncoder.getStopped() && leftEncoder.getStopped()){
      System.out.println("STOPPED");
      System.out.println(leftEncoder.get());
      System.out.println(rightEncoder.get());     
    }

    //Test Three: Begin to use PID to simulate motion + movement - assuming it is not absolute value
    /*distance = liftEncoder.getDistance() * RobotMap.kDriveTick2Feet;

    rate = (distance - previousDistance) / (Timer.getFPGATimestamp() - lastTimestamp);
    lastTimestamp = Timer.getFPGATimestamp();

    //We can add the Integral term later - that one will need more knowledge of what we're doing and how encoders work
    double outputSpeed = RobotMap.kP * distance + RobotMap.kD * rate;
    Climb.getLiftMotor().set(ControlMode.PercentOutput, outputSpeed)
    distance = previousDistance;
    */
    iterations++;
  
  }

  public void resetEncoders(){
    leftEncoder.reset();
    rightEncoder.reset();
  }


}
