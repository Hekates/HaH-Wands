package ch.hekates.wands.spells;

import ch.hekates.wands.Main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Protego {

    public static void use(Player player) {
        Location location = player.getLocation().add(0, 1, 0);
        player.playSound(location, Sound.ENTITY_ARROW_SHOOT, 1, 0);
        player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 5, 1));


        Integer cd = null;
        Integer finalCd = cd;
        cd = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {

            Location location = player.getLocation().add(0, 1, 0);
            Particle.DustTransition dustTransition = new Particle.DustTransition(Color.AQUA, Color.WHITE, 0.5f);

            float value = 0.2f;
            public Integer time = 5;

            @Override
            public void run() {
                if (time >= 0) {
                    for (double i = 0; i <= Math.PI; i += Math.PI / 10) {
                        double radius = Math.sin(i) * value;
                        double y = Math.cos(i) * value;
                        for (double a = 0; a < Math.PI * 2; a += Math.PI / 10) {
                            double x = Math.cos(a) * radius;
                            double z = Math.sin(a) * radius;
                            location.add(x, y, z);
                            player.getWorld().spawnParticle(Particle.REDSTONE, location, 1, dustTransition);
                            location.subtract(x, y, z);
                        }
                    }
                }else if (time == 0){
                    Bukkit.getScheduler().cancelTask(finalCd);
                }

                time--;
                value += 0.2;
            }
        }, 0, 1);
    }
}
