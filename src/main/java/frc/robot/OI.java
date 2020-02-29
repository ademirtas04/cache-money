package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ArmDump;
import frc.robot.commands.ArmIntake;
import frc.robot.commands.BaseLift;
import frc.robot.commands.BaseSink;
import frc.robot.commands.ClimbPullUp;
import frc.robot.commands.ClimbTest1;
import frc.robot.commands.ClimbTest2;


//XYAB will be used for the pixycam, bumpers and triggers for arm control
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
    public static Button liftTestButtonOne = new JoystickButton(joystick, RobotMap.TEST_BUTTON_ONE);
    public static Button liftTestButtonTwo = new JoystickButton(joystick, RobotMap.TEST_BUTTON_TWO);


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

        //liftButton.whenPressed(new ClimbPullUp(1));
        liftTestButtonOne.whenPressed(new ClimbTest1());
        //liftTestButtonTwo.whenPressed(new ClimbTest2());

    }

    public double getDriverRawAxis(int axis) {
        return xbox.getRawAxis(axis);
    }
}