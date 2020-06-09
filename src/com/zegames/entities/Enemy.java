package com.zegames.entities;

import com.zegames.main.Game;
import com.zegames.world.AStar;
import com.zegames.world.Vector2i;
import com.zegames.world.World;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends Entity {
    public double vida = 30;

    public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
        super(x, y, width, height, speed, sprite);
        path = AStar.findPath(Game.world, new Vector2i(World.xInitial, World.yInitial), new Vector2i(World.xFinal, World.yFinal));
    }

    public void tick() {
        followPath(path);

        if (x >= Game.WIDTH) {
            Game.vida -= Entity.rand.nextDouble();
            Game.entities.remove(this);
        }

        if (vida <= 0) {
            Game.entities.remove(this);
            Game.dinheiro += 2;
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);

        g.setColor(Color.RED);
        g.fillRect((int) x, (int) (y-5), 30, 6);

        g.setColor(Color.GREEN);
        g.fillRect((int) x, (int) (y-5), (int) ((vida / 30) * 30), 6);
    }
}
