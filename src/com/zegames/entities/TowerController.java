package com.zegames.entities;

import com.zegames.main.Game;
import com.zegames.world.World;

import java.awt.image.BufferedImage;

public class TowerController extends Entity {
    public boolean isPressed = false;
    public int xTarget, yTarget;

    public TowerController(double x, double y, int width, int height, double speed, BufferedImage sprite) {
        super(x, y, width, height, speed, sprite);
    }

    @Override
    public void tick() {
        if (isPressed) {
            isPressed = false;
            boolean liberado = true;
            int xx = (xTarget/16) * 16;
            int yy = (yTarget/16) * 16;
            Player player = new Player(xx, yy, 16, 16,0, Game.spritesheet.getSprite(16, 16, 16, 16));

            for (int i = 0; i < Game.entities.size(); i++) {
                Entity entity = Game.entities.get(i);

                if (entity instanceof Player) {
                    if (Entity.isColidding(entity, player)) {
                        liberado = false;
                        System.out.println("Já existe uma torre aí!!");
                    }
                }
            }

            if (World.isFree(xx, yy)) {
                liberado = false;
                System.out.println("Estrada, não dá!!");
            }

            if (liberado) {
                if (Game.dinheiro < 10) {
                    System.out.println("Sem grana!!");
                    return;
                }

                Game.entities.add(player);
                Game.dinheiro -= 10;
            }
        }

        if (Game.vida <= 0) {
            System.exit(1);
        }
    }
}
