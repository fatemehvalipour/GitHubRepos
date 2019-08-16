package com.example.testretrofit;


import android.R.layout;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends ListActivity {
    private EditText username;
    private Button ok;
    private ListView listView;
    private ArrayList<String> repoNames = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        ok = findViewById(R.id.ok);
        listView = getListView();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GitHubService service = RetroClient.getInstance().create(GitHubService.class);
                Call<List<RetroRepo>> repoList = service.listRepos(username.getText().toString());
                Log.d("tag before" , "ghabl az response");
                repoList.enqueue(new Callback<List<RetroRepo>>() {
                    @Override
                    public void onResponse(Call<List<RetroRepo>> call, Response<List<RetroRepo>> response) {
                        for (RetroRepo repo : response.body()){
                            repoNames.add(repo.getName());
                        }
                        Log.d("tag " , "response");
                        setListAdapter(new ArrayAdapter<String>(MainActivity.this, layout.simple_list_item_1, repoNames));

                    }

                    @Override
                    public void onFailure(Call<List<RetroRepo>> call, Throwable t) {
                        Log.d("tag3" , "onfailure");
                        Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                        Log.d("toast" , " bad as toast");
                    }
                });
            }
        });

    }
}
