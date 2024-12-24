package com.example.easychat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.easychat.model.UserModel;
import com.example.easychat.utils.AndroidUtil;
import com.example.easychat.utils.FirebaseUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (getIntent().getExtras() != null) {
            // Handle intent extras from notification
            String userId = getIntent().getExtras().getString("userId");
            if (userId != null) {
                FirebaseUtil.allUserCollectionReference().document(userId).get()
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful() && task.getResult() != null) {
                                UserModel model = task.getResult().toObject(UserModel.class);
                                if (model != null) {
                                    // Navigate to MainActivity
                                    Intent mainIntent = new Intent(this, MainActivity.class);
                                    mainIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(mainIntent);

                                    // Navigate to ChatActivity with user data
                                    Intent chatIntent = new Intent(this, ChatActivity.class);
                                    AndroidUtil.passUserModelAsIntent(chatIntent, model);
                                    chatIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(chatIntent);
                                }
                            } else {
                                Log.e(TAG, "Error fetching user: ", task.getException());
                            }
                            finish();
                        });
            }
        } else {
            // Default behavior: delayed transition
            new Handler().postDelayed(() -> {
                if (FirebaseUtil.isLoggedIn()) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginPhoneNumberActivity.class));
                }
                finish();
            }, 1000);
        }
    }
}
