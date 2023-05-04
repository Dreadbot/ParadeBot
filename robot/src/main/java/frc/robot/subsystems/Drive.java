package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import util.misc.DreadbotSubsystem;

public class Drive extends DreadbotSubsystem {
    private DifferentialDrive diffDrive;
    private WPI_TalonSRX leftMotor;
    private WPI_TalonSRX rightMotor;

    public Drive(int leftMotorId, int rightMotorId) {
        leftMotor = new WPI_TalonSRX(leftMotorId);
        rightMotor = new WPI_TalonSRX(rightMotorId);
        leftMotor.setInverted(true);
        diffDrive = new DifferentialDrive(this.leftMotor, this.rightMotor);
    }

    public void arcadeDrive(double xSpeed, double zRotation) {
        diffDrive.arcadeDrive(xSpeed, zRotation);
    }

    @Override
    public void close() {
        stopMotors();
        leftMotor.close();
        rightMotor.close();
    }
    
    @Override
    public void stopMotors() {
        arcadeDrive(0, 0);
    }
}
