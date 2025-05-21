import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 
 Button b;

 boolean r;

 int[] ia = new int[]{
 R.drawable.i1,
 R.drawable.i2,
 R.drawable.i3,
 R.drawable.i4,
 R.drawable.i5,
 R.drawable.i6,
 R.drawable.i7
 };
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);

 setContentView(R.layout.activity_main);

 b = (Button) findViewById(R.id.button);

 b.setOnClickListener(this);
 }

 @Override
 public void onClick(View v) {


 if (!r) {

 new Timer().schedule(new MyTimer(), 0, 3000);

 r = true;
 }
 }

 private class MyTimer extends TimerTask {
 @Override
 public void run() {
 try {

 WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());

 Random random = new Random();
wallpaperManager.setBitmap( BitmapFactory.decodeResource(getResources(), ia[random.nextInt(ia.length)] ) );
 }
 catch (IOException e) {
 e.printStackTrace();
 }
 }
 }
}



























































































































 
