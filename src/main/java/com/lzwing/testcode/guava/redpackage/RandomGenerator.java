package com.lzwing.testcode.guava.redpackage;

/* n个随机数，总和为sum，每个随机数的范围为[min,max]。
    前n-1个用rand函数随机产生，第n个数设为val=sum-（前n-1数之和）。
（1）若val属于[min,max]，则可以直接用；

（2）若val>=max,则用max。val-max的处理：在1~n-1中随机出一个序号m来，将多出来的val-max补到这第m个数上，如果将其补为200仍然还有剩余，则继续做这样的操作，直到多余部分被分配完为止。
（3）若val<=min，则用min。min-val的处理：在1~n-1中随机出一个序号m来，将多出来的min-val部分从这第m个数上扣除，如果将其削为min仍然没有扣完，则继续这个操作，直到配平为止。*/

import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    /// <summary>
    /// 生成指定个数的限定金额范围的随机红包，且总额为指定值
    /// </summary>
    /// <param name="totalValue">指定总额</param>
    /// <param name="min">最小边界</param>
    /// <param name="max">最大边界</param>
    /// <param name="num">数量</param>
    /// <returns>以列表的形式返回生成的数据</returns>

    public static final Double ratio = 0.2;

    private static Double getFloor(Double d) {
        BigDecimal b = new BigDecimal(d);
        return b.setScale(2, BigDecimal.ROUND_FLOOR).doubleValue();
    }

    public static List<Double> reward(Double totalValue, int num){
        Double avg = getFloor(totalValue / num);

        Double min = getFloor(avg * (1 - ratio));
        Double max = getFloor(avg * (1 + ratio));

        System.out.println("avg:" + avg + ",min=" + min + ",max=" + max);

        List<Double> list = Lists.newArrayList();

        Double sum = 0.0;
        Random random = new Random();

        Double temp;
        //前num-1个数据随机生成
        for (int i = 0; i < num-1; i++){
            temp = RandomUtils.nextDouble(min, max);
            sum+=temp;
            temp = getFloor(temp);
            list.add(temp);
        }
        //为了保证总额为指定值，须对最后一个数据的生成做处理
        Double gap = getFloor(totalValue-sum);
        if (gap >= min && gap <= max){
            list.add(gap);
            return list;
        }
        else if (gap > max){//剩余值大于max
            list.add(max);
            gap = gap - max;
            int index;
            Double value;
            while (gap > 0){
                index = random.nextInt(num - 1);  //生成0到num-1之间的随机整数（包括0，不包括num-1）
                value = list.get(index);
                Double margin = max - value;
                if (margin>0){
                    if (gap >= margin){
                        list.set(index,max);
                        gap = gap - margin;
                    } else {
                        list.set(index, getFloor(list.get(index) + gap));
                        return list;
                    }
                }
            }
        } else {
            //剩余值小于min
            list.add(min);
            Double need = min-gap;
            int index;
            Double value;
            Double buffer;
            while (need > 0) {
                index = random.nextInt(num - 1);  //生成0到num-1之间的随机整数（包括0，不包括num-1）
                value = list.get(index);
                buffer = value - min;
                if (buffer >= need){
                    list.set(index, getFloor(list.get(index) - need));
                    return list;
                } else {
                    list.set(index, min);
                    need = need - buffer;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        /*List<Double> rewardList = reward(50000.00, 2453);

        Double max = Collections.max(rewardList);
        Double min = Collections.min(rewardList);

        double sum = 0;
        for (Double itm : rewardList) {
            sum += itm;
        }

        System.out.println(rewardList);

        System.out.println("sum:" + getFloor(sum) + ",max:" + max + ",min:" + min);*/

        for (int i = 0; i < 10; i++) {
            double v = RandomUtils.nextDouble(0.8, 1.2);

            System.out.println("v = " + v);
        }
    }

}