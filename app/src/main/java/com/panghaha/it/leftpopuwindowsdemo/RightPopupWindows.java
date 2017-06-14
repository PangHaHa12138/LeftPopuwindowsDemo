package com.panghaha.it.leftpopuwindowsdemo;

/**
 * Created by pang on 2017/4/4.
 *  自定义 popupwindow 左侧弹窗
 */

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class RightPopupWindows extends PopupWindow {
    private View mMenuView; // PopupWindow 菜单布局
    private Context context; // 上下文参数
    private OnClickListener myOnClick; // PopupWindow 菜单 空间单击事件

    private LinearLayout shenqing;
    private LinearLayout shenpi;
    private LinearLayout gongxiangwj;
    private LinearLayout exit;
    private CircleImageView touxiang;
    private TextView name;
    private ImageView shenqing_red,shenpi_red,gongxiangwj_red;

    public RightPopupWindows(Activity context, OnClickListener myOnClick) {
        super(context);
        this.context = context;
        this.myOnClick = myOnClick;
        Init();
    }

    private void Init() {
        // TODO Auto-generated method stub
        // PopupWindow 导入
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.leftpopuwindows, null);

        shenqing = (LinearLayout) mMenuView.findViewById(R.id.shenqing);
        shenpi = (LinearLayout) mMenuView.findViewById(R.id.shenpi);
        gongxiangwj = (LinearLayout) mMenuView.findViewById(R.id.gongxiangwj);
        name = (TextView) mMenuView.findViewById(R.id.leftname);
        touxiang  = (CircleImageView) mMenuView.findViewById(R.id.leftphoto);
        shenpi_red = (ImageView) mMenuView.findViewById(R.id.shenpi_red);
        shenqing_red = (ImageView) mMenuView.findViewById(R.id.shenqing_red);
        gongxiangwj_red = (ImageView) mMenuView.findViewById(R.id.gongxiangwj_red);
        exit = (LinearLayout) mMenuView.findViewById(R.id.exit);

        touxiang.setOnClickListener(myOnClick);
        //审批
        shenpi.setOnClickListener(myOnClick);
        //申请
        shenqing.setOnClickListener(myOnClick);
        //共享文件
        gongxiangwj.setOnClickListener(myOnClick);
        //退出
        exit.setOnClickListener(myOnClick);

        // 导入布局
        this.setContentView(mMenuView);
        // 设置动画效果
        this.setAnimationStyle(R.style.AnimationRightFade);
        //防止虚拟键挡住
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //设置弹出窗体的 宽，高
        this.setWidth(LayoutParams.WRAP_CONTENT);
        this.setHeight(LayoutParams.MATCH_PARENT);
        // 设置可触
        this.setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x0000000);
        this.setBackgroundDrawable(dw);
        // 单击弹出窗以外处 关闭弹出窗
        mMenuView.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                int height = mMenuView.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                        setWindowAlpa(false);
                    }
                }
                return true;
            }
        });


    }



    /**
     * 动态设置Activity背景透明度
     *
     * @param isopen
     */
    public void setWindowAlpa(boolean isopen) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        final Window window = ((Activity) context).getWindow();
        final WindowManager.LayoutParams lp = window.getAttributes();
        window.setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND, WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        ValueAnimator animator;
        if (isopen) {
            animator = ValueAnimator.ofFloat(1.0f, 0.5f);
        } else {
            animator = ValueAnimator.ofFloat(0.5f, 1.0f);
        }
        animator.setDuration(400);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float alpha = (float) animation.getAnimatedValue();
                lp.alpha = alpha;
                window.setAttributes(lp);
            }
        });
        animator.start();
    }
}
