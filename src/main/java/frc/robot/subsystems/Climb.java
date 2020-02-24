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
  public static VictorSPX armMotor1 = new VictorSPX(RobotMap.ARM_MOTOR_1_ID);
  public static VictorSPX armMotor2 = new VictorSPX(RobotMap.ARM_MOTOR_2_ID);



  /**
   * Drive Train motor declaration
   */
  //private static SparkMax armMotorMax = new SparkMax(RobotMap.ARM_MOTOR_1_ID);
 
 
  @Override
  public void initDefaultCommand() {
    

    
   
  }

  public static void setClimbs(double speed) {
    armMotor1.set(ControlMode.PercentOutput, speed);
    armMotor2.set(ControlMode.PercentOutput, 63/100 * speed);

}

}
