package booboo.thelocalnick.CreateTour;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import booboo.thelocalnick.data.Schedule;
import booboo.thelocalnick.databinding.ScheduleCardViewBinding;

public class ScheduleViewHolder extends RecyclerView.ViewHolder {
    private ScheduleCardViewBinding scheduleCardViewBinding;

    public ScheduleViewHolder(View itemView) {
        super(itemView);
        scheduleCardViewBinding = DataBindingUtil.bind(itemView);
    }

    public void bind(Schedule schedule) {
        scheduleCardViewBinding.setSchedule(schedule);
    }
}