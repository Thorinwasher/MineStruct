package dev.thorinwasher.minestruct.command;

import dev.thorinwasher.minestruct.Registry;
import dev.thorinwasher.minestruct.struct.StructSession;
import dev.thorinwasher.minestruct.vector.Axis;
import dev.thorinwasher.minestruct.vector.RotationType;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentEnum;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RotateStructure extends Command {
    public RotateStructure(@NotNull String name, @Nullable String... aliases) {
        super(name, aliases);

        setDefaultExecutor(((sender, context) -> {
            sender.sendMessage("Command syntax:\n\t" + name + " <rotation-axis> <rotation>");
        }));

        ArgumentEnum<Axis> axisArgument = ArgumentType.Enum("rotation-axis", Axis.class).setFormat(ArgumentEnum.Format.LOWER_CASED);
        ArgumentEnum<RotationType> rotationArgument = ArgumentType.Enum("rotation", RotationType.class).setFormat(ArgumentEnum.Format.LOWER_CASED);
        addSyntax((sender, context) -> {
            if (!(sender instanceof Player player)) {
                throw new IllegalArgumentException("Only player can execute this command!");
            }
            StructSession session = Registry.STRUCTURE_SESSION_REGISTRY.get(player.getUuid().toString());
            if (session == null) {
                throw new IllegalArgumentException("You're not in an active session!");
            }
            Axis axis = context.get(axisArgument);
            RotationType rotationType = context.get(rotationArgument);
            session.rotate(rotationType, axis);
        }, axisArgument, rotationArgument);
    }
}
