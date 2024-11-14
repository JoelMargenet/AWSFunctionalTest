package com.example.myawstest;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView; // Add the import for TextView
import androidx.appcompat.app.AppCompatActivity;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.amplifyframework.datastore.generated.model.Person;

public class MainActivity extends AppCompatActivity {

    // Declare a TextView for displaying the person's name
    private TextView nameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the TextView
        nameTextView = findViewById(R.id.Name);

        // Initialize Amplify
        try {
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.addPlugin(new AWSS3StoragePlugin());

            Amplify.configure(getApplicationContext());
            Log.d("MainActivity", "Amplify initialized successfully!");

            // Save a Person object to AWS DataStore
            savePersonToDataStore();

            // Retrieve Person object from AWS DataStore
            getPersonFromDataStore();

        } catch (Exception e) {
            Log.e("MainActivity", "Error initializing Amplify", e);
        }
    }

    // Function to save a Person object to AWS DataStore
    private void savePersonToDataStore() {
        Person person = Person.builder()
                .name("John")
                .lastName("Doe")
                .build();

        Amplify.DataStore.save(
                person,
                result -> Log.d("MainActivity", "Saved item: " + result.item()),
                error -> Log.e("MainActivity", "Error saving item: ", error)
        );
    }

    // Function to retrieve Person object from AWS DataStore
    private void getPersonFromDataStore() {
        Amplify.DataStore.query(
                Person.class,
                items -> {
                    while (items.hasNext()) {
                        Person person = items.next();
                        Log.d("MainActivity", "Retrieved person: " + person);

                        // Update the UI with the person's name
                        runOnUiThread(() -> nameTextView.setText(person.getName()));
                    }
                },
                error -> Log.e("MainActivity", "Error retrieving items: ", error)
        );
    }
}
