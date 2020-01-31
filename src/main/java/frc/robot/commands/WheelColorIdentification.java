/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.pixy.Pixy2;
import frc.robot.pixy.Pixy2Video;
import frc.robot.pixy.Pixy2Video.RGB;
import frc.robot.pixy.links.I2CLink;
import java.awt.Color;

public class WheelColorIdentification extends Command {
  public I2CLink link = new I2CLink();
  public Pixy2 camera = new Pixy2(link);
  public Pixy2Video video = new Pixy2Video(camera);
  int color;
  Color idealColor;
  boolean match = false;
  public WheelColorIdentification(int i) {
    this.color = i;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    colorSet();
  }

  public void colorSet() {
    switch (this.color){
      case 1: 
        idealColor = new Color(0,255,0);
      case 2: 
        idealColor = new Color(255,0,0);
      case 3:
        idealColor = new Color(0,0,255);
      case 4: 
        idealColor = new Color(255,255,0); 
      default:
        idealColor = new Color(0,0,0);
    }
  }
  public boolean colorMatch(){
    Color inputColor = video.getColor(); 
    return true;
  }
	@Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
