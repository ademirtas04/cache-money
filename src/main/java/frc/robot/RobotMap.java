/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

public class RobotMap {

	//MOTORS
	public static final int MOTOR_LEFT_1_ID = 21;
    public static final int MOTOR_LEFT_2_ID = 24;
	public static final int MOTOR_RIGHT_1_ID = 22;
	public static final int MOTOR_RIGHT_2_ID = 23;
	public static final int ARM_MOTOR_1_ID = 25;
	public static final int ARM_MOTOR_2_ID = 26;
	public static final int ARM_MOTOR_3_ID = 27;
	public static final int ARM_MOTOR_4_ID = 28;

	//SERVO PORTS
	public static final int BASE_PORT = 0;
	public static final int ARM_PORT = 1; 
	public static final int WHEEL_ARM_PORT = 2;

	//CONTROLLER PORT VALUES
	public static final int DRIVER_CONTROLLER = 0;
	public static final int BUTTON_CONTROLLER = 1;

	//XBOX PORT VALUES
	public static final int RIGHT_STICK_Y = 0;
	public static final int RIGHT_STICK_X = 1;
	public static final int BUTTON_LEFTTRIG = 2;
	public static final int BUTTON_RIGHTTRIG = 3;
	public static final int LEFT_STICK_Y = 4;
	public static final int JOYSTICK_Y = 5;

	//XBOX BUTTON VALUES
	public static final int BUTTON_GREEN = 1;
	public static final int BUTTON_RED = 2;
	public static final int BUTTON_BLUE = 3;
	public static final int BUTTON_YELLOW = 4;
	public static final int BUTTON_LEFTBUMP = 5;
	public final static int BUTTON_RIGHTBUMP = 6;
	public final static int BUTTON_BACK = 7;
	public final static int BUTTON_START = 8;
	public final static int BUTTON_LEFTSTICK = 9;
	public final static int BUTTON_RIGHTSTICK = 10;

	//JOYSTICK BUTTON VALUES
	public static final int MAIN_TRIGGER = 1;
	public static final int TEST_BUTTON_ONE = 2;
	public static final int TEST_BUTTON_TWO = 3;
	public static final int TEST_BUTTON_THREE = 4;
	public static final int TEST_BUTTON_FOUR = 5;
	public static final int TEST_BUTTON_FIVE = 6;
	public static final int TEST_BUTTON_SIX = 7;
	public static final int TEST_BUTTON_SEVEN = 8;
	public static final int TEST_BUTTON_EIGHT = 9;
	public static final int TEST_BUTTON_NINE = 10;
	public static final int TEST_BUTTON_TEN = 11;
	public static final int TEST_BUTTON_ELEVEN = 12;
    //PID VALUES
	public static final double kP = 0.5;
	public static final double kI = 0.5;
	public static final double kD = 0.1;
	public static final double iLimit = 1;
	public static final double kDriveTick2Feet = 0.196 / 12; //CHECK THESE

	//PIXY CAM CONSTANTS
	public static final int PIXY_WIDTH = 640;
	public static final int PIXY_LENGTH = 400;
	public static final int ERROR_CONSTANT = 15;

	//ROTATION VALUES
	public static final double SINGLE_ROTATION_TIME = 0; // Fill in once tested
	public static final double CONSTANT_TIMER = 5;
	public static final double CONSTANT_ARM_TIMER = 5;




	public static final double IDEAL_DUMP_ANGLE = 90; // Change once tested
	public static final double IDEAL_HOLD_ANGLE = 10; // Change once tested

	//AUTONOMOUS VALUES
	public static final double AUTO_DRIVE_TIME = 10;
	public static final double AUTO_WAIT_TIME = 0;
	public static final double AUTO_DROP_TIME = 15;
	public static final double AUTONOMOUS_LENGTH = 15;
	public static final double ENDPOINT = 0;

	//CLIMB VALUES

	public static final int WINCH_MOTOR_ID = 25;
	public static final int LIFT_MOTOR_ID = 26;
	public static final int ENCODER_RIGHT_MOTORS_A = 1;
	public static final int ENCODER_RIGHT_MOTORS_B = 2;
	public static final int ENCODER_LEFT_MOTORS_A = 5;
	public static final int ENCODER_LEFT_MOTORS_B = 6;
	public static final int WHEEL_ARM_MOTOR_ID = 27;
	public static final double TIME_FOR_ONE_ROTATION = 100/625/Math.PI*4/3;
	public static final double CONVERSION_RATE = 4096/Math.PI;

	//Constants copied from https://github.com/wpilibsuite/allwpilib/blob/main/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/examples/ramsetecommand/Constants.java
	public static final class DriveConstants {
		public static final int kLeftMotor1Port = 0;
		public static final int kLeftMotor2Port = 1;
		public static final int kRightMotor1Port = 2;
		public static final int kRightMotor2Port = 3;
	
		public static final int[] kLeftEncoderPorts = new int[] {0, 1};
		public static final int[] kRightEncoderPorts = new int[] {2, 3};
		public static final boolean kLeftEncoderReversed = false;
		public static final boolean kRightEncoderReversed = true;
	
		public static final double kTrackwidthMeters = 0.69;
		public static final DifferentialDriveKinematics kDriveKinematics =
			new DifferentialDriveKinematics(kTrackwidthMeters);
	
		public static final int kEncoderCPR = 1024;
		public static final double kWheelDiameterMeters = 0.15;
		public static final double kEncoderDistancePerPulse =
			// Assumes the encoders are directly mounted on the wheel shafts
			(kWheelDiameterMeters * Math.PI) / (double) kEncoderCPR;
	
		// These are example values only - DO NOT USE THESE FOR YOUR OWN ROBOT!
		// These characterization values MUST be determined either experimentally or theoretically
		// for *your* robot's drive.
		// The Robot Characterization Toolsuite provides a convenient tool for obtaining these
		// values for your robot.
		public static final double ksVolts = 0.22;
		public static final double kvVoltSecondsPerMeter = 1.98;
		public static final double kaVoltSecondsSquaredPerMeter = 0.2;
	
		// Example value only - as above, this must be tuned for your drive!
		public static final double kPDriveVel = 8.5;
	  }
	
	  public static final class OIConstants {
		public static final int kDriverControllerPort = 1;
	  }
	
	  public static final class AutoConstants {
		public static final double kMaxSpeedMetersPerSecond = 3;
		public static final double kMaxAccelerationMetersPerSecondSquared = 3;
	
		// Reasonable baseline values for a RAMSETE follower in units of meters and seconds
		public static final double kRamseteB = 2;
		public static final double kRamseteZeta = 0.7;
	  }



}


