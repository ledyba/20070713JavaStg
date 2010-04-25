package shooting.GameMode.Stage.eachStage;

import java.awt.*;

import shooting.GameMode.Stage.*;
import shooting.GameMode.Stage.basic.*;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: タイトルを描写します．</p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */
public class ModeSelect_Title
    implements chr {
  public ModeSelect_Title() {
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
    g.setColor(Color.white);
    g.setFont(new Font("Helvetica", Font.PLAIN, 24));
    g.drawString("Title",point.getGameAreaStartX() + 20,point.getHeightSize() * 1/5);
  }

  /**
   *
   * @return int
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public int getCode() {
    return object.CODE_FRIEND_CHR;
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
    return true;
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
