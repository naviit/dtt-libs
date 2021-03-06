/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSplitter {

  public static List<String> splitBySpace(String value) {
    if (StringUtil.isEmpty(value)) return new ArrayList<String>();
    String[] lstChar = value.split(StringUtil.SPACE);
    return Arrays.asList(lstChar);
  }

  public static List<String> toList(String value, char separator) {
    List<String> temp = new ArrayList<String>((value.length()/2)+1);
    int start = 0;  
    int index = value.indexOf(separator);  // First substring
    while(index >= 0){  
      temp.add(value.substring(start, index));  
      start = index + 1;  
      index = value.indexOf(separator, start);   // Rest of substrings
    } 
    temp.add(value.substring(start)); // Last substring  
    return temp;  
  }

  public static List<String> toListBySpace(String value) {
    if (value == null) return new ArrayList<String>(0);
    List<String> temp = new ArrayList<String>((value.length() / 2) + 1);
    int start = 0;
    int i = 1;
    while (i < value.length()) {
      char c = value.charAt(i);
      if (Character.isWhitespace(c) || Character.isSpaceChar(c)) {
        String element = value.substring(start, i);
        if (!element.isEmpty())
          temp.add(element);
        start = i + 1;
        i++;
        continue;
      }
      i++;
    }
    if (start < value.length()) {
      String element = value.substring(start);
      if (!element.isEmpty())
        temp.add(element);
    }
    return temp;
  }

  public static String[] toArrayBySpace(String value) {
    List<String> list = toListBySpace(value);
    return list.toArray(new String[list.size()]);
  }

  public static String[] toArray(String value, char separator){  
    List<String> list = toList(value, separator);
    return list.toArray(new String[list.size()]);
  }
}
