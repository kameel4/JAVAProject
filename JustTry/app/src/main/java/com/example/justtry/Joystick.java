package com.example.justtry;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Joystick {

    private final double outerCircleCenterPositionX;
    private final double outerCircleCenterPositionY;
    private double innerCircleCenterPositionX;
    private double innerCircleCenterPositionY;
    private final double outerCircleRadius;
    private final double innerCircleRadius;
    private final Paint outerCirclePaint;
    private final Paint innerCirclePaint;
    private double joystickCenterToTouchDistance;
    private boolean isPressed;
    private double actuatorX;
    private double actuatorY;

    public Joystick(int centerPositionX, int centerPositionY, int outerCircleRadiys, int innerCircleRadiys){
        // Центр внешнего и внутреннего кругов джойстика
        outerCircleCenterPositionX = centerPositionX;
        outerCircleCenterPositionY = centerPositionY;
        innerCircleCenterPositionX = centerPositionX;
        innerCircleCenterPositionY = centerPositionY;

        outerCircleRadius = outerCircleRadiys;
        innerCircleRadius = innerCircleRadiys;

        outerCirclePaint = new Paint();
        outerCirclePaint.setColor(Color.GRAY);
        outerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        innerCirclePaint = new Paint();
        innerCirclePaint.setColor(Color.BLUE);
        innerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void draw(Canvas canvas){
        canvas.drawCircle((float) outerCircleCenterPositionX, (float) outerCircleCenterPositionY, (float) outerCircleRadius, outerCirclePaint);
        canvas.drawCircle((float) innerCircleCenterPositionX, (float) innerCircleCenterPositionY, (float) innerCircleRadius, innerCirclePaint);
    }

    public void update(){
        updateInnerCirclePosition();
    }

    private void updateInnerCirclePosition() {
        innerCircleCenterPositionX = (outerCircleCenterPositionX + actuatorX*outerCircleRadius);
        innerCircleCenterPositionY = (outerCircleCenterPositionY + actuatorY*outerCircleRadius);
    }

    public boolean isPressed(double touchPositionX, double touchPositionY) {
        joystickCenterToTouchDistance = Math.sqrt(
                Math.pow(outerCircleCenterPositionX - touchPositionX, 2) + Math.pow(outerCircleCenterPositionY - touchPositionY, 2)
        );
        return joystickCenterToTouchDistance < outerCircleRadius;
    }

    public void setIsPressed(boolean isPressed) {
        this.isPressed = isPressed;
    }

    public boolean getIsPressed() {
        return isPressed;
    }

    public void setActuator(int touchPositionX, int touchPositionY) {
        double deltaX = touchPositionX - outerCircleCenterPositionX;
        double deltaY = touchPositionY - outerCircleCenterPositionY;
        double deltaDistance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));

        if (deltaDistance < outerCircleRadius){
            actuatorX = deltaX/outerCircleRadius;
            actuatorY = deltaY/outerCircleRadius;
        } else {
            actuatorX = deltaX/deltaDistance;
            actuatorY = deltaY/deltaDistance;
        }

    }

    public void resetActuator() {
        actuatorX = 0;
        actuatorY = 0;
    }

    public double getActuatorX() {
        return actuatorX;
    }

    public double getActuatorY() {
        return actuatorY;
    }
}
