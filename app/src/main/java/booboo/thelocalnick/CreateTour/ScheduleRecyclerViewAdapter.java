package booboo.thelocalnick.CreateTour;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import booboo.thelocalnick.R;
import booboo.thelocalnick.data.Schedule;
import booboo.thelocalnick.data.Spot;

class ScheduleRecyclerViewAdapter extends RecyclerView.Adapter<ScheduleViewHolder> {
    private List<Schedule> schedules;

    public ScheduleRecyclerViewAdapter(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View container = inflater.inflate(R.layout.schedule_card_view, parent, false);

        return new ScheduleViewHolder(container);
    }

    @Override
    public void onBindViewHolder(ScheduleViewHolder holder, int position) {
        Schedule scheduleItem = schedules.get(position);
        holder.bind(scheduleItem);
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }
}
