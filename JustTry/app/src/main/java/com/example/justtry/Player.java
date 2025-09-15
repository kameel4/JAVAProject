package com.example.justtry;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.widget.ImageView;
/*
Игрок - это главный персонаж игры, движимый касанием джойстика.
Игрок наследуется от Охотника, а Охотник - от GameObject
 */

public class Player extends AnimatedSprite {
    public static final double SPEED_PIXELS_PER_SECOND = 300.0;
    public static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    public String playerStatus = "rest";
    private final Joystick joystick;

    public Player(Context context, double positionX, double positionY, Resources resources, Joystick joystick){
        super(context, resources, positionX, positionY);
        this.joystick = joystick;
    }

    public void update() {
        // Рассчет значения изменения позиции игрока
        velocityX = (joystick.getActuatorX()*MAX_SPEED);
        velocityY = (joystick.getActuatorY()*MAX_SPEED);
        System.out.println(velocityX);

        if (velocityX < 0){
            this.setPlayerStatus("GoingLeft");
        }else{this.setPlayerStatus("GoingRight");}

        // Обнвление позиции игрока
        positionX += velocityX;
        positionY += velocityY;
    }

    public void setPosition(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void setPlayerStatus(String status){
        playerStatus = status;
    }
}
