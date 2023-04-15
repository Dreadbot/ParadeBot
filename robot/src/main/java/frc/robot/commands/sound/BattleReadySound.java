package frc.robot.commands.sound;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.SoundSystemConstants;
import frc.robot.subsystems.SoundSystem;

public class BattleReadySound extends CommandBase {
    private SoundSystem soundSystem;

    public BattleReadySound(SoundSystem soundSystem) {
        this.soundSystem = soundSystem;
    }

    @Override
    public void execute() {
        soundSystem.startSound(SoundSystemConstants.SOMETHING_ID);
    }

    @Override
    public void end(boolean interrupted) {
        soundSystem.neutralSound(SoundSystemConstants.SOMETHING_ID);
    }
}
