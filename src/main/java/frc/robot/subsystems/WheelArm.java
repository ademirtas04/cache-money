/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class WheelArm extends Subsystem {
  public static Servo arm = new Servo(RobotMap.WHEEL_ARM_PORT);
  public static VictorSPX armMotor = new VictorSPX(RobotMap.WHEEL_ARM_MOTOR_ID);
  
 
 
  @Override
  public void initDefaultCommand() {
    // This method will be called once per scheduler run
  }

  public static void armMove(){
    arm.setAngle(90);
  }
  
  public static void armReset(){
    arm.setAngle(0);
  }

  public static void wheelMove(double speed){
    armMotor.set(ControlMode.PercentOutput, speed);
  }

  public static double getArmAngle(){
    return arm.getAngle();
  }

  
}
