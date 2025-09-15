package com.example.justtry;

import android.graphics.Canvas;

public abstract class GameObject {
    protected double positionX = 0;
    protected double positionY = 0;
    protected double velocityX;
    protected double velocityY;

    /*
    GameObject - абстрактный класс, который является основой
     для всех объектов игрового мира
     */

    public GameObject(double positionX, double positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }

    protected static double getDistanceBetweenObjects(GameObject obj1, GameObject obj2) {
        return Math.sqrt(
                Math.pow(obj2.getPositionX() - obj1.getPositionX(), 2) +
                  Math.pow(obj2.getPositionY() - obj1.getPositionY(), 2)
        );
    }

    public abstract void draw(Canvas canvas, String status);
    public abstract void update();

    protected double getPositionX() { return positionX; }
    protected double getPositionY() { return positionY; }
}
