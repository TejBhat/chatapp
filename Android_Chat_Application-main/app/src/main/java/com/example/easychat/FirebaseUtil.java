package com.example.easychat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseUtil {

    private static final String USERS_COLLECTION = "users";

    /**
     * Get a reference to the "users" Firestore collection.
     */
    public static CollectionReference allUserCollectionReference() {
        return FirebaseFirestore.getInstance().collection(USERS_COLLECTION);
    }

    /**
     * Check if the user is logged in via FirebaseAuth.
     */
    public static boolean isLoggedIn() {
        return FirebaseAuth.getInstance().getCurrentUser() != null;
    }
}
