package com.example.bottomnavgation;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.window.OnBackInvokedDispatcher;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bottomnavgation.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActivityMainBinding binding ;
    ArrayList<Fragment> oneFragment;
    ArrayList<String> tabsList ;
    ArrayList<Fragment> fragmentsList ;
    ActionBarDrawerToggle toggle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar(binding.toolBar);

        toggle =new ActionBarDrawerToggle(this ,binding.drawerLayout ,binding.toolBar , R.string.open_drawer,R.string.close_drawer);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        binding.navigationDrawer.setCheckedItem(R.id.homeDrawer);
        binding.navigationDrawer.setNavigationItemSelectedListener(this);


        oneFragment = new ArrayList<>();
        oneFragment.add(ProfileFragment.newInstance("Profile Page"));
        oneFragment.add(SettingFragment.newInstance("Setting Page"));


        tabsList =new ArrayList<>();
        tabsList.add("All events") ;
        tabsList.add("Party") ;
        tabsList.add("Tech events") ;
        tabsList.add("Programing") ;


        fragmentsList =new ArrayList<>();
        fragmentsList.add( EventsFragment.newInstance("All events"));
        fragmentsList.add( PartyFragment.newInstance("Party"));
        fragmentsList.add( TecheEventsFragment.newInstance("Tech events"));
        fragmentsList.add( PartyFragment.newInstance("Programing"));





        binding.viewPager.setAdapter(new Adapter(this , fragmentsList));



        new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabsList.get(position)) ;
            }
        }).attach(); ;



        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()== R.id.home1){
                    binding.tabLayout.setVisibility(View.VISIBLE);
                    binding.viewPager.setAdapter(new Adapter(MainActivity.this , fragmentsList));
                    binding.navigationDrawer.setCheckedItem(R.id.homeDrawer);


                }

                else if (item.getItemId()== R.id.profile) {

                    binding.tabLayout.setVisibility(View.GONE);
                    binding.viewPager.setAdapter(new Adapter(MainActivity.this , oneFragment));
                    binding.navigationDrawer.setCheckedItem(R.id.profileDrawer);

                    binding.viewPager.setCurrentItem(0 ,true);


                }

                else if (item.getItemId()== R.id.setting) {
                    binding.tabLayout.setVisibility(View.GONE);
                    binding.viewPager.setAdapter(new Adapter(MainActivity.this ,oneFragment));
                    binding.navigationDrawer.setCheckedItem(R.id.settingDrawer);
                    binding.viewPager.setCurrentItem(1 ,true);


                }
                return true;
            }
        });




        binding.backButton.setOnClickListener(v -> {
            if (binding.tabLayout.getVisibility() == View.VISIBLE) {
                finish();
            } else {
                 binding.tabLayout.setVisibility(View.VISIBLE);
                binding.viewPager.setAdapter(new Adapter(this, fragmentsList));

                new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                        (tab, position) -> tab.setText(tabsList.get(position))
                ).attach();

                binding.bottomNavigation.setSelectedItemId(R.id.home1);
                binding.navigationDrawer.setCheckedItem(R.id.homeDrawer);
            }
        });



    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.homeDrawer) {
            binding.tabLayout.setVisibility(View.VISIBLE);
            binding.viewPager.setAdapter(new Adapter(MainActivity.this , fragmentsList));
            binding.bottomNavigation.setSelectedItemId(R.id.home1);
            binding.navigationDrawer.setCheckedItem(R.id.homeDrawer);
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        }


        else if (item.getItemId() == R.id.profileDrawer) {

            binding.tabLayout.setVisibility(View.GONE);
            binding.viewPager.setAdapter(new Adapter(MainActivity.this , oneFragment));
            binding.viewPager.setCurrentItem(0 ,true);
            binding.bottomNavigation.setSelectedItemId(R.id.profile);
            binding.navigationDrawer.setCheckedItem(R.id.profileDrawer);
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        }

        else if (item.getItemId() == R.id.settingDrawer) {

            binding.tabLayout.setVisibility(View.GONE);
            binding.viewPager.setAdapter(new Adapter(MainActivity.this , oneFragment));
            binding.viewPager.setCurrentItem(1 ,true);
            binding.navigationDrawer.setCheckedItem(R.id.settingDrawer);
            binding.bottomNavigation.setSelectedItemId(R.id.setting);
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        }

        return true ;    }



    @Override
    public void onBackPressed() {
         if (binding.tabLayout.getVisibility() == View.VISIBLE) {
            super.onBackPressed();
        } else {
             binding.tabLayout.setVisibility(View.VISIBLE);
            binding.viewPager.setAdapter(new Adapter(this, fragmentsList));

            new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                    (tab, position) -> tab.setText(tabsList.get(position))
            ).attach();

            binding.bottomNavigation.setSelectedItemId(R.id.home1);
            binding.navigationDrawer.setCheckedItem(R.id.homeDrawer);
        }
    }



}
