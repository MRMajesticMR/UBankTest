package ru.arkadiy.ubanktest.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.arkadiy.ubanktest.R;
import ru.arkadiy.ubanktest.model.data.Item;

/**
 * Created by arkadiy.zakharov on 17.10.2016.
 */

public class ItemsRecyclerViewAdapter extends RecyclerView.Adapter<ItemsRecyclerViewAdapter.ViewHolder> {

    private static final DateFormat TIME_FORMAT = new SimpleDateFormat("mm:ss");

    private final List<Item> items;

    public ItemsRecyclerViewAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public ItemsRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Разные варианты разметки с фиксированным временем справа
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_item_v1, parent, false);
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_item_v2, parent, false);

        ItemsRecyclerViewAdapter.ViewHolder vh = new ItemsRecyclerViewAdapter.ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = items.get(position);

        holder.titleTxt.setText(item.getTitle());

        holder.timeTxt.setText(TIME_FORMAT.format(item.getDate()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_title)
        TextView titleTxt;

        @BindView(R.id.txt_time)
        TextView timeTxt;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

}