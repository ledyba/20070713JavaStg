package shooting.GameMode.Stage.basic;

import shooting.GameMode.Stage.basic.*;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: 敵弾か何かを扱うインターフェースです</p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */
//弾の抽象メソッド
public interface bull
    extends chr {

  /**
   * 弾の速度を設定します．
   * @param speed int
   */
  public abstract void setSpeed(int speed);
  /**
   * 弾の速度を返します．
   * @return int
   */
  public abstract int getSpeed();
  }
