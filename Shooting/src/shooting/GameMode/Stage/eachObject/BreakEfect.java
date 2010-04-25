package shooting.GameMode.Stage.eachObject;

import shooting.GameMode.Stage.basic.chr;
import java.awt.Graphics;
import shooting.GameMode.Stage.basic.point;
import shooting.GameMode.Stage.Stage;
import shooting.GameMode.Stage.basic.object;
import java.awt.Color;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: エフェクトを描写します．結構，難しい．</p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */
public class BreakEfect
    implements chr {
  public BreakEfect() {
  }

  /**
   *
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public void Destroy() {
  }

  /**
   *
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void Move() {
  }

  /**
   *
   * @param damage int
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public void addDamage(int damage) {
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void draw(Graphics g, byte isHitDisp) {
  }

  /**
   *
   * @return int
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public int getCode() {
    return 0;
  }

  /**
   *
   * @return int
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public int getDamege() {
    return 0;
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
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public boolean isAlive() {
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
   * @param flag boolean
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public void setKilled(boolean flag) {
  }

  /**
   *
   * @param point point
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void setPoint(point point) {
  }

  /**
   *
   * @param color Color
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public void setShipColor(Color color) {
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
}
