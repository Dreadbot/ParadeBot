package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import util.misc.DreadbotSubsystem;

public class Turret extends DreadbotSubsystem{
    private CANSparkMax turretMotor;
    private DigitalInput leftLimitSwitch;
    private DigitalInput rightLimitSwitch;
    private double leftLimitSwitchPosition;
    private double rightLimitSwitchPosition;


    public Turret() {
        turretMotor = new CANSparkMax(3, MotorType.kBrushless);
        leftLimitSwitchPosition = 1000; //starting values, when we trigger the limit switches we will remember the position so that if we get behind one,
        rightLimitSwitchPosition = -1000; //we stop so we don't break anything
        leftLimitSwitch = new DigitalInput(0);
        rightLimitSwitch = new DigitalInput(1);
    }
    public void rotateTurret(double speed) {
        if(getLeftLimitSwitch() && Math.signum(speed) > 0) {
            leftLimitSwitchPosition = turretMotor.getEncoder().getPosition();
            speed = 0;
        }
        if(turretMotor.getEncoder().getPosition() > leftLimitSwitchPosition && Math.signum(speed) > 0) {
            speed = 0;
        }
        if(getRightLimitSwitch() && Math.signum(speed) < 0) {
            rightLimitSwitchPosition = turretMotor.getEncoder().getPosition();
            speed = 0;
        }
        if(turretMotor.getEncoder().getPosition() < rightLimitSwitchPosition && Math.signum(speed) < 0) {
            speed = 0;
        }
        turretMotor.set(speed);
    }
    public boolean getLeftLimitSwitch() {
        return !leftLimitSwitch.get();
    }
    public boolean getRightLimitSwitch() {
        return !rightLimitSwitch.get();
    }
    @Override
    public void close() throws Exception {
        stopMotors();
    }

    @Override
    public void stopMotors() {
        turretMotor.close();
    }
    
}
