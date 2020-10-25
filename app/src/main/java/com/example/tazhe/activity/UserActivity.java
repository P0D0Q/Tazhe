package com.example.tazhe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tazhe.R;
import com.example.tazhe.beans.CollectResult;
import com.example.tazhe.beans.CollectStatus;
import com.example.tazhe.beans.FollowResult;
import com.example.tazhe.beans.FollowStatus;
import com.example.tazhe.beans.FramerDetails;
import com.example.tazhe.beans.UnCollect;
import com.example.tazhe.beans.UnFollow;
import com.example.tazhe.beans.UserDetails;
import com.example.tazhe.constants.Constants;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.model.UserModel;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class UserActivity extends AppCompatActivity implements RetrofitListener {

    private ImageView avator;
    private TextView username,usersex,userbirthday,userplace;
    private ImageView follow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initViews();
        initEvents();
        initData();
    }

    private void initViews() {
        avator=findViewById(R.id.useravator2);
        username=findViewById(R.id.username2);
        usersex=findViewById(R.id.usersex2);
        userbirthday=findViewById(R.id.userbirthday2);
        userplace=findViewById(R.id.userplace2);
        follow=findViewById(R.id.follow);
    }

    private void initEvents() {
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("UserInfo",
                        MODE_PRIVATE);
                String user_id = sp.getString("user_id", "");
                int f_user = Integer.parseInt(user_id);

                Intent intent = getIntent();
                int framerid = intent.getIntExtra("framerid",0);

                Drawable.ConstantState image1 = follow.getDrawable().getConstantState();
                Drawable.ConstantState image2 = getResources().getDrawable(R.drawable.ic_collected_24).getConstantState();
                Drawable.ConstantState image3 = getResources().getDrawable(R.drawable.ic_uncollect_24).getConstantState();

                if(image1.equals(image2)){
                    unFollow(f_user,framerid);
                }else if(image1.equals(image3)){
                    followFramer(f_user, framerid);
                }

            }
        });
    }

    private void followFramer(int user_id,int video_id){
        UserModel userModel=new UserModel();
        userModel.FollowResult(user_id,video_id,this);
    }

    private void isFollowed(int user_id,int framer_id){
        UserModel userModel=new UserModel();
        userModel.FollowStatus(user_id,framer_id,UserActivity.this);
    }

    private void unFollow(int user_id,int framer_id){
        UserModel userModel=new UserModel();
        userModel.UnFollow(user_id,framer_id,this);
    }

    private void initData() {

        Intent intent = getIntent();
        int framerdetails = intent.getIntExtra("framerid", 0);

        SharedPreferences sp = getSharedPreferences("UserInfo",
                MODE_PRIVATE);
        String user_id = sp.getString("user_id", "");
        int f_userid = Integer.parseInt(user_id);

        UserModel userModel = new UserModel();
        userModel.FramerDetails(framerdetails,UserActivity.this);

        isFollowed(f_userid,framerdetails);
    }

    @Override
    public void onSuccess(Object o, int flag) {
        switch (flag){
            case Constants.FRAMERDETAILS:
                FramerDetails details = (FramerDetails) o;
                if (details != null && details.getFramer_id() != 0) {
                    username.setText("创作者：" + details.getFramername());
                    usersex.setText("性别：" + details.getSex());
                    userbirthday.setText("生日：" + details.getBirthday());
                    userplace.setText("所在地：" + details.getBornplace());

                    Picasso.with(UserActivity.this).load(Constants.BASE_URL+details.getFramer_picture()).into(avator);
                }
                else{
                    Toast.makeText(UserActivity.this, "网络错误2", Toast.LENGTH_SHORT).show();
                }
                break;

            case Constants.ISFOLLOWED:
                FollowStatus followStatus = (FollowStatus) o;
                if(followStatus.getSta().equals("0")){
                    follow.setImageResource(R.drawable.ic_collected_24);
                }else if(followStatus.getSta().equals("1")){
                    follow.setImageResource(R.drawable.ic_uncollect_24);
                }
                break;

            case Constants.FOLLOWFRAMER:
                FollowResult followResult=(FollowResult) o;
                if(followResult.getMessage().equals("0")){
                    follow.setImageResource(R.drawable.ic_collected_24);
                    Toast.makeText(UserActivity.this, "关注成功", Toast.LENGTH_SHORT).show();
                }
                break;

            case Constants.UNFOLLOW:
                UnFollow unFollow = (UnFollow) o;
                if(unFollow.getMessage().equals("0")){
                    follow.setImageResource(R.drawable.ic_uncollect_24);
                    Toast.makeText(UserActivity.this, "取消关注成功", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(UserActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }

    @Override
    public void onFail() {
        Toast.makeText(UserActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
    }

}