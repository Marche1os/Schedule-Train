package view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.marchelos.tutuparser.R;

import java.util.List;

import adapters.ScheduleAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import controller.ParserController;

/**
 * ParserActivity of schedule from TUTU.ru
 * <p>
 * created by Mark Kolpakov
 *
 * @version 1.0
 * @date 27.04.2019
 */
public class ParserActivity extends AppCompatActivity {
    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.activity_schedule_rv_schedule)
    RecyclerView rvSchedule;

    private ParserController mController;
    private ScheduleAdapter mScheduleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        ButterKnife.bind(this);

        mController = ParserController.getInstance();
        rvSchedule.setLayoutManager(new LinearLayoutManager(this));

    }

    @OnClick(R.id.activity_schedule_btn_to_job)
    void onRequestToJob() {
        mController.downloadSchedule(ParserActivity.this, "36705", "36105");

    }

    @OnClick(R.id.activity_schedule_btn_from_job)
    void onRequestFromJob() {
        mController.downloadSchedule(ParserActivity.this, "36105", "36705");
    }

    public void setTextView(List<String> dep, List<String> arr) {
        mScheduleAdapter = new ScheduleAdapter(dep, arr);
        rvSchedule.setAdapter(mScheduleAdapter);
        mScheduleAdapter.notifyDataSetChanged();
    }
}
