package com.ob.algorithm.coding;

import com.google.common.collect.ImmutableMap;

import java.util.*;
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
                            int res;
                            if (null != first.getLastName() && null != second.getLastName()) {
                                res = first.getLastName().compareTo(second.getLastName());
                            } else {
                                res = first.getLastName() != null ? -1 : second.getLastName() != null ? 1 : 0;
                            }
                            return res;
                        })
                        .thenComparing((first, second) -> {
                            int res;
                            if (null != first.getExt() && null != second.getExt()) {
                                res = first.getExt().compareTo(second.getExt());
                            } else {
                                res = first.getExt() != null ? -1 : second.getExt() != null ? 1 : 0;
                            }
                            return res;
                        }))
                .collect(Collectors.toList());
    }

    /**
     * Question2, sort extType, extType is a string and can
     * be "User", "Dept", "AO", "TMO", "Other",
     * sort by User > Dept > AO > TMO > Other;
     **/
    public static List<Extension> sortByExtType(List<Extension> extensions) {
        return extensions.stream()
                .sorted(Comparator.comparingInt(o -> ORDER_MAP.get(o.getExtType())))
                .collect(Collectors.toList());
    }

    /**
     * Question3, sum all sales items by quarter
     **/
    public static List<QuarterSalesItem> sumByQuarter(List<SaleItem> saleItems) {

        return saleItems.stream()
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(sale -> ((sale.getMonth() - 1) / 3) + 1,
                        TreeMap::new,
                        Collectors.mapping(SaleItem::getSaleNumbers, Collectors.summingDouble(Double::valueOf))),
                        intDoubleMap -> intDoubleMap.keySet()
                                .stream()
                                .map(key -> {
                                    QuarterSalesItem quarterSalesItem = new QuarterSalesItem();
                                    quarterSalesItem.setQuarter((Integer) key);
                                    quarterSalesItem.setValue(intDoubleMap.get(key));
                                    return quarterSalesItem;
                                }).collect(Collectors.toList())));

    }

    /**
     * Question4, max all sales items by quarter
     **/
    public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {
        List<QuarterSalesItem> quarterSalesItems = sumByQuarter(saleItems);
        double[] array = new double[5];
        quarterSalesItems.stream()
                .peek(item -> array[item.getQuarter()] = array[item.getQuarter() - 1] + item.getValue())
                .forEach(item -> item.setValue(array[item.getQuarter()]));
        return quarterSalesItems;

    }

    /**
     * We have all Keys: 0-9;
     * usedKeys is an array to store all used keys like :
     * [2,3,4];
     * We want to get all unused keys, in this example it
     * would be: [0,1,5,6,7,8,9,]
     */

    public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
        if (allKeys == null || allKeys.length == 0 || usedKeys == null || usedKeys.length == 0) {
            return allKeys;
        }
        Set<Integer> usedKeySet = new HashSet<>(usedKeys.length);
        for (int x : usedKeys) {
            usedKeySet.add(x);
        }
        int j = 0;
        for (int i = 0; i < allKeys.length; i++) {
            if (!usedKeySet.contains(allKeys[i])) {
                allKeys[j] = allKeys[i];
                j++;
            }
        }
        int[] unusedKey = new int[j];
        System.arraycopy(allKeys, 0, unusedKey, 0, j);
        return unusedKey;
    }

    private static final ImmutableMap<String, Integer> ORDER_MAP = ImmutableMap.<String, Integer>builder()
            .put("User", 1)
            .put("Dept", 2)
            .put("AO", 3)
            .put("TMO", 4)
            .put("Other", 5)
            .build();
}
