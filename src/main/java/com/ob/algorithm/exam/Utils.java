package com.ob.algorithm.exam;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: oubin
 * @Date: 2020/9/4 15:36
 * @Description:
 */
public class Utils {

    /**
     * Question1, sort by firstName + lastName + ext,
     * if firstName is the same then sort by lastName and
     * ext, please note lastName and ext can be empty
     * string or null.
     **/

    public static List<Extension> sortByName(List<Extension> extensions) {
        return extensions.stream()
                .sorted(Comparator.comparing(Extension::getFirstName)
                        .thenComparing((first, second) -> {
                            int res = 1;
                            if (null != first.getLastName() && null != second.getLastName()) {
                                res = first.getLastName().compareTo(second.getLastName());
                            } else if (null == second.getLastName()) {
                                res = -1;
                            }
                            return res;
                        }).thenComparing((first, second) -> {
                            int res = 1;
                            if (null != first.getExt() && null != second.getExt()) {
                                res = first.getExt().compareTo(second.getExt());
                            } else if (null == second.getExt()) {
                                res = -1;
                            }
                            return res;
                        })).collect(Collectors.toList());
    }


    /**
     * Question2, sort extType, extType is a string and can
     * be "User", "Dept", "AO", "TMO", "Other",
     * sort by User > Dept > AO > TMO > Other;
     **/
    public static List<Extension> sortByExtType(List<Extension> extensions) {
        Map<String, Integer> orderMap = Maps.newHashMap();
        orderMap.put("User", 1);
        orderMap.put("Dept", 2);
        orderMap.put("AO", 3);
        orderMap.put("TMO", 4);
        orderMap.put("Other", 5);
        return extensions.stream()
                .sorted(Comparator.comparingInt(o -> orderMap.get(o.getExtType())))
                .collect(Collectors.toList());
    }

    /**
     * Question3, sum all sales items by quarter
     **/
    public static List<QuarterSalesItem> sumByQuarter(List<SaleItem> saleItems) {
        return null;
    }

    /**
     * Question4, max all sales items by quarter
     **/
    public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {
        return null;
    }

    /**
     * We have all Keys: 0-9;
     * usedKeys is an array to store all used keys like :
     * [2,3,4];
     * We want to get all unused keys, in this example it
     * would be: [0,1,5,6,7,8,9,]
     */

    public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
        return null;
    }
}
