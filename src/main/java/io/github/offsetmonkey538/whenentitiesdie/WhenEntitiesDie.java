package io.github.offsetmonkey538.whenentitiesdie;

import io.github.offsetmonkey538.whenentitiesdie.advancement.criterion.ModCriteria;
import net.fabricmc.api.ModInitializer;

public class WhenEntitiesDie implements ModInitializer {
    @Override
    public void onInitialize() {
        ModCriteria.register();
        // TODO: Check all the versions the mod can run on. Add them to fabric.mod.json
    }
}
