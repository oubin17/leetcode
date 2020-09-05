package com.ob.algorithm.coding;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: oubin
 * @Date: 2020/9/5 10:48
 * @Description:
 */
public class UnitTest {

    @Test
    public void testSortByName() {

        Extension extension1 = new Extension();
        extension1.setFirstName("first_1");
        extension1.setLastName("last_2");
        extension1.setExt("");
        extension1.setExtType("1");

        Extension extension2 = new Extension();
        extension2.setFirstName("first_1");
        extension2.setLastName("last_1");
        extension2.setExt("");
        extension2.setExtType("2");

        Extension extension3 = new Extension();
        extension3.setFirstName("first_2");
        extension3.setExtType("3");

        Extension extension4 = new Extension();
        extension4.setFirstName("first_2");
        extension4.setExt("");
        extension4.setExtType("4");

        List<Extension> extensions = Lists.newArrayList(extension1, extension2, extension3, extension4);
        List<Extension> extensionList = Utils.sortByName(extensions);
        String[] result = new String[4];
        for (int i = 0; i < extensionList.size(); i++) {
            result[i] = extensionList.get(i).getExtType();
        }
        String[] expect = new String[]{"2", "1", "4", "3"};
        Assert.assertArrayEquals(expect, result);
    }

    @Test
    public void testSortByExtType() {

        String[] generateStr = new String[]{"Other", "User", "TMO", "Dept", "AO"};
        List<Extension> extensions = new ArrayList<>();
        for (String order : generateStr) {
            Extension extension = new Extension();
            extension.setExtType(order);
            extensions.add(extension);
        }

        List<Extension> extensionList = Utils.sortByExtType(extensions);
        String[] result = new String[5];
        for (int i = 0; i < extensionList.size(); i++) {
            result[i] = extensionList.get(i).getExtType();
        }
        String[] expect = new String[]{"User", "Dept", "AO", "TMO", "Other"};
        Assert.assertArrayEquals(expect, result);
    }

    @Test
    public void testSumByQuarter() {
        List<SaleItem> saleItemList = Lists.newArrayList();
        generateSaleItems(saleItemList);
        List<QuarterSalesItem> quarterSalesItems = Utils.sumByQuarter(saleItemList);
        double[] quarterSale = new double[5];
        for (QuarterSalesItem salesItem : quarterSalesItems) {
            quarterSale[salesItem.getQuarter()] = salesItem.getValue();
        }
        double[] expect = new double[]{0.0, 6.0, 15.0, 24.0, 33.0};
        Assert.assertArrayEquals(expect, quarterSale, 0.1);
    }

    @Test
    public void testMaxByQuarter() {
        List<SaleItem> saleItemList = Lists.newArrayList();
        generateSaleItems(saleItemList);
        List<QuarterSalesItem> quarterSalesItems = Utils.maxByQuarter(saleItemList);
        double[] quarterSale = new double[5];
        for (QuarterSalesItem salesItem : quarterSalesItems) {
            quarterSale[salesItem.getQuarter()] = salesItem.getValue();
        }
        double[] expect = new double[]{0.0, 6.0, 21.0, 45.0, 78.0};
        Assert.assertArrayEquals(expect, quarterSale, 0.1);
    }

    @Test
    public void testGetUnUsedKeys() {
        int[] allKeys = new int[]{2, 3, 4, 1, 5};
        int[] usedKeys = new int[]{3, 4};
        int[] result = Utils.getUnUsedKeys(allKeys, usedKeys);
        int[] expect = new int[]{2, 1, 5};
        Assert.assertArrayEquals(expect, result);
    }

    private void generateSaleItems(List<SaleItem> saleItemList) {
        for (int i = 0; i < 12; i++) {
            SaleItem saleItem = new SaleItem();
            saleItem.setMonth(i + 1);
            saleItem.setSaleNumbers(i + 1);
            saleItemList.add(saleItem);
        }
    }
}
