package com.lance.perfect.view.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lance.perfect.R;
import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.widget.TitleBarView;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.util.Locale;
import java.util.Random;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/26.
 */
public class UCropActivity extends BaseActivity{
    private static final String TAG = "UCropActivity";
    protected static final int REQUEST_STORAGE_READ_ACCESS_PERMISSION = 101;
    protected static final int REQUEST_STORAGE_WRITE_ACCESS_PERMISSION = 102;
    private TitleBarView mTitleBarView;

    private static final int REQUEST_SELECT_PICTURE = 0x01;
    private static final String SAMPLE_CROPPED_IMAGE_NAME = "SampleCropImage";

    private RadioGroup mRadioGroupAspectRatio, mRadioGroupCompressionSettings;
    private EditText mEditTextMaxWidth, mEditTextMaxHeight;
    private EditText mEditTextRatioX, mEditTextRatioY;
    private CheckBox mCheckBoxMaxSize;
    private SeekBar mSeekBarQuality;
    private TextView mTextViewQuality;
    private CheckBox mCheckBoxHideBottomControls;
    private CheckBox mCheckBoxFreeStyleCrop;

    private AlertDialog mAlertDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ucrop;
    }
    @Override
    protected void initViews() {
        mTitleBarView= (TitleBarView) findViewById(R.id.mTitleBarView);
        mTitleBarView.setTitleBar(View.VISIBLE, View.VISIBLE, View.GONE, "UCrop学习",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                },null);
        /***/
        findViewById(R.id.button_crop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickFromGallery();
            }
        });
        findViewById(R.id.button_random_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int minSizePixels = 800;
                int maxSizePixels = 2400;
                startCropActivity(Uri.parse(String.format(Locale.getDefault(), "https://unsplash.it/%d/%d/?random",
                        minSizePixels + random.nextInt(maxSizePixels - minSizePixels),
                        minSizePixels + random.nextInt(maxSizePixels - minSizePixels))));
            }
        });
        mRadioGroupAspectRatio = ((RadioGroup) findViewById(R.id.radio_group_aspect_ratio));
        mRadioGroupCompressionSettings = ((RadioGroup) findViewById(R.id.radio_group_compression_settings));
        mCheckBoxMaxSize = ((CheckBox) findViewById(R.id.checkbox_max_size));
        mEditTextRatioX = ((EditText) findViewById(R.id.edit_text_ratio_x));
        mEditTextRatioY = ((EditText) findViewById(R.id.edit_text_ratio_y));
        mEditTextMaxWidth = ((EditText) findViewById(R.id.edit_text_max_width));
        mEditTextMaxHeight = ((EditText) findViewById(R.id.edit_text_max_height));
        mSeekBarQuality = ((SeekBar) findViewById(R.id.seekbar_quality));
        mTextViewQuality = ((TextView) findViewById(R.id.text_view_quality));
        mCheckBoxHideBottomControls = ((CheckBox) findViewById(R.id.checkbox_hide_bottom_controls));
        mCheckBoxFreeStyleCrop = ((CheckBox) findViewById(R.id.checkbox_freestyle_crop));

        mRadioGroupAspectRatio.check(R.id.radio_dynamic);
        mEditTextRatioX.addTextChangedListener(mAspectRatioTextWatcher);
        mEditTextRatioY.addTextChangedListener(mAspectRatioTextWatcher);
        mRadioGroupCompressionSettings.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mSeekBarQuality.setEnabled(checkedId == R.id.radio_jpeg);
            }
        });
        mRadioGroupCompressionSettings.check(R.id.radio_jpeg);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_SELECT_PICTURE) {
                final Uri selectedUri = data.getData();
                if (selectedUri != null) {
                    startCropActivity(data.getData());
                } else {
                    Toast.makeText(UCropActivity.this, R.string.toast_cannot_retrieve_selected_image, Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == UCrop.REQUEST_CROP) {
                handleCropResult(data);
            }
        }
        if (resultCode == UCrop.RESULT_ERROR) {
            handleCropError(data);
        }
    }
    private void handleCropResult(@NonNull Intent result) {
        final Uri resultUri = UCrop.getOutput(result);
        if (resultUri != null) {
            Intent intent = new Intent(this, UCropResultActivity.class);
            intent.setData(resultUri);
            startActivity(intent);
        } else {
            Toast.makeText(UCropActivity.this, R.string.toast_cannot_retrieve_cropped_image, Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
    private void handleCropError(@NonNull Intent result) {
        final Throwable cropError = UCrop.getError(result);
        if (cropError != null) {
            Toast.makeText(UCropActivity.this, cropError.getMessage(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(UCropActivity.this, R.string.toast_unexpected_error, Toast.LENGTH_SHORT).show();
        }
    }
    private void pickFromGallery() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermission(Manifest.permission.READ_EXTERNAL_STORAGE,
                    getString(R.string.permission_read_storage_rationale),
                    REQUEST_STORAGE_READ_ACCESS_PERMISSION);
        } else {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            startActivityForResult(Intent.createChooser(intent, getString(R.string.label_select_picture)), REQUEST_SELECT_PICTURE);
        }
    }
    protected void requestPermission(final String permission, String rationale, final int requestCode) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
            showAlertDialog(getString(R.string.permission_title_rationale), rationale,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(UCropActivity.this,
                                    new String[]{permission}, requestCode);
                        }
                    }, getString(R.string.label_ok), null, getString(R.string.label_cancel));
        } else {
            ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
        }
    }
    protected void showAlertDialog(@Nullable String title, @Nullable String message,
                                   @Nullable DialogInterface.OnClickListener onPositiveButtonClickListener,
                                   @NonNull String positiveText,
                                   @Nullable DialogInterface.OnClickListener onNegativeButtonClickListener,
                                   @NonNull String negativeText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positiveText, onPositiveButtonClickListener);
        builder.setNegativeButton(negativeText, onNegativeButtonClickListener);
        mAlertDialog = builder.show();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_STORAGE_READ_ACCESS_PERMISSION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickFromGallery();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    private TextWatcher mAspectRatioTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            mRadioGroupAspectRatio.clearCheck();
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    @Override
    protected void initData() {
    }
    private void startCropActivity(@NonNull Uri uri) {
        String destinationFileName = SAMPLE_CROPPED_IMAGE_NAME;
        switch (mRadioGroupCompressionSettings.getCheckedRadioButtonId()) {
            case R.id.radio_png:
                destinationFileName += ".png";
                break;
            case R.id.radio_jpeg:
                destinationFileName += ".jpg";
                break;
        }

        UCrop uCrop = UCrop.of(uri, Uri.fromFile(new File(getCacheDir(), destinationFileName)));

        uCrop = basisConfig(uCrop);
        uCrop = advancedConfig(uCrop);

        uCrop.start(UCropActivity.this);
    }
    private UCrop basisConfig(@NonNull UCrop uCrop) {
        switch (mRadioGroupAspectRatio.getCheckedRadioButtonId()) {
            case R.id.radio_origin:
                uCrop = uCrop.useSourceImageAspectRatio();
                break;
            case R.id.radio_square:
                uCrop = uCrop.withAspectRatio(1, 1);
                break;
            case R.id.radio_dynamic:
                // do nothing
                break;
            default:
                try {
                    float ratioX = Float.valueOf(mEditTextRatioX.getText().toString().trim());
                    float ratioY = Float.valueOf(mEditTextRatioY.getText().toString().trim());
                    if (ratioX > 0 && ratioY > 0) {
                        uCrop = uCrop.withAspectRatio(ratioX, ratioY);
                    }
                } catch (NumberFormatException e) {
                    Log.i(TAG, String.format("Number please: %s", e.getMessage()));
                }
                break;
        }

        if (mCheckBoxMaxSize.isChecked()) {
            try {
                int maxWidth = Integer.valueOf(mEditTextMaxWidth.getText().toString().trim());
                int maxHeight = Integer.valueOf(mEditTextMaxHeight.getText().toString().trim());
                if (maxWidth > 0 && maxHeight > 0) {
                    uCrop = uCrop.withMaxResultSize(maxWidth, maxHeight);
                }
            } catch (NumberFormatException e) {
                Log.e(TAG, "Number please", e);
            }
        }

        return uCrop;
    }

    private UCrop advancedConfig(@NonNull UCrop uCrop) {
        UCrop.Options options = new UCrop.Options();
        switch (mRadioGroupCompressionSettings.getCheckedRadioButtonId()) {
            case R.id.radio_png:
                options.setCompressionFormat(Bitmap.CompressFormat.PNG);
                break;
            case R.id.radio_jpeg:
            default:
                options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
                break;
        }
        options.setCompressionQuality(mSeekBarQuality.getProgress());
        options.setHideBottomControls(mCheckBoxHideBottomControls.isChecked());
        options.setFreeStyleCropEnabled(mCheckBoxFreeStyleCrop.isChecked());
        /*
        If you want to configure how gestures work for all UCropActivity tabs

        options.setAllowedGestures(UCropActivity.SCALE, UCropActivity.ROTATE, UCropActivity.ALL);
        * */
        /*
        This sets max size for bitmap that will be decoded from source Uri.
        More size - more memory allocation, default implementation uses screen diagonal.
        options.setMaxBitmapSize(640);
        * */
       /*
        Tune everything (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
        options.setMaxScaleMultiplier(5);
        options.setImageToCropBoundsAnimDuration(666);
        options.setDimmedLayerColor(Color.CYAN);
        options.setOvalDimmedLayer(true);
        options.setShowCropFrame(false);
        options.setCropGridStrokeWidth(20);
        options.setCropGridColor(Color.GREEN);
        options.setCropGridColumnCount(2);
        options.setCropGridRowCount(1);
        // Color palette
        options.setToolbarColor(ContextCompat.getColor(this, R.color.your_color_res));
        options.setStatusBarColor(ContextCompat.getColor(this, R.color.your_color_res));
        options.setActiveWidgetColor(ContextCompat.getColor(this, R.color.your_color_res));
		options.setToolbarWidgetColor(ContextCompat.getColor(this, R.color.your_color_res));
       */
        return uCrop.withOptions(options);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAlertDialog != null && mAlertDialog.isShowing()) {
            mAlertDialog.dismiss();
        }
    }
}
