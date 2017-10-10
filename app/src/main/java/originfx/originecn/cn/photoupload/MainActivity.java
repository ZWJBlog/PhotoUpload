package originfx.originecn.cn.photoupload;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.yalantis.ucrop.UCrop;

import static android.R.attr.maxHeight;
import static android.R.attr.maxWidth;

public class MainActivity extends AppCompatActivity {
    CropHandlers cropHandler;
    ImageView img;
    public static int REQUEST_SELECT_PICTURE = Activity.RESULT_OK;

    public class CropHandlers implements PicCrop.CropHandler {

        @Override
        public void handleCropResult(Uri uri, int tag) {
            img.setImageURI(uri);
        }

        @Override
        public void handleCropError(Intent data) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.img);

        cropHandler = new CropHandlers();
        PicCrop.cropFromGallery(this);
    }


    //使用时的调用:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        PicCrop.handleResult(this, cropHandler, requestCode, resultCode, data);

    }


}
