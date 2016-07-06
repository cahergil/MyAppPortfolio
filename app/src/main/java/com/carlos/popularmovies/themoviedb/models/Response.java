package com.carlos.popularmovies.themoviedb.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Carlos on 19/08/2015.
 */
public class Response {



    private List<Movie> results;
    private int page;
    private int total_pages;
    private int total_results;

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public List<Movie> getResults() {
        return results;
    }

    public int getPage() {
        return page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }



    public static class Movie implements Parcelable{

        private double vote_average;
        private String backdrop_path;
        private boolean adult;
        private int id;
        private String title;
        private String original_language;
        private String overview;

        private String original_title;
        private String release_date;
        private int vote_count;
        private String poster_path;
        private boolean video;
        private double popularity;

        public Movie(double vote_average, String backdrop_path, boolean adult, int id, String title, String original_language, String overview, String original_title, String release_date, int vote_count, String poster_path, boolean video, double popularity) {
            this.vote_average = vote_average;
            this.backdrop_path = backdrop_path;
            this.adult = adult;
            this.id = id;
            this.title = title;
            this.original_language = original_language;
            this.overview = overview;
            this.original_title = original_title;
            this.release_date = release_date;
            this.vote_count = vote_count;
            this.poster_path = poster_path;
            this.video = video;
            this.popularity = popularity;
        }
        private Movie(Parcel in){

            this.vote_average =in.readDouble();
            this.backdrop_path = in.readString();
            this.adult = in.readByte()!=0; //adult=true if byte!=0
            this.id = in.readInt();
            this.title = in.readString();
            this.original_language = in.readString();
            this.overview = in.readString();
            this.original_title = in.readString();
            this.release_date = in.readString();
            this.vote_count = in.readInt();
            this.poster_path = in.readString();
            this.video = in.readByte()!=0;
            this.popularity = in.readDouble();

        }
        public Movie(){

        }
        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeDouble(vote_average);
            dest.writeString(backdrop_path);
            dest.writeByte((byte) (adult ? 1 : 0));
            dest.writeInt(id);
            dest.writeString(title);
            dest.writeString(original_language);
            dest.writeString(overview);
            dest.writeString(original_title);
            dest.writeString(release_date);
            dest.writeInt(vote_count);
            dest.writeString(poster_path);
            dest.writeByte((byte) (video ? 1 : 0));
            dest.writeDouble(popularity);
        }
        public final Parcelable.Creator<Movie> CREATOR= new Creator<Movie>() {
            @Override
            public Movie createFromParcel(Parcel source) {
               return new Movie(source);
            }

            @Override
            public Movie[] newArray(int size) {
                return new Movie[size];
            }
        };

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }



        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public double getVote_average() {
            return vote_average;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public boolean isAdult() {
            return adult;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public String getOverview() {
            return overview;
        }



        public String getOriginal_title() {
            return original_title;
        }

        public String getRelease_date() {
            return release_date;
        }

        public int getVote_count() {
            return vote_count;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public boolean isVideo() {
            return video;
        }

        public double getPopularity() {
            return popularity;
        }


    }
}
