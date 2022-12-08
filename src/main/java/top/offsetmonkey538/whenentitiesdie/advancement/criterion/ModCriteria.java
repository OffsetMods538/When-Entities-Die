package top.offsetmonkey538.whenentitiesdie.advancement.criterion;

import net.minecraft.advancement.criterion.Criteria;

public final class ModCriteria {

    public static final KilledUsingItemCriterion KILLED_USING_ITEM = Criteria.register(new KilledUsingItemCriterion());

    private ModCriteria() {

    }

    public static void register() {
        // Registers all criteria because this class is now loaded
    }
}
