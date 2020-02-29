/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class Climb extends Subsystem {
  public static VictorSPX winch = new VictorSPX(RobotMap.WINCH_MOTOR_ID);
  public static VictorSPX lift = new VictorSPX(RobotMap.LIFT_MOTOR_ID);



  /**
   * Drive Train motor declaration
   */
 
 
  @Override
  public void initDefaultCommand() {
      
  }

  public static void setWinchSpeed(double speed){
    winch.set(ControlMode.PercentOutput, speed);
  }

  public static void setLiftSpeed(double speed){
    lift.set(ControlMode.PercentOutput, speed);
  }

  public static void setClimbs(double speed) {
    winch.set(ControlMode.PercentOutput, speed);
    lift.set(ControlMode.PercentOutput, 63/100 * speed);

}

}
