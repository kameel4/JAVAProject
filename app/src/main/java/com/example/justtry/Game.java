package com.example.justtry;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Класс Game управляет всеми игровыми объектами, обновляет всевозможные значения
// и отрисовывает все игрове объекты на холст, заполняя пространство нашего окна

public class Game extends SurfaceView implements SurfaceHolder.Callback {

    private final Player player;
//    private final Enemy enemy;
    private GameLoop gameLoop;
    private final Joystick joystick;
    private List<Enemy> enemyList = new ArrayList<Enemy>();

    public Game(Context context) {
        super(context);

        // Эти модификации позволят нам отрисовывать события на экране и реагировать на нажатия
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        gameLoop = new GameLoop(this, surfaceHolder);

        joystick = new Joystick(200, 550, 70, 40);

        // Инициализация нового игрока
        player = new Player(getContext(), 100, 100, this.getResources(), joystick);

//        enemy = new Enemy(getContext(), getResources(), player, 600, 400);
        setFocusable(true);
    }

    // Метод, обрабатывающий нажатия на экран
    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (joystick.isPressed(event.getX(), event.getY())){
                    joystick.setIsPressed(true);
                    player.setPlayerStatus("move");
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                if (joystick.getIsPressed()){
                    joystick.setActuator((int)event.getX(), (int)event.getY());
                }
                return true;
            case MotionEvent.ACTION_UP:
                joystick.setIsPressed(false);
                joystick.resetActuator();
                player.setPlayerStatus("rest");
                return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        this.gameLoop.startLoop();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void draw(Canvas canvas) {
        // Отрисовка объектов
        super.draw(canvas);
        drawFPS(canvas);
        drawUPS(canvas);

        player.draw(canvas, player.playerStatus);
        joystick.draw(canvas);
        for (Enemy enemy : enemyList){
        enemy.draw(canvas, enemy.enemyStatus);
        }
    }

    public void update() {
        // Обновление значений игры
        player.update();
        joystick.update();

        // Появление новых врагов, если пришло время
        if(Enemy.readyToSpawn()){
            enemyList.add(new Enemy(getContext(), player));
        }

        // Обновление каждого отдельного врага
        for (Enemy enemy : enemyList){
            enemy.update();
        }

        //Итератор, который проверяет элементы массива врагов на коллизию с игроком
        Iterator<Enemy> iteratorEnemy = enemyList.iterator();
//        while (iteratorEnemy.hasNext()){
//            if (isColloding(iteratorEnemy.next(), player)){
//
//            }
//        }
    }

    // UPS - кол-во обновлений в секунду
    public void drawUPS(Canvas canvas) {
        String averageUPS = Double.toString(gameLoop.getAverageUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.favColor);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("UPS:" + averageUPS, 20, 40, paint);
    }

    public void drawFPS(Canvas canvas) {
        String averageFPS = Double.toString(gameLoop.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.favColor);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("FPS:" + averageFPS, 20, 100, paint);
    }
}
