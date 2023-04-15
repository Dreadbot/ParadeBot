package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import util.misc.DreadbotSubsystem;

public class SoundSystem extends DreadbotSubsystem {
    Relay[] relays = {
        new Relay(0),
        new Relay(1),
        new Relay(2),
        new Relay(3),
    };

    public SoundSystem() {}

    public void startSound(int relayId) {
        System.out.printf("Starting relay %d%n", relayId);
        relays[relayId].set(Value.kForward);
    }

    public void neutralSound(int relayId) {
        relays[relayId].set(Value.kOff);
    }

    public void close() {}
    public void stopMotors() {}
}
