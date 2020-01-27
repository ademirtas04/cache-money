/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.Autonomous;
import frc.robot.commands.TankDrive;
import frc.robot.misc.ControlChooser;
import frc.robot.misc.SensorReset;
import frc.robot.misc.SmartDashboardInterface;
import frc.robot.subsystems.DriveTrain;




/**
 *Class declaration
 */

public class Robot extends TimedRobot {
  public static DriveTrain driveTrain = new DriveTrain();
  public static TankDrive tankDrive = new TankDrive();
  public static Autonomous autonomous = new Autonomous();
  public static OI m_oi;
  private Command m_autonomousCommand;
  private XboxController driveController = new XboxController(RobotMap.DRIVER_CONTROLLER);
  private WPI_VictorSPX motorLeft1 = new WPI_VictorSPX(RobotMap.MOTOR_LEFT_1_ID);
  private WPI_VictorSPX motorLeft2 = new WPI_VictorSPX(RobotMap.MOTOR_LEFT_2_ID);
  private WPI_VictorSPX motorRight1 = new WPI_VictorSPX(RobotMap.MOTOR_RIGHT_1_ID);
  private WPI_VictorSPX motorRight2 = new WPI_VictorSPX(RobotMap.MOTOR_RIGHT_2_ID);
  private ControlChooser m_controlChooser;
  private SmartDashboardInterface m_smartDashboardInterface;
  private SensorReset m_sensorReset;

 
  @Override
 
  public void robotInit() {
    new RobotMap();
    m_controlChooser = new ControlChooser();
    m_smartDashboardInterface = new SmartDashboardInterface();
    m_sensorReset = new SensorReset();
    //variable instances
 
  
    m_smartDashboardInterface.SmartDashboardInit();
    m_sensorReset.ResetSensors();
  }

 
  @Override
  public void robotPeriodic() {
    
    CommandScheduler.getInstance().run();
    m_smartDashboardInterface.SmartDashboardPeriodic();

    if(SmartDashboard.getBoolean("Reset Sensors", false)) m_sensorReset.ResetSensors();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  //Code when the enable button is hit in the autonomous tab
  public void autonomousInit() {
    m_controlChooser.ControlInit(SmartDashboardInterface.controlType.getSelected());
 
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous every 0.02 seconds
   */
  @Override
  public void autonomousPeriodic() {
    autonomous.execute();
  }

  @Override
  //Code when the Enable button is hit during teleop period
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }
  /**
   * Driver Controls
   */
  @Override
  public void teleopPeriodic() {
    //The Left stick is speed control, the Right stick is turning control
    double speed = driveController.getRawAxis(RobotMap.LEFT_STICK_Y);

    double turn = -driveController.getRawAxis(RobotMap.RIGHT_STICK_X);
    //The Left is pos the right is neg
     double left = speed + turn;
     double right = speed - turn;

     motorLeft1.set(ControlMode.PercentOutput, left);
     motorLeft2.set(ControlMode.PercentOutput, left);
     motorRight1.set(ControlMode.PercentOutput, -right);
     motorRight2.set(ControlMode.PercentOutput, -right);
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
