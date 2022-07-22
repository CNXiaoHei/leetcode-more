package entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Xiaohei
 * @CreateTime: 2022/7/9 0:04
 */
@Data
public class QuestionAccept {

    private String id;

    private String userId;

    private Integer easy;

    private Integer mid;

    private Integer hard;

    private Integer total;

    private Date writeTime;
}
