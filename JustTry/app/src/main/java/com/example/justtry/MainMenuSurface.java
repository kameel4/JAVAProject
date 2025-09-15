package com.example.justtry;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainMenuSurface extends Game {
    private final GameLoop gameLoop;
    public int backgroundDrawCounter = 44;
    public int backgroundAnimationTimer = 0;

    public MainMenuSurface(Context context) {
        super(context);
        // Эти модификации позволят нам отрисовывать события на экране и реагировать на нажатия
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        setFocusable(true);
        gameLoop = new GameLoop(this, surfaceHolder);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        this.gameLoop.startLoop();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    // Метод, обрабатывающий нажатия на экран
    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//        }
        return super.onTouchEvent(event);
    }

    @Override
    public void draw(Canvas canvas) {
        // Отрисовка объектов
        super.draw(canvas);
        AssetManager am = this.getContext().getAssets();
        String[] files = new String[46];
        try {
            files = am.list("assets");
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream istr = null;
        ArrayList<Drawable> drawables = new ArrayList<>();

        for (String file : files) {
            Drawable d = null;
            try {
                d = Drawable.createFromStream(am.open(file), null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            drawables.add(d);
        }

                System.out.println("BRUH");
                canvas.drawBitmap(((BitmapDrawable) drawables.get(0)).getBitmap(), 0, 0, null);


    }
}


