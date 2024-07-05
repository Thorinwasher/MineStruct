package dev.thorinwasher.minestruct;

import dev.thorinwasher.minestruct.struct.Struct;
import dev.thorinwasher.minestruct.struct.StructSession;

import java.util.HashMap;

public class Registry<K> extends HashMap<String, K> {

    public static final Registry<Struct> STRUCTURE_REGISTRY = new Registry<>();
    public static final Registry<StructSession> STRUCTURE_SESSION_REGISTRY = new Registry<>();
}
