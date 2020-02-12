package com.company;

import org.apache.commons.lang3.StringUtils;

public class Test {
    public static void main(String[] args) {
        boolean rs = StringUtils.isNumeric("Hello Maven");
        System.out.println(rs);
    }
}
