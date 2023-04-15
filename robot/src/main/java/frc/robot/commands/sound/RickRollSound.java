package frc.robot.commands.sound;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants.SoundSystemConstants;
import frc.robot.subsystems.SoundSystem;

public class RickRollSound extends InstantCommand {
    private SoundSystem soundSystem;

    public RickRollSound(SoundSystem soundSystem) {
        this.soundSystem = soundSystem;
    }

    @Override
    public void execute() {
        soundSystem.startSound(SoundSystemConstants.RICK_ROLL_ID);
    }

    @Override
    public void end(boolean interrupted) {
        soundSystem.neutralSound(SoundSystemConstants.RICK_ROLL_ID);
    }
}
