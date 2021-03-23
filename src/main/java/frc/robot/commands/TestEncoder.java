/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;

import java.lang.reflect.Array;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.IntArraySerializer;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.RobotMap;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.SerialPort;
import java.util.Arrays;


public class TestEncoder extends Command {


  public static double startTime = 0;
  public static boolean done = false;
  public boolean initialized = false;
  public Encoder rightEncoder = new Encoder(RobotMap.ENCODER_RIGHT_MOTORS_A, RobotMap.ENCODER_RIGHT_MOTORS_B, true, EncodingType.k4X);
  public Encoder leftEncoder = new Encoder(RobotMap.ENCODER_LEFT_MOTORS_A, RobotMap.ENCODER_LEFT_MOTORS_B, true, EncodingType.k4X);
  public Boolean[] boolArray = new Boolean[50];
  public int direction=0;
  private int iterations = 0;
  private double firstValue = 0;
  public PIDController turnController;
  public double rotateToAngleRate;
  public AHRS ahrs;
  public int step = 0;
  static final double kP = 0.03;
  static final double kI = 0.00;
  static final double kD = 0.00;
  static final double kF = 0.00;
  public TestEncoder(){
    System.out.println("Constructing");
    for(int i = 0; i < boolArray.length; i++){
      boolArray[i] = false;
    }
    requires(Robot.driveTrain);
    try {
      ahrs = new AHRS(SerialPort.Port.kUSB1);
    } catch (RuntimeException ex) {
      System.out.println("Error instantiating navX MXP:  " + ex.getMessage());
    }
    turnController = new PIDController(kP, kI, kD);
    turnController.enableContinuousInput(-180.0f, 180.0f);

  }

  @Override
  public void start() {
  
  }

  @Override
  public void cancel(){
    leftEncoder.reset();
    rightEncoder.reset();
    super.cancel();
  }

  @Override
  protected boolean isFinished() {
    return false;
  }
    
  /*public void movetoDistance(double distance){
    rightEncoder.setDistancePerPulse(1);
    leftEncoder.setDistancePerPulse(1);
    if(leftEncoder.getDistance() < distance * RobotMap.CONVERSION_RATE){
      DriveTrain.move(0.2,0.2);                                                                                                                                                 
    }
    if(firstValue == 0) {
      firstValue = leftEncoder.getDistance();
    }
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
      boolArray[step] = true;
      step++;    
      resetEncoders();
    }
    iterations++;
  }
*/
/*
  public void turntoAngle(double setpoint){
    double correctedAngle = -ahrs.getAngle();
    if(correctedAngle < setpoint){
      DriveTrain.move(-0.3,0.3);
      System.out.println(correctedAngle);
    } else {
      boolArray[step] = true;
      step++;
      resetGyro();
    }
  }
*/
 /* public Boolean getBool(int index){
    return boolArray[index];
  }

  public void resetEncoders(){
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public void resetGyro(){
    ahrs.reset();
  }
*/

}
