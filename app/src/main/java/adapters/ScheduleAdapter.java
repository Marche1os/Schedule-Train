package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.marchelos.tutuparser.R;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.TimeHolder> {

    private List<String> listDeparture;
    private List<String> listArrival;

    public ScheduleAdapter(List<String> listDeparture, List<String> listArrival) {
        this.listDeparture = listDeparture;
        this.listArrival = listArrival;
    }

    @NonNull
    @Override
    public TimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_schedule, parent, false);
        return new TimeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeHolder holder, int position) {
        if (position < 79) {
            holder.tvArrivalTime.setText(listArrival.get(position));
            holder.tvDepartureTime.setText(listDeparture.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return listDeparture.size() > listArrival.size() ? listDeparture.size() : listArrival.size();
    }

    class TimeHolder extends RecyclerView.ViewHolder {
        TextView tvDepartureTime, tvArrivalTime;

        TimeHolder(@NonNull View view) {
            super(view);
            tvArrivalTime = view.findViewById(R.id.vh_schedule_tv_arrival_time);
            tvDepartureTime = view.findViewById(R.id.vh_schedule_tv_departure_time);
        }
    }
}
