package com.edgarlpassos.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
class GroupPhoto {
    public String highres_link;
    public String photo_link;
    public long photo_id;
    public String thumb_link;
}
