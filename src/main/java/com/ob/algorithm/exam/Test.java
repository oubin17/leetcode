package com.ob.algorithm.exam;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author: oubin
 * @Date: 2020/9/4 15:42
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

//        test1();
        test2();

    }


    public static void test1() {

        Extension extension1 = new Extension();
        extension1.setFirstName("first_name_a");
//        extension1.setLastName("last_name_a");
//        extension1.setExt("ext_a");

        Extension extension2 = new Extension();
        extension2.setFirstName("first_name_a");
        extension2.setLastName("");
//        extension2.setExt("ext_b");


        Extension extension3 = new Extension();
        extension3.setFirstName("first_name_a");
        extension3.setLastName("last_name_c");
//        extension3.setExt("ext_c");

        List<Extension> extensions = Lists.newArrayList(extension1, extension2, extension3);
        List<Extension> extensionList = Utils.sortByName(extensions);
        for(Extension extension : extensionList) {
            System.out.println(extension.getFirstName());
            System.out.println(extension.getLastName());
            System.out.println(extension.getExt());
        }

    }

    /**
     * Question2, sort extType, extType is a string and can
     * be "User", "Dept", "AO", "TMO", "Other",
     * sort by User > Dept > AO > TMO > Other;
     **/
    public static void test2() {

        Extension extension1 = new Extension();
        extension1.setExtType("Other");

        Extension extension2 = new Extension();
        extension2.setExtType("User");

        Extension extension3 = new Extension();
        extension3.setExtType("TMO");

        Extension extension4 = new Extension();
        extension4.setExtType("Dept");

        Extension extension5 = new Extension();
        extension5.setExtType("AO");


        List<Extension> extensions = Lists.newArrayList(extension1, extension2, extension3, extension4, extension5);
        List<Extension> extensionList = Utils.sortByExtType(extensions);
        for(Extension extension : extensionList) {
//            System.out.println(extension.getFirstName());
//            System.out.println(extension.getLastName());
            System.out.println(extension.getExtType());
        }
    }
}
