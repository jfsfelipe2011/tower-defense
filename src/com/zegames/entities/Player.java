package com.zegames.entities;

import com.zegames.main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{
    public int xTarget, yTarget;
    public boolean atacando = false;

    public Player(int x, int y, int width, int height,double speed,BufferedImage sprite) {
        super(x, y, width, height,speed,sprite);
    }

    public void tick() {
        Enemy enemy = null;

        for (int i = 0; i < Game.entities.size(); i++) {
            Entity entity = Game.entities.get(i);

            if (entity instanceof Enemy) {
                int xEnemy = entity.getX();
                int yEnemy = entity.getY();

                if (Entity.calculateDistance(this.getX(), this.getY(), xEnemy, yEnemy) < 40) {
                    enemy = (Enemy) entity;
                }
            }
        }

        if (enemy != null) {
            atacando = true;
            xTarget = enemy.getX();
            yTarget = enemy.getY();

            if (Entity.rand.nextInt(100) < 30) {
                enemy.vida -= Entity.rand.nextDouble();
            }
        } else {
            atacando = false;
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);

        if (atacando) {
            g.setColor(Color.BLUE);
            g.drawLine(this.getX() + 7, this.getY(), xTarget + 7, yTarget + 4);
        }
    }
}
