/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class Climb extends Subsystem {
  public static VictorSPX winch = new VictorSPX(RobotMap.WINCH_MOTOR_ID);
  public static VictorSPX lift = new VictorSPX(RobotMap.LIFT_MOTOR_ID);
  public static Encoder liftEncoder = new Encoder(RobotMap.ENCODER_LIFT_PORT_A, RobotMap.ENCODER_LIFT_PORT_B, true, EncodingType.k4X);
  public static Encoder winchEncoder = new Encoder(RobotMap.ENCODER_WINCH_PORT_A, RobotMap.ENCODER_WINCH_PORT_B, true, EncodingType.k4X);


  /**
   * Drive Train motor declaration
   */
 
 
  @Override
  public void initDefaultCommand() {
      
  }



  public static void resetEncoders(){
    liftEncoder.reset();
    winchEncoder.reset();
  }

  public static VictorSPX getLiftMotor(){
    return lift;
  }

  public static VictorSPX getWinchMotor(){
    return winch;
  }

  public static Encoder getLiftEncoder(){
    return liftEncoder;
  }

  public static Encoder getWinchEncoder(){
    return winchEncoder;
  }

  public static void setSpeed(double speed, VictorSPX motorWinch, VictorSPX motorLift) {
    motorWinch.set(ControlMode.PercentOutput, speed);
    motorLift.set(ControlMode.PercentOutput, 63/100 * speed);

}

}
