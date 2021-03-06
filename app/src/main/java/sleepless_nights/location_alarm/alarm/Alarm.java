package sleepless_nights.location_alarm.alarm;

import androidx.annotation.NonNull;

public class Alarm {
    private long id;
    private String name;
    private String address;
    private boolean isActive;
    private double latitude;
    private double longitude;
    private float radius;

    public Alarm(long id, String name, String address, boolean isActive,
                 double latitude, double longitude, float radius) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.isActive = isActive;
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }
  
    public Alarm(@NonNull Alarm alarm) {
        this.id = alarm.id;
        this.name = alarm.name;
        this.address = alarm.address;
        this.isActive = alarm.isActive;
        this.latitude = alarm.latitude;
        this.longitude = alarm.longitude;
        this.radius = alarm.radius;
    }

    public Alarm(long id, @NonNull Alarm alarm) {
        this.id = id;
        this.name = alarm.name;
        this.address = alarm.address;
        this.isActive = alarm.isActive;
        this.latitude = alarm.latitude;
        this.longitude = alarm.longitude;
        this.radius = alarm.radius;
    }

    public long getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }

    public String getAddress() {
        return address;
    }
    public Alarm setAddress(String address) {
        this.address = address;
        return this;
    }

    public void setIsActive(boolean isActive) { this.isActive = isActive; }
    public boolean getIsActive() { return this.isActive; }

    public void setLatitude(double latitude) { this.latitude = latitude; }
    public double getLatitude() { return latitude; }

    public void setLongitude(double longitude) { this.longitude = longitude; }
    public double getLongitude() { return longitude; }

    public void setRadius(float radius) { this.radius = radius; }
    public float getRadius() { return radius; }

    public boolean equals(Alarm alarm) {
        return id == alarm.id &&
                name.equals(alarm.name) &&
                address.equals(alarm.address) &&
                isActive == alarm.isActive &&
                latitude == alarm.latitude &&
                longitude == alarm.longitude &&
                radius == alarm.radius;
    }
}