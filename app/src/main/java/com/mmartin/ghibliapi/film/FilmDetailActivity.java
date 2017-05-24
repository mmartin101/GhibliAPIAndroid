package com.mmartin.ghibliapi.film;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mmartin.ghibliapi.R;
import com.mmartin.ghibliapi.people.GhibliPeopleService;
import com.mmartin.ghibliapi.people.Person;
import com.mmartin.ghibliapi.retrofit.GhibliApiManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class FilmDetailActivity extends AppCompatActivity {
    @BindView(R.id.film_title_text_view)
    TextView titleTextView;
    @BindView(R.id.film_description_text_view)
    TextView descriptionTextView;
    @BindView(R.id.content)
    LinearLayout content;

    private Film film;

    public static Intent newIntent(Context c, Film film) {
        Intent intent = new Intent(c, FilmDetailActivity.class);
        intent.putExtra("film", film);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);
        ButterKnife.bind(this);
        if (getIntent() != null && getIntent().hasExtra("film")) {
            film = getIntent().getParcelableExtra("film");
            titleTextView.setText(film.getTitle());
            descriptionTextView.setText(film.getDescription());
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getPeople();

    }

    private void getPeople() {
        @SuppressLint("StaticFieldLeak")
        GetPeopleTask task = new GetPeopleTask() {
            @Override
            protected void onPostExecute(List<Person> people) {
                for (Person person : people) {
                    TextView tv = new TextView(getBaseContext());
                    tv.setText(person.getName());
                    content.addView(tv);
                }
            }
        };
        task.execute(film.getPeople().toArray(new String[]{}));

    }

    static class GetPeopleTask extends AsyncTask<String, Void, List<Person>> {

        @Override
        protected List<Person> doInBackground(String... strings) {
            List<Person> personList = new ArrayList<>(strings.length);
            GhibliPeopleService service = GhibliApiManager.getInstance().getPeopleService();
            String id;
            for (String s : strings) {
                id = s.replace(GhibliApiManager.API_URL + "people/", "");
                if (!id.trim().isEmpty()) {
                    try {
                        personList.add(service.getPeopleById(id).execute().body());
                    } catch (IOException e) {
                        Timber.e(e);
                    }
                }
            }
            return personList;
        }
    }

}
