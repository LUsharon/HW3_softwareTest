package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

  @Test
  void score() {
    System.out.println("Test");
  }

  @ParameterizedTest
  @CsvSource({
      "1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,2, 2,0,1,1,1,1,0,2,1, 1,1,3,0,0,1,1,1,2, -1" ,//9局正常B win-1
      "1,1,1,1,1,1,1,1,2, 1,1,1,1,1,1,1,1,1, 1,1,3,0,0,1,1,2,1, 2,0,1,1,1,1,0,1,2, 1",//9局正常A win 1
      "1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,3,-1, 1,1,3,0,0,1,1,2,0, 2,0,2,1,1,1,0,1,2, -1",//9局 B後攻在9上已win
      "1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,-1, 1,1,3,0,0,1,1,2,0, 2,0,0,1,1,1,0,1,2, 1",//9局 B後攻 不合理
      "1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1, 1,1,3,0,0,1,1,2,0, 2,0,1,1,1,1,0,1,2, 0",//9局平手 不合理
      "1,1,1,1,1,1,1,2,1, 1,1,1,1,1,1,1,1,1, 1,1,3,0,0,1,1,2,0, 2,0,1,1,1,1,0,1,2, 1"//9局Awin1 局數總分和隊員總分不一致
  })
  void testBaseballGame(int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9,
                         int b1, int b2, int b3, int b4, int b5, int b6, int b7, int b8, int b9,
                         int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9,
                         int q1, int q2, int q3, int q4, int q5, int q6, int q7, int q8, int q9,
                        int dif) throws Exception {
    // 解析參數並呼叫 BaseballGame.score 方法進行測試
    int[] inningA1 = {a1, a2, a3, a4, a5, a6, a7, a8, a9};
    int[] inningB1 = {b1, b2, b3, b4, b5, b6, b7, b8, b9};
    int[] playerA1 = {p1, p2, p3, p4, p5, p6, p7, p8, p9};
    int[] playerB1 = {q1, q2, q3, q4, q5, q6, q7, q8, q9};
    BaseballGame b = new BaseballGame();
    // 呼叫 BaseballGame.score 方法並進行相應的測試斷言
    int result = b.score(inningA1, inningB1, playerA1, playerB1);
    assertEquals(dif,result);
    // 添加相應的斷言來檢查結果是否符合預期
  }
  @Test
  void testInvalidInningCount() throws Exception {
    int[] inningA = {1, 2, 3};
    int[] inningB = {3, 4, 5};
    int[] playerA = {1, 2, 3};
    int[] playerB = {3, 4, 5};
    int dif = -6;

    BaseballGame b = new BaseballGame();
    // 呼叫 BaseballGame.score 方法並進行相應的測試斷言
    int result = b.score(inningA, inningB, playerA, playerB);
    assertEquals(dif,result);
  }
}
