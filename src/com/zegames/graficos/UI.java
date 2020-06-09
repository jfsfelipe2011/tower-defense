package com.zegames.graficos;

import com.zegames.main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    public static BufferedImage HEART = Game.spritesheet.getSprite(0, 16, 8, 6);

    public void render(Graphics g) {
        for (int i = 0; i < (int) Game.vida; i++) {
            g.drawImage(HEART, 20 + (i * 40), 10, 36, 36, null);
        }

        g.setFont(new Font("arial", Font.BOLD, 24));
        g.setColor(Color.YELLOW);
        g.drawString("$ " + Game.dinheiro, (Game.WIDTH * Game.SCALE) - 65, 24);
    }
}
