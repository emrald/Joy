package fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.abc.joy23final.ActivityRegister;
import com.example.abc.joy23final.FilterActivity;
import com.example.abc.joy23final.R;
import com.example.abc.joy23final.SearchCoupon_activity;

public class MainActivity2 extends FragmentActivity implements TabLayout.OnTabSelectedListener {

    static TextView tvtitle;
    static ImageView imgarrow;
    ImageView imgFilter;
    ImageView imgSearch;
    Animation animUp, animDown;
    boolean arrow = true;
    TabLayout tabLayout;
    Fragment fragment = null;
    String[] list = {"Deal", "Needs", "Friends", "Chat", "More"};
    String[] filterList = {"Distance", "Latest", "Relevance", "Price:Low to High", "Price:High to Low", "Avg.Customer Review"};
    TabLayout.Tab tab1;
    RelativeLayout relativeLayoutTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fragment = new Deal_Fragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().add(fragment, "TAG");
        ft.replace(R.id.content_frame, fragment);
        ft.commit();

        tvtitle = (TextView) findViewById(R.id.tvTitle);

        imgarrow = (ImageView) findViewById(R.id.imgArrow);
        imgFilter = (ImageView) findViewById(R.id.imgFilter);
        imgSearch = (ImageView) findViewById(R.id.imgSearch);

        relativeLayoutTitle = (RelativeLayout) findViewById(R.id.rlTitle);

        animUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out);
        animDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in);

        MainActivity2.imgarrow.setImageResource(R.drawable.arrow_down);

        tabLayout = (TabLayout) findViewById(R.id.pages_tabs);
        final TabLayout.Tab deal = tabLayout.newTab();
        final TabLayout.Tab needs = tabLayout.newTab();
        final TabLayout.Tab friends = tabLayout.newTab();
        final TabLayout.Tab chat = tabLayout.newTab();
        final TabLayout.Tab more = tabLayout.newTab();
        tab1 = tabLayout.newTab();

        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity2.this, SearchCoupon_activity.class);
                startActivity(i);
            }
        });

        imgFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    final Dialog dialog = new Dialog(MainActivity2.this, R.style.ThemeDialog);

                dialog.setContentView(R.layout.design_filter_listview);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.show();

                RelativeLayout rl = (RelativeLayout) dialog.findViewById(R.id.rlDialogFilter);
                LinearLayout li = (LinearLayout) dialog.findViewById(R.id.liFilter);
                ListView lst = (ListView) dialog.findViewById(R.id.lstFilter);

                TextView txt = (TextView) dialog.findViewById(R.id.textItem);

                rl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();

                    }
                });
                ArrayAdapter<String> ad = new ArrayAdapter<String>(MainActivity2.this, R.layout.design_filter, R.id.textItemFilter, filterList);
                lst.setAdapter(ad);

                lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                   //     Log.e("position", position + "");
                        dialog.cancel();
                    }
                });*/

                Intent i = new Intent(MainActivity2.this, FilterActivity.class);
                startActivity(i);
            }
        });

        relativeLayoutTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Log.e("clickedddd", "clicked");
                final Dialog dialog;
                dialog = new Dialog(MainActivity2.this, R.style.ThemeDialog);

                dialog.setContentView(R.layout.design_dialog_list);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.show();

                final ListView lst = (ListView) dialog.findViewById(R.id.ListViewDialog);
                final RelativeLayout rl = (RelativeLayout) dialog.findViewById(R.id.rlDialog);
                TextView txt = (TextView) dialog.findViewById(R.id.textItem);
                final LinearLayout li = (LinearLayout) dialog.findViewById(R.id.li_dialog_list);

                //true=down false=up
                Log.e("boolean....", arrow + ".......");

                if (arrow == true) {
                    arrow = false;
                    li.startAnimation(animDown);
                    imgarrow.setImageResource(R.drawable.arrow_up);

                } else {
                    arrow = true;

                    li.startAnimation(animUp);
                    imgarrow.setImageResource(R.drawable.arrow_down);

                    final Handler handler = new Handler();
                    final Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            if (dialog.isShowing()) {
                                dialog.cancel();
                            }
                        }
                    };

                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            handler.removeCallbacks(runnable);
                        }
                    });

                    handler.postDelayed(runnable, 500);

                }

                rl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (arrow == false) {
                            arrow = true;
                            li.startAnimation(animUp);
                            MainActivity2.imgarrow.setImageResource(R.drawable.arrow_down);

                            final Handler handler = new Handler();
                            final Runnable runnable = new Runnable() {
                                @Override
                                public void run() {
                                    if (dialog.isShowing()) {
                                        dialog.cancel();
                                    }
                                }
                            };

                            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    handler.removeCallbacks(runnable);
                                }
                            });

                            handler.postDelayed(runnable, 500);
                        }
                    }
                });
                final ArrayAdapter<String> ad = new ArrayAdapter<String>(MainActivity2.this, R.layout.design_listview, R.id.textItem, list);
                lst.setAdapter(ad);

                lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        if (arrow == false) {
                            arrow = true;
                            li.startAnimation(animUp);
                            MainActivity2.imgarrow.setImageResource(R.drawable.arrow_down);

                            final Handler handler = new Handler();
                            final Runnable runnable = new Runnable() {
                                @Override
                                public void run() {
                                    if (dialog.isShowing()) {

                                        dialog.cancel();
                                    }
                                }
                            };

                            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    handler.removeCallbacks(runnable);
                                }
                            });

                            handler.postDelayed(runnable, 500);
                        }

                        if (position == 0) {
                            fragment = new Deal_Fragment();

                        } else if (position == 1) {
                      //      fragment = new Needs_Fragment();

                        } else if (position == 2) {
                            fragment = new Friends_Fragment();

                        } else if (position == 3) {
                            fragment = new Chat_Fragment();

                        } else if (position == 4) {
                            fragment = new More_Fragment();

                        }
                        if (fragment != null) {
                            FragmentTransaction ftt = getSupportFragmentManager().beginTransaction();
                            ftt.replace(R.id.content_frame, fragment);
                            ftt.commit();
                        }
                    }
                });
            }

        });

        deal.setIcon(R.drawable.deal);
        needs.setIcon(R.drawable.needs);
        friends.setIcon(R.drawable.friends);
        chat.setIcon(R.drawable.chat);
        more.setIcon(R.drawable.more);

        deal.setText("Deal");
        needs.setText("Needs");
        friends.setText("Friends");
        chat.setText("Chat");
        more.setText("More");

        tabLayout.addTab(deal, 0);
        tabLayout.addTab(needs, 1);
        tabLayout.addTab(friends, 2);
        tabLayout.addTab(chat, 3);
        tabLayout.addTab(more, 4);

        //    tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.black));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white));

        tabLayout.setOnTabSelectedListener(this);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        tab1 = tab;

     //   Log.e("tabPOsition....", tab1.getPosition() + "tabPOsition....");

        if (tab1.getPosition() == 0) {
            fragment = new Deal_Fragment();

        } else if (tab1.getPosition() == 1) {
            //fragment = new Needs_Fragment();

        } else if (tab1.getPosition() == 2) {
            fragment = new Friends_Fragment();

        } else if (tab1.getPosition() == 3) {
            fragment = new Chat_Fragment();

        } else if (tab1.getPosition() == 4) {
            fragment = new More_Fragment();
        }

        if (fragment != null) {
            FragmentTransaction ftt = getSupportFragmentManager().beginTransaction();
            ftt.replace(R.id.content_frame, fragment);
            ftt.commit();
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(MainActivity2.this,ActivityRegister.class);
        startActivity(i);
        finish();
        super.onBackPressed();

    }
}
