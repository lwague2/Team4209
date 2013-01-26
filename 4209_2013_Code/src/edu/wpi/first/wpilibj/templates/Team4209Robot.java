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

    private Joystick m_leftStick = new Joystick(1); /*joystick called m_leftStick plugged into Port 1*/
    private Joystick m_rightStick = new Joystick(2); /* joystick called m_rightStick plugged into Port 2 */

    //Drive Motors
    private SpeedController m_left_front = new Victor(4);
    private SpeedController m_right_front = new Victor(2);
    private SpeedController m_left_back = new Victor(5);
    private SpeedController m_right_back = new Victor(3);
    private RobotDrive drive = new RobotDrive(m_left_front, m_left_back, m_right_front, m_right_back);
    
    //Other Motors
    private SpeedController m_arm_big = new Victor(6);
    private SpeedController m_arm_small = new Victor(7);
    private SpeedController m_powerDumper = new Victor(8);

    //Pnuematics
    private Compressor compressor = new Compressor(14, 1);
    private DoubleSolenoid piston_big = new DoubleSolenoid(1, 2);
    private DoubleSolenoid piston_small = new DoubleSolenoid(3, 4);

    /**
     * Called once when the robot is first turned on.
     */
    public void robotInit() {
      // compressor.start();
    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomousContinuous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void teleopContinuous() {
            drive.arcadeDrive(m_leftStick);
    }
}