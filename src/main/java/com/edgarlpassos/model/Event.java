package com.edgarlpassos.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.annotation.Nullable;

@JsonSerialize
public class Event {
    public Venue venue;
    public Group group;
    public Category category;
    public int utc_offset;
    public int rsvp_limit;
    public String venue_visibility;
    public String visibility;
    public int maybe_rsvp_count;
    public String description;
    public long mtime;
    public String event_url;
    public int yes_rsvp_count;
    public int payment_required;
    public String name;
    public long time;
    public long duration;
    public String id;
    public String status;
    public Object fee;
}

