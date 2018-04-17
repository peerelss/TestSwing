package conf;

/**
 * Created by kevin on 2017/11/25.
 */
public class TwitterCurlConf {
    public static final String TAG_INDEX_POSITION="TAG_INDEX_POSITION";
    public static final String FILENAME_TAG="twitter_curl_result.html";
    public static final String MILKY_CAT_CURL="curl \"https://twitter.com/i/profiles/show/milkycatcom/media_timeline?include_available_features=1&include_entities=1&max_position=TAG_INDEX_POSITION&reset_error_state=false\" " +
            "-o twitter_curl_result.html -x 127.0.0.1:1080 " +
            "-H \"Host: twitter.com\" " +
            "-H \"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0\" " +
            "-H \"Accept: application/json, text/javascript, */*; q=0.01\" " +
            "-H \"Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2\" " +
            "--compressed -H \"Referer: https://twitter.com/milkycatcom/media\" " +
            "-H \"X-Twitter-Active-User: yes\" -H \"X-Requested-With: XMLHttpRequest\" " +
            "-H \"Cookie: guest_id=v1\"%\"3A148150635701629653; pid=\"\"v3:1481506364869393708003403\"\"; _ga=GA1.2.956139179.1481506370; kdt=m3NrBssW1uN5Mcz7WDRAdtDPJC4KIJbiAfrjHxC0; remember_checked_on=1; twid=\"\"u=748639380516966400\"\"; auth_token=496baa164ba45e24a1088e8222d37985ec18ed35; moments_profile_moments_nav_tooltip_other=true; __utma=43838368.956139179.1481506370.1508347410.1510417663.5; __utmz=43838368.1510417663.5.3.utmcsr=t.co|utmccn=(referral)|utmcmd=referral|utmcct=/rP5sR3XB3o; personalization_id=\"\"v1_ZovftMbasjY17HOIWhmdOQ==\"\"; tip_nightmode=true; tfw_exp=0; _gid=GA1.2.349321205.1510333926; external_referer=padhuUp37ziylVCcdaVJIgiuzOnzKRJOJnLJek4NYFk4xVlXdqZGZ77AD4EjQ3t3DgHNIEYL7KEZwtiTtw9oE3Dm06cWw8D39UpMyPzO96CU4\"%\"2BfVfRt6fw\"%\"3D\"%\"3D|0|8e8t2xd8A2w\"%\"3D; ct0=16af697ec5231d6dac72b14ad3f10eac; lang=zh-cn; _twitter_sess=BAh7CSIKZmxhc2hJQzonQWN0aW9uQ29udHJvbGxlcjo6Rmxhc2g6OkZsYXNo\"%\"250ASGFzaHsABjoKQHVzZWR7ADoPY3JlYXRlZF9hdGwrCFZZQc1fAToMY3NyZl9p\"%\"250AZCIlNjZhZDg5ZjEyYjQ4NTY4Y2RkODY1NmQ2MjYzY2Q2NTY6B2lkIiVjNTcy\"%\"250AYjE3N2VlNTc3NGFkZjA3MjhjOTg3MDMzYmFkMg\"%\"253D\"%\"253D--2c3cc887bee18612abdc0a972b9759e8dae0e95f; _gat=1\" " +
            "-H \"Connection: keep-alive\"";
}
