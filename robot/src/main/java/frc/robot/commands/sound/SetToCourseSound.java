package frc.robot.commands.sound;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.SoundSystemConstants;
import frc.robot.subsystems.SoundSystem;

public class SetToCourseSound extends CommandBase {
    private SoundSystem soundSystem;

    public SetToCourseSound(SoundSystem soundSystem) {
        this.soundSystem = soundSystem;
    }

    @Override
    public void execute() {
        soundSystem.startSound(SoundSystemConstants.TURRET_ID);
    }

    @Override
    public void end(boolean interrupted) {
        soundSystem.neutralSound(SoundSystemConstants.TURRET_ID);
    }
}
