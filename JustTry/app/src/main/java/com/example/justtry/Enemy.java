package com.example.justtry;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;

public class Enemy extends AnimatedSprite{
    private static final double SPAWNS_PER_MINUTE = 10;
    private static final double SPAWNS_PER_SECOND = SPAWNS_PER_MINUTE/60.0;
    private static final double UPDATES_PER_SPAWN = GameLoop.MAX_UPS/SPAWNS_PER_SECOND;
    private static double updatesUntilNextSpawn = UPDATES_PER_SPAWN;
    private final Player player;
    private static final double SPEED_PIXELS_PER_SECOND = Player.SPEED_PIXELS_PER_SECOND*0.6;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    public String enemyStatus = "enemyGoingRight";

    public Enemy(Context context, Resources resources,Player player, double positionX, double positionY) {
        super(context, resources, positionX, positionY);
        this.player = player;
    }

    public Enemy(Context context, Player player) {
        super(context,
                context.getResources(),
                Math.random()*1000,
                Math.random()*1000);
        this.player = player;

    }

    /**
     * ReadyToSpawn проверяет, должен ли появиться новый враг, опираясь
     * на определенное кол-во появлений в минуту (см. SPAWNS_PER_MINUTE наверху)
     * @return
     */
    public static boolean readyToSpawn() {
        if (updatesUntilNextSpawn <=0 ){
            updatesUntilNextSpawn += UPDATES_PER_SPAWN;
            return true;
        }else{
            updatesUntilNextSpawn--;
            return false;
        }
    }

    @Override
    public void update() {
        // Рассчет вектора от врага до игрока (в координатах X и Y)
        double distanceToPlayerX = player.getPositionX() - positionX;
        double distanceToPlayerY = player.getPositionY() - positionY;

        // Рассчет дистанции между врагом (this) и игроком
        double distanceToPlayer = GameObject.getDistanceBetweenObjects(this, player);
        // Рассчет напрвления от врага к игроку
        double directionX = distanceToPlayerX/distanceToPlayer;
        double directionY = distanceToPlayerY/distanceToPlayer;
        // Рассчет значения изменения позиции
        if (distanceToPlayer > 0){ // Во избежание деления на ноль
        velocityX = directionX*MAX_SPEED;
        if (velocityX<0)
        {this.enemyStatus = "enemyGoingLeft";}else
        {this.enemyStatus = "enemyGoingRight";}
        velocityY = directionY*MAX_SPEED;
        }else{
            velocityX = 0;
            velocityY = 0;
        }

        // Непосредственно изменение позиции
        positionX += velocityX;
        positionY += velocityY;
    }
}
