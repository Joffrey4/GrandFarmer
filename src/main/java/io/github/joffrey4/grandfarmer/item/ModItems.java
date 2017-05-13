package io.github.joffrey4.grandfarmer.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    public static ItemFood bacon;
    public static ItemFood cookedBacon;
    public static ItemFood cookedFlesh;

    public static void init() {

        bacon = register(new ItemFood("bacon", 1, 0.3F, true));
        cookedBacon = register(new ItemFood("cookedBacon", 3, 0.8F, true));
        cookedFlesh = register(new ItemFood("cookedFlesh", 4, 1.0F, true));

    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemModelProvider) {
            ((ItemModelProvider)item).registerItemModel(item);
        }

        return item;
    }

}
