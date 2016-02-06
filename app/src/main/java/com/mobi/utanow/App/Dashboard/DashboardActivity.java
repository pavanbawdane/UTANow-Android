package com.mobi.utanow.App.Dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.login.LoginManager;
import com.mobi.utanow.App.Login.LoginActivity;
import com.mobi.utanow.myapplication.R;

import layout.LoginFragmentPageAdapter;

/**
 * Created by Anthony on 11/13/15.
 */
public class DashboardActivity extends AppCompatActivity{

    Intent intent;
    Context context;
    Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        context = this;

        // Getting viewpage
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new LoginFragmentPageAdapter(getSupportFragmentManager(), DashboardActivity.this));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


        logoutButton = (Button)findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logout
                LoginManager.getInstance().logOut();
                intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
