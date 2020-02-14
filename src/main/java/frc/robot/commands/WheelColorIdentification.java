/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.pixy.Pixy2;
import frc.robot.pixy.Pixy2Video;
import frc.robot.pixy.Pixy2Video.RGB;
import frc.robot.pixy.links.SPILink;
import frc.robot.commands.TankDrive;
import java.awt.Color;

public class WheelColorIdentification extends Command {
  
  //SETS UP PIXY CAM
  public static SPILink link = new SPILink();
  public static Pixy2 camera = new Pixy2(link);
  public static Pixy2Video video = new Pixy2Video(camera);
  public static RGB ruth = video.new RGB(0, 0, 0);

  //VARIABLES USED THROUGHOUT THE CODE
  public static int numCorrect = 0;
  int color;
  public static Color idealColor;
  
  public WheelColorIdentification() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  public static void colorSet(int i) {
    if(i == 1){
      idealColor = new Color(0,255,0);
      System.out.println("GREEN");
  } else if(i == 2){
      idealColor = new Color(255,0,0);
      System.out.println("RED");
  } else if(i == 3){
      idealColor = new Color(0,0,255);
      System.out.println("BLUE");
  } else if(i == 4){
      idealColor = new Color(255,255,0); 
      System.out.println("YELLOW");
  } else {
      idealColor = new Color(0,0,0);
      System.out.println("NONE");
  }
  }
  public static boolean colorMatch(){
    int startCoordX = RobotMap.PIXY_WIDTH/2 - 10;
    int startCoordY = RobotMap.PIXY_LENGTH/2 - 10;
    for(int i = 0; i < 20; i++){
      for(int j = 0; j < 20;j++){
        video.getRGB(startCoordX + j, startCoordY + i, ruth, true);
        Color inputColor = ruth.getColor(); 
        if(inputColor.getBlue() > 255 - RobotMap.ERROR_CONSTANT){
          ruth.setB(255);
        } 
        if(inputColor.getGreen() > 255 - RobotMap.ERROR_CONSTANT){
          ruth.setG(255);
        }
        if(inputColor.getRed() > 255 - RobotMap.ERROR_CONSTANT){
          ruth.setR(255);
        }
        if(inputColor.equals(idealColor)){
          numCorrect++;
        }
      }
    } 
    if(numCorrect > 300){
      return true;
    } else {
      return false;
    }
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