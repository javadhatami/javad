package com.example.android.network2.features;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.network2.R;
import com.example.android.network2.data.GitHubData;
import com.example.android.network2.api.GitHubJsonModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        getContactsData();
    }
    private void getContactsData() {

        GitHubData data = new GitHubData();
        Call<List<GitHubJsonModel>> call = data.getRepo();

        call.enqueue(new Callback<List<GitHubJsonModel>>() {
            @Override
            public void onResponse(Call<List<GitHubJsonModel>> call, Response<List<GitHubJsonModel>> response) {
                List<GitHubJsonModel> gitHubJsonModels = response.body();

                if(gitHubJsonModels != null) {
                    showContacts(gitHubJsonModels);
                }
            }


            @Override
            public void onFailure(Call<List<GitHubJsonModel>> call, Throwable t) {

            }
        });
    }

    private void showContacts(List<GitHubJsonModel> gitHubJsonModels) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < gitHubJsonModels.size(); i++) {
            Integer id = gitHubJsonModels.get(i).getId();
            String name = gitHubJsonModels.get(i).getName();
            list.add(String.valueOf(id) + "-" + name);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);
    }

    }



