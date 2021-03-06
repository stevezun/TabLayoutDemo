package com.ebookfrenzy.tablayoutdemo;

import android.net.Uri;
import android.os.Bundle;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener;

public class MainActivity extends AppCompatActivity implements
    Tab1Fragment.OnFragmentInteractionListener,
    Tab2Fragment.OnFragmentInteractionListener,
    Tab3Fragment.OnFragmentInteractionListener,
    Tab4Fragment.OnFragmentInteractionListener, {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.activity_main );
    Toolbar toolbar = findViewById( R.id.toolbar );
    setSupportActionBar( toolbar );

    FloatingActionButton fab = findViewById( R.id.fab );
    fab.setOnClickListener( new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
            .setAction( "Action", null ).show();
      }
    } );
    configureTabLayout();
  }

  private void configureTabLayout() {
    TabLayout tabLayout = findViewById( R.id.tab_layout );

    tabLayout.addTab( tabLayout.newTab().setIcon( android.R.drawable.ic_dialog_email ) );
    tabLayout.addTab( tabLayout.newTab().setIcon( android.R.drawable.ic_dialog_dialer ) );
    tabLayout.addTab( tabLayout.newTab().setIcon( android.R.drawable.ic_dialog_map ) );
    tabLayout.addTab( tabLayout.newTab().setIcon( android.R.drawable.ic_dialog_info ) );


    final ViewPager viewPager = findViewById( R.id.pager );
    final PagerAdapter adapter = new TabPagerAdapter( getSupportFragmentManager(),
        tabLayout.getTabCount() );

    viewPager.setAdapter( adapter );

    viewPager.addOnPageChangeListener( new TabLayoutOnPageChangeListener( tabLayout ) );
    tabLayout.addOnTabSelectedListener( new OnTabSelectedListener() {
      @Override
      public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem( tab.getPosition() );

      }

      @Override
      public void onTabUnselected(TabLayout.Tab tab) {

      }

      @Override
      public void onTabReselected(TabLayout.Tab tab) {

      }
    } );
  }

  @Override
  public void OnFragmentInteraction(Uri uri) {

  }

}
