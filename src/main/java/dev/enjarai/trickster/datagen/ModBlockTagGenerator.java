package dev.enjarai.trickster.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        registerHeatConversion(Blocks.STONE, Blocks.DEEPSLATE);
        registerHeatConversion(Blocks.COBBLESTONE, Blocks.COBBLED_DEEPSLATE);
        registerHeatConversion(Blocks.DEEPSLATE, Blocks.MAGMA_BLOCK);
        registerHeatConversion(Blocks.COBBLED_DEEPSLATE, Blocks.MAGMA_BLOCK);
        registerHeatConversion(Blocks.DIORITE, Blocks.TUFF);
        registerHeatConversion(Blocks.ANDESITE, Blocks.TUFF);
        registerHeatConversion(Blocks.GRANITE, Blocks.TUFF);
        registerHeatConversion(Blocks.MAGMA_BLOCK, Blocks.LAVA);
        registerHeatConversion(Blocks.MUD, Blocks.PACKED_MUD);
        registerHeatConversion(Blocks.SAND, Blocks.GLASS);
        registerHeatConversion(Blocks.RED_SAND, Blocks.ORANGE_STAINED_GLASS);
        registerHeatConversion(Blocks.RAW_IRON_BLOCK, Blocks.IRON_BLOCK);
        registerHeatConversion(Blocks.RAW_GOLD_BLOCK, Blocks.GOLD_BLOCK);
        registerHeatConversion(Blocks.RAW_COPPER_BLOCK, Blocks.COPPER_BLOCK);
        registerHeatConversion(Blocks.BLUE_ICE, Blocks.PACKED_ICE);
        registerHeatConversion(Blocks.PACKED_ICE, Blocks.ICE);
        registerHeatConversion(Blocks.ICE, Blocks.WATER);
        registerHeatConversion(Blocks.WATER_CAULDRON, Blocks.CAULDRON);
        registerHeatConversion(Blocks.DIRT, Blocks.COARSE_DIRT);
        registerHeatConversion(Blocks.GRASS_BLOCK, Blocks.COARSE_DIRT);
        registerHeatConversion(Blocks.DIRT_PATH, Blocks.COARSE_DIRT);
        registerHeatConversion(Blocks.PODZOL, Blocks.COARSE_DIRT);
        registerHeatConversion(Blocks.MYCELIUM, Blocks.COARSE_DIRT);
        registerHeatConversion(Blocks.ROOTED_DIRT, Blocks.COARSE_DIRT);
        registerHeatConversion(Blocks.FARMLAND, Blocks.COARSE_DIRT);
        registerHeatConversion(Blocks.WATER, Blocks.AIR);
        registerHeatConversion(Blocks.SNOW, Blocks.AIR);
        registerHeatConversion(Blocks.SNOW_BLOCK, Blocks.AIR);
        registerHeatConversion(Blocks.OAK_SAPLING, Blocks.DEAD_BUSH);
        registerHeatConversion(Blocks.SPRUCE_SAPLING, Blocks.DEAD_BUSH);
        registerHeatConversion(Blocks.BIRCH_SAPLING, Blocks.DEAD_BUSH);
        registerHeatConversion(Blocks.JUNGLE_SAPLING, Blocks.DEAD_BUSH);
        registerHeatConversion(Blocks.ACACIA_SAPLING, Blocks.DEAD_BUSH);
        registerHeatConversion(Blocks.DARK_OAK_SAPLING, Blocks.DEAD_BUSH);
        registerHeatConversion(Blocks.CHERRY_SAPLING, Blocks.DEAD_BUSH);
        registerHeatConversion(Blocks.AZALEA, Blocks.DEAD_BUSH);
        registerHeatConversion(Blocks.FLOWERING_AZALEA, Blocks.DEAD_BUSH);
        registerHeatConversion(Blocks.WET_SPONGE, Blocks.SPONGE);
        registerHeatConversion(Blocks.COAL_ORE, Blocks.DEEPSLATE_COAL_ORE);
        registerHeatConversion(Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE);
        registerHeatConversion(Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE);
        registerHeatConversion(Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE);
        registerHeatConversion(Blocks.REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE);
        registerHeatConversion(Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE);
        registerHeatConversion(Blocks.LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE);
        registerHeatConversion(Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE);
        registerHeatConversion(Blocks.COBWEB, Blocks.AIR);

        registerCoolConversion(Blocks.WATER, Blocks.ICE);
        registerCoolConversion(Blocks.ICE, Blocks.PACKED_ICE);
        registerCoolConversion(Blocks.PACKED_ICE, Blocks.BLUE_ICE);
        registerCoolConversion(Blocks.LAVA, Blocks.OBSIDIAN);
        registerCoolConversion(Blocks.MAGMA_BLOCK, Blocks.NETHERRACK);
        registerCoolConversion(Blocks.OAK_SAPLING, Blocks.DEAD_BUSH);
        registerCoolConversion(Blocks.SPRUCE_SAPLING, Blocks.DEAD_BUSH);
        registerCoolConversion(Blocks.BIRCH_SAPLING, Blocks.DEAD_BUSH);
        registerCoolConversion(Blocks.JUNGLE_SAPLING, Blocks.DEAD_BUSH);
        registerCoolConversion(Blocks.ACACIA_SAPLING, Blocks.DEAD_BUSH);
        registerCoolConversion(Blocks.DARK_OAK_SAPLING, Blocks.DEAD_BUSH);
        registerCoolConversion(Blocks.CHERRY_SAPLING, Blocks.DEAD_BUSH);
        registerCoolConversion(Blocks.AZALEA, Blocks.DEAD_BUSH);
        registerCoolConversion(Blocks.FLOWERING_AZALEA, Blocks.DEAD_BUSH);
        registerCoolConversion(Blocks.CAULDRON, Blocks.POWDER_SNOW_CAULDRON);
    }

    public void registerHeatConversion(Block block, Block... conversions) {
        var tag = TagKey.of(RegistryKeys.BLOCK, Registries.BLOCK.getId(block).withPrefixedPath("trickster/conversion/heat/"));
        getOrCreateTagBuilder(tag).add(conversions);
    }

    public void registerCoolConversion(Block block, Block... conversions) {
        var tag = TagKey.of(RegistryKeys.BLOCK, Registries.BLOCK.getId(block).withPrefixedPath("trickster/conversion/cool/"));
        getOrCreateTagBuilder(tag).add(conversions);
    }
}
