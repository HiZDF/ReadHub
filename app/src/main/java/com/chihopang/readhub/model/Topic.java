package com.chihopang.readhub.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.chihopang.readhub.util.TimeUtil;
import java.util.ArrayList;
import org.parceler.Parcel;

@Entity @Parcel public class Topic {
  @PrimaryKey @NonNull public String id;
  public String createdAt;
  public String updatedAt;
  public String publishDate;
  public String order;
  public String title;
  public String summary;

  @Ignore public ArrayList<News> newsArray;
  @Ignore public Extra extra;

  public Topic() {
  }

  @Ignore public String getTitle() {
    return TextUtils.isEmpty(title) ? null : title.trim();
  }

  @Ignore public String getSummary() {
    return TextUtils.isEmpty(summary) ? null : summary.trim();
  }

  @Ignore public String getPublishDateCountDown() {
    return TimeUtil.countDown(publishDate);
  }

  @Ignore public String getFormatPublishDate() {
    return TimeUtil.getFormatDate(publishDate);
  }

  @Ignore public boolean hasInstantView() {
    return extra != null && extra.instantView;
  }

  @Parcel public static class Extra {
    boolean instantView;
  }
}