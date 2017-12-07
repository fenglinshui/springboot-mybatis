package conoha.model;

public class PixivImage {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pixiv_image_show.pixiv_id
     *
     * @mbggenerated
     */
    private Long pixivId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pixiv_image_show.local_path
     *
     * @mbggenerated
     */
    private String localPath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pixiv_image_show.small_image_url
     *
     * @mbggenerated
     */
    private String smallImageUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pixiv_image_show.large_image_url
     *
     * @mbggenerated
     */
    private String largeImageUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pixiv_image_show.author
     *
     * @mbggenerated
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pixiv_image_show.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pixiv_image_show.tag
     *
     * @mbggenerated
     */
    private String tag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pixiv_image_show.isDeleted
     *
     * @mbggenerated
     */
    private Boolean isdeleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pixiv_image_show
     *
     * @mbggenerated
     */
    public PixivImage(Long pixivId, String localPath, String smallImageUrl, String largeImageUrl, String author, String title, String tag, Boolean isdeleted) {
        this.pixivId = pixivId;
        this.localPath = localPath;
        this.smallImageUrl = smallImageUrl;
        this.largeImageUrl = largeImageUrl;
        this.author = author;
        this.title = title;
        this.tag = tag;
        this.isdeleted = isdeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pixiv_image_show
     *
     * @mbggenerated
     */
    public PixivImage() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pixiv_image_show.pixiv_id
     *
     * @return the value of pixiv_image_show.pixiv_id
     * @mbggenerated
     */
    public Long getPixivId() {
        return pixivId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pixiv_image_show.pixiv_id
     *
     * @param pixivId the value for pixiv_image_show.pixiv_id
     * @mbggenerated
     */
    public void setPixivId(Long pixivId) {
        this.pixivId = pixivId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pixiv_image_show.local_path
     *
     * @return the value of pixiv_image_show.local_path
     * @mbggenerated
     */
    public String getLocalPath() {
        return localPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pixiv_image_show.local_path
     *
     * @param localPath the value for pixiv_image_show.local_path
     * @mbggenerated
     */
    public void setLocalPath(String localPath) {
        this.localPath = localPath == null ? null : localPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pixiv_image_show.small_image_url
     *
     * @return the value of pixiv_image_show.small_image_url
     * @mbggenerated
     */
    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pixiv_image_show.small_image_url
     *
     * @param smallImageUrl the value for pixiv_image_show.small_image_url
     * @mbggenerated
     */
    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl == null ? null : smallImageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pixiv_image_show.large_image_url
     *
     * @return the value of pixiv_image_show.large_image_url
     * @mbggenerated
     */
    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pixiv_image_show.large_image_url
     *
     * @param largeImageUrl the value for pixiv_image_show.large_image_url
     * @mbggenerated
     */
    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl == null ? null : largeImageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pixiv_image_show.author
     *
     * @return the value of pixiv_image_show.author
     * @mbggenerated
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pixiv_image_show.author
     *
     * @param author the value for pixiv_image_show.author
     * @mbggenerated
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pixiv_image_show.title
     *
     * @return the value of pixiv_image_show.title
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pixiv_image_show.title
     *
     * @param title the value for pixiv_image_show.title
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pixiv_image_show.tag
     *
     * @return the value of pixiv_image_show.tag
     * @mbggenerated
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pixiv_image_show.tag
     *
     * @param tag the value for pixiv_image_show.tag
     * @mbggenerated
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pixiv_image_show.isDeleted
     *
     * @return the value of pixiv_image_show.isDeleted
     * @mbggenerated
     */
    public Boolean getIsdeleted() {
        return isdeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pixiv_image_show.isDeleted
     *
     * @param isdeleted the value for pixiv_image_show.isDeleted
     * @mbggenerated
     */
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
}