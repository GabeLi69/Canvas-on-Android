package com.example.myapplication;

import android.content.Context;
//import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
//import android.telecom.PhoneAccountHandle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;


public class Canvas extends View{
    Rect button;
    Paint paint;
    Path path;

    public Canvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        button = new Rect(0,0,100,100);
        paint = new Paint();
        path = new Path();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
        canvas.drawRect(button, paint );
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xPos = event.getX();
        float yPos = event.getY();
        Log.d("tag", "ValueX: " + xPos);
        Log.d("tag", "ValueY: " + yPos);


        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(xPos<100 && yPos<100){
                    path.reset();
                    Log.d("FUCK","YEA");
                }
                path.moveTo(xPos,yPos);
                return true;

            case MotionEvent.ACTION_MOVE:
                path.lineTo(xPos,yPos);
                break;

            case MotionEvent.ACTION_UP:
                Log.d("NOOOO", "NOOOOOO");
                break;

            default:
                return false;


        }
        invalidate();
        return true;
    }
}
