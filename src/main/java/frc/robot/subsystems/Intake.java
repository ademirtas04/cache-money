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
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.SparkMax;

public class Intake extends Subsystem {
  public static Servo intake = new Servo(RobotMap.INTAKE_PORT);
  public static Servo arm = new Servo(RobotMap.ARM_PORT);
  public static Servo base = new Servo(RobotMap.BASE_PORT);
 
 
  @Override
  public void initDefaultCommand() {
    // This method will be called once per scheduler run
  }

  public static void IntakeMove(){
    //ALERT: We need to find the right angle for this (see if it's negative or not) 
    intake.setAngle(-90);
  }

  public static void IntakeReset(){
    intake.setAngle(0);
  }

  public static void armMove(){
    intake.setAngle(-90);
  }
  
  public static void armReset(){
    intake.setAngle(0);
  }

  public static void baseMove(){
    base.setSpeed(1.0);
  }

  public static void baseReset(){
    base.setAngle(-1.0);
  }


}
