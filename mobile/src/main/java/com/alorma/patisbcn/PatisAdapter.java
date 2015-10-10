package com.alorma.patisbcn;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alorma.patisbcn.data.CoordinatesHelper;
import com.alorma.patisbcn.domain.model.Acte;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import gov.nasa.worldwind.geom.Angle;

/**
 * Created by Bernat on 10/10/2015.
 */
public class PatisAdapter extends RecyclerView.Adapter<PatisAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<Acte> acteList;

    public PatisAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        acteList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.row_pati, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Location loc = CoordinatesHelper.convert(acteList.get(position).lloc_simple.adreca_simple.coordenades);
        String url = "http://maps.google.com/maps/api/staticmap?center=" + loc.getLatitude() + "," + loc.getLongitude()
                + "&zoom=15&size=200x200&sensor=false";
        Glide.with(context).load(url).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return acteList.size();
    }

    public void addAll(Collection<Acte> actes) {
        acteList.addAll(actes);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
