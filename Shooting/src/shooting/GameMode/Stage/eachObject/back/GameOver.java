package shooting.GameMode.Stage.eachObject.back;

import java.awt.*;

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
public class GameOver
    implements back {
  long frameCount = 0;
  Stage stg;
  point Point = new point(point.getWidthSize() / 10, point.getHeightSize() / 5,
                          0, 0);
  public GameOver(Stage stg) {
    this.stg = stg;
  }

  /**
   *
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void Move() {
    frameCount++;
    if (Point.getY() <= point.getHeightSize() / 2) {
      Point.setY(Point.getY() + 2);
    }
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void draw(Graphics g, byte isHitDisp) {
    g.setColor(Color.white);
    g.setFont(new Font("Helvetica", Font.PLAIN, 36));
    g.drawString("Game Over", Point.getXinFrame(), Point.getYinFrame() - 36);
    g.drawString( ("Score : " + String.valueOf(stg.getScore())),
                 Point.getXinFrame(), Point.getYinFrame());
    if (frameCount >= Stage.END_KEY_PRESSED_COUNT_INTERVAL) {
      if ( (frameCount % 40) < 20) {
        g.drawString("Press Shot Key", Point.getXinFrame() - 20,
                     (point.getHeightSize() * 4) / 5);
      }
    }
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
    return null;
  }

  /**
   *
   * @return boolean
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public boolean getVisible() {
    return false;
  }

  /**
   *
   * @return boolean
   * @param obj object
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public boolean judge(object obj) {
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
  }

  /**
   *
   * @param isVisible boolean
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void setVisible(boolean isVisible) {
  }

  public int getCode() {
    return object.CODE_SCORE;
  }

}
