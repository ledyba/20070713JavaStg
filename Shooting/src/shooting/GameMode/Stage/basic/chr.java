package shooting.GameMode.Stage.basic;
import java.awt.*;
/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: 自機や敵機をインターフェースです</p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */
public interface chr
    extends object {
  /**
   * そのキャラクタが死んでいるか否かのセット
   * @param flag boolean
   */
  public abstract void setKilled(boolean flag);

  /**
   * 殺されているか否かの取得
   * @return boolean
   */
  public abstract boolean isAlive();

  /**
   * 弾や自機を破棄します．
   */
  public abstract void Destroy();

  /**
   * そのキャラクタにダメージを加えます
   * @param damage int
   */
  public abstract void addDamage(int damage);

  /**
   * 残りシールドを返します
   * @return int
   */
  public abstract int getDamege();
  /**
   * 色の設定
   * @param color Color
   */
  public abstract void setShipColor(Color color);
}
