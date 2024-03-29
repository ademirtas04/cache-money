/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.TankDrive;
import frc.robot.commands.TestEncoder;
import frc.robot.misc.ControlChooser;
import frc.robot.misc.SensorReset;
import frc.robot.misc.SmartDashboardInterface;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Ramp;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.WheelArm;




/**
 *Class declaration
 */

public class Robot extends TimedRobot {
  public static Climb liftClimb = new Climb();
  public static Climb winchClimb = new Climb();
  public static Climb timeClimb = new Climb();
  public static Climb encoderClimb = new Climb();
  public static Climb testClimb = new Climb();
  public static WheelArm wheelArm = new WheelArm();
  public static DriveTrain driveTrain = new DriveTrain();
  public static TankDrive tankDrive = new TankDrive();
  public static Arm arm = new Arm();
  public static Ramp ramp = new Ramp();
  public static OI m_oi;
  public static boolean movable;
  public static double startTime = 0;
  private Command m_autonomousCommand;
  private ControlChooser m_controlChooser;
  private SmartDashboardInterface m_smartDashboardInterface;
  private SensorReset m_sensorReset;
  public static TestEncoder encodertester = new TestEncoder();


  @Override
 
  public void robotInit() {
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
    //Git Push
    if(currentTime - startTime < RobotMap.AUTO_WAIT_TIME){
        DriveTrain.move(0,0);
      }
      if(currentTime - startTime < (3+RobotMap.AUTO_WAIT_TIME) && currentTime - startTime > RobotMap.AUTO_WAIT_TIME){
        DriveTrain.move(0.3,-0.3);
       // encodertester.resetEncoders();

      }  
      else if (currentTime - startTime > (3+RobotMap.AUTO_WAIT_TIME) && currentTime - startTime < (RobotMap.AUTO_WAIT_TIME + 6)){
        Arm.armMove();
      }      
    }  
    
  


  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
   // encodertester.resetEncoders();
  }
  @Override
  public void teleopPeriodic() {
     Scheduler.getInstance().run();
     TankDrive.move();
     
    /* if(!encodertester.getBool(0)){
        System.out.println("Found");
        encodertester.movetoDistance(3);
     } 
     else if(!encodertester.getBool(1) && encodertester.getBool(0)){
        System.out.println("Turn");
        encodertester.turntoAngle(-75);
     }
     else if(!encodertester.getBool(2) && encodertester.getBool(1)){
        System.out.println("Turn");
        encodertester.movetoDistance(3);
     } 
     else if(!encodertester.getBool(3) && encodertester.getBool(2)){
      System.out.println("Turn");
      encodertester.turntoAngle(75);
     }
    else if(!encodertester.getBool(4) && encodertester.getBool(3)){
      System.out.println("Turn");
      encodertester.movetoDistance(3);
    }
    else if(!encodertester.getBool(5) && encodertester.getBool(4)){
        System.out.println("Turn");
        encodertester.turntoAngle(75);
    }
    else if(!encodertester.getBool(6) && encodertester.getBool(5)){
        System.out.println("Turn");
        encodertester.movetoDistance(3);
    } 
    else if(!encodertester.getBool(7) && encodertester.getBool(6)){
      System.out.println("Turn");
      encodertester.turntoAngle(-75);
    }
    else if(!encodertester.getBool(8) && encodertester.getBool(7)){
      System.out.println("Turn");
      encodertester.movetoDistance(3);
    }
    else if(!encodertester.getBool(9) && encodertester.getBool(8)){
      System.out.println("Turn");
      encodertester.turntoAngle(-75);
    }
    else if(!encodertester.getBool(10) && encodertester.getBool(9)){
      System.out.println("Turn");
      encodertester.movetoDistance(3);
    } 
    else if(!encodertester.getBool(11) && encodertester.getBool(10)){
      System.out.println("Turn");
      encodertester.turntoAngle(-75);
    }
    else if(!encodertester.getBool(12) && encodertester.getBool(11)){
      System.out.println("Turn");
      encodertester.movetoDistance(3);
    }
    else if(!encodertester.getBool(13) && encodertester.getBool(12)){
        System.out.println("Turn");
        encodertester.turntoAngle(-75);
    }
    else if(!encodertester.getBool(14) && encodertester.getBool(13)){
        System.out.println("Turn");
        encodertester.movetoDistance(3);
    } 
    else if(!encodertester.getBool(15) && encodertester.getBool(14)){
      System.out.println("Turn");
      encodertester.turntoAngle(75);
    }
    else if(!encodertester.getBool(16) && encodertester.getBool(15)){
      System.out.println("Turn");
      encodertester.movetoDistance(3);
    }
    else if(!encodertester.getBool(17) && encodertester.getBool(16)){
      System.out.println("Turn");
      encodertester.turntoAngle(75);
    }
    else if(!encodertester.getBool(18) && encodertester.getBool(17)){
        System.out.println("Turn");
        encodertester.movetoDistance(3);
    } 
    else if(!encodertester.getBool(19) && encodertester.getBool(18)){
      System.out.println("Turn");
      encodertester.turntoAngle(-75);
    }
    else if(!encodertester.getBool(20) && encodertester.getBool(19)){
      System.out.println("Turn");
      encodertester.movetoDistance(3);
    } */      
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
