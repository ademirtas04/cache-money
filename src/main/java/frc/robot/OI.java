package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ArmDump;
import frc.robot.commands.ArmIntake;
import frc.robot.commands.BaseLift;
import frc.robot.commands.BaseSink;
/*
import frc.robot.commands.ClimbTestLift;
import frc.robot.commands.ClimbTestWinch;

import frc.robot.subsystems.Climb;
*/
import frc.robot.commands.ClimbLiftTime;
import frc.robot.subsystems.Climb;

public class OI {
    // CONTROLLERS
    public static Joystick xbox = new Joystick(RobotMap.DRIVER_CONTROLLER);
    public static Joystick joystick = new Joystick(RobotMap.BUTTON_CONTROLLER);

    public static Button greenButton = new JoystickButton(xbox, RobotMap.BUTTON_GREEN);
    public static Button redButton = new JoystickButton(xbox, RobotMap.BUTTON_RED);
    public static Button blueButton = new JoystickButton(xbox, RobotMap.BUTTON_BLUE);
    public static Button yellowButton = new JoystickButton(xbox, RobotMap.BUTTON_YELLOW);
    public static Button LeftBumpButton = new JoystickButton(xbox, RobotMap.BUTTON_LEFTBUMP);
    public static Button RightBumpButton = new JoystickButton(xbox, RobotMap.BUTTON_RIGHTBUMP);
    public static Button BackButton = new JoystickButton(xbox, RobotMap.BUTTON_BACK);
    public static Button StartButton = new JoystickButton(xbox, RobotMap.BUTTON_START);

    public static Button liftButton = new JoystickButton(joystick, RobotMap.MAIN_TRIGGER);
    public static Button liftTestButtonWinch = new JoystickButton(joystick, RobotMap.TEST_BUTTON_ONE);
    public static Button liftTestButtonLift = new JoystickButton(joystick, RobotMap.TEST_BUTTON_TWO);
    public static Button liftDropButtonWinch = new JoystickButton(joystick, RobotMap.TEST_BUTTON_THREE);
    public static Button liftDropButtonLift = new JoystickButton(joystick, RobotMap.TEST_BUTTON_FOUR);
    public static Button liftResetButton = new JoystickButton(joystick, RobotMap.TEST_BUTTON_SEVEN);
    public static Button winchResetButton = new JoystickButton(joystick, RobotMap.TEST_BUTTON_SIX);




    public OI() {
        
        // COLOR BUTTONS
        

        // WHEN PRESSED || ACTUAL VALUES COMMENTED OUT FOR TESTING       
        greenButton.whenPressed(new ArmDump());
        blueButton.whenPressed(new ArmIntake());

        //WHEEL ROTATION BUTTONS
        
        
        //SERVO ARM ROTATION BUTTONS
        LeftBumpButton.whenPressed(new BaseSink());
        RightBumpButton.whenPressed(new BaseLift());
        BackButton.whenPressed(new ArmDump());
        StartButton.whenPressed(new ArmIntake());

        /*
        liftTestButtonWinch.whenPressed(new ClimbTestWinch(Climb.getWinchEncoder() ,Climb.getWinchMotor(), 1, 1.0, 1.0));
        liftTestButtonLift.whenPressed(new ClimbTestLift(Climb.getLiftEncoder(), Climb.getLiftMotor(), 1, 1.0, 1.0));
        liftDropButtonWinch.whenPressed(new ClimbTestWinch(Climb.getWinchEncoder(), Climb.getWinchMotor(), -1, 1.0, 1.0));
        liftDropButtonLift.whenPressed(new ClimbTestLift(Climb.getLiftEncoder(), Climb.getLiftMotor(), -1, 1.0, 1.0));
        liftResetButton.whenPressed(new ClimbTestLift(Climb.getLiftEncoder(), Climb.getLiftMotor(), 0, 0, 0));
        winchResetButton.whenPressed(new ClimbTestWinch(Climb.getWinchEncoder() ,Climb.getWinchMotor(), 0, 0, 0));
        */
        liftTestButtonWinch.whenPressed(new ClimbLiftTime(Climb.getLiftMotor(), Climb.getWinchMotor(), 1));
        liftTestButtonLift.whenPressed(new ClimbLiftTime(Climb.getLiftMotor(), Climb.getWinchMotor(), -1));
        liftResetButton.whenPressed(new ClimbLiftTime(Climb.getLiftMotor(), Climb.getWinchMotor(), 1));
        winchResetButton.whenPressed(new ClimbLiftTime(Climb.getLiftMotor(), Climb.getWinchMotor(), -1));


    }

    public double getDriverRawAxis(int axis) {
        return xbox.getRawAxis(axis);
    }
}