/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.Scanner;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.TankDrive;
import frc.robot.misc.ControlChooser;
import frc.robot.misc.SensorReset;
import frc.robot.misc.SmartDashboardInterface;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Base;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.DriveTrain;




/**
 *Class declaration
 */

public class Robot extends TimedRobot {
  public static Climb liftClimb = new Climb();
  public static Climb winchClimb = new Climb();
  public static Climb timeClimb = new Climb();
  public static Climb encoderClimb = new Climb();
  public static DriveTrain driveTrain = new DriveTrain();
  public static TankDrive tankDrive = new TankDrive();
  public static Arm arm = new Arm();
  public static Base base = new Base();
  public static OI m_oi;
  public static double startTime = 0;
  private Command m_autonomousCommand;
  private ControlChooser m_controlChooser;
  private SmartDashboardInterface m_smartDashboardInterface;
  private SensorReset m_sensorReset;
  private int autonomous;


  @Override
 
  public void robotInit() {
    Scanner s = new Scanner(System.in);
    System.out.println("What autonomous would you like to execute? 0: Normal 1: Move from Different Position 2: Dump");
    autonomous = s.nextInt();
    s.close();
    System.out.println(autonomous);
    m_controlChooser = new ControlChooser();
    m_smartDashboardInterface = new SmartDashboardInterface();
    m_sensorReset = new SensorReset();
    System.out.println("WORKS");
    Robot.m_oi = new OI();
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
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void autonomousPeriodic() {
    double currentTime = Timer.getFPGATimestamp();
    if(autonomous == 0){
      if(currentTime - startTime < RobotMap.AUTO_WAIT_TIME){
        DriveTrain.move(1,1);
      }  else if (currentTime - startTime < RobotMap.AUTO_DROP_TIME){
        Arm.armMove();
      }
    } else if(autonomous == 1){
      if(currentTime - startTime < 2){
        DriveTrain.move(1,1);
      }
      if(currentTime - startTime < 2.25){
        DriveTrain.move(1,-1);
      }
      if(currentTime - startTime < 15){
        Arm.armMove();
      }
    } else if(autonomous == 2){
      Arm.armMove();
    }
  }
  


  @Override
  //Code when the Enable button is hit during teleop period
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }
  @Override
  public void teleopPeriodic() {
     Scheduler.getInstance().run();
     TankDrive.move();
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
