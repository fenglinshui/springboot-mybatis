package conoha.dao;

import conoha.model.AvMovie;
import conoha.model.AvMovieExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

public interface AvMovieMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_movie
     *
     * @mbggenerated
     */
    @Insert({
            "insert into av_movie (id, name, ",
            "tag, imgs, url, ",
            "size, attachment_name, ",
            "attachment_url, is_Delete, ",
            "download, download_time, ",
            "is_show, add_date)",
            "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
            "#{tag,jdbcType=VARCHAR}, #{imgs,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
            "#{size,jdbcType=DECIMAL}, #{attachmentName,jdbcType=VARCHAR}, ",
            "#{attachmentUrl,jdbcType=VARCHAR}, #{isDelete,jdbcType=BIT}, ",
            "#{download,jdbcType=BIT}, #{downloadTime,jdbcType=TIMESTAMP}, ",
            "#{isShow,jdbcType=BIT}, #{addDate,jdbcType=TIMESTAMP})"
    })
    int insert(AvMovie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_movie
     *
     * @mbggenerated
     */
    int insertSelective(AvMovie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_movie
     *
     * @mbggenerated
     */

    List<AvMovie> selectByExample(AvMovieExample example);

    @Select({
            "select",
            "url",
            "from av_movie"
    })
    Set<String> getUrls();

}