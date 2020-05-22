package com.rajesh.math_calculation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class JumpingBoyView extends View {

    private Bitmap gameboy[] =new Bitmap[2];
    private Bitmap background;
    private Paint scorecard=new Paint();
    private Bitmap [] life= new Bitmap[2];
    private boolean touch= false;
    private int score, lifecounter;

    private int gameboyx=10;
    private int gameboyY, gameboyspeed;

    private int canvasHight, canvasWidth;

    private int yelloballx, yellobally, yellowballspeed=5;
    private Paint yellopaint= new Paint();

    private int greenballx, greenbally,greenballspeed=10;
    private Paint greenpaint= new Paint();

    private int redballx, redbally,redballspeed=15;
    private Paint redpaint= new Paint();



    public JumpingBoyView(Context context)
    {
        super(context);
        gameboy[0]= BitmapFactory.decodeResource(getResources(),R.drawable.jumpingboy);
        gameboy[1]=BitmapFactory.decodeResource(getResources(),R.drawable.jumpingboy);
        background= BitmapFactory.decodeResource(getResources(),R.drawable.citybackground);

        yellopaint.setColor(Color.YELLOW);
        yellopaint.setAntiAlias(false);

        greenpaint.setColor(Color.GREEN);
        greenpaint.setAntiAlias(false);

        redpaint.setColor(Color.RED);
        redpaint.setAntiAlias(false);

        scorecard.setColor(Color.RED);
        scorecard.setTextSize(30);
        scorecard.setTypeface(Typeface.DEFAULT_BOLD);
        scorecard.setAntiAlias(true);

        life[0]=BitmapFactory.decodeResource(getResources(),R.drawable.hearts);
        life[1]=BitmapFactory.decodeResource(getResources(),R.drawable.heart_grey);

        gameboyY=550;
        score=0;
        lifecounter=3;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvasWidth=canvas.getWidth();
        canvasHight= canvas.getHeight();
        canvas.drawBitmap(background,0,0,null);

        int minGameboy_y=gameboy[0].getHeight();
        int maxGamBoy_y=canvasHight- gameboy[0].getHeight();
        gameboyY=gameboyY+gameboyspeed;

        if(gameboyY<minGameboy_y)
        {
            gameboyY=minGameboy_y;
        }

        if(gameboyY> maxGamBoy_y)
        {
            gameboyY=maxGamBoy_y;
        }

        gameboyspeed=gameboyspeed+2;

        if(touch)
        {
            canvas.drawBitmap(gameboy[0],gameboyx,gameboyY,null);
            touch=false;
        }
        else
        {
            canvas.drawBitmap(gameboy[0],gameboyx,gameboyY,null);
        }

        /*Yellow Ball functionality  */

        canvas.drawCircle(yelloballx,yellobally,15,yellopaint);

        yelloballx=yelloballx-yellowballspeed;

        if(hitBallchecker(yelloballx,yellobally))
        {
            score=score+10;
            yelloballx= -100;
        }

        if(yelloballx<0)
        {
            yelloballx=canvasWidth;
            yellobally= (int) Math.floor(Math.random()* (maxGamBoy_y-minGameboy_y))+minGameboy_y;
        }


        /*Gree Ball functionality  */
        canvas.drawCircle(greenballx,greenbally,20,greenpaint);

        greenballx=greenballx-greenballspeed;

        if(hitBallchecker(greenballx,greenbally))
        {
            score=score+20;
            greenballx= -100;
        }


        if(greenballx<0)
        {
            greenballx=canvasWidth;
            greenbally= (int) Math.floor(Math.random()* (maxGamBoy_y-minGameboy_y))+minGameboy_y;
        }

        /*Red Ball functionality  */

        canvas.drawCircle(redballx,redbally,20,redpaint);

        redballx=redballx-redballspeed;

        if(hitBallchecker(redballx,redbally))
        {
            redballx= -100;
            lifecounter--;

            if(lifecounter==0)
            {
                Toast.makeText(getContext(),"GAME OVER",Toast.LENGTH_SHORT).show();
                Intent gameOverintent=new Intent(getContext(),Game_Over.class);
                gameOverintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                getContext().startActivities(new Intent[]{gameOverintent});
            }
        }

        if(redballx<0)
        {
            redballx=canvasWidth;
            redbally= (int) Math.floor(Math.random()* (maxGamBoy_y-minGameboy_y))+minGameboy_y;
        }

        canvas.drawText("Score :"+score,10, 60,scorecard);
        for(int i=0;i<3;i++)
        {
            int x= (int) (280 +life[0].getWidth()* 1.5 *i);
            int y=30;

            if(i<lifecounter)
            {
                canvas.drawBitmap(life[0],x,y,null);
            }
            else
            {
                canvas.drawBitmap(life[1],x,y,null);
            }
        }



//        canvas.drawBitmap(life[0],280,10,null);
//        canvas.drawBitmap(life[0],340,10,null);
//        canvas.drawBitmap(life[0],400,10,null);

        //canvas.drawBitmap(life[1],680, 35, null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
                touch=true;
                gameboyspeed=-22;
        }
        return true;

    }

    public boolean hitBallchecker(int x, int y)
    {
        if(gameboyx<x && x<(gameboyx+gameboy[0].getWidth()) && gameboyY<y && y<(gameboyY+gameboy[0].getHeight()))
        {
            return true;
        }
        return false;
    }


}
