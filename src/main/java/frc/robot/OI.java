package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.ArmDump;
import frc.robot.commands.ArmIntake;
import frc.robot.commands.BaseLift;
import frc.robot.commands.BaseSink;
import frc.robot.commands.PrintTester1;
import frc.robot.commands.PrintTester2;
import frc.robot.commands.PrintTester3;
import frc.robot.commands.WheelColorIdentification;
import frc.robot.commands.WheelColorRotation;
import frc.robot.commands.WheelRotation;

//XYAB will be used for the pixycam, bumpers and triggers for arm control
public class OI {
    // CONTROLLERS
    public static XboxController xbox = new XboxController(RobotMap.DRIVER_CONTROLLER);
    public static Joystick joystick = new Joystick(RobotMap.BUTTON_CONTROLLER);

    private Button greenButton;
    private Button redButton;
    private Button blueButton;
    private Button yellowButton;
    private Button LeftTrigButton;
    private Button RightTrigButton;
    private Button LeftBumpButton;
    private Button RightBumpButton;

    public OI() {

        // COLOR BUTTONS
        greenButton = new JoystickButton(xbox, RobotMap.BUTTON_GREEN);
        redButton = new JoystickButton(xbox, RobotMap.BUTTON_RED);
        blueButton = new JoystickButton(xbox, RobotMap.BUTTON_BLUE);
        yellowButton = new JoystickButton(xbox, RobotMap.BUTTON_YELLOW);

        // WHEN PRESSED || ACTUAL VALUES COMMENTED OUT FOR TESTING
        blueButton.whenPressed(new PrintTester1());
        greenButton.whenPressed(new PrintTester2(2));
        redButton.whenPressed(new PrintTester3());
        
        //blueButton.whenPressed(new WheelColorIdentification());
        //greenButton.whenPressed(new WheelColorIdentification());
        //redButton.whenPressed(new WheelColorIdentification());
        //yellowButton.whenPressed(new WheelColorIdentification());

        //WHEEL ROTATION BUTTONS
        

        //SERVO ARM ROTATION BUTTONS
        RightTrigButton = new JoystickButton(xbox, RobotMap.BUTTON_RIGHTTRIG);
        RightTrigButton.whenPressed(new BaseSink());
        LeftTrigButton = new JoystickButton(xbox, RobotMap.BUTTON_LEFTTRIG);
        LeftTrigButton.whenPressed(new BaseLift());
        LeftBumpButton = new JoystickButton(xbox, RobotMap.BUTTON_LEFTBUMP);
        LeftBumpButton.whenPressed(new ArmDump());
        RightBumpButton = new JoystickButton(xbox, RobotMap.BUTTON_RIGHTBUMP);
        RightBumpButton.whenPressed(new ArmIntake());
    }

}