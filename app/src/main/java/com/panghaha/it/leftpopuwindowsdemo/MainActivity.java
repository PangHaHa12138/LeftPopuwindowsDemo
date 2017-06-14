package com.panghaha.it.leftpopuwindowsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView lefticon,righticon;
    private TextView title;
    private LinearLayout mainlayout;
    private LeftPopupWindows leftPopupWindows;

    private RightPopupWindows rightpopuwindows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lefticon = (ImageView) findViewById(R.id.lefthaha);
        righticon = (ImageView) findViewById(R.id.righthaha);
        title = (TextView) findViewById(R.id.titlehaha);
        mainlayout = (LinearLayout) findViewById(R.id.mainlayout);

        title.setText("你是电，你是光，你是唯一的智障");

        lefticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftPopupWindows = new LeftPopupWindows(MainActivity.this,leftonclick );
                leftPopupWindows.showAtLocation(mainlayout, Gravity.LEFT,0,0);
                leftPopupWindows.setWindowAlpa(true);

                leftPopupWindows.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        leftPopupWindows.setWindowAlpa(false);
                    }
                });
            }
        });

        righticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightpopuwindows = new RightPopupWindows(MainActivity.this,rightonclick );
                rightpopuwindows.showAtLocation(mainlayout, Gravity.RIGHT,0,0);
                rightpopuwindows.setWindowAlpa(true);

                rightpopuwindows.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        rightpopuwindows.setWindowAlpa(false);
                    }
                });
            }
        });
    }

    private View.OnClickListener leftonclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            leftPopupWindows.dismiss();
            switch (v.getId()) {

                case R.id.leftphoto:
                    Toast.makeText(MainActivity.this, "头像", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.shenqing:
                    Toast.makeText(MainActivity.this, "菜单1", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.shenpi:
                    Toast.makeText(MainActivity.this, "菜单2", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.gongxiangwj:
                    Toast.makeText(MainActivity.this, "菜单3", Toast.LENGTH_SHORT).show();

                    break;

                case R.id.exit:
                    Toast.makeText(MainActivity.this, "退出", Toast.LENGTH_SHORT).show();

                    break;

            }
        }
    };

    private View.OnClickListener rightonclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            rightpopuwindows.dismiss();
            switch (v.getId()) {

                case R.id.leftphoto:
                    Toast.makeText(MainActivity.this, "头像", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.shenqing:
                    Toast.makeText(MainActivity.this, "菜单1", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.shenpi:
                    Toast.makeText(MainActivity.this, "菜单2", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.gongxiangwj:
                    Toast.makeText(MainActivity.this, "菜单3", Toast.LENGTH_SHORT).show();

                    break;

                case R.id.exit:
                    Toast.makeText(MainActivity.this, "退出", Toast.LENGTH_SHORT).show();

                    break;

            }
        }
    };
}
