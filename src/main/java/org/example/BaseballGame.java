package org.example;

import java.util.Arrays;

public class BaseballGame {

  public static int score(int[] inningA, int[] inningB,
                          int[] playerA, int[] playerB) throws Exception {
    //檢查局數是否正常
    if (inningA.length < 9 || inningB.length < 9) {
      //System.out.println("局數小於9局");
      throw new RuntimeException("局數小於9局");
    }

    //計算總分
    int totalA = 0;
    int totalB = 0;
    for (int i = 0; i < 9; i++) {
      totalA += inningA[i];
      if (inningB[i] != -1) {
        totalB += inningB[i];
      }
    }

    //檢查提前結束的情況
    if (inningB[8] == -1 && totalB <= totalA) {
      //System.out.println("不合理的提前結束");
      throw new RuntimeException("不合理的提前結束");
    }

    //檢查全員的總分是否一致
    if (totalA != Arrays.stream(playerA).sum() || totalB != Arrays.stream(playerB).sum()) {
      System.out.println("totalA:" + totalA + " totalB:" + totalB);
      System.out.println("playerA:" + Arrays.stream(playerA).sum()
                        + " playerB:" + Arrays.stream(playerB).sum());
      //System.out.println("局數總分和隊員總分不一致");
      throw new RuntimeException("局數總分和隊員總分不一致");
    }

    //判斷勝負
    int diff = totalA - totalB;
    if (diff == 0) {
      //System.out.println("不可以和局"); return 0;
      throw new RuntimeException("不可以和局");
    } else {
      return diff;
    }
  }
}
