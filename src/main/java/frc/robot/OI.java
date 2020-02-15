package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ArmDump;
import frc.robot.commands.ArmIntake;
import frc.robot.commands.BaseLift;
import frc.robot.commands.BaseSink;
import frc.robot.commands.PrintTester1;
import frc.robot.commands.PrintTester2;
import frc.robot.commands.WheelColorIdentification;
import frc.robot.commands.WheelColorRotation;
import frc.robot.commands.WheelRotation;

//XYAB will be used for the pixycam, bumpers and triggers for arm control
public class OI {
    // CONTROLLERS
    public static Joystick xbox = new Joystick(RobotMap.DRIVER_CONTROLLER);
    public static Joystick joystick = new Joystick(RobotMap.BUTTON_CONTROLLER);

    public static Button greenButton = new JoystickButton(xbox, RobotMap.BUTTON_GREEN);
    public static Button redButton = new JoystickButton(xbox, RobotMap.BUTTON_RED);
    public static Button blueButton = new JoystickButton(xbox, RobotMap.BUTTON_BLUE);
    public static Button yellowButton = new JoystickButton(xbox, RobotMap.BUTTON_YELLOW);
    public static Button LeftTrigButton = new JoystickButton(xbox, RobotMap.BUTTON_LEFTTRIG);
    public static Button RightTrigButton = new JoystickButton(xbox, RobotMap.BUTTON_RIGHTTRIG);
    public static Button LeftBumpButton = new JoystickButton(xbox, RobotMap.BUTTON_LEFTBUMP);
    public static Button RightBumpButton = new JoystickButton(xbox, RobotMap.BUTTON_RIGHTBUMP);
    public static Button BackButton = new JoystickButton(xbox, RobotMap.BUTTON_BACK);
    public static Button StartButton = new JoystickButton(xbox, RobotMap.BUTTON_START);

    public OI() {
        
        // COLOR BUTTONS
        

        // WHEN PRESSED || ACTUAL VALUES COMMENTED OUT FOR TESTING       
        System.out.println("OI");
        greenButton.whenPressed(new PrintTester1());
        blueButton.whenPressed(new PrintTester2(3));
        /*
        greenButton.whenPressed(new WheelColorIdentification(1));
        blueButton.whenPressed(new WheelColorIdentification(3));
        redButton.whenPressed(new WheelColorIdentification(2));
        yellowButton.whenPressed(new WheelColorIdentification(4));
        */

        //WHEEL ROTATION BUTTONS
        
        
        //SERVO ARM ROTATION BUTTONS
        RightTrigButton.whenPressed(new BaseSink());
        LeftTrigButton.whenPressed(new BaseLift());
        BackButton.whenPressed(new ArmDump());
        StartButton.whenPressed(new ArmIntake());
    }

    public double getDriverRawAxis(int axis) {
        return xbox.getRawAxis(axis);
    }
}