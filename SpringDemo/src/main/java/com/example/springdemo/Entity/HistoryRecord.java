package com.example.springdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户搜索历史记录
 * </p>
 *
 * @author 郭旗
 * @since 2022-08-19
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_yx_history_record")
public class HistoryRecord implements Serializable {


      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 用户userId
     */
      private Integer yxUserId;

      /**
     * 历史记录信息
     */
      private String record;

      /**
     * 权重值/排序
     */
      private Integer weights;

      /**
     * 是否删除
     */
      private Integer deleted;

      /**
     * 创建时间
     */
      private Integer createTime;

      /**
     * 更新时间
     */
      private Integer updateTime;


}
