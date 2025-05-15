package net.animals.capybaramod.sound;

import net.animals.capybaramod.CapybaraMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent CAPYBARA_FLUTE = registerSoundEvent("capy_flute");
    public static final SoundEvent CAPYBARA_FLUTE_SHIFT = registerSoundEvent("capy_flute_shift");



    public static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(CapybaraMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        CapybaraMod.LOGGER.info("Registering sounds for " + CapybaraMod.MOD_ID);
    }
}
