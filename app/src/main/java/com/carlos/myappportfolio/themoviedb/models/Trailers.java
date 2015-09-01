package com.carlos.myappportfolio.themoviedb.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 28/08/2015.
 */
public class Trailers implements Parcelable {
    @SerializedName("youtube")
    private List<YoutubeEntity> youtubeTrailers;


    public List<YoutubeEntity> getYoutubeTrailers() {
        return youtubeTrailers;
    }

    public void setYoutubeTrailers(List<YoutubeEntity> youtubeTrailers) {
        this.youtubeTrailers = youtubeTrailers;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.youtubeTrailers);
    }

    public Trailers() {
    }

    protected Trailers(Parcel in) {
        this.youtubeTrailers = new ArrayList<YoutubeEntity>();
        in.readList(this.youtubeTrailers, List.class.getClassLoader());
    }

    public static final Parcelable.Creator<Trailers> CREATOR = new Parcelable.Creator<Trailers>() {
        public Trailers createFromParcel(Parcel source) {
            return new Trailers(source);
        }

        public Trailers[] newArray(int size) {
            return new Trailers[size];
        }
    };
    public static class YoutubeEntity implements Parcelable {

        private String source;
        private String name;
        private String type;
        private String size;

        public void setSource(String source) {
            this.source = source;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getSource() {
            return source;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getSize() {
            return size;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.source);
            dest.writeString(this.name);
            dest.writeString(this.type);
            dest.writeString(this.size);
        }

        public YoutubeEntity() {
        }

        protected YoutubeEntity(Parcel in) {
            this.source = in.readString();
            this.name = in.readString();
            this.type = in.readString();
            this.size = in.readString();
        }

        public static final Creator<YoutubeEntity> CREATOR = new Creator<YoutubeEntity>() {
            public YoutubeEntity createFromParcel(Parcel source) {
                return new YoutubeEntity(source);
            }

            public YoutubeEntity[] newArray(int size) {
                return new YoutubeEntity[size];
            }
        };
    }


}
