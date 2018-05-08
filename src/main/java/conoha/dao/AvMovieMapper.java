package conoha.dao;

import conoha.model.AvMovie;
import conoha.model.AvMovieExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AvMovieMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_movie
     *
     * @mbggenerated
     */
    @Delete({
            "delete from av_movie",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

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
            "#{isShow,jdbcType=BIT}, #{addDate,jdbcType=TIMESTAMP})",
            " ON DUPLICATE KEY UPDATE url=#{url,jdbcType=VARCHAR}"
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

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_movie
     *
     * @mbggenerated
     */
    @Select({
            "select",
            "id, name, tag, imgs, url, size, attachment_name, attachment_url, is_Delete, ",
            "download, download_time, is_show, add_date",
            "from av_movie",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    AvMovie selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_movie
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AvMovie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_movie
     *
     * @mbggenerated
     */
    @Update({
            "update av_movie",
            "set name = #{name,jdbcType=VARCHAR},",
            "tag = #{tag,jdbcType=VARCHAR},",
            "imgs = #{imgs,jdbcType=VARCHAR},",
            "url = #{url,jdbcType=VARCHAR},",
            "size = #{size,jdbcType=DECIMAL},",
            "attachment_name = #{attachmentName,jdbcType=VARCHAR},",
            "attachment_url = #{attachmentUrl,jdbcType=VARCHAR},",
            "is_Delete = #{isDelete,jdbcType=BIT},",
            "download = #{download,jdbcType=BIT},",
            "download_time = #{downloadTime,jdbcType=TIMESTAMP},",
            "is_show = #{isShow,jdbcType=BIT},",
            "add_date = #{addDate,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AvMovie record);
}