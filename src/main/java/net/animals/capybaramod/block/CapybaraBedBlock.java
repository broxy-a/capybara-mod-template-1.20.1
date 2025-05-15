package net.animals.capybaramod.block; // Путь до этого класса

import net.minecraft.block.Block; // Импот класса для создания классов
import net.minecraft.block.BlockState; // Импорт для состояния блока (направление, уровень и т.д)
import net.minecraft.block.HorizontalFacingBlock; // Импорт для направления блока в стороны
import net.minecraft.entity.Entity; // Импорт для сущностей майнкрафта
import net.minecraft.entity.LivingEntity; // Импорт для ЖИВЫХ существ
import net.minecraft.entity.effect.StatusEffectInstance; // Эффекты от зелей и т.д
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemPlacementContext; // Импорт для того как блок устанавливается
import net.minecraft.sound.SoundCategory; // Импорт для указания категории звука
import net.minecraft.sound.SoundEvents; // Предопределенные звуки (например листва)
import net.minecraft.state.StateManager; //
import net.minecraft.util.math.BlockPos; // Координаты блока в мире
import net.minecraft.world.World; // Мир в котором всё происходит
import org.jetbrains.annotations.Nullable; // Проверка на null

public class CapybaraBedBlock extends Block {
    // Класс создания блока, но имеет расширение extends - обычного блока. Значит, это обычный блок но можно менять его поведение
    public CapybaraBedBlock(Settings settings) {
        super(settings); // Передача настроек моему блоку
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
                // То проигрыватеся звук листвы азалии
            }
        }

        // Смягчение падения (как у слизи)
        if (entity instanceof LivingEntity) {
            entity.fallDistance *= 0.5F; // Сильное смягчение (20% от обычного урона)
        }
        super.onSteppedOn(world, pos, state, entity); // Вызов родительского метода, тут по сути прописано стаднртное поведение блока


    }

}

