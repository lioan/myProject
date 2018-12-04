package cn.com.lioan.testEnum;

import java.util.HashMap;
import java.util.Map;

public class TestEnum1 {
    /**
     * @param score 用户得分
     * @return string 用户赢得的流量值组合,多个流量值之间以“,”隔开，例如：“10,20”
     * @title getDataFlowByScore
     * @description 根据用户得分 通过配置得分档次返回相应的流量值
     */
    private Map<String, Object> getDataFlowByScore(int score) {
        String flowStr = "";

//		String[] levels = new String[]{FlowLevel.ONE.getKey(),FlowLevel.TWO.getKey(),FlowLevel.THREE.getKey()};
        String[] levels = new String[]{FlowLevel.ONE.getKey(), FlowLevel.TWO.getKey(), FlowLevel.THREE.getKey(), FlowLevel.FOUR.getKey()};
//		String[] levels = new String[]{FlowLevel.ONE.getKey(),FlowLevel.TWO.getKey(),FlowLevel.THREE.getKey(),FlowLevel.FOUR.getKey(),FlowLevel.FIVE.getKey()};

        int length = levels.length;
        //标记变量:标记当前成绩处于几档,1-代表最低档，其他依次类推，:length档为最高档
        int mark = 0;
        //封装最终结果
        Map<String, Object> resultMap = new HashMap<String, Object>();

        try {
            if (score < Integer.parseInt(levels[0])) {//小于最低档
                flowStr = "";
            } else if (score >= Integer.parseInt(levels[length - 1])) {//大于等于最高档
                mark = length;
                for (int i = 0; i < length; i++) {
                    if (i == length - 1) {
                        flowStr += FlowLevel.getValueByKey(levels[length - 1]);
                    } else {
                        flowStr += FlowLevel.getValueByKey(levels[i]) + ",";
                    }
                }
            } else {//大于等于最低档且小于最高档
                for (int j = 1; j < length; j++) {
                    if (score < Integer.parseInt(levels[j])) {
                        mark = j;
                        break;
                    }
                }
                //根据档级获取相应的流量值
                for (int k = 0; k < mark; k++) {
                    if (k == mark - 1) {
                        flowStr += FlowLevel.getValueByKey(levels[mark - 1]);
                    } else {
                        flowStr += FlowLevel.getValueByKey(levels[k]) + ",";
                    }
                }
            }
            System.out.println("score === " + score);
            System.out.println("mark === " + mark);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resultMap.put("Level", (Integer) mark);
        resultMap.put("DataFlows", flowStr);
        return resultMap;
    }

    public enum FlowLevel {
        ONE("natialActivityDataFlowLevel", "300", "10"),//一档
        TWO("natialActivityDataFlowLevel", "500", "20"),//二挡
        THREE("natialActivityDataFlowLevel", "1000", "30"),//三挡
        FOUR("natialActivityDataFlowLevel", "1200", "60");//四档
        //		FIVE("natialActivityDataFlowLevel","1500","100");//五档
        private String type;//类型
        private String key;//过档分数线
        private String value; //过档流量值

        private FlowLevel(String type, String key, String value) {
            this.type = type;
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public String getType() {
            return type;
        }

        public static String getValueByKey(String key) {
            for (FlowLevel flowLevel : FlowLevel.values()) {
                if (flowLevel.key.equals(key)) {
                    return flowLevel.value;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("test enum1");
        TestEnum1 test = new TestEnum1();
        int score = 1509;
        Map<String, Object> result = test.getDataFlowByScore(score);
        System.out.println("level ======= " + result.get("Level"));
        System.out.println("dataFlows ======= " + result.get("DataFlows"));
    }
}
