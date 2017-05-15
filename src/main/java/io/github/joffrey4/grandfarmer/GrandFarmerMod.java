package io.github.joffrey4.grandfarmer;

import io.github.joffrey4.grandfarmer.block.ModBlocks;
import io.github.joffrey4.grandfarmer.client.GrandFarmerTab;
import io.github.joffrey4.grandfarmer.fluid.ModFluids;
import io.github.joffrey4.grandfarmer.item.ModItems;
import io.github.joffrey4.grandfarmer.proxy.CommonProxy;
import io.github.joffrey4.grandfarmer.recipes.ModRecipes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = GrandFarmerMod.modId, name = GrandFarmerMod.name, version = GrandFarmerMod.version, acceptedMinecraftVersions = "[1.10.2]")
public class GrandFarmerMod {

    @SidedProxy(serverSide = "io.github.joffrey4.grandfarmer.proxy.CommonProxy", clientSide = "io.github.joffrey4.grandfarmer.proxy.ClientProxy")
    public static CommonProxy proxy;

    public static final String modId = "grandfarmer";
    public static final String name = "Grand Farmer";
    public static final String version = "1.0.0";

    public static final GrandFarmerTab creativeTab = new GrandFarmerTab();

    @Mod.Instance(modId)
    public static GrandFarmerMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(name + " is loading!");
        ModFluids.init();
        ModBlocks.init();
        ModItems.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModRecipes.init();

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}
