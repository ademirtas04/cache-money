/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Climb extends Subsystem {
  public static CANSparkMax armMotorMax = new CANSparkMax(RobotMap.ARM_MOTOR_1_ID, MotorType.kBrushless);



  /**
   * Drive Train motor declaration
   */
  //private static SparkMax armMotorMax = new SparkMax(RobotMap.ARM_MOTOR_1_ID);
 
 
  @Override
  public void initDefaultCommand() {
    

    
   
  }

  public static void setMotor(double speed) {
    armMotorMax.set(speed);

}

}
