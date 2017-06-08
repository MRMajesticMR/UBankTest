package ru.arkadiy.ubanktest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.arkadiy.ubanktest.model.ItemsGenerator;
import ru.arkadiy.ubanktest.model.data.Item;
import ru.arkadiy.ubanktest.ui.adapters.ItemsRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    private static final int ITEMS_COUNT = 100;

    @BindView(R.id.recycler_view_items)
    RecyclerView itemsRecyclerView;

    private List<Item> items;
    private ItemsRecyclerViewAdapter itemsRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        items = ItemsGenerator.generateItems(ITEMS_COUNT);

        itemsRecyclerViewAdapter = new ItemsRecyclerViewAdapter(this, items);

        itemsRecyclerView.setAdapter(itemsRecyclerViewAdapter);
        itemsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
