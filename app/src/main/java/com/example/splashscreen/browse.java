package com.example.splashscreen;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import java.util.Set;



import androidx.appcompat.app.AppCompatActivity;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import java.util.ArrayList;


public class  browse extends AppCompatActivity {

    ListView newsListView;
    EditText search;
    NewsAdapter newsAdapter;
    ImageView search_button_img;
    private Button[] buttons;
    private Button randomNewsButton;

    ArrayList<Integer> selectedButtonIds = new ArrayList<>();


    ArrayList<News> newsList = new ArrayList<>();
    String defaultSearchTerm = "business";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("browse", "onCreate called");
        setContentView(R.layout.activity_browse);
//        newsListView = findViewById(R.id.list_view);
//        getSupportActionBar().hide();

        buttons = new Button[]{
                findViewById(R.id.sports_topic_button),
                findViewById(R.id.politics_topic_button),
                findViewById(R.id.life_topic_button),
                findViewById(R.id.gaming_topic_button),
                findViewById(R.id.animals_topic_button),
                findViewById(R.id.nature_topic_button),
                findViewById(R.id.food_topic_button),
                findViewById(R.id.art_topic_button),
                findViewById(R.id.history_topic_button),
                findViewById(R.id.fashion_topic_button)
        };

        SharedPreferences sharedPreferences = getSharedPreferences("Saved Buttons", MODE_PRIVATE);
        Set<String> selectedButtonIdsSet = sharedPreferences.getStringSet("selectedButtonIds", null);
        if (selectedButtonIdsSet != null) {
            for (String buttonId : selectedButtonIdsSet) {
                Button button = findViewById(Integer.parseInt(buttonId));
                if (button != null) {
                    toggleButtonSelection(button);
                }
                Log.d("browse", "Received selectedButtonId: " + buttonId);
            }
        } else {
            Log.d("browse", "selectedButtonIds is null");
        }


        //Get the ListView and attach the adapter
        newsListView = findViewById(R.id.list_view);

        search = findViewById(R.id.search_bar);
        search_button_img = findViewById(R.id.imageView12);

        randomNewsButton = (Button) findViewById(R.id.random_news_button);



        loadButtonStates();


        fetchNewsArticles(defaultSearchTerm);


        onClickListeners();

        //Display  news by default


    }

    private void loadButtonStates() {
        for (Button button : buttons) {
            int buttonId = button.getId();
            boolean isSelected = selectedButtonIds.contains(buttonId);
            button.setSelected(isSelected);

            Log.d("ButtonVisibility", button.getText().toString() + " is selected: " + isSelected);

            if (isSelected) {
                button.setVisibility(View.VISIBLE);
                fetchNewsArticles(button.getText().toString());
            } else {
                button.setVisibility(View.GONE);
            }
        }
    }


    private void fetchNewsArticles(String searchTerm) {
        // Getting news from News Api
        NewsApiClient newsApiClient = new NewsApiClient("75604105726b411db5484a99e67bf6d1");


        //News Api integration
        // /v2/everything
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q(searchTerm)
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {

                    @Override
                    public void onSuccess(ArticleResponse response) {

                        newsList.clear();
                        Log.e("browse - ", "author - " + "1");

                        for (Article article : response.getArticles()) {
                            String author = article.getAuthor();
                            String title = article.getTitle();
                            String imageUrl = article.getUrlToImage();
                            String content = article.getContent();
                            String url = article.getUrl();
                            String publishedAt = article.getPublishedAt();
                            String description = article.getDescription();

//                            Log.e("browse - ", "author - " + author);

                            if (!title.equals("[Removed]") && !title.isEmpty()) {

                                News news = new News(title, imageUrl, author, content, url, publishedAt, description);
                                Log.e("browse - ", "news title - " + title);
                                newsList.add(news);
                            }
                        }

                        Log.e("browse - ", "news list count - " + newsList.size());

                        newsAdapter = new NewsAdapter(browse.this, newsList);
                        newsListView.setAdapter(newsAdapter);


                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                        Log.e("browse - ", "author - " + "2");
                    }
                }
        );

    }

    public void toggleButtonSelection(Button button) {
        int buttonId = button.getId();
        if (selectedButtonIds.contains(buttonId)) {
            // Button is selected, so deselect it
            selectedButtonIds.remove(Integer.valueOf(buttonId));
            button.setSelected(false);
            button.setBackgroundResource(R.drawable.rounded_corner_view);
            button.setTextColor(getColor(R.color.grey_darker));

        } else {
            // Button is not selected, so select it
            selectedButtonIds.add(buttonId);
            button.setSelected(true);
            button.setBackgroundResource(R.drawable.roundshapebutton);
            button.setTextColor(getColor(R.color.white));
            // Fetch news articles based on the selected topic
            fetchNewsArticles(button.getText().toString());


        }
    }

    private void onClickListeners() {
        //Set an OnClickListener for search button
        search_button_img.setOnClickListener(view -> {
            //Get the current search query from the search text
            String search_query = search.getText().toString();
            fetchNewsArticles(search_query);
        });
//
        randomNewsButton.setOnClickListener(view -> {
            toggleButtonSelection(randomNewsButton);
            Intent intent = new Intent(browse.this, selecetfavorite.class);
            startActivity(intent);


        });

        newsListView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(browse.this, adapterview.class);
            intent.putExtra("title", newsList.get(i).getTitle());
            intent.putExtra("content", newsList.get(i).getContent());
            intent.putExtra("author", newsList.get(i).getAuthor());
            intent.putExtra("image", newsList.get(i).getImageUrl());
            intent.putExtra("url", newsList.get(i).getUrl());

            startActivity(intent);
        });

        // OnClickListener for each topic button
        for (Button button : buttons) {
            if (button.getVisibility() == View.VISIBLE) {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Get the text of the selected button
                        String selectedTopic = button.getText().toString();

                        //Fetch news articles based on the selected topic
                        fetchNewsArticles(selectedTopic);

                        //Update the selectedButtonIds and button state
                        toggleButtonSelection(button);
                    }
                });

            }
        }

    }
}













