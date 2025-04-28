package net.animals.capybaramod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CapybaraBedBlock extends Block {
    public CapybaraBedBlock(Settings settings) {
        super(settings);
    }


    /* Добавление звуков при ходьбе по блоку.
     * внутри if - добавляется звук хождения по листве.
     * внутри второго if добавление эффекта для живых существ - эффект как у слайм блока и его характеристики
     */
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient()) {
            // Проверяем, что сущность только что наступила на блок
            if (entity.getVelocity().y < -0.01) { // Если падает вниз
                world.playSound(null, pos, SoundEvents.BLOCK_AZALEA_LEAVES_STEP, SoundCategory.BLOCKS, 0.5F, 1.0F);
            }
        }
        // Смягчение падения (как у слизи)
        if (entity instanceof LivingEntity) {
            entity.fallDistance *= 0.5F; // Сильное смягчение (20% от обычного урона)
        }
        super.onSteppedOn(world, pos, state, entity);


    }

}

