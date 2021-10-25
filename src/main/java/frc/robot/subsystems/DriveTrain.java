// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
    private final TalonFX m_frontLeft, m_backLeft, m_frontRight, m_backRight;
    private final Encoder m_leftEncoder, m_rightEncoder;

    /** Creates a new DriveTrain */
    public DriveTrain() {
        m_frontLeft = new TalonFX(RobotMap.CAN.TALONFX_DRIVE_FRONT_LEFT);
        m_backLeft = new TalonFX(RobotMap.CAN.TALONFX_DRIVE_BACK_LEFT);
        m_frontRight = new TalonFX(RobotMap.CAN.TALONFX_DRIVE_FRONT_RIGHT);
        m_backRight = new TalonFX(RobotMap.CAN.TALONFX_DRIVE_BACK_RIGHT);

        m_frontLeft.setInverted(true);
        m_backLeft.setInverted(true);
        m_frontRight.setInverted(false);
        m_backRight.setInverted(false);
        
        m_leftEncoder = new Encoder(RobotMap.DIO.DRIVE_LEFT_ENCODER_A, RobotMap.DIO.DRIVE_LEFT_ENCODER_B);
        m_rightEncoder = new Encoder(RobotMap.DIO.DRIVE_RIGHT_ENCODER_A, RobotMap.DIO.DRIVE_RIGHT_ENCODER_B);

        m_leftEncoder.setReverseDirection(true);
        m_rightEncoder.setReverseDirection(false);
        m_leftEncoder.setDistancePerPulse(Constants.DriveTrain.ENCODER_METERS_PER_TICK);
        m_rightEncoder.setDistancePerPulse(Constants.DriveTrain.ENCODER_METERS_PER_TICK);
    }

    public double getLeftDistance() {
        return m_leftEncoder.getDistance();
    }

    public double getRightDistance() {
        return m_rightEncoder.getDistance();
    }

    public double getAverageDistance() {
        return (getLeftDistance() + getRightDistance()) / 2;
    }

    public void resetEncoders() {
        m_leftEncoder.reset();
        m_rightEncoder.reset();
    }

    public double getLeftWheelVelocity() {
        return m_leftEncoder.getRate();
    }

    public double getRightWheelVelocity() {
        return m_rightEncoder.getRate();
    }

    public void setLeftVelocity(double speed) {
        m_frontLeft.set(ControlMode.PercentOutput, speed);
        m_backLeft.set(ControlMode.PercentOutput, speed);
    }

    public void setRightVelocity(double speed) {
        m_frontRight.set(ControlMode.PercentOutput, speed);
        m_backRight.set(ControlMode.PercentOutput, speed);
    }

    public void stopLeftMotors() {
        setLeftVelocity(0);
    }

    public void stopRightMotors() {
        setRightVelocity(0);
    }

    public void arcadeDrive(double ySpeed, double xRotation) {
        ySpeed = Math.max(-1, Math.min(1, ySpeed));
        xRotation = Math.max(-1, Math.min(1, ySpeed));

        setLeftVelocity(ySpeed - xRotation);
        setRightVelocity(ySpeed + xRotation);
    }
}
