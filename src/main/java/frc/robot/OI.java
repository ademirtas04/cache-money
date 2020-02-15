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
    public static Joystick xbox = new Joystick(RobotMap.DRIVER_CONTROLLER);
    public static Joystick joystick = new Joystick(RobotMap.BUTTON_CONTROLLER);

    private Button greenButton = new JoystickButton(xbox, RobotMap.BUTTON_GREEN);
    private Button redButton = new JoystickButton(xbox, RobotMap.BUTTON_RED);
    private Button blueButton = new JoystickButton(xbox, RobotMap.BUTTON_BLUE);
    private Button yellowButton = new JoystickButton(xbox, RobotMap.BUTTON_YELLOW);
    private Button LeftTrigButton = new JoystickButton(xbox, RobotMap.BUTTON_LEFTTRIG);
    private Button RightTrigButton = new JoystickButton(xbox, RobotMap.BUTTON_RIGHTTRIG);
    private Button LeftBumpButton = new JoystickButton(xbox, RobotMap.BUTTON_LEFTBUMP);
    private Button RightBumpButton = new JoystickButton(xbox, RobotMap.BUTTON_RIGHTBUMP);

    public OI() {
        
        // COLOR BUTTONS
        

        // WHEN PRESSED || ACTUAL VALUES COMMENTED OUT FOR TESTING       
        
        greenButton.whenPressed(new WheelColorIdentification(1));
        blueButton.whenPressed(new WheelColorIdentification(3));
        redButton.whenPressed(new WheelColorIdentification(2));
        yellowButton.whenPressed(new WheelColorIdentification(4));

        //WHEEL ROTATION BUTTONS
        

        //SERVO ARM ROTATION BUTTONS
        RightTrigButton.whenPressed(new BaseSink());
        LeftTrigButton.whenPressed(new BaseLift());
        LeftBumpButton.whenPressed(new ArmDump());
        RightBumpButton.whenPressed(new ArmIntake());
    }
}