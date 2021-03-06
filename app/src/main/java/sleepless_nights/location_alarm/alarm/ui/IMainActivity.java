package sleepless_nights.location_alarm.alarm.ui;

import sleepless_nights.location_alarm.alarm.Alarm;

public interface IMainActivity {

    void showAlarmList();

    void showAllAlarms();

    void newAlarm();

    void showAlarm(Alarm alarm);

    void editAlarm(Alarm alarm);

}
