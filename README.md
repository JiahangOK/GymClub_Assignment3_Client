# GymClub_Assignment3_Client for Android Development    
### Team Members:        
16231114 喻琳珠    
16301134 吴家行   

### Running Result：
见录屏文件：第三次作业录屏.mp4       

### Technical Features Applied：
- 服务端    
  Flask网络框架传递视频的url   
  flask_sqlalchemy   
  sqlite3数据库   
  response = make_response(video_data)做出相应   
  response.headers['Content-Type'] = 'video/mp4'打开视频文件    

- 客户端   
  1. 播放视频：    
  - 视频列表    
    RecyclerView  
    RecyclerView.Adapter  
    VideoInfo类使用了MediaMetadataRetriever获取视频的某一帧作为该视频的介绍图片  
  - 打开视频   
    VideoView播放远程视频文件     
    
  2. 发送邮件、发送SMS、拨打电话   
  - 发邮件  
    Intent data=new Intent(Intent.ACTION_SENDTO);    
    data.setData(Uri.parse("mailto:"+trainer_email.getText().toString().split(":")[1]));      
  - 发送SMS    
    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+trainer_tel.getText().toString().split(":")[1]));    
    String message ="hello.";   
    intent.putExtra("sms_body",message);    
  - 拨打电话    
    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + trainer_tel.getText().toString().split(":")[1]));     
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);     
      
  3. 地图功能  
  调用百度地图SDK接口  
  - 定位    
    MyLocationConfiguration      
  - 显示GymClub位置    
    BitmapDescriptor、OverlayOptions  
  - 切换视图  
    BaiduMap.MAP_TYPE_SATELLITE、BaiduMap.MAP_TYPE_NORMAL
    
  
