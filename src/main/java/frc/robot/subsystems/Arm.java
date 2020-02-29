/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Arm extends Subsystem {
  public static Servo arm = new Servo(RobotMap.ARM_PORT);
  
 
 
  @Override
  public void initDefaultCommand() {
    // This method will be called once per scheduler run
  }

  public static void armMove(){
    arm.setAngle(180);
  }
  
  public static void armReset(){
    arm.setAngle(15);
  }

  
}
