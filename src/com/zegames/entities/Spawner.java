package com.zegames.entities;

import com.zegames.main.Game;

import java.awt.image.BufferedImage;

public class Spawner extends Entity {
    private int timer = 60;
    private int curTimer = 0;

    public Spawner(double x, double y, int width, int height, double speed, BufferedImage sprite) {
        super(x, y, width, height, speed, sprite);
    }

    @Override
    public void tick() {
        curTimer++;

        if (curTimer == timer) {
            Enemy enemy = new Enemy(x, y, 16, 16, Entity.rand.nextDouble(), Entity.ENEMY1);
            Game.entities.add(enemy);
            curTimer = 0;
            timer = Entity.rand.nextInt(60 - 30) + 30;
        }
    }
}
