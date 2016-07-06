package com.carlos.popularmovies.themoviedb.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Carlos on 23/08/2015.
 */
public class MovieDetail implements Parcelable {

    private int id;
    private String title;
    private String original_title;
    private int runtime;
    private String release_date;
    private String poster_path;
    private String backdrop_path;
    private double vote_average;
    private int vote_count;
    private String overview;
    @SerializedName("trailers")
    private Trailers trailers;
    @SerializedName("reviews")
    private Reviews reviews;
    @SerializedName("images")
    private MovieImages images;



    public MovieDetail(){

    }
    private MovieDetail(Parcel in){

        this.id=in.readInt();
        this.title=in.readString();
        this.original_title=in.readString();
        this.runtime=in.readInt();
        this.release_date=in.readString();
        this.poster_path=in.readString();
        this.backdrop_path=in.readString();
        this.vote_average=in.readDouble();
        this.vote_count=in.readInt();
        this.overview=in.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(original_title);
        dest.writeInt(runtime);
        dest.writeString(release_date);
        dest.writeString(poster_path);
        dest.writeString(backdrop_path);
        dest.writeDouble(vote_average);
        dest.writeInt(vote_count);
        dest.writeString(overview);
    }
    //make transietn to avoid error instance creator with gson
    public final transient Parcelable.Creator<MovieDetail> CREATOR=new Creator<MovieDetail>() {
        @Override
        public MovieDetail createFromParcel(Parcel source) {
            return new MovieDetail(source);
        }

        @Override
        public MovieDetail[] newArray(int size) {
            return new MovieDetail[size];
        }
    };
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Trailers getTrailers() {
        return trailers;
    }
    public Reviews getReviews() {
        return reviews;
    }
    public MovieImages getImages(){return images;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieDetail that = (MovieDetail) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
