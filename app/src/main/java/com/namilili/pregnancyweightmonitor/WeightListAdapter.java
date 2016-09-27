package com.namilili.pregnancyweightmonitor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class WeightListAdapter extends BaseAdapter
{
    private final Context mContext;
    private List<WeightItem> mListWeightItem;

    public WeightListAdapter(Context paramContext, List<WeightItem> weightItems)
    {
        this.mContext = paramContext;
        this.mListWeightItem = weightItems;
    }

    public int getCount()
    {
        return mListWeightItem.size();
    }

    public Object getItem(int paramInt)
    {
        return this.mListWeightItem.get(paramInt);
    }

    public long getItemId(int paramInt)
    {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
        ViewHolder localViewHolder = null;
        if (paramView == null)
        {
            paramView = LayoutInflater.from(this.mContext).inflate(
                    R.layout.weight_list, null);
            localViewHolder = new ViewHolder();
            localViewHolder.tvDate = ((TextView) paramView
                    .findViewById(R.id.date));
            localViewHolder.tvWeight = ((TextView) paramView.findViewById(R.id.weight));
            paramView.setTag(localViewHolder);
        }
        localViewHolder = (ViewHolder) paramView.getTag();
        localViewHolder.tvDate.setText(this.mListWeightItem
                .get(paramInt).getDate());
        localViewHolder.tvWeight.setText(this.mListWeightItem
                .get(paramInt).getWeight());
        return paramView;

    }

    public void updateAdapter(List<WeightItem> paramList)
    {
        this.mListWeightItem = paramList;
        notifyDataSetChanged();
    }

    static class ViewHolder
    {
        TextView tvDate;
        TextView tvWeight;
    }
}

