package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Joystick.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Team4209Robot extends IterativeRobot {

    private Joystick leftStick;
    //private Joystick rightStick;

    //Drive Motors
    private SpeedController m_left1;
    private SpeedController m_right1;
    private SpeedController m_left2;
    private SpeedController m_right2;
    private RobotDrive drive1;
    private RobotDrive drive2;
    
    //Other Motors
    /*
    private SpeedController m_arm_big = new Victor(3);
    private SpeedController m_arm_small = new Victor(4);
    private SpeedController m_powerDumper = new Victor(5);*/

    //Pnuematics
    /*private Compressor compressor = new Compressor(14, 1);
    private DoubleSolenoid piston_big = new DoubleSolenoid(1, 2);
    private DoubleSolenoid piston_small = new DoubleSolenoid(3, 4);*/
    private DriverStationLCD lcd = DriverStationLCD.getInstance();;

    /**
     * Called once when the robot is first turned on.
     */
    public void robotInit() {
        leftStick = new Joystick(1);
        //rightStick = new Joystick(2);
        m_left1 = new Victor(3);
        m_right1 = new Victor(1);
        m_left2 = new Victor(4);
        m_right2 = new Victor(2);
        drive1 = new RobotDrive(m_left1, m_right1);
        drive2 = new RobotDrive(m_left2, m_right2);


        drive1.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
        drive1.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
        drive1.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
        drive1.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
        drive2.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
        drive2.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
        drive2.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
        drive2.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);

        getWatchdog().setEnabled(false);
        // compressor.start();
        lcd.println(DriverStationLCD.Line.kUser2, 1, "Enabled!     ");
        lcd.updateLCD();
    }

    public void disabledInit() {
        lcd.println(DriverStationLCD.Line.kUser2, 1, "Disabled     ");
        lcd.updateLCD();
    }

    public void disabledContinuous() {

    }

    public void disabledPeriodic() {

    }

    public void autonomousInit() {
        lcd.println(DriverStationLCD.Line.kUser2, 1, "Auto     ");
        lcd.updateLCD();
    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomousContinuous() {
        
    }

    public void autonomousPeriodic() {
        
    }

    public void teleopInit() {
        lcd.println(DriverStationLCD.Line.kUser2, 1, "Teleop     ");
        lcd.updateLCD();
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    long x = 0;
    public void teleopContinuous() {
        double leftSpeed = leftStick.getY()*-1;
        //if (leftSpeed < .25) leftSpeed = 0;
        drive1.tankDrive(leftSpeed,leftSpeed);
        drive2.tankDrive(leftSpeed,leftSpeed);
        lcd.println(DriverStationLCD.Line.kMain6, 1, ""+leftSpeed);
        lcd.println(DriverStationLCD.Line.kUser4, 1, ""+ ++x);
        lcd.updateLCD();
    }

    public void teleopPeriodic() {

    }
}