package net.animals.capybaramod.item;

import net.animals.capybaramod.CapybaraMod;
import net.minecraft.client.sound.Sound;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    CAPYBARIUM ("capybarium_ingot", 17, new int[] {2, 6, 5, 2}, 11,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1f, 0f, () -> Ingredient.ofItems(ModItems.CAPYBARIUM_INGOT));

    // Имя материала для брони
    private final String name;

    // Множитель прочности. Базовая прочность каждой части брони умножается на этот множитель.
    //Например, если BASE_DURABILITY = {13, 15, 16, 11} и durabilityMulti = 30.
    private final int durabilityMulti;

    // Сколько брони дает каждый элемент (ботинки, поножи, нагрудник, шлем)
    private final int[] protectionAmounts;

    // Зачаровываемость — насколько хорошо броня чаруется.
    private final int enchantability;

    // Звук надевания брони.
    private final SoundEvent equipSound;

    // Прочность против сильных ударов. Только алмаз и незерит такое использует
    private final float toughness;

    // Сопротивление отбрасыванию. Только у незеритки.
    private final float knockBackResistence;

    // Из чего чинится брони на наковальне
    private final Supplier<Ingredient> repairIngredient;

    // Базовые значения прочности
    private static final int[] BASE_DURABILITY = {13, 16, 16, 11};

    ModArmorMaterials(String name, int durabilityMulti, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockBackResistence, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMulti = durabilityMulti;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockBackResistence = knockBackResistence;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMulti;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return CapybaraMod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockBackResistence;
    }
}
