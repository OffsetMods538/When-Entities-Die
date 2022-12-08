package top.offsetmonkey538.whenentitiesdie.advancement.criterion;

import com.google.gson.JsonObject;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.entity.Entity;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.AdvancementEntityPredicateSerializer;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class KilledUsingItemCriterion extends AbstractCriterion<KilledUsingItemCriterion.Conditions> {
    static final Identifier ID = new Identifier("when-entities-die", "killed_using_item");

    @Override
    public Identifier getId() {
        return ID;
    }

    public void trigger(ServerPlayerEntity player, Entity killedEntity) {
        this.trigger(player, conditions -> conditions.matches(player, killedEntity));
    }

    @Override
    public Conditions conditionsFromJson(JsonObject jsonObject, EntityPredicate.Extended player, AdvancementEntityPredicateDeserializer advancementEntityPredicateDeserializer) {
        ItemPredicate item = ItemPredicate.fromJson(jsonObject.get("item"));
        EntityPredicate entity = EntityPredicate.fromJson(jsonObject.get("entity"));

        return new Conditions(player, item, entity);
    }

    public static class Conditions extends AbstractCriterionConditions {
        private final ItemPredicate item;
        private final EntityPredicate entity;

        public Conditions(EntityPredicate.Extended player, ItemPredicate item, EntityPredicate entity) {
            super(ID, player);
            this.item = item;
            this.entity = entity;
        }

        @Override
        public JsonObject toJson(AdvancementEntityPredicateSerializer predicateSerializer) {
            JsonObject jsonObject = super.toJson(predicateSerializer);

            jsonObject.add("item", item.toJson());
            jsonObject.add("entity", entity.toJson());

            return jsonObject;
        }

        public boolean matches(ServerPlayerEntity player, Entity killedEntity) {
            return (item.test(player.getInventory().getMainHandStack()) && entity.test(player, killedEntity));
        }
    }
}
