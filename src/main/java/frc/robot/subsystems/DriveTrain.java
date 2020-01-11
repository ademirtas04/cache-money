/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class DriveTrain extends SubsystemBase {
  /**
   * Drive Train motor declaration
   */
  private VictorSPX motorLeft1 = new VictorSPX(RobotMap.MOTOR_LEFT_1_ID);
  private VictorSPX motorLeft2 = new VictorSPX(RobotMap.MOTOR_LEFT_2_ID);
  private VictorSPX motorRight1 = new VictorSPX(RobotMap.MOTOR_RIGHT_1_ID);
  private VictorSPX motorRight2 = new VictorSPX(RobotMap.MOTOR_RIGHT_2_ID);
 
 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new TankDrive());
  }

//-speed goes reverse
  public void setLeftMotors(double speed) {
      motorLeft1.set(ControlMode.PercentOutput, -speed);
      motorLeft2.set(ControlMode.PercentOutput, -speed);
  }

  public void setRightMotors(double speed) {
    motorRight1.set(ControlMode.PercentOutput, speed);
    motorRight2.set(ControlMode.PercentOutput, speed);
}

}
