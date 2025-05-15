package net.animals.capybaramod.item.custom;

/* Импорты классов для работы с:
 * Item, ItemStack - работа с предметами в Minecraft
 * PlayerEntity — игрок.
 * World, ServerWorld — игровой мир (клиент или сервер).
 * SoundEvent, SoundEvents, SoundCategory — звуки.
 * ParticleTypes — эффекты частиц.
 * Hand — какая рука используется (левая или правая).
 * TypedActionResult — возвращаемый результат действия (например, использовать предмет).
 * UseAction — как анимация будет выглядеть при использовании (например, как у лука, еды и т.д.).
 */
import net.animals.capybaramod.sound.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class CapyFluteItem extends Item {
    // Конструктор предметов с настройками
    public CapyFluteItem(Settings settings) {
        super(settings);
    }


    // При нажатии на пкм.
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        // Проверяем, что код выполняется на стороне сервера (а не клиента)
        if (!world.isClient) {

            if (user.isSneaking()) { // Если игрок нажимает Shift
                // Проигрывается альтернативный звук
                world.playSound(
                        null, // Значит что слышно всем игрокам
                        user.getBlockPos(), // Позиция игрока
                        ModSounds.CAPYBARA_FLUTE_SHIFT, // Кастомный звук
                        SoundCategory.PLAYERS, // Категория звука
                        1.0F, // Громкость
                        1.0F // Тон
                );
                // Создание частиц вокруг головы игрока
                ((ServerWorld) world).spawnParticles(
                        ParticleTypes.NOTE, // Частицы ноты
                        user.getX(), user.getY() + 1.5, user.getZ(), // Расположение частиц
                        5, 0.3, 0.3, 0.3, 0 // Количество
                );
                user.getItemCooldownManager().set(this, 180); // Кулдаун предмета

            } else {
                // Если игрок не шифтит
                world.playSound(
                        null,
                        user.getBlockPos(),
                        ModSounds.CAPYBARA_FLUTE, // Другой звук
                        SoundCategory.PLAYERS,
                        1.0F,
                        1.0F
                );
                // Такие же частицы
                ((ServerWorld) world).spawnParticles(
                        ParticleTypes.NOTE,
                        user.getX(), user.getY() + 1.5, user.getZ(),
                        5, 0.3, 0.3, 0.3, 0
                );
                // Кулдаун в 90 тиков
                user.getItemCooldownManager().set(this, 90);
            }
        }
        // Возвращаем результат использования: успешно и оставляем предмет как есть
        return TypedActionResult.success(stack, world.isClient);
    }
    @Override
    public UseAction getUseAction(ItemStack stack) {

        return UseAction.BOW;
    }
}