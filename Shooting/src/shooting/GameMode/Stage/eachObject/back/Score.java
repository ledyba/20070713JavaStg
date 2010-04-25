package shooting.GameMode.Stage.eachObject.back;

import java.awt.*;

import shooting.GameMode.*;
import shooting.GameMode.Stage.*;
import shooting.GameMode.Stage.basic.*;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: </p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */
public class Score
    implements back {
  Stage Stg;
  boolean isVisible = true;
  private long preTime; //一秒前の時間
  private int fps = 0;
  private int preFps = 0;

  public Score(Stage stg) {
    Stg = stg;
  }

  /**
   *
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void Move() {
    //動かすようなこともしません．
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void draw(Graphics g, byte isHitDisp) {
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, point.getGameAreaStartX(), point.getHeightSize());
    g.fillRect(point.getGameAreaEndX(), 0,
               GameFrame.Width - point.getGameAreaEndX(),
               point.getGameAreaEndY());

/*    g.setColor(Color.BLUE);
    g.drawRect(point.getGameAreaStartX(), point.getGameAreaStartY(),
               point.getWidthSize(), point.getHeightSize() - 1);
 */

    g.setColor(Color.WHITE);
    g.setFont(new Font("Helvetica", Font.PLAIN, 12));
    g.drawString( ("Rank : " + String.valueOf(Stg.getRank())), point.getGameAreaEndX() + 10,50);
    g.drawString( ("Score : " + String.valueOf(Stg.getScore())), 10,
                 point.getHeightSize() - 30);
    g.drawString( ("Ship × " + String.valueOf(Stg.getShips())), 10,
                 point.getHeightSize() - 18);
   showFrameRate(g);
  }

  private void showFrameRate(Graphics g) {
    fps++;
    long justNow = Stg.getNowTime();
    if ( (justNow - preTime) >= 1000) {
      preTime = justNow;
      preFps = fps;
      fps = 0;
    }

    String str;
    str = String.valueOf(preFps) + " FPS";
    g.drawString(str,
                 point.getGameAreaEndX() + 10, point.getGameAreaEndY() - 18);

    g.drawString(String.valueOf(Stg.getObjects()) + " object(s)",
                 point.getGameAreaEndX() + 10, point.getGameAreaEndY() - 30);

    g.drawString(String.valueOf(Stg.getFrameCount()) + " frame(s)",
                 point.getGameAreaEndX() + 10, point.getGameAreaEndY() - 42);

  }

  /**
   *
   * @return point
   * @todo この shooting.GameMode.Stage.basic.back メソッドを実装
   */
  public point getBackPoint() {
    return null;
  }

  /**
   *
   * @return point
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public point getPoint() {
    return null;
  }

  /**
   *
   * @return Stage
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public Stage getStage() {
    return Stg;
  }

  /**
   *
   * @return boolean
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public boolean getVisible() {
    return isVisible;
  }

  /**
   *
   * @return boolean
   * @param obj object
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public boolean judge(object obj) {
    //背景なので判定なし
    return false;
  }

  /**
   *
   * @param point point
   * @todo この shooting.GameMode.Stage.basic.back メソッドを実装
   */
  public void setBackPoint(point point) {
  }

  /**
   *
   * @param point point
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void setPoint(point point) {
  }

  /**
   * 所属するステージを設定します.
   *
   * @param stg Stage
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void setStage(Stage stg) {
    Stg = stg;
  }

  /**
   *
   * @param isVisible boolean
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void setVisible(boolean isVisible) {
    this.isVisible = isVisible;
  }

  public int getCode() {
    return object.CODE_SCORE;
  }

}
