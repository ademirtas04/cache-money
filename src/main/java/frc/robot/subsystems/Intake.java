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


public class Intake extends Subsystem {
  //public static Servo intake = new Servo(RobotMap.INTAKE_PORT);

  
 
 
  @Override
  public void initDefaultCommand() {
    // This method will be called once per scheduler run
  }

  public static void IntakeMove(){
    //ALERT: We need to find the right angle for this (see if it's negative or not) 
    //intake.setAngle(RobotMap.IDEAL_DUMP_ANGLE);
  }

  public static void IntakeReset(){
    //intake.setAngle(RobotMap.IDEAL_HOLD_ANGLE);
  }

  public static double getAngle(){
    //return intake.getAngle();
    return 0;
  }

  public static void zeroSpeed(){
    //intake.setSpeed(0);
  }
}
