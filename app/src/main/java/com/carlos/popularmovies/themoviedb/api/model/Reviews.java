package com.carlos.popularmovies.themoviedb.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 28/08/2015.
 */
public class Reviews implements Parcelable {
    @SerializedName("results")
    private List<ResultsEntity> listReviews;


    public void setListReviews(List<ResultsEntity> listReviews) {
        this.listReviews = listReviews;
    }


    public List<ResultsEntity> getListReviews() {
        return listReviews;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.listReviews);

    }

    public Reviews() {
    }

    protected Reviews(Parcel in) {
        this.listReviews = new ArrayList<ResultsEntity>();
        in.readList(this.listReviews, List.class.getClassLoader());

    }

    public static final Parcelable.Creator<Reviews> CREATOR = new Parcelable.Creator<Reviews>() {
        public Reviews createFromParcel(Parcel source) {

            return new Reviews(source);
        }

        public Reviews[] newArray(int size) {

            return new Reviews[size];
        }
    };

    public static class ResultsEntity implements Parcelable {

        private String content;
        private String id;
        private String author;
        private String url;

        public void setContent(String content) {
            this.content = content;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getContent() {
            return content;
        }

        public String getId() {
            return id;
        }

        public String getAuthor() {
            return author;
        }

        public String getUrl() {
            return url;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.content);
            dest.writeString(this.id);
            dest.writeString(this.author);
            dest.writeString(this.url);
        }

        public ResultsEntity() {
        }

        protected ResultsEntity(Parcel in) {
            this.content = in.readString();
            this.id = in.readString();
            this.author = in.readString();
            this.url = in.readString();
        }

        public static final Creator<ResultsEntity> CREATOR = new Creator<ResultsEntity>() {
            public ResultsEntity createFromParcel(Parcel source) {
                return new ResultsEntity(source);
            }

            public ResultsEntity[] newArray(int size) {
                return new ResultsEntity[size];
            }
        };
    }


}
