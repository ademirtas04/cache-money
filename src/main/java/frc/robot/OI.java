package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ArmDump;
import frc.robot.commands.ArmIntake;
import frc.robot.commands.BaseLift;
import frc.robot.commands.BaseSink;
import frc.robot.commands.ClimbLiftLong;
import frc.robot.subsystems.Climb;
import frc.robot.commands.BaseMid;
import frc.robot.commands.ClimbLiftTime;
import frc.robot.commands.ClimbWinchTime;
import frc.robot.commands.WheelRotation;
import frc.robot.commands.TestEncoder;

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

    public static Button wheelButton = new JoystickButton(joystick, RobotMap.MAIN_TRIGGER);
    public static Button BaseMid = new JoystickButton(joystick, RobotMap.TEST_BUTTON_ONE);
    public static Button BaseSink = new JoystickButton(joystick, RobotMap.TEST_BUTTON_TWO);
    public static Button BaseLift = new JoystickButton(joystick, RobotMap.TEST_BUTTON_THREE);
    public static Button ArmDump = new JoystickButton(joystick, RobotMap.TEST_BUTTON_FOUR);
    public static Button ArmIntake = new JoystickButton(joystick, RobotMap.TEST_BUTTON_FIVE);
    public static Button liftButton = new JoystickButton(joystick, RobotMap.TEST_BUTTON_SIX);
    public static Button dropButton = new JoystickButton(joystick, RobotMap.TEST_BUTTON_SEVEN);
    public static Button winchButton = new JoystickButton(joystick, RobotMap.TEST_BUTTON_EIGHT);
    public static Button spareButton = new JoystickButton(joystick, RobotMap.TEST_BUTTON_NINE);
    public static Button longLiftButton = new JoystickButton(joystick, RobotMap.TEST_BUTTON_TEN);
    public static Button longDropButton = new JoystickButton(joystick, RobotMap.TEST_BUTTON_ELEVEN);
    




    public OI() {
        
        // COLOR BUTTONS
        
        /*
        // WHEN PRESSED || ACTUAL VALUES COMMENTED OUT FOR TESTING       
        ArmDump.whenPressed(new ArmDump());
        ArmIntake.whenPressed(new ArmIntake());

        //WHEEL ROTATION BUTTONS
        
        wheelButton.whenPressed(new WheelRotation());
        //SERVO ARM ROTATION BUTTONS
        BaseMid.whenPressed(new BaseMid());
        BaseSink.whenPressed(new BaseSink());
        BaseLift.whenPressed(new BaseLift());
        /*
        liftButton.whenPressed(new ClimbLiftTime(Climb.getLiftMotor(), 1));
        dropButton.whenPressed(new ClimbLiftTime(Climb.getLiftMotor(), -1));
        longLiftButton.whenPressed(new ClimbLiftLong(Climb.getLiftMotor(), 1));
        longDropButton.whenPressed(new ClimbLiftLong(Climb.getLiftMotor(), -1));
        winchButton.whenPressed(new ClimbWinchTime(Climb.getWinchMotor()));
        */
        spareButton.whileHeld(new TestEncoder());


    }

    public double getDriverRawAxis(int axis) {
        return xbox.getRawAxis(axis);
    }

}