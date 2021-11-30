package AliCode.io;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.ActionBar;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{

    MyRecyclerViewAdapter adapter;



    public VideoView vidoePlayer;

    public RecyclerView recyclerView;





    float x1,x2;
    float y1, y2;




        public int counter=0;

     public TVchannel[] channelNumber =new TVchannel[38];










    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);






        vidoePlayer = (VideoView) findViewById(R.id.videoViewPalyer);



        // data to populate the RecyclerView with



        channelNumber[0] = new TVchannel("MBC1","https://shls-mbc1ksa-prod-dub.shahid.net/out/v1/451b666db1fb41c7a4bbecf7b4865107/index.m3u8");
        channelNumber[1] = new TVchannel("MBC2","https://shls-mbc2-prod-dub.shahid.net/out/v1/b4befe19798745fe986f5a9bfba62126/index_1.m3u8");
        channelNumber[2] = new TVchannel("MBC3","https://shls-mbc3-prod-dub.shahid.net/out/v1/d5bbe570e1514d3d9a142657d33d85e6/index_1.m3u8");
        channelNumber[3] = new TVchannel("MBC4","https://shls-mbc4-prod-dub.shahid.net/out/v1/c08681f81775496ab4afa2bac7ae7638/index_1.m3u8");
        channelNumber[4] = new TVchannel("MBC5","https://shls-mbc5-prod-dub.shahid.net/out/v1/2720564b6a4641658fdfb6884b160da2/index_1.m3u8");
        channelNumber[5] = new TVchannel("MBC Drama","https://shls-mbcdramaksa-prod-dub.shahid.net/out/v1/ce0f0762d89e4394a856c5fd13e43645/index_2.m3u8");
        channelNumber[6] = new TVchannel("mbc plus","https://shls-mbcplusdrama-prod-dub.shahid.net/out/v1/97ca0ce6fc6142f4b14c0a694af59eab/index_1.m3u8");
        channelNumber[7] = new TVchannel("MBC MAX HD","https://shls-mbcmax-prod-dub.shahid.net/out/v1/13815a7cda864c249a88c38e66a2e653/index.m3u8");
        channelNumber[8] = new TVchannel("mbc iraq","https://shls-iraq-prod-dub.shahid.net/out/v1/c9bf1e87ea66478bb20bc5c93c9d41ea/index_1.m3u8");
        channelNumber[9] = new TVchannel("cartoon-net","https://shls-cartoon-net-prod-dub.shahid.net/out/v1/dc4aa87372374325a66be458f29eab0f/index.m3u8");
        channelNumber[10] = new TVchannel("AbuDhabi","https://admdn2.cdn.mangomolo.com/adtv/smil:adtv.stream.smil/chunklist_b4000000_t64MTA4MHA=.m3u8");
        channelNumber[11] = new TVchannel("AbuDhabi Drama","https://admdn5.cdn.mangomolo.com/drama/smil:drama.stream.smil/chunklist_b1800000_t64NzIwcA==.m3u8");
        channelNumber[12] = new TVchannel("Dubai","https://dmisxthvll.cdn.mangomolo.com/dubaitv/smil:dubaitv.stream.smil/chunklist_b1500000.m3u8");
        channelNumber[13] = new TVchannel("Sama Dubai","https://dmieigthvll.cdn.mangomolo.com/samadubai/smil:samadubai.stream.smil/chunklist_b1500000.m3u8");
        channelNumber[14] = new TVchannel("Dubai one","https://dminnvll.cdn.mangomolo.com/dubaione/smil:dubaione.stream.smil/chunklist_b1300000.m3u8");
        channelNumber[15] = new TVchannel("mbc action","https://shls-mbcaction-prod-dub.shahid.net/out/v1/68dd761538e5460096c42422199d050b/index_1.m3u8");
        channelNumber[16] = new TVchannel("Sharjah","https://svs.itworkscdn.net/smc1live/smc1.smil/playlist_1080p.m3u8");
        channelNumber[17] = new TVchannel("AD National G","https://admdn2.cdn.mangomolo.com/nagtv/smil:nagtv.stream.smil/playlist.m3u8?adtv");
        channelNumber[18] = new TVchannel("alrai","https://stream02.fasttelco.net/live/alrai.stream/chunklist_w825183773.m3u8");
        channelNumber[19] = new TVchannel("emarat","https://admdn3.cdn.mangomolo.com/emarat/smil:emarat.stream.smil/chunklist_b4000000_t64MTA4MHA=.m3u8");
        channelNumber[20] = new TVchannel("netTV","https://unlimited1-us.dps.live/nettv/nettv.smil/playlist.m3u8");
        channelNumber[21] = new TVchannel("sky news","https://stream.skynewsarabia.com/hls/sna_720.m3u8");
        channelNumber[22] = new TVchannel("Australia Channel","https://austchannel-live.akamaized.net/hls/live/2002729/austchannel-news/master1280x720.m3u8");
        channelNumber[23] = new TVchannel("alarabiya","https://live.alarabiya.net/alarabiapublish/alarabiya.smil/playlist_1080p.m3u8");
        channelNumber[24] = new TVchannel("syria tv","https://svs.itworkscdn.net/syriatvlive/syriatv.smil/playlist.m3u8");
        channelNumber[25] = new TVchannel("Rotana kids","https://rotana.hibridmedia.com/rotana/kids_dabr/rotana/kids_1080p/chunks.m3u8");
        channelNumber[26] = new TVchannel("Rotana comedy","https://rotana.hibridmedia.com/rotana/comedy_dabr/rotana/comedy_1080p/chunks.m3u8");
        channelNumber[27] = new TVchannel("Rotana Drama","https://rotana.hibridmedia.com/rotana/drama_dabr/playlist.m3u8");
        channelNumber[28] = new TVchannel("womexerc","https://bozztv.com/36bay2/gin/giniko_womexerc_1000kb_36bay2/tracks-v1a1/mono.m3u8");
        channelNumber[29] = new TVchannel("majid","https://admdn4.cdn.mangomolo.com/majid/smil:majid.stream.smil/playlist.m3u8?checkedby:hlscat.com");
        channelNumber[30] = new TVchannel("Spacetoon","https://streams.spacetoon.com/live/stchannel/smil:livesmil.smil/playlist.m3u8");
        channelNumber[31] = new TVchannel("DW News","https://dwstream4-lh.akamaihd.net/i/dwstream4_live@131329/master.m3u8");
        channelNumber[32] = new TVchannel("RT ARAB","https://rt-arab.secure.footprint.net/1104_2500Kb.m3u8");
        channelNumber[33] = new TVchannel("ALJAZEERA UK","https://live-hls-web-aje.getaj.net/AJE/index.m3u8");
        channelNumber[34] = new TVchannel("TRT 1","https://tv-trt1.live.trt.com.tr/master_720.m3u8");
        channelNumber[35] = new TVchannel("RT USA","https://rt-usa.secure.footprint.net/1105_2500Kb.m3u8");
        channelNumber[36] = new TVchannel("Russia 1","https://a3569457286-s26881.cdn.ngenix.net/hls/russia_hd/playlist_3.m3u8");
        

        ArrayList<String> animalNames = new ArrayList<>();

        for(int i=0; i<channelNumber.length;i++)
        {
            animalNames.add(channelNumber[i].getChName());
        }






        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);



        recyclerView.setVisibility(View.GONE);


          TV(counter);

        Log.d("the video Start","the video Start msg");







    }

    @Override
    public void onItemClick(View view, int position)
    {
        Toast.makeText(this, " " + adapter.getItem(position) + "  " + position, Toast.LENGTH_SHORT).show();



            TV(position);
            recyclerView.setVisibility(View.GONE);



            counter = position;



    }

    public void TV(int channelNumberX)
    {


        vidoePlayer.setVideoURI(Uri.parse(channelNumber[channelNumberX].getServerUrl()));
        //Toast.makeText(this, " " + channelNumber[channelNumberX].getChName() + "  " + channelNumberX, Toast.LENGTH_SHORT).show();

        try{
            vidoePlayer.start();
        }
        catch(Exception e)
        {
            TV(channelNumberX + 1);
        }




    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        Log.d("onkeyDown: "," "+keyCode + " ");
        if(keyCode==22)
        {
            // Next // remote control right button
            if(counter < channelNumber.length-1)
            {
                counter ++;


            }



            TV(counter);



            recyclerView.setVisibility(View.GONE);
        }
        else if(keyCode==21)
        {
            // back //  remote control left button
            if(counter >0)
            {
                counter --;
            }
            else
            {
                counter=0;
            }


            TV(counter);

            recyclerView.setVisibility(View.GONE);
        }


         if(keyCode==19)
        {
            // up key
        }


         if(keyCode==20)
        {
            //down key
        }


         if(keyCode==23)
        {
            // Ok key
            Log.d("Ok key Code",":"+keyCode + "recyclerView.getVisibility() = " + recyclerView.getVisibility());

            if( recyclerView.getVisibility()==View.GONE)
            {
                recyclerView.setVisibility(View.VISIBLE);




            }
        }

        return super.onKeyDown(keyCode, event);
    }





    public boolean onTouchEvent(MotionEvent event){





        switch (event.getAction()) {
            // when user first touches the screen we get x and y coordinate
            case MotionEvent.ACTION_DOWN: {
                x1 = event.getX();
                y1 = event.getY();
                break;
            }
            case MotionEvent.ACTION_UP: {
                x2 = event.getX();
                y2 = event.getY();

                                                 //if left to right sweep event on screen
                if (x1 < x2) {
                    //Toast.makeText(this, "Left to Right Swap Performed", Toast.LENGTH_LONG).show();

                    if(counter >0)
                    {
                        counter --;
                    }
                    else
                    {
                        counter=0;
                    }


                    TV(counter);

                }

                // if right to left sweep event on screen
                if (x1 > x2) {
                    //Toast.makeText(this, "Right to Left Swap Performed", Toast.LENGTH_LONG).show();

                    if(counter < channelNumber.length-1)
                    {
                        counter ++;


                    }



                    TV(counter);
                }

                // if UP to Down sweep event on screen
                if (y1 < y2) {
                   // Toast.makeText(this, "UP to Down Swap Performed", Toast.LENGTH_LONG).show();
                }

                                                 //if Down to UP sweep event on screen
                if (y1 > y2) {
                   // Toast.makeText(this, "Down to UP Swap Performed", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }



        return super.onTouchEvent(event);
    }



}

