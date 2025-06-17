package net.animals.capybaramod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.animals.capybaramod.item.ModArmorMaterials;
import net.animals.capybaramod.item.tooltip.TooltipItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.CAPYBARIUM, List.of(
                            new StatusEffectInstance(StatusEffects.WATER_BREATHING, 400, 1, false, false, true),
                            new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 400, 1, false, false, true)
                    ))
                    .build();


    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player && hasFullSuitOfArmorOn(player)) {
                if (player.isSubmergedInWater()) {
                    evaluateArmorEffects(player);
                }
            }
            }
            super.inventoryTick(stack, world, entity, slot, selected);
        }



    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> effects = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
               for (StatusEffectInstance effect : effects) {
                   addStatusEffectForMaterial(player, mapArmorMaterial, effect);
               }
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect));
        }
    }

        private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
            ItemStack boots = player.getInventory().getArmorStack(0);
            ItemStack leggings = player.getInventory().getArmorStack(1);
            ItemStack chestplate = player.getInventory().getArmorStack(2);
            ItemStack helmet = player.getInventory().getArmorStack(3);

            return !helmet.isEmpty() && !chestplate.isEmpty() &&
                    !leggings.isEmpty() && !boots.isEmpty();
        }


    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack: player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem chestplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && chestplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.capybaramod.capybarium_armor.tooltip").formatted(Formatting.AQUA));
        super.appendTooltip(stack, world, tooltip, context);

    }
}
