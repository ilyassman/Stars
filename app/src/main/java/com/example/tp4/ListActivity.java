package com.example.tp4;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.MenuItemCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp4.adapter.StarAdapter;
import com.example.tp4.beans.Star;
import com.example.tp4.service.StarService;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private List<Star> stars;
    private RecyclerView recyclerView;
    private StarAdapter starAdapter = null;
    StarService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.appbar)));
        }
        stars = new ArrayList<>();
        service = StarService.getInstance();
        init();
        recyclerView = findViewById(R.id.recycle_view);
        starAdapter = new StarAdapter(this, service.findAll());
        recyclerView.setAdapter(starAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.homme) {
            if (starAdapter != null){
                starAdapter.getFilter().filter("homme");
            }
            return true;
        } else if (itemId == R.id.femme) {
            if (starAdapter != null){
                starAdapter.getFilter().filter("femme");
            }
            return true;
        } else if (itemId == R.id.share) {
            String txt = "Stars";
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Stars")
                    .setText(txt)
                    .startChooser();
        }
        return super.onOptionsItemSelected(item);
    }
    public void init() {
        service.create(new Star("Anne Hathaway", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTTPqsTBEwd6QUluxycfWH-k7S7gPA1tRt4lisrlPb5tBCkJeru", 4f, false));
        service.create(new Star("Lizzy Caplan", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSRRV9vv9ap9XhUoMwNW0lDfXSpIirQf9XAwB2eaX8jwCNcmOT9", 3.5f, false));
        service.create(new Star("Robert Downey Jr", "https://media.gqmagazine.fr/photos/661f986869b8ce37a6f2cbb7/1:1/w_1600%2Cc_limit/803015182", 4.5f, true));
        service.create(new Star("Scarlett Johansson", "https://m.media-amazon.com/images/M/MV5BMTM3OTUwMDYwNl5BMl5BanBnXkFtZTcwNTUyNzc3Nw@@._V1_.jpg", 4.5f, false));
        service.create(new Star("Tom Hanks", "https://upload.wikimedia.org/wikipedia/commons/a/a9/Tom_Hanks_TIFF_2019.jpg", 5f, true));
        service.create(new Star("Meryl Streep", "https://upload.wikimedia.org/wikipedia/commons/4/46/Meryl_Streep_December_2018.jpg", 5f, false));
        service.create(new Star("Leonardo DiCaprio", "https://upload.wikimedia.org/wikipedia/commons/4/46/Leonardo_Dicaprio_Cannes_2019.jpg", 4.5f, true));
        service.create(new Star("Jennifer Lawrence", "https://upload.wikimedia.org/wikipedia/commons/0/0b/Jennifer_Lawrence_SDCC_2015_X-Men.jpg", 4f, false));
        service.create(new Star("Brad Pitt", "https://upload.wikimedia.org/wikipedia/commons/4/4c/Brad_Pitt_2019_by_Glenn_Francis.jpg", 4.5f, true));
        service.create(new Star("Denzel Washington", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Denzel_Washington_2018.jpg/1200px-Denzel_Washington_2018.jpg", 4.5f, true));
        service.create(new Star("Tom Cruise", "https://upload.wikimedia.org/wikipedia/commons/3/33/Tom_Cruise_by_Gage_Skidmore_2.jpg", 4f, true));
        service.create(new Star("Viola Davis", "https://upload.wikimedia.org/wikipedia/commons/8/85/Viola_Davis_by_Gage_Skidmore.jpg", 4.5f, false));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Stars");
        }
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        if (searchItem != null) {
            SearchView searchView = (SearchView) searchItem.getActionView();
            if (searchView != null) {
                searchView.setQueryHint("taper le nom");
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {

                        return true;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        if (starAdapter != null){
                            starAdapter.getFilter().filter(newText);
                        }
                        return true;
                    }
                });
            }
        }

        return true;
    }


}