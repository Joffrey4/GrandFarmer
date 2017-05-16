package io.github.joffrey4.grandfarmer.event;

import io.github.joffrey4.grandfarmer.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModEventHandler {

    @SubscribeEvent
    public void breakEventHandler(BlockEvent.HarvestDropsEvent event){

        // Replace the vanilla CLAY drop by the clay of this mod.
        if (event.getState().getBlock() == Blocks.CLAY) {
            event.getDrops().removeIf(itemStack -> itemStack == null || itemStack.getItem() == Items.CLAY_BALL);
            event.getDrops().add(new ItemStack(ModItems.clayBall, 4));
        }
    }
}
