package com.carlos.popularmovies.themoviedb.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 29/06/2016.
 */
public class MovieImages implements Parcelable {

    /**
     * id : 76341
     * backdrops : [{"aspect_ratio":1.77777777777778,"file_path":"/tbhdm8UJAb4ViCTsulYFL3lxMCd.jpg","height":1080,"iso_639_1":null,"vote_average":5.856524427953,"vote_count":14,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/phszHPFVhPHhMZgo0fWTKBDQsJA.jpg","height":1080,"iso_639_1":null,"vote_average":5.67765567765568,"vote_count":15,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/jxPeRkfOoWs6gFybOa8C4xrHLrm.jpg","height":1080,"iso_639_1":null,"vote_average":5.45739348370927,"vote_count":13,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/1esSytxJBQ9KxIpuU2W1oFFwXHZ.jpg","height":2160,"iso_639_1":null,"vote_average":5.43823326432022,"vote_count":6,"width":3840},{"aspect_ratio":1.77777777777778,"file_path":"/w1jeDCyVB3ABo1jb9LfB2DNoO2q.jpg","height":1080,"iso_639_1":null,"vote_average":5.41184041184041,"vote_count":11,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/837yyS9Xkb1NlnbWsbKYrPtWvxt.jpg","height":1080,"iso_639_1":"xx","vote_average":5.40769732550554,"vote_count":10,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/1MYxDtcPunrLtEOyUATk0DIVnwb.jpg","height":1080,"iso_639_1":null,"vote_average":5.38610038610039,"vote_count":11,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/jHy2KU7mXLjoPT7ubSYhgXRtMwF.jpg","height":1080,"iso_639_1":null,"vote_average":5.38239538239538,"vote_count":3,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/dv2dwdaPcESIlMTn7b5PQObHNBd.jpg","height":720,"iso_639_1":null,"vote_average":5.38239538239538,"vote_count":3,"width":1280},{"aspect_ratio":1.77777777777778,"file_path":"/fhhASrzDak8r9jXELkJgnAnBLSv.jpg","height":1080,"iso_639_1":null,"vote_average":5.32600732600733,"vote_count":2,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/7lnfCwUCSBbcWP4vQYuE3n056Dy.jpg","height":1080,"iso_639_1":null,"vote_average":5.30206112295665,"vote_count":4,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/jSwr5tIM5zsTbwhdorTpEglmOHP.jpg","height":2160,"iso_639_1":null,"vote_average":5.30206112295665,"vote_count":4,"width":3840},{"aspect_ratio":1.77777777777778,"file_path":"/tuwKKh0MnK8xXht0XkpUDFz88ky.jpg","height":1080,"iso_639_1":null,"vote_average":5.2967032967033,"vote_count":2,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/zR9Wmx5Pg1jO7qgNxIiJkaugn6x.jpg","height":1080,"iso_639_1":null,"vote_average":5.27363184079602,"vote_count":4,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/l7WFajNTCttVNLpupcPu38NPDJq.jpg","height":1080,"iso_639_1":null,"vote_average":5.26610644257703,"vote_count":5,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/Ox8mUuDARf2MoTtuAswLcA9QxH.jpg","height":2160,"iso_639_1":null,"vote_average":5.25974025974026,"vote_count":3,"width":3840},{"aspect_ratio":1.77777777777778,"file_path":"/hnC4PB4xSLsztwhVLGb0Eoufu8p.jpg","height":2160,"iso_639_1":null,"vote_average":5.25210084033613,"vote_count":5,"width":3840},{"aspect_ratio":1.77777777777778,"file_path":"/9YmbTTQUVozGBB8MDNsALjx1Hmg.jpg","height":1080,"iso_639_1":null,"vote_average":5.24553571428571,"vote_count":1,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/e2adnEHiaj0NVV19JvPA21DzUpK.jpg","height":720,"iso_639_1":null,"vote_average":5.24553571428571,"vote_count":1,"width":1280},{"aspect_ratio":1.77777777777778,"file_path":"/nfr0orNygMdnjlnCS3acWOFKAvx.jpg","height":1080,"iso_639_1":null,"vote_average":5.23809523809524,"vote_count":1,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/dqsFZiVG5cQFGa1H5Vz5R3HX7do.jpg","height":1080,"iso_639_1":null,"vote_average":5.23809523809524,"vote_count":1,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/buXI5OHWj6DkyfcbsOOUOyiwDlQ.jpg","height":720,"iso_639_1":null,"vote_average":5.23809523809524,"vote_count":1,"width":1280},{"aspect_ratio":1.77777777777778,"file_path":"/53Mdr2uV83r8suuvnLC79WnfIJ0.jpg","height":1080,"iso_639_1":null,"vote_average":5.2311939268461,"vote_count":6,"width":1920},{"aspect_ratio":1.77767265846736,"file_path":"/kt2ajM1EimaXUGcp99ZQtgIZIeK.jpg","height":1057,"iso_639_1":null,"vote_average":5.22321428571429,"vote_count":1,"width":1879},{"aspect_ratio":1.77690029615005,"file_path":"/cqRofYiJ9xG1E6SsjT3iMnQBTZ7.jpg","height":1013,"iso_639_1":null,"vote_average":5.22321428571429,"vote_count":1,"width":1800},{"aspect_ratio":1.77777777777778,"file_path":"/6EYa2oOJixBKfvwrGxSvF1ZlNwz.jpg","height":1080,"iso_639_1":null,"vote_average":5.21577380952381,"vote_count":1,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/8SiIFFRGLGAVQ7gRmPAEbChMNch.jpg","height":1080,"iso_639_1":null,"vote_average":5.20833333333333,"vote_count":1,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/lhCacl4B8J17OBqGI0ajVfgO0Ao.jpg","height":720,"iso_639_1":null,"vote_average":5.19668737060041,"vote_count":6,"width":1280},{"aspect_ratio":1.77777777777778,"file_path":"/gmKsYVRAaMPXr9vTkmab6dsnt08.jpg","height":1080,"iso_639_1":null,"vote_average":5.18681318681319,"vote_count":2,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/shPcdB4tTx4pYAOrIifIAu8xFyr.jpg","height":720,"iso_639_1":null,"vote_average":5.18681318681319,"vote_count":2,"width":1280},{"aspect_ratio":1.77777777777778,"file_path":"/2rtMPSvIxcBB2d8Cw797nV4Rnp.jpg","height":1080,"iso_639_1":"en","vote_average":5.18681318681319,"vote_count":2,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/fsPKo75jz5Rv6rOylArKHo6KjZS.jpg","height":1440,"iso_639_1":null,"vote_average":5.17948717948718,"vote_count":2,"width":2560},{"aspect_ratio":1.77777777777778,"file_path":"/bgLUWwfZ3dEeZkYEHDq9DEgNksP.jpg","height":1080,"iso_639_1":"en","vote_average":5.16594516594517,"vote_count":3,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/gVdwQInU5rdcnaCERK2Z7yfpnbD.jpg","height":1080,"iso_639_1":null,"vote_average":5.16218081435473,"vote_count":6,"width":1920},{"aspect_ratio":1.77777777777778,"file_path":"/oD84uqd4Q7AT2RTiX3RQ7TcCqie.jpg","height":720,"iso_639_1":null,"vote_average":5.15018315018315,"vote_count":2,"width":1280},{"aspect_ratio":1.77777777777778,"file_path":"/2Sb7UNrv7G3rNZU0xWMkB6HhUS1.jpg","height":1080,"iso_639_1":"xx","vote_average":5.10622710622711,"vote_count":2,"width":1920}]
     * posters : [{"aspect_ratio":0.666666666666667,"file_path":"/dywDjqAJoWudjgtHHIndmY9xvj9.jpg","height":3000,"iso_639_1":"en","vote_average":6.29680998613038,"vote_count":40,"width":2000},{"aspect_ratio":0.666666666666667,"file_path":"/sARK4uNacjUY4ACu0QjQPG0OUmW.jpg","height":1500,"iso_639_1":"en","vote_average":5.5663430420712,"vote_count":40,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/2N9FKLaAfBJ7H1lm69K8Vjf8xyg.jpg","height":1500,"iso_639_1":"en","vote_average":5.5534941249227,"vote_count":14,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/chMOGs0qNQyIeJnz7ZN9MJOA18T.jpg","height":2100,"iso_639_1":"pt","vote_average":5.49395877754087,"vote_count":4,"width":1400},{"aspect_ratio":0.666666666666667,"file_path":"/wp7OHP9r6ajhnnVCrVDW46hMSpa.jpg","height":3000,"iso_639_1":"fr","vote_average":5.46258503401361,"vote_count":7,"width":2000},{"aspect_ratio":0.68081821690467,"file_path":"/tLWz8zVKgc4IpdOlm8Ra9N36Lco.jpg","height":2591,"iso_639_1":"pt","vote_average":5.44973544973545,"vote_count":9,"width":1764},{"aspect_ratio":0.7375,"file_path":"/6jkviwPHZPHGHRu6QhECU2mbO05.jpg","height":1600,"iso_639_1":"fr","vote_average":5.38992408557626,"vote_count":6,"width":1180},{"aspect_ratio":0.666666666666667,"file_path":"/i68IvNkUvqaKPY0UbadXcQ23aik.jpg","height":3000,"iso_639_1":"de","vote_average":5.38461538461539,"vote_count":2,"width":2000},{"aspect_ratio":0.67476383265857,"file_path":"/jhXEo2H6v2wZz8PygYtCwCvZQ73.jpg","height":2964,"iso_639_1":"it","vote_average":5.37728937728938,"vote_count":2,"width":2000},{"aspect_ratio":0.647058823529412,"file_path":"/eLnvZlxc7DvVUW3fsV9fCJH2QLm.jpg","height":1224,"iso_639_1":"en","vote_average":5.37114845938375,"vote_count":5,"width":792},{"aspect_ratio":0.666666666666667,"file_path":"/oQoIl0j4Lk6NFvOA0u7UREF8Sxm.jpg","height":1500,"iso_639_1":"en","vote_average":5.35714285714286,"vote_count":45,"width":1000},{"aspect_ratio":0.647875816993464,"file_path":"/q6HQNKj3mvZunuSwZci5Nd21Dbm.jpg","height":1224,"iso_639_1":"en","vote_average":5.35211267605634,"vote_count":8,"width":793},{"aspect_ratio":0.666936790923825,"file_path":"/lXG8LzFMy7woT5N2nKRo2z9mexK.jpg","height":1234,"iso_639_1":"en","vote_average":5.33910533910534,"vote_count":3,"width":823},{"aspect_ratio":0.666666666666667,"file_path":"/fHujUkalsHD6sLg9rYrNmAc0uSw.jpg","height":1500,"iso_639_1":"hu","vote_average":5.33333333333333,"vote_count":2,"width":1000},{"aspect_ratio":0.69921875,"file_path":"/jRhTFJ7RT46OzIN95LGrBr6gx2L.jpg","height":1024,"iso_639_1":"zh","vote_average":5.3125,"vote_count":1,"width":716},{"aspect_ratio":0.666666666666667,"file_path":"/A7p3eYkvpHBYGpDNBim0CNUB56F.jpg","height":3000,"iso_639_1":"en","vote_average":5.3125,"vote_count":1,"width":2000},{"aspect_ratio":0.666666666666667,"file_path":"/qOfwj5JeMFxJkSbyYbpOtjpAGSJ.jpg","height":1500,"iso_639_1":"fr","vote_average":5.3125,"vote_count":1,"width":1000},{"aspect_ratio":0.674915635545557,"file_path":"/oMnFhxdXCstEDg5kAY8wHLYGSiM.jpg","height":1778,"iso_639_1":"pt","vote_average":5.3125,"vote_count":1,"width":1200},{"aspect_ratio":0.674915635545557,"file_path":"/hKDXtVZjKICe72D1ie6lmiPVvyx.jpg","height":1778,"iso_639_1":"pt","vote_average":5.3125,"vote_count":1,"width":1200},{"aspect_ratio":0.690131124913734,"file_path":"/l3fiePYSJmz5LBk8GTuGvC8X7ve.jpg","height":1449,"iso_639_1":"el","vote_average":5.3125,"vote_count":1,"width":1000},{"aspect_ratio":0.70704845814978,"file_path":"/3NoqAxsBHXKRsztoQMaAAr3b4wU.jpg","height":1816,"iso_639_1":"ro","vote_average":5.3125,"vote_count":1,"width":1284},{"aspect_ratio":0.700437317784257,"file_path":"/65KuGeszIiHC6hDZUDHmlTuxMwX.jpg","height":1372,"iso_639_1":"ko","vote_average":5.3125,"vote_count":1,"width":961},{"aspect_ratio":0.701262272089762,"file_path":"/xsCBOxnD8wLWb1If1aO01sgnHym.jpg","height":1426,"iso_639_1":"pt","vote_average":5.3125,"vote_count":1,"width":1000},{"aspect_ratio":0.67476383265857,"file_path":"/gIJijdbJbWbk7vYAOAFX9fjwZks.jpg","height":2964,"iso_639_1":"it","vote_average":5.3125,"vote_count":1,"width":2000},{"aspect_ratio":0.741875,"file_path":"/mz5WKU9E5cK62p1EOgAfu6oQc9p.jpg","height":1600,"iso_639_1":"fr","vote_average":5.31135531135531,"vote_count":2,"width":1187},{"aspect_ratio":0.666666666666667,"file_path":"/2V3MhnJNqNRxfsqL5glhmASGG3B.jpg","height":1500,"iso_639_1":"en","vote_average":5.30710835058661,"vote_count":6,"width":1000},{"aspect_ratio":0.67476383265857,"file_path":"/hjdedOO5UOYzuG5iYXUQQs1Dssy.jpg","height":2964,"iso_639_1":"it","vote_average":5.30505952380952,"vote_count":1,"width":2000},{"aspect_ratio":0.647875816993464,"file_path":"/ehgLCBNKNonYc5oawscFRA2LK0V.jpg","height":1224,"iso_639_1":"en","vote_average":5.30020703933747,"vote_count":6,"width":793},{"aspect_ratio":0.666666666666667,"file_path":"/dwJOo4m3lvUQ1Ps4iVfGcBlQKuk.jpg","height":3000,"iso_639_1":"en","vote_average":5.30020703933747,"vote_count":6,"width":2000},{"aspect_ratio":0.674915635545557,"file_path":"/rjfGxkpRPtw5HD0lYta4ehs23hT.jpg","height":1778,"iso_639_1":"pt","vote_average":5.29761904761905,"vote_count":1,"width":1200},{"aspect_ratio":0.674915635545557,"file_path":"/yFqD8nJ70VapWF3vLtunypitbPo.jpg","height":1778,"iso_639_1":"pt","vote_average":5.29761904761905,"vote_count":1,"width":1200},{"aspect_ratio":0.666666666666667,"file_path":"/kqjL17yufvn9OVLyXYpvtyrFfak.jpg","height":2100,"iso_639_1":"en","vote_average":5.28822055137845,"vote_count":51,"width":1400},{"aspect_ratio":0.693000693000693,"file_path":"/43Gu8C9DBDOUkc8ybyUdPaVHVAd.jpg","height":1443,"iso_639_1":"hu","vote_average":5.28273809523809,"vote_count":1,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/vgmPJiLLt6q126Yw4kAH1VCjJRk.jpg","height":1500,"iso_639_1":"en","vote_average":5.28011204481793,"vote_count":5,"width":1000},{"aspect_ratio":0.674536256323777,"file_path":"/p8Mm0uWdBegz508CJYNzKil8tBy.jpg","height":1186,"iso_639_1":"en","vote_average":5.27472527472527,"vote_count":2,"width":800},{"aspect_ratio":0.666666666666667,"file_path":"/2gFfUfTVSkT8F1Cmhs4dqpptcRK.jpg","height":1323,"iso_639_1":"en","vote_average":5.27472527472527,"vote_count":2,"width":882},{"aspect_ratio":0.706666666666667,"file_path":"/uKMa97rluGaRXM3MnrnM7yNcyE9.jpg","height":2175,"iso_639_1":"da","vote_average":5.26785714285714,"vote_count":1,"width":1537},{"aspect_ratio":0.666666666666667,"file_path":"/hOSENuL0p4Loz0WNzGpsFp8Xtgg.jpg","height":1500,"iso_639_1":"cs","vote_average":5.26785714285714,"vote_count":1,"width":1000},{"aspect_ratio":0.698074974670719,"file_path":"/xJBg8qlo7sDyKNeVhNwR0kLc6mK.jpg","height":987,"iso_639_1":"el","vote_average":5.26785714285714,"vote_count":1,"width":689},{"aspect_ratio":0.666666666666667,"file_path":"/k6UvxBUAN6Jyxd4YKZZOgn7sP7X.jpg","height":2100,"iso_639_1":"en","vote_average":5.26739926739927,"vote_count":2,"width":1400},{"aspect_ratio":0.7502679528403,"file_path":"/5bUDa0p91dlYXph25NOXNqQyR4G.jpg","height":933,"iso_639_1":"en","vote_average":5.26652452025586,"vote_count":4,"width":700},{"aspect_ratio":0.666666666666667,"file_path":"/nunV04bV4zmE1yvavYte1DUn6TS.jpg","height":2100,"iso_639_1":"en","vote_average":5.26652452025586,"vote_count":4,"width":1400},{"aspect_ratio":0.714285714285714,"file_path":"/A355KzAI6zX2PtZdKIXiYRLT8t4.jpg","height":980,"iso_639_1":"en","vote_average":5.26610644257703,"vote_count":5,"width":700},{"aspect_ratio":0.666666666666667,"file_path":"/99U7GeMuVX1FTQ6nmZ1toJkAaRP.jpg","height":2100,"iso_639_1":"en","vote_average":5.26610644257703,"vote_count":5,"width":1400},{"aspect_ratio":0.666666666666667,"file_path":"/lwsyCooO8S7vTmIgHbhwsWKiEbi.jpg","height":1500,"iso_639_1":"en","vote_average":5.26007326007326,"vote_count":2,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/1GkTj3ayIaX3boMHleYSW2QZF06.jpg","height":3000,"iso_639_1":"en","vote_average":5.25879917184265,"vote_count":6,"width":2000},{"aspect_ratio":0.708138447146866,"file_path":"/8h8qm9GG8lOq1QRDeT1f5ej1RDO.jpg","height":1069,"iso_639_1":"pt","vote_average":5.25297619047619,"vote_count":1,"width":757},{"aspect_ratio":0.719144800777454,"file_path":"/m2UZRgUpVxjqfLbR0comXZRZy5M.jpg","height":1029,"iso_639_1":"pt","vote_average":5.25297619047619,"vote_count":1,"width":740},{"aspect_ratio":0.687285223367698,"file_path":"/ltePOsl69bJv9MNGYOTLOyZU8YU.jpg","height":873,"iso_639_1":"it","vote_average":5.24542124542125,"vote_count":2,"width":600},{"aspect_ratio":0.666666666666667,"file_path":"/2xG5fyaOomVDGNP66ToI7bnIYAB.jpg","height":1800,"iso_639_1":"en","vote_average":5.23809523809524,"vote_count":3,"width":1200},{"aspect_ratio":0.666666666666667,"file_path":"/z5UXjrZ9H4PHnabk4OVfotpLa74.jpg","height":1500,"iso_639_1":"en","vote_average":5.23109243697479,"vote_count":5,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/zrTRhi6EuafAKsIDltSX047t7q5.jpg","height":3000,"iso_639_1":"en","vote_average":5.23109243697479,"vote_count":5,"width":2000},{"aspect_ratio":0.666666666666667,"file_path":"/jGcYYgSTcvbTWFz7UTaO01H4yjS.jpg","height":3000,"iso_639_1":"en","vote_average":5.23109243697479,"vote_count":5,"width":2000},{"aspect_ratio":0.666666666666667,"file_path":"/73JSPlhWwCD2WbIrzpJdj9DJLJw.jpg","height":3000,"iso_639_1":"en","vote_average":5.22468142186452,"vote_count":8,"width":2000},{"aspect_ratio":0.647875816993464,"file_path":"/mxkSiEN6lSEyJnCgsVCwACJhgOS.jpg","height":1224,"iso_639_1":"en","vote_average":5.21008403361345,"vote_count":5,"width":793},{"aspect_ratio":0.647875816993464,"file_path":"/bgA3hkgSGuv2fwj11PiOETC2gIe.jpg","height":1224,"iso_639_1":"en","vote_average":5.19607843137255,"vote_count":5,"width":793},{"aspect_ratio":0.647875816993464,"file_path":"/jW3ozNJXG7950NoFNvv5TUsk2eT.jpg","height":1224,"iso_639_1":"en","vote_average":5.19607843137255,"vote_count":5,"width":793},{"aspect_ratio":0.666666666666667,"file_path":"/T3RPc95zr6wV2qAR1THanE3Chp.jpg","height":1500,"iso_639_1":"en","vote_average":5.1890756302521,"vote_count":5,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/jYsYJqjfqRl9hZbOlkbWeLoqQAE.jpg","height":1500,"iso_639_1":"fr","vote_average":5.18601190476191,"vote_count":1,"width":1000},{"aspect_ratio":0.647875816993464,"file_path":"/8Gj0Pr7UqTLvw4mr5IqT5ofz7G5.jpg","height":1224,"iso_639_1":"en","vote_average":5.18288474810214,"vote_count":6,"width":793},{"aspect_ratio":0.701262272089762,"file_path":"/ulgTYlYqRcP3sARWUVP2DCQqk2Y.jpg","height":1426,"iso_639_1":"en","vote_average":5.18123667377399,"vote_count":4,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/fYCQpEgNQidE3SPm0XFebxLrIJ2.jpg","height":1500,"iso_639_1":"de","vote_average":5.18037518037518,"vote_count":3,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/4lsLQELoLecPtw54nh9fquTp7kX.jpg","height":1500,"iso_639_1":"hu","vote_average":5.17113095238095,"vote_count":1,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/vI41NgP4PgecyO8e6FfhX8Guffp.jpg","height":3000,"iso_639_1":"en","vote_average":5.16806722689076,"vote_count":5,"width":2000},{"aspect_ratio":0.666666666666667,"file_path":"/7XJI3PaM2eZo7EzFsZgbxgky7AW.jpg","height":3000,"iso_639_1":"en","vote_average":5.16806722689076,"vote_count":5,"width":2000},{"aspect_ratio":0.666666666666667,"file_path":"/1uHppSIi7MPJpO3K4ahDxQL7aIq.jpg","height":1500,"iso_639_1":"en","vote_average":5.16218081435473,"vote_count":6,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/ard6RONIYbCgmuWnIwAl3VZhpQZ.jpg","height":3000,"iso_639_1":"en","vote_average":5.16218081435473,"vote_count":6,"width":2000},{"aspect_ratio":0.666666666666667,"file_path":"/vbAi7D4XC331kgU2YYCYQ6fr5Ff.jpg","height":2100,"iso_639_1":"en","vote_average":5.16218081435473,"vote_count":6,"width":1400},{"aspect_ratio":0.666666666666667,"file_path":"/it0eVPVkYs0ycwryQCppGdRMGip.jpg","height":1500,"iso_639_1":"en","vote_average":5.16218081435473,"vote_count":6,"width":1000},{"aspect_ratio":0.6669921875,"file_path":"/28ikuBa8QIaqBsJEg8cDI5sipv1.jpg","height":2048,"iso_639_1":"en","vote_average":5.15329419439008,"vote_count":10,"width":1366},{"aspect_ratio":0.75,"file_path":"/rO5xWm8m0w63DZhEJTutbZH25Yr.jpg","height":1000,"iso_639_1":"en","vote_average":5.14705882352941,"vote_count":5,"width":750},{"aspect_ratio":0.674666666666667,"file_path":"/1MnVcWKubiN4Xb9M7J5NG9KB63m.jpg","height":1500,"iso_639_1":"en","vote_average":5.13148542999289,"vote_count":4,"width":1012},{"aspect_ratio":0.666666666666667,"file_path":"/btBxj2KCr6azIKKsjnpBH9RDDzl.jpg","height":2100,"iso_639_1":"en","vote_average":5.11904761904762,"vote_count":9,"width":1400},{"aspect_ratio":0.666666666666667,"file_path":"/vnTYl66GMZ07PsdAjLyNkPGeqoq.jpg","height":3000,"iso_639_1":"de","vote_average":5.11727078891258,"vote_count":4,"width":2000},{"aspect_ratio":0.647668393782383,"file_path":"/iaTathi2agQoEQwk2vsJfgBsfkc.jpg","height":1158,"iso_639_1":"en","vote_average":5.09920634920635,"vote_count":9,"width":750},{"aspect_ratio":0.68701171875,"file_path":"/8zyOl6ez7DXOWBm0QnigY4Haw9C.jpg","height":2048,"iso_639_1":"en","vote_average":5.04385964912281,"vote_count":13,"width":1407},{"aspect_ratio":0.666666666666667,"file_path":"/yiRSA9OKizlX1fRqqZfSrTZxoQq.jpg","height":2100,"iso_639_1":"en","vote_average":4.98964803312629,"vote_count":6,"width":1400},{"aspect_ratio":0.676142131979695,"file_path":"/tk49i3B95tPsWtlIHESgU0FhIGG.jpg","height":985,"iso_639_1":"en","vote_average":4.8015873015873,"vote_count":9,"width":666},{"aspect_ratio":0.666666666666667,"file_path":"/wDo6f58WygrnQ7BmidUJDz7ygTZ.jpg","height":1500,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/wyxABQxL7CpTlWfK6vCAHiY2yEp.jpg","height":1500,"iso_639_1":"en","vote_average":0,"vote_count":0,"width":1000},{"aspect_ratio":0.706703910614525,"file_path":"/5OeWfelmN0zSxvvruvGK3K6JLD4.jpg","height":1074,"iso_639_1":"es","vote_average":0,"vote_count":0,"width":759},{"aspect_ratio":0.686641697877653,"file_path":"/9kZ9SfBEICeD7KpxYKlKpzF9XQu.jpg","height":801,"iso_639_1":"uk","vote_average":0,"vote_count":0,"width":550},{"aspect_ratio":0.674846625766871,"file_path":"/itXZJad58ObMTc4MzJinw7sXY2U.jpg","height":815,"iso_639_1":"uk","vote_average":0,"vote_count":0,"width":550},{"aspect_ratio":0.666666666666667,"file_path":"/3K72cf2PxR3yh1LqRxsxoPIGgu6.jpg","height":1500,"iso_639_1":"cs","vote_average":0,"vote_count":0,"width":1000},{"aspect_ratio":0.675675675675676,"file_path":"/nbhxOIgHdGfaixgGo6I97zIlW3c.jpg","height":1480,"iso_639_1":"te","vote_average":0,"vote_count":0,"width":1000},{"aspect_ratio":0.666666666666667,"file_path":"/7BnPPONUta4ttTlZ89X1GBu30Ci.jpg","height":2100,"iso_639_1":"ru","vote_average":0,"vote_count":0,"width":1400},{"aspect_ratio":0.666666666666667,"file_path":"/nOzMPaSiU4s6dqj4M2eeB5DigtT.jpg","height":1077,"iso_639_1":"bg","vote_average":0,"vote_count":0,"width":718},{"aspect_ratio":0.70048097944906,"file_path":"/uUF7hOPxNwM5sZzfbzmIuZqO2bP.jpg","height":2287,"iso_639_1":"ko","vote_average":0,"vote_count":0,"width":1602},{"aspect_ratio":0.700944386149003,"file_path":"/jwH3GHPf9eQkQzqvzLUIfEASHv0.jpg","height":953,"iso_639_1":"ko","vote_average":0,"vote_count":0,"width":668},{"aspect_ratio":0.700944386149003,"file_path":"/yP6WA6bTVG7mU9ydCukZFdQbAEM.jpg","height":953,"iso_639_1":"ko","vote_average":0,"vote_count":0,"width":668},{"aspect_ratio":0.700944386149003,"file_path":"/zjFPB511fGij8PDTKP2FbeywgfE.jpg","height":953,"iso_639_1":"ko","vote_average":0,"vote_count":0,"width":668},{"aspect_ratio":0.700944386149003,"file_path":"/caCZNmaIDtQiNVhEuBeSMvZAl0A.jpg","height":953,"iso_639_1":"ko","vote_average":0,"vote_count":0,"width":668},{"aspect_ratio":0.700589970501475,"file_path":"/60WLY635KIUsDjn5qoKMBZVfRXO.jpg","height":1356,"iso_639_1":"he","vote_average":0,"vote_count":0,"width":950},{"aspect_ratio":0.674915635545557,"file_path":"/xHfhQIK4BNlsGv5Ylx8mVq0hJT1.jpg","height":1778,"iso_639_1":"es","vote_average":0,"vote_count":0,"width":1200},{"aspect_ratio":0.694542253521127,"file_path":"/c62or4LSmDKo4WORgZuMXV5ceqT.jpg","height":1136,"iso_639_1":"el","vote_average":0,"vote_count":0,"width":789},{"aspect_ratio":0.685871056241427,"file_path":"/7osuSSk41c0bDBoP3IwIZoQzOUu.jpg","height":1458,"iso_639_1":"pl","vote_average":0,"vote_count":0,"width":1000},{"aspect_ratio":0.7,"file_path":"/vMFGfDmDkUTNmjxuI5RYYphuN9R.jpg","height":960,"iso_639_1":"it","vote_average":0,"vote_count":0,"width":672},{"aspect_ratio":0.666666666666667,"file_path":"/ylb23f8lJRPrLaAK7jdAXB7xpf.jpg","height":1500,"iso_639_1":"es","vote_average":0,"vote_count":0,"width":1000},{"aspect_ratio":0.666433076384022,"file_path":"/1FKROgrEZgYxhA9Dz8bwQ6JwTCc.jpg","height":1427,"iso_639_1":"es","vote_average":0,"vote_count":0,"width":951},{"aspect_ratio":0.666666666666667,"file_path":"/slnUheSBaZYrhXnQAsBSHzkyKGc.jpg","height":2100,"iso_639_1":"it","vote_average":0,"vote_count":0,"width":1400},{"aspect_ratio":0.675585284280936,"file_path":"/rBfcceKgI3X4i1q1inPvwMeXMC7.jpg","height":897,"iso_639_1":"fr","vote_average":0,"vote_count":0,"width":606},{"aspect_ratio":0.666314119513485,"file_path":"/81QP5b03dHTzmUuG9KkQtnztB8q.jpg","height":1891,"iso_639_1":"sk","vote_average":0,"vote_count":0,"width":1260}]
     */

    private int id;
    /**
     * aspect_ratio : 1.77777777777778
     * file_path : /tbhdm8UJAb4ViCTsulYFL3lxMCd.jpg
     * height : 1080
     * iso_639_1 : null
     * vote_average : 5.856524427953
     * vote_count : 14
     * width : 1920
     */

    private List<BackdropsEntity> backdrops;
    /**
     * aspect_ratio : 0.666666666666667
     * file_path : /dywDjqAJoWudjgtHHIndmY9xvj9.jpg
     * height : 3000
     * iso_639_1 : en
     * vote_average : 6.29680998613038
     * vote_count : 40
     * width : 2000
     */

    private List<PostersEntity> posters;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BackdropsEntity> getBackdrops() {
        return backdrops;
    }

    public void setBackdrops(List<BackdropsEntity> backdrops) {
        this.backdrops = backdrops;
    }

    public List<PostersEntity> getPosters() {
        return posters;
    }

    public void setPosters(List<PostersEntity> posters) {
        this.posters = posters;
    }

    public static class BackdropsEntity implements Parcelable {
        private double aspect_ratio;
        private String file_path;
        private int height;
        private String iso_639_1;
        private double vote_average;
        private int vote_count;
        private int width;

        public double getAspect_ratio() {
            return aspect_ratio;
        }

        public void setAspect_ratio(double aspect_ratio) {
            this.aspect_ratio = aspect_ratio;
        }

        public String getFile_path() {
            return file_path;
        }

        public void setFile_path(String file_path) {
            this.file_path = file_path;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Object getIso_639_1() {
            return iso_639_1;
        }

        public void setIso_639_1(String iso_639_1) {
            this.iso_639_1 = iso_639_1;
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

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeDouble(this.aspect_ratio);
            dest.writeString(this.file_path);
            dest.writeInt(this.height);
            dest.writeString(this.iso_639_1);
            dest.writeDouble(this.vote_average);
            dest.writeInt(this.vote_count);
            dest.writeInt(this.width);
        }

        public BackdropsEntity() {
        }

        protected BackdropsEntity(Parcel in) {
            this.aspect_ratio = in.readDouble();
            this.file_path = in.readString();
            this.height = in.readInt();
            this.iso_639_1 = in.readParcelable(Object.class.getClassLoader());
            this.vote_average = in.readDouble();
            this.vote_count = in.readInt();
            this.width = in.readInt();
        }

        public static final Creator<BackdropsEntity> CREATOR = new Creator<BackdropsEntity>() {
            @Override
            public BackdropsEntity createFromParcel(Parcel source) {
                return new BackdropsEntity(source);
            }

            @Override
            public BackdropsEntity[] newArray(int size) {
                return new BackdropsEntity[size];
            }
        };
    }

    public static class PostersEntity implements Parcelable {
        private double aspect_ratio;
        private String file_path;
        private int height;
        private String iso_639_1;
        private double vote_average;
        private int vote_count;
        private int width;

        public double getAspect_ratio() {
            return aspect_ratio;
        }

        public void setAspect_ratio(double aspect_ratio) {
            this.aspect_ratio = aspect_ratio;
        }

        public String getFile_path() {
            return file_path;
        }

        public void setFile_path(String file_path) {
            this.file_path = file_path;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getIso_639_1() {
            return iso_639_1;
        }

        public void setIso_639_1(String iso_639_1) {
            this.iso_639_1 = iso_639_1;
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

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeDouble(this.aspect_ratio);
            dest.writeString(this.file_path);
            dest.writeInt(this.height);
            dest.writeString(this.iso_639_1);
            dest.writeDouble(this.vote_average);
            dest.writeInt(this.vote_count);
            dest.writeInt(this.width);
        }

        public PostersEntity() {
        }

        protected PostersEntity(Parcel in) {
            this.aspect_ratio = in.readDouble();
            this.file_path = in.readString();
            this.height = in.readInt();
            this.iso_639_1 = in.readString();
            this.vote_average = in.readDouble();
            this.vote_count = in.readInt();
            this.width = in.readInt();
        }

        public static final Creator<PostersEntity> CREATOR = new Creator<PostersEntity>() {
            @Override
            public PostersEntity createFromParcel(Parcel source) {
                return new PostersEntity(source);
            }

            @Override
            public PostersEntity[] newArray(int size) {
                return new PostersEntity[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeList(this.backdrops);
        dest.writeList(this.posters);
    }

    public MovieImages() {
    }

    protected MovieImages(Parcel in) {
        this.id = in.readInt();
        this.backdrops = new ArrayList<BackdropsEntity>();
        in.readList(this.backdrops, BackdropsEntity.class.getClassLoader());
        this.posters = new ArrayList<PostersEntity>();
        in.readList(this.posters, PostersEntity.class.getClassLoader());
    }

    public static final Parcelable.Creator<MovieImages> CREATOR = new Parcelable.Creator<MovieImages>() {
        @Override
        public MovieImages createFromParcel(Parcel source) {
            return new MovieImages(source);
        }

        @Override
        public MovieImages[] newArray(int size) {
            return new MovieImages[size];
        }
    };
}
