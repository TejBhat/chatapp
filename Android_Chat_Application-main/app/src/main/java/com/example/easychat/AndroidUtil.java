package com.example.easychat;

import android.content.Intent;

import com.example.easychat.model.UserModel;

public class AndroidUtil {

    public static final String EXTRA_USER_MODEL = "extra_user_model";

    /**
     * Pass UserModel as an Intent extra.
     */
    public static void passUserModelAsIntent(Intent intent, UserModel userModel) {
        intent.putExtra(EXTRA_USER_MODEL, (CharSequence) userModel);
    }
}
