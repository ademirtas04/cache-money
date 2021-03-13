/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


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




}


