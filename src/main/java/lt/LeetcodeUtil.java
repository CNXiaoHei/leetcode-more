package lt;


import com.alibaba.fastjson.JSONObject;
import entity.QuestionAccept;
import entity.QuestionNum;
import entity.UserProfileUserQuestionProgress;
import http.HttpUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Xiaohei
 * @CreateTime: 2022/7/21 23:46
 */
public class LeetcodeUtil {

    private final static String URL = "https://leetcode.cn/graphql/";

    private final static String BODY_PARAMS = "{\r\n    \"query\": \"\\n    query userQuestionProgress($userSlug: String!) {\\n  userProfileUserQuestionProgress(userSlug: $userSlug) {\\n    numAcceptedQuestions {\\n      difficulty\\n      count\\n    }\\n    numFailedQuestions {\\n      difficulty\\n      count\\n    }\\n    numUntouchedQuestions {\\n      difficulty\\n      count\\n    }\\n  }\\n}\\n    \",\r\n    \"variables\": {\r\n        \"userSlug\": \"{1}\"\r\n    }\r\n}";

    public static UserProfileUserQuestionProgress getQuestions(String userSlug) {
        String body = BODY_PARAMS.replace("{1}", userSlug);
        String response = HttpUtil.post(URL, body);
        JSONObject obj = JSONObject.parseObject(response);
        UserProfileUserQuestionProgress data = obj.getJSONObject("data").getObject("userProfileUserQuestionProgress", UserProfileUserQuestionProgress.class);
        return data;
    }

    public static List<QuestionAccept> getData(List<String> userIds) {

        List<QuestionAccept> acceptArrayList = new ArrayList<>();
        for (String userId : userIds) {
            UserProfileUserQuestionProgress userData = getQuestions(userId);
            QuestionAccept questionAccept = new QuestionAccept();
            List<QuestionNum> nums = userData.getNumAcceptedQuestions();
            Map<String, Integer> map = nums.stream().collect(Collectors.toMap(QuestionNum::getDifficulty, QuestionNum::getCount));
            Integer easy = map.get("EASY");
            Integer medium = map.get("MEDIUM");
            Integer hard = map.get("HARD");
            questionAccept.setEasy(easy);
            questionAccept.setMid(medium);
            questionAccept.setHard(hard);
            int count = easy + medium + hard;
            questionAccept.setTotal(count);
            questionAccept.setUserId(userId);
            acceptArrayList.add(questionAccept);
        }
        return acceptArrayList;
    }


}
