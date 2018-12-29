package com.ccl.yuedu.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;

import com.squareup.picasso.Transformation;

/**
 * Created by chencanlin on 2018/12/24 11:22
 */
public class BlurTransformation implements Transformation {

    private final RenderScript mRenderScript;
    private final int mRadius;
    private final float mScale;

    public BlurTransformation(Context context, int radius, float scale) {
        mRenderScript = RenderScript.create(context);
        mRadius = radius;
        mScale = scale;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        int width = Math.round(source.getWidth() * mScale);
        int height = Math.round(source.getHeight() * mScale);

        Bitmap inputBmp = Bitmap.createScaledBitmap(source, width, height, false);

        // Allocate memory for Renderscript to work with

        final Allocation input = Allocation.createFromBitmap(mRenderScript, inputBmp);
        final Allocation output = Allocation.createTyped(mRenderScript, input.getType());

        // Load up an instance of the specific script that we want to use.
        ScriptIntrinsicBlur scriptIntrinsicBlur = ScriptIntrinsicBlur.create(mRenderScript, Element.U8_4(mRenderScript));
        scriptIntrinsicBlur.setInput(input);

        // Set the blur radius
        scriptIntrinsicBlur.setRadius(mRadius);

        // Start the ScriptIntrinisicBlur
        scriptIntrinsicBlur.forEach(output);

        // Copy the output to the blurred bitmap
        output.copyTo(inputBmp);


        mRenderScript.destroy();
        return inputBmp;
    }

    @Override
    public String key() {
        return "blur";
    }
}
