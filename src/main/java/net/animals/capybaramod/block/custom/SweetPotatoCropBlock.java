package net.animals.capybaramod.block.custom;

import net.animals.capybaramod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class SweetPotatoCropBlock extends CropBlock {

    // Максимальный возраст роста кульутуры (как у картошки 7)
    public static final int MAX_AGE = 7;
    // Создание параметров состояние блока, которое будет хранить возраст роста. С помощью него майнкрафт знает, как рендерить стадии роста и как его обрабатывать.
    public static final IntProperty AGE_POTATO = Properties.AGE_7;

    // Просто конструктор родителя
     public SweetPotatoCropBlock(Settings settings) {
        super(settings);
    }

    // Какие семена используются для него
    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.SWEET_POTATO_SEEDS;
    }

    // Передача параметров роста культуры
    @Override
    public IntProperty getAgeProperty() {
        return AGE_POTATO;
    }

    // Передача до какого возраста растет культура
    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    // Говорит о том что у блока есть доп.состояния в переменной AGE_POTATO которые будут отслеживаться.
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
         builder.add(AGE_POTATO);
    }
}
