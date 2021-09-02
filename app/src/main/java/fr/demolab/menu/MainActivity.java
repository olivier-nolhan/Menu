package fr.demolab.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawer);
        toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=menuItem.getItemId();
                Fragment fragment=null;
                switch (id)
                {
                    case R.id.back_to_application:
                        Toast.makeText(getApplicationContext(), R.string.Clicked_back_to_application, Toast.LENGTH_SHORT).show();
                        fragment=new IndexFragment();
                        loadFragment(fragment);
                        break;

                    case R.id.nav_share:
                        Toast.makeText(getApplicationContext(), R.string.Clicked_Share, Toast.LENGTH_SHORT).show();
                        fragment=new ShareFragment();
                        loadFragment(fragment);
                        break;

                    case R.id.nav_rate_us:
                        Toast.makeText(getApplicationContext(), R.string.Clicked_Rate_us, Toast.LENGTH_SHORT).show();
                        fragment=new RateUsFragment();
                        loadFragment(fragment);
                        break;

                    case R.id.nav_comment:
                        Toast.makeText(getApplicationContext(), R.string.Clicked_Comment_this_App, Toast.LENGTH_SHORT).show();
                        fragment=new CommentFragment();
                        loadFragment(fragment);
                        break;

                    case R.id.nav_apk:
                        Toast.makeText(getApplicationContext(), R.string.Clicked_All_our_application, Toast.LENGTH_SHORT).show();
                        fragment=new APKFragment();
                        loadFragment(fragment);
                        break;

                    case R.id.nav_donate:
                        Toast.makeText(getApplicationContext(), R.string.Clicked_Donate, Toast.LENGTH_SHORT).show();
                        fragment=new DonateFragment();
                        loadFragment(fragment);
                        break;

                    case R.id.nav_info:
                        Toast.makeText(getApplicationContext(), R.string.Clicked_Information, Toast.LENGTH_SHORT).show();
                        fragment=new InfoFragment();
                        loadFragment(fragment);
                        break;

                    default:
                        return true;
                }
                return true;
            }
        });
    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        fragmentTransaction.addToBackStack(null);
    }
}