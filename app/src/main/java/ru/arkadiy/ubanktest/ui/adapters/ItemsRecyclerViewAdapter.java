package ru.arkadiy.ubanktest.ui.adapters;

import android.content.Context;
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
import ru.arkadiy.ubanktest.ui.utils.DimensionsUtils;

/**
 * Created by arkadiy.zakharov on 17.10.2016.
 */

public class ItemsRecyclerViewAdapter extends RecyclerView.Adapter<ItemsRecyclerViewAdapter.ViewHolder> {

    private static final DateFormat TIME_FORMAT = new SimpleDateFormat("mm:ss");

    private final List<Item> items;

    private int screenSize;

    public ItemsRecyclerViewAdapter(Context context, List<Item> items) {
        this.items = items;

        screenSize = DimensionsUtils.getScreenWidth(context);
    }

    @Override
    public ItemsRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_item, parent, false);

        ItemsRecyclerViewAdapter.ViewHolder vh = new ItemsRecyclerViewAdapter.ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = items.get(position);

        holder.titleTxt.setText(item.getTitle());

        holder.timeTxt.setText(TIME_FORMAT.format(item.getDate()));

        //Я не горжусь этим решением, но, at least, оно работает...
        //88 - суммарное число бокковых отступов 2-х TextView и ширина TextView, в которое помещается время в формате mm:ss
        holder.titleTxt.setMaxWidth(screenSize - (DimensionsUtils.convertDpToPixel(88, holder.itemView.getContext())));
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