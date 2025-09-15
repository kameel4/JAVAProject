package com.example.justtry;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/*
Охотник - абстрактный класс, который реализует метод draw() класса GameObject,
отрисовывающий анимированного охотника
 */
public abstract class AnimatedSprite extends GameObject {

    public int archerDrawCounter = 3;
    public int archerAnimationTimer = 0;
    public int enemyDrawCounter = 3;
    public int enemyAnimationTimer = 0;
    private int frame0;
    private int frame1;
    private int frame2;
    private int frame3;
    private int frame4;
    private int frame5;
    private int frame6;
    private int frame7;
    protected Resources resources;


    public AnimatedSprite(Context context, Resources resources, double positionX, double positionY) {
        super(positionX, positionY);
        this.resources = resources;
    }

    public void draw(Canvas canvas, String status) {
        switch (status){
            case "rest":
                frame0 = R.drawable.clear_archer_frame0;
                frame1 = R.drawable.clear_archer_frame1;
                frame2 = R.drawable.clear_archer_frame2;
                frame3 = R.drawable.clear_archer_frame3;

                switch (archerDrawCounter%4){
                    case 0: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame0), (int)positionX, (int)positionY, null);
                        archerAnimationTimer++;
                        if (archerAnimationTimer == 8){archerDrawCounter++; archerAnimationTimer = 0;}
                        break;
                    case 1: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame1), (int)positionX, (int)positionY, null);
                        archerAnimationTimer++;
                        if (archerAnimationTimer == 8){archerDrawCounter++; archerAnimationTimer = 0;}
                        break;
                    case 2: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame2), (int)positionX, (int)positionY, null);
                        archerAnimationTimer++;
                        if (archerAnimationTimer == 8){archerDrawCounter++; archerAnimationTimer = 0;}
                        break;
                    case 3: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame3), (int)positionX, (int)positionY, null);
                        archerAnimationTimer++;
                        if (archerAnimationTimer == 8){archerDrawCounter=0; archerAnimationTimer = 0;}
                        break;
                    default: System.out.println("Что-то не так с REST");
                }
                break;

            case "GoingRight":
                frame0 = R.drawable.clear_walk0;
                frame1 = R.drawable.clear_walk1;
                frame2 = R.drawable.clear_walk2;
                frame3 = R.drawable.clear_walk3;

                switch (archerDrawCounter%4){
                    case 0: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame0), (int)positionX, (int)positionY, null);
                        archerAnimationTimer++;
                        if (archerAnimationTimer == 8){archerDrawCounter++; archerAnimationTimer = 0;}
                        break;
                    case 1: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame1), (int)positionX, (int)positionY, null);
                        archerAnimationTimer++;
                        if (archerAnimationTimer == 8){archerDrawCounter++; archerAnimationTimer = 0;}
                        break;
                    case 2: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame2), (int)positionX, (int)positionY, null);
                        archerAnimationTimer++;
                        if (archerAnimationTimer == 8){archerDrawCounter++; archerAnimationTimer = 0;}
                        break;
                    case 3: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame3), (int)positionX, (int)positionY, null);
                        archerAnimationTimer++;
                        if (archerAnimationTimer == 8){archerDrawCounter=0; archerAnimationTimer = 0;}
                        break;
                    default: System.out.println("Что-то не так с MOVE");
                }
                break;

            case "enemyGoingRight":
                frame0 = R.drawable.clear_wolf1;
                frame1 = R.drawable.clear_wolf2;
                frame2 = R.drawable.clear_wolf3;
                frame3 = R.drawable.clear_wolf4;
                frame4 = R.drawable.clear_wolf5;
                frame5 = R.drawable.clear_wolf6;
                frame6 = R.drawable.clear_wolf7;
                frame7 = R.drawable.clear_wolf8;

                switch (enemyDrawCounter%8){
                    case 0: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame0), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter++; enemyAnimationTimer = 0;}
                        break;
                    case 1: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame1), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter++; enemyAnimationTimer = 0;}
                        break;
                    case 2: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame2), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter++; enemyAnimationTimer = 0;}
                        break;
                    case 3: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame3), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter=0; enemyAnimationTimer = 0;}
                        break;
                    case 4: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame4), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter=0; enemyAnimationTimer = 0;}
                        break;
                    case 5: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame5), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter=0; enemyAnimationTimer = 0;}
                        break;
                    case 6: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame6), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter=0; enemyAnimationTimer = 0;}
                        break;
                    case 7: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame7), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter=0; enemyAnimationTimer = 0;}
                        break;
                    default: System.out.println("Что-то не так с ENEMYWOLF");
                }
                break;

            case "GoingLeft":
                frame0 = R.drawable.clear_walk_left0;
                frame1 = R.drawable.clear_walk_left1;
                frame2 = R.drawable.clear_walk_left2;
                frame3 = R.drawable.clear_walk_left3;

                switch (archerDrawCounter%4){
                    case 0: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame0), (int)positionX, (int)positionY, null);
                        archerAnimationTimer++;
                        if (archerAnimationTimer == 8){archerDrawCounter++; archerAnimationTimer = 0;}
                        break;
                    case 1: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame1), (int)positionX, (int)positionY, null);
                        archerAnimationTimer++;
                        if (archerAnimationTimer == 8){archerDrawCounter++; archerAnimationTimer = 0;}
                        break;
                    case 2: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame2), (int)positionX, (int)positionY, null);
                        archerAnimationTimer++;
                        if (archerAnimationTimer == 8){archerDrawCounter++; archerAnimationTimer = 0;}
                        break;
                    case 3: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame3), (int)positionX, (int)positionY, null);
                        archerAnimationTimer++;
                        if (archerAnimationTimer == 8){archerDrawCounter=0; archerAnimationTimer = 0;}
                        break;
                    default: System.out.println("Что-то не так с MOVE");
                }
                break;

            case "enemyGoingLeft":
                frame0 = R.drawable.clear_wolf_left1;
                frame1 = R.drawable.clear_wolf_left2;
                frame2 = R.drawable.clear_wolf_left3;
                frame3 = R.drawable.clear_wolf_left4;
                frame4 = R.drawable.clear_wolf_left5;
                frame5 = R.drawable.clear_wolf_left6;
                frame6 = R.drawable.clear_wolf_left7;
                frame7 = R.drawable.clear_wolf_left8;

                switch (enemyDrawCounter%8){
                    case 0: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame0), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter++; enemyAnimationTimer = 0;}
                        break;
                    case 1: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame1), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter++; enemyAnimationTimer = 0;}
                        break;
                    case 2: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame2), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter++; enemyAnimationTimer = 0;}
                        break;
                    case 3: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame3), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter=0; enemyAnimationTimer = 0;}
                        break;
                    case 4: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame4), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter=0; enemyAnimationTimer = 0;}
                        break;
                    case 5: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame5), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter=0; enemyAnimationTimer = 0;}
                        break;
                    case 6: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame6), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter=0; enemyAnimationTimer = 0;}
                        break;
                    case 7: canvas.drawBitmap(BitmapFactory.decodeResource(resources, frame7), (int)positionX, (int)positionY, null);
                        enemyAnimationTimer++;
                        if (enemyAnimationTimer == 8){enemyDrawCounter=0; enemyAnimationTimer = 0;}
                        break;
                    default: System.out.println("Что-то не так с ENEMYWOLF");
                }
                break;
        }
    }
}
