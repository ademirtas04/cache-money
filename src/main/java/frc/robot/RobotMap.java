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

	//CONTROLLERS AND STICK VALUES
	public static final int DRIVER_CONTROLLER = 0;
	public static final int BUTTON_CONTROLLER = 1;
	public static final int LEFT_STICK_Y = 4;
	public static final int RIGHT_STICK_X = 1;
	public static final int JOYSTICK_Y = 5;

	//BUTTON VALUES
	public static final int BUTTON_GREEN = 1;
	public static final int BUTTON_RED = 2;
	public static final int BUTTON_BLUE = 3;
	public static final int BUTTON_YELLOW = 4;
	public static final int BUTTON_LEFTTRIG = 2;
	public static final int BUTTON_RIGHTTRIG = 3;
	public static final int BUTTON_RIGHTBUMP = 6;
	public static final int BUTTON_LEFTBUMP = 5;

    //PID VALUES
	public static final double kP = 0.5;
	public static final double kI = 0.5;
	public static final double kD = 0.1;
	public static final double iLimit = 1;
	public static final double kDriveTick2Feet = 1.0 / 128 * 6 * Math.PI / 12;

	//PIXY CAM CONSTANTS
	public static final int PIXY_WIDTH = 640;
	public static final int PIXY_LENGTH = 400;
	public static final int ERROR_CONSTANT = 15;

	//ROTATION VALUES
	public static final double SINGLE_ROTATION_TIME = 0;
	public static final double CONSTANT_TIMER = 0;
	public static final double CONSTANT_ARM_TIMER = 0;
	public static final int INTAKE_PORT = 0;
	public static final int ARM_PORT = 0;
	public static final int BASE_SPORT = 0;
	public static final int BASE_PORT = 0;




}


