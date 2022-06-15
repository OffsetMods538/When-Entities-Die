package io.github.offsetmonkey538.whenentitiesdie;

import io.github.offsetmonkey538.whenentitiesdie.advancement.criterion.ModCriteria;
import net.fabricmc.api.ModInitializer;

public class WhenEntitiesDie implements ModInitializer {
    @Override
    public void onInitialize() {
        ModCriteria.register();
    }
}
