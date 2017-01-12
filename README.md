# Popular Movies

The purpose of this project was to built an app, optimized for tablets, to help users discover popular and highly rated movies on the web. It displays a scrolling grid of movie trailers, launches a details screen whenever a particular movie is selected, allows users to save favorites, play trailers, and read user reviews. This app utilizes core Android user interface components and fetches movie information using themoviedb.org web API.

 ![grid](https://raw.githubusercontent.com/cahergil/shareablefotos/master/pm/phone_grid1.png) 
 ![details](https://raw.githubusercontent.com/cahergil/shareablefotos/master/pm/phone_details1.png) 

 ![tablet](https://raw.githubusercontent.com/cahergil/shareablefotos/master/pm/tablet.png) 

### Features

This app is the first and second project in Udacity's Android Developer Nanodegree. To develop this app I used the MVP pattern. [This](http://antonioleiva.com/mvp-android/) blog entry explains briefly what is MVP and why you should use it in your developments. 
The following is the requirements list of this app in the Android Developer Nanodegree.

1. **Popular Movies Stage 1 requirements:**
  1. Present the user with a grid arrangement of movie posters upon launch.
  2. Allow your user to change sort order via a setting:
  3. The sort order can be by most popular or by highest-rated
  4. Allow the user to tap on a movie poster and transition to a details screen with additional information such as:
    * *original title.*
    * *movie poster image thumbnail.*
    * *a plot synopsis.* 
    * *user rating.* 
    * *release date.*
2. **Popular Movies Stage 2 requirements:**	
  1. Allow users to view and play trailers ( either in the youtube app or a web browser).
  2. Allow users to read reviews of a selected movie.
  3. Allow users to mark a movie as a favorite in the details view by tapping a button(star). This is for a local    movies collection that you will maintain and does not require an API request*.
  4. Modify the existing sorting criteria for the main view to include an additional pivot to show their favorites collection.				



### Libraries

- [Android Support Library]()
- [Picasso](http://square.github.io/picasso/)
- [CircleImageView] (https://github.com/hdodenhof/CircleImageView)
- [Retrofit 2.0] (http://square.github.io/retrofit/)
- [Butterknife] (http://jakewharton.github.io/butterknife/)

### Movies Api

[themoviedb](https://www.themoviedb.org/)

### License

MIT License

Copyright (c) 2016 Carlos Hernández Gil

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


## Android Developer Nanodegree
[![udacity][1]][2]

[1]: https://raw.githubusercontent.com/cahergil/shareablefotos/master/pm/nanodegree-logo.png
[2]: https://www.udacity.com/course/android-developer-nanodegree--nd801
