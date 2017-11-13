package com.ptp.phamtanphat.navigationview0208;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        setSupportActionBar(toolbar);
        // co the set icon cho toolbar
//        getSupportActionBar().setIcon(android.R.drawable.ic_menu_sort_by_size);
        //Dang icon mac dinh cua navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        // Lay mau tu set trong color
//        toolbar.setBackgroundColor(getResources().getColor(R.color.colornavigation));
        // Lay mau da co san trong android
        toolbar.setBackgroundColor(Color.LTGRAY);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.START);
            }
        });
        // tro ve mau mac dinh cua icon
//        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.item_email:
                        fragment = new Fragment_Android();
                        break;
                    case R.id.item_galery:
                        fragment = new Fragment_iOS();
                        break;
                    case R.id.item_import:
                        fragment = new Fragment_Php();
                        break;
                        default:fragment = new Fragment_Android();
                }
                fragmentTransaction.replace(R.id.linearlayout,fragment);
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(Gravity.START);
                return false;
            }
        });
        //Tuong tac voi headerlayout
//        View header = navigationView.getHeaderView(0);
//        TextView txttile = header.findViewById(R.id.textviewten);
//        txttile.setText("Khoa hoc lap trinh Android");
    }

    private void anhxa() {
        linearLayout = findViewById(R.id.linearlayout);
        drawerLayout = findViewById(R.id.drawerlayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationview);
    }
}
