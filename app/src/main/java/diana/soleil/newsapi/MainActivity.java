package diana.soleil.newsapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.request.SourcesRequest;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.kwabenaberko.newsapilib.models.response.SourcesResponse;

public class MainActivity extends AppCompatActivity {
    NewsApiClient newsApiClient = new NewsApiClient("InProject");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


// /v2/top-headlines
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .q("tesla")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse articleResponse) {
                        System.out.println(articleResponse.getArticles().get(0).getTitle()+"2");
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );


// /v2/everything
newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q("tesla")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {

                    @Override
                    public void onSuccess(ArticleResponse articleResponse) {
                        System.out.println(articleResponse.getArticles().get(0).getTitle() + "1");

                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );


// /v2/sources
        newsApiClient.getSources(
                new SourcesRequest.Builder()
                        .language("en")
                        .country("us")
                        .build(),
                new NewsApiClient.SourcesCallback() {
                    @Override
                    public void onSuccess(SourcesResponse sourcesResponse) {
                        System.out.println(sourcesResponse.getSources().get(0).getName()+"3");
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
    }
}