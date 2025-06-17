package net.animals.capybaramod; // Путь к пакету

import net.animals.capybaramod.block.ModBlocks;
import net.animals.capybaramod.item.ModItemGroup; // Импорт класса для создания вкладки в креативе
import net.animals.capybaramod.item.ModItems; // Регистрация предметов
import net.animals.capybaramod.sound.ModSounds;
import net.animals.capybaramod.util.ModLootTableModify;
import net.fabricmc.api.ModInitializer; // Интерфейс Fabric, для инициализации мода
import org.slf4j.Logger; // Вывод логов (сообщений) в консоль
import org.slf4j.LoggerFactory; // Фабрика логгеров

// Класс мода, вызывается fabric при запуске
public class CapybaraMod implements ModInitializer {
	public static final String MOD_ID = "capybaramod"; // Идентификатор мода, нужен для регистрации путей, json, предметов и т.д

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID); // Логгер - который выводит текст в консоль при запуске игры

	// Метод который вызывается при запуске игры, тут регестрируется все что надо.
	@Override
	public void onInitialize() {
		ModItemGroup.registerItemsGroup(); // Регистрация вкладки креатива.

		//ModEffects.registerStatusEffects(); // Регистрация эффектов.
		ModItems.registerModItems(); // Регистрация предметов.
		ModBlocks.registerModBlocks(); // Регистрация блоков.
		ModSounds.registerSounds(); // Регистрация звуков.
		ModLootTableModify.modify(); // Регистрация таблиц лута

	}
}