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


public class Ramp extends Subsystem {


  public static Servo ramp = new Servo(RobotMap.BASE_PORT);
  
 
 
  @Override
  public void initDefaultCommand() {
    // This method will be called once per scheduler run
  }

  public static void baseMove(){
    ramp.setBounds(2.0, 1.8, 1.5, 1.2, 1.0);
    ramp.setSpeed(1.0);
  }
  public static void baseReset(){
    ramp.setBounds(2.0, 1.8, 1.5, 1.2, 1.0);
    ramp.setAngle(-1.0);
  }
  
  public static void baseMid(){
    ramp.setBounds(1.3, 1.22, 1.15, 1.07, 1.0);
    ramp.setSpeed(1.0);
  }

}
