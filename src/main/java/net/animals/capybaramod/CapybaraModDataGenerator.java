package net.animals.capybaramod;

import net.animals.capybaramod.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class CapybaraModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack data = fabricDataGenerator.createPack();

		data.addProvider(ModBlockTagProvider::new);
		data.addProvider(ModItemTagProvider::new);
		data.addProvider(ModLootTableProvider::new);
		data.addProvider(ModModelProvider::new);
		data.addProvider(ModRecipeProvider::new);
	}
}
