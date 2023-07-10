package com.example.sample_one

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sample_one.databinding.NormalProfileBinding
import com.example.sample_one.ui.theme.Sample_oneTheme
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


class MainActivity : ComponentActivity() {

    private lateinit var  binding: NormalProfileBinding
    private lateinit var databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  NormalProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        databaseReference = Firebase.database.getReference("user2")
        readDataIfPresent()
        initListeners()


    }

    private fun initListeners() {
       binding.saveThis.setOnClickListener {

//           val usersRef: DatabaseReference = databaseReference.child("userId")

//           usersRef.child("userId").setValue("John Doe")
           databaseReference.setValue("John Doe 2")
//           databaseReference.child("settingEnabled").setValue("false")

       }
    }

    private fun readDataIfPresent(){
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue<String>()
                Log.d("firebase value", "Value is: " + value)
               binding.showThisText.text = value.toString()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // This method is called if there's an error reading the data
                // Handle the error here
            }
        })
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Sample_oneTheme {
        Greeting("Android")
    }
}