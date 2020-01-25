/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

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
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */

public class Robot extends TimedRobot {
  public static DriveTrain driveTrain = new DriveTrain();
  public static TankDrive tankDrive = new TankDrive();
  public static Autonomous autonomous = new Autonomous();
  public static OI m_oi;
  private Command m_autonomousCommand;
  private XboxController driveController = new XboxController(RobotMap.DRIVER_CONTROLLER);
  private VictorSPX motorLeft1 = new VictorSPX(RobotMap.MOTOR_LEFT_1_ID);
  private VictorSPX motorLeft2 = new VictorSPX(RobotMap.MOTOR_LEFT_2_ID);
  private VictorSPX motorRight1 = new VictorSPX(RobotMap.MOTOR_RIGHT_1_ID);
  private VictorSPX motorRight2 = new VictorSPX(RobotMap.MOTOR_RIGHT_2_ID);
  private ControlChooser m_controlChooser;
  private SmartDashboardInterface m_smartDashboardInterface;
  private SensorReset m_sensorReset;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
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

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
    m_smartDashboardInterface.SmartDashboardPeriodic();

    //Resets sensors when driver presses Shuffleboard button
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
  public void autonomousInit() {
    m_controlChooser.ControlInit(SmartDashboardInterface.controlType.getSelected());
 
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    autonomous.execute();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    double speed = driveController.getRawAxis((RobotMap.LEFT_STICK_Y));
    double turn = driveController.getRawAxis((RobotMap.RIGHT_STICK_X));

    double left = speed + turn;
    double right = speed - turn;

     driveTrain.setLeftMotors(-left);
     driveTrain.setRightMotors(right);
  }
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    double speed = driveController.getRawAxis((RobotMap.LEFT_STICK_Y));
    double turn = driveController.getRawAxis((RobotMap.RIGHT_STICK_X));

     double left = speed + turn;
     double right = speed - turn;

     Robot.driveTrain.setLeftMotors(-left);
     Robot.driveTrain.setRightMotors(right);
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

  public void setLeftMotors(double speed) {
    motorLeft1.set(ControlMode.PercentOutput, speed);
    motorLeft2.set(ControlMode.PercentOutput, speed);
  }

  public void setRightMotors(double speed) {
    motorRight1.set(ControlMode.PercentOutput, speed);
    motorRight2.set(ControlMode.PercentOutput, speed);
  }
}
