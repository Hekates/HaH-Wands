package ch.hekates.wands.wands;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import ch.hekates.wands.utils.ItemBuilder;
import ch.hekates.wands.utils.LoreBuilder;

public class Wands {

    //Standard Zauberstab ohne spezifikationen
    public static ItemStack NormalWand = new ItemBuilder(Material.STICK, 1)
            .setName("Normaler Zauberstab").setLore(new LoreBuilder()
                    .emptyLine()
                    .description("Ein normaler Zauberstab ohne Parameter")
                    .emptyLine()
                    .build())
            .setEnchantment(true)
            .build();
}
