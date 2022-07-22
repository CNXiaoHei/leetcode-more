package entity;


import lombok.Data;

import java.util.List;

/**
 * @Author: Xiaohei
 * @CreateTime: 2022/7/7 22:24
 */
@Data
public class UserProfileUserQuestionProgress {

    private List<QuestionNum> numAcceptedQuestions;

    private List<QuestionNum> numFailedQuestions;

    private List<QuestionNum> numUntouchedQuestions;

}
