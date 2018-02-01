package dataclass;

/**
 * Created by TI A1 on 23-05-2017.
 */
public class DataReviewsDetail {
    String reviewname;
    String imgurl;
    String rating_star;

    public String getReview_desc() {
        return review_desc;
    }

    public void setReview_desc(String review_desc) {
        this.review_desc = review_desc;
    }

    public String getReviewname() {
        return reviewname;
    }

    public void setReviewname(String reviewname) {
        this.reviewname = reviewname;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getRating_star() {
        return rating_star;
    }

    public void setRating_star(String rating_star) {
        this.rating_star = rating_star;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    String review_desc;
    String date_time;
}
