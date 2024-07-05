package dev.thorinwasher.minestruct.command;

import dev.thorinwasher.minestruct.Registry;
import dev.thorinwasher.minestruct.struct.SimpleStruct;
import dev.thorinwasher.minestruct.struct.Struct;
import dev.thorinwasher.minestruct.struct.StructSession;
import net.hollowcube.schem.Schematic;
import net.hollowcube.schem.SchematicReader;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.command.builder.arguments.ArgumentWord;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class LoadStructureCommand extends Command {


    public LoadStructureCommand(@NotNull String name, @Nullable String... aliases) {
        super(name, aliases);

        setDefaultExecutor(((sender, context) -> {
            sender.sendMessage("Command syntax:\n\t" + name + " <relative-file-location>");
        }));

        ArgumentWord fileNameArgument = ArgumentType.Word("file-name");

        addSyntax(((sender, context) -> {
            if(!(sender instanceof Player player)){
                throw new IllegalArgumentException("Only players can use this command");
            }
            String fileName = context.get(fileNameArgument);
            try(InputStream inputStream = new FileInputStream(fileName)){
                Schematic schematic = SchematicReader.read(inputStream);
                Struct struct = new SimpleStruct(schematic);
                Registry.STRUCTURE_REGISTRY.put(fileName, struct);
                StructSession structSession = new StructSession(struct);
                Registry.STRUCTURE_SESSION_REGISTRY.put(player.getUuid().toString(), structSession);
            } catch (IOException e) {
                throw new IllegalArgumentException("Could not find file: " + fileName);
            }
        }), fileNameArgument);
    }
}
