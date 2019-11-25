package sleepless_nights.location_alarm.alarm.view_models;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import sleepless_nights.location_alarm.alarm.Alarm;
import sleepless_nights.location_alarm.alarm.use_cases.AlarmDataSet;
import sleepless_nights.location_alarm.alarm.use_cases.AlarmRepository;

public class AlarmViewModel extends AndroidViewModel {
    private static final String TAG = "AlarmViewModel";
    private MediatorLiveData<AlarmDataSet> liveData = new MediatorLiveData<>();

    public AlarmViewModel(@NonNull Application application) {
        super(application);
        final LiveData<AlarmDataSet> repoLiveData = AlarmRepository.getInstance().getDataSetLiveData();
        liveData.setValue(repoLiveData.getValue());
        liveData.addSource(repoLiveData, alarmDataSet -> {
            Log.d(TAG, "dataSet updated from repository");
            liveData.postValue(alarmDataSet);
        });
    }

    @NonNull
    public LiveData<AlarmDataSet> getLiveData() { return liveData; }

    @Nullable
    public Alarm getAlarmByPosition(int pos) {
        return AlarmRepository.getInstance().getAlarmByPosition(pos);
    }

    @Nullable
    public Alarm getAlarmLiveDataById(int id) {
        return AlarmRepository.getInstance().getAlarmById(id);
    }

    public void createAlarm(String name, String address, boolean isActive,
                            double latitude, double longitude, float radius) {
        AlarmRepository.getInstance().createAlarm(name, address, isActive,
                latitude, longitude, radius);
    }

    public void deleteAlarm(int id) {
        AlarmRepository.getInstance().deleteAlarm(id);
    }

    public void updateAlarm(Alarm alarm) {
        AlarmRepository.getInstance().updateAlarm(alarm);
    }
}