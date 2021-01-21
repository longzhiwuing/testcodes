package com.lzwing.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 院校学科排名表(PeUniversitySubjectRank)表实体类
 *
 * @author chenzhongyong
 * @since 2021-01-21 13:25:11
 */
@SuppressWarnings("serial")
@Data
@TableName("pe_university_subject_rank")
public class UniversitySubjectRank extends Model<UniversitySubjectRank> {
    //id
    private Integer id;
    //一级学科名称
    private String categoryName;
    //学科code
    private String subjectCode;
    //学科名称
    private String subjectName;
    //院校code
    private String universityCode;
    //院校名称
    private String universityName;
    //学科排名
    private String univRank;
    //等级 1 - 9 对应 A+ ~ C-
    private Integer univLevel;
    //创建时间
    private Date createTime;
    //操作时间
    private Date ts;
    //是否删除
    private Integer isDelete;
    //高校和科研院所参评数合计
    private Integer statCount;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }