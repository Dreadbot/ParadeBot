package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants.SmokestackConstants;
import util.misc.DreadbotSubsystem;

public class Electromagnet extends DreadbotSubsystem {
    WPI_TalonSRX magnet = new WPI_TalonSRX(9);

    public Electromagnet() {}

    public void pull() {
        magnet.set(SmokestackConstants.electromagnetActivePower);
    }

    public void push() {
        magnet.set(-SmokestackConstants.electromagnetActivePower);
    }

    public void neutral() {
        magnet.set(0);
    }

    @Override
    public void close() {
        stopMotors();
    }

    @Override
    public void stopMotors() {
        neutral();
    }
}
