package com.example.whackingmolesgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    ConstraintLayout layout;
    TextView timeLeft, score, hidden;
    ImageView mole1, mole2, mole3, mole4, mole5, mole6, mole7, mole8, mole9;
    ArrayList<ImageView> moleList;
    ArrayList<Boolean> show;
    ArrayList<Boolean> alreadyclicked;
    ArrayList<Integer> extras;
    public int gameTime = 61;
    public int probability = 8;
    public int goldenProbability = 20;
    public int refereeProbability = 12;
    public int theScore = 0;
    public int lastId;
    public int countBalls = 0;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        layout = findViewById(R.id.myLayout);
        timeLeft = findViewById(R.id.timeLeft);
        timeLeft.setText("Time Left: " + gameTime);
        score = findViewById(R.id.score);
        hidden = findViewById(R.id.textView3);
        lastId = hidden.getId();
        mole1 = findViewById(R.id.imageView1);
        mole2 = findViewById(R.id.imageView2);
        mole3 = findViewById(R.id.imageView3);
        mole4 = findViewById(R.id.imageView4);
        mole5 = findViewById(R.id.imageView5);
        mole6 = findViewById(R.id.imageView6);
        mole7 = findViewById(R.id.imageView7);
        mole8 = findViewById(R.id.imageView8);
        mole9 = findViewById(R.id.imageView9);
        moleList = new ArrayList<>();
        moleList.add(mole1);
        moleList.add(mole2);
        moleList.add(mole3);
        moleList.add(mole4);
        moleList.add(mole5);
        moleList.add(mole6);
        moleList.add(mole7);
        moleList.add(mole8);
        moleList.add(mole9);
        show = new ArrayList<>();
        alreadyclicked = new ArrayList<>();
        extras = new ArrayList<>();
        for(int i = 0; i < moleList.size(); i++){
            show.add(false);
            alreadyclicked.add(true);
            extras.add(0);//0 = none, 1 = ref, 2= golden
            moleList.get(i).setVisibility(View.INVISIBLE);
        }
        timer = new Timer();
        timer.schedule(new timerThread(), 0, 1000);
        timer.schedule(new taskThread1(), 0, (int)(Math.random()*1000)+800);
        timer.schedule(new taskThread2(), 0, (int)(Math.random()*1000)+800);
        timer.schedule(new taskThread3(), 0, (int)(Math.random()*1000)+800);
        timer.schedule(new taskThread4(), 0, (int)(Math.random()*1000)+800);
        timer.schedule(new taskThread5(), 0, (int)(Math.random()*1000)+800);
        timer.schedule(new taskThread6(), 0, (int)(Math.random()*1000)+800);
        timer.schedule(new taskThread7(), 0, (int)(Math.random()*1000)+800);
        timer.schedule(new taskThread8(), 0, (int)(Math.random()*1000)+800);
        timer.schedule(new taskThread9(), 0, (int)(Math.random()*1000)+800);
        mole1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHandler(0);
            }
        });
        mole2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHandler(1);
            }
        });
        mole3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHandler(2);
            }
        });
        mole4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHandler(3);
            }
        });
        mole5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHandler(4);
            }
        });
        mole6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHandler(5);
            }
        });
        mole7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHandler(6);
            }
        });
        mole8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHandler(7);
            }
        });
        mole9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHandler(8);
            }
        });

    }
    public void setTimeLeft(){
        timeLeft.setText("Time Left: " + gameTime);
    }
    class timerThread extends TimerTask{
        @Override
        public void run() {
            gameTime--;
            if(gameTime <= 0){
                timer.cancel();
                Intent intent = new Intent(GameActivity.this, FinishActivity.class);
                intent.putExtra("score", theScore);
                startActivity(intent);
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    setTimeLeft();
                }
            });
        }
    }
    class taskThread1 extends TimerTask{
        @Override
        public void run() {
            doRunnable(0);
        }
    }
    class taskThread2 extends TimerTask{
        @Override
        public void run() {
            doRunnable(1);
        }
    }
    class taskThread3 extends TimerTask{
        @Override
        public void run() {
            doRunnable(2);
        }
    }
    class taskThread4 extends TimerTask{
        @Override
        public void run() {
            doRunnable(3);
        }
    }
    class taskThread5 extends TimerTask{
        @Override
        public void run() {
            doRunnable(4);
        }
    }
    class taskThread6 extends TimerTask{
        @Override
        public void run() {
            doRunnable(5);
        }
    }
    class taskThread7 extends TimerTask{
        @Override
        public void run() {
            doRunnable(6);
        }
    }
    class taskThread8 extends TimerTask{
        @Override
        public void run() {
            doRunnable(7);
        }
    }
    class taskThread9 extends TimerTask{
        @Override
        public void run() {
            doRunnable(8);
        }
    }



    public void doRunnable(int index) {
        int appear = (int) (Math.random() * probability);
        int golden = (int) (Math.random() * goldenProbability);
        int ref = (int) (Math.random() * refereeProbability);
        if (golden == 0) {
            extras.set(index, 2);
        } else if (ref == 0) {
            extras.set(index, 1);
        } else {
            extras.set(index, 0);
        }
        if (appear == 0) {
            show.set(index, true);
        } else {
            show.set(index, false);
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (extras.get(index)) {
                    case 0:
                        moleList.get(index).setImageResource(R.drawable.football);
                        break;
                    case 1:
                        moleList.get(index).setImageResource(R.drawable.referee);
                        break;
                    case 2:
                        moleList.get(index).setImageResource(R.drawable.goldenfootball);
                        break;
                    default:
                        break;
                }
                if (!show.get(index)) {
                    if (moleList.get(index).getVisibility() == View.VISIBLE) {
                        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 0f, 1f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                        scaleAnimation.setDuration(50);
                        moleList.get(index).startAnimation(scaleAnimation);
                    }
                    moleList.get(index).setVisibility(View.INVISIBLE);
                    moleList.get(index).setClickable(false);
                    alreadyclicked.set(index, true);
                } else {
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    scaleAnimation.setDuration(50);
                    moleList.get(index).startAnimation(scaleAnimation);
                    moleList.get(index).setVisibility(View.VISIBLE);
                    moleList.get(index).setClickable(true);
                    alreadyclicked.set(index, false);
                }
            }
        });
    }

    public void onClickHandler(int index){
        if (!alreadyclicked.get(index)){
            ImageView gf = new ImageView(this);
            if(extras.get(index) == 2){
                theScore+=5;
                gf.setId(View.generateViewId());
                gf.setImageResource(R.drawable.goldenfootball);
            }
            else if(extras.get(index) == 1){
                gameTime-=5;
                gf.setId(View.generateViewId());
                gf.setImageResource(R.drawable.referee);
            }
            else {
                theScore++;
                gf.setId(View.generateViewId());
                gf.setImageResource(R.drawable.football);
            }
            score.setText("Score: " + theScore);
            ConstraintLayout.LayoutParams params1 = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_PERCENT*30, ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_PERCENT*30);
            gf.setLayoutParams(params1);
            layout.addView(gf);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(layout);
            countBalls++;
            if(countBalls%16 == 0){
                constraintSet.connect(gf.getId(), ConstraintSet.TOP, lastId, ConstraintSet.BOTTOM, 10);
                constraintSet.connect(gf.getId(), ConstraintSet.LEFT, hidden.getId(), ConstraintSet.RIGHT, -5);
            }
            else{
                constraintSet.connect(gf.getId(), ConstraintSet.TOP, lastId, ConstraintSet.TOP, 0);
                constraintSet.connect(gf.getId(), ConstraintSet.LEFT, lastId, ConstraintSet.RIGHT, -5);
            }
            lastId = gf.getId();
            constraintSet.applyTo(layout);
        }
        show.set(index, false);
        alreadyclicked.set(index, true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 0f, 1f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(50);
        moleList.get(index).startAnimation(scaleAnimation);
        moleList.get(index).setVisibility(View.INVISIBLE);
        moleList.get(index).setClickable(false);
    }
}