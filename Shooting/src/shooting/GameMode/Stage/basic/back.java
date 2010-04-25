package shooting.GameMode.Stage.basic;

import java.awt.*;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: 背景を扱うインターフェースです</p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */

public interface back
    extends object {
  /**
   * 背景でのどこかを設定します．
   * pointのサイズは無視します．
   * @param point point
   */
  abstract void setBackPoint(point point);

  /**
   * 背景内での座標を返します．
   * pointのサイズは0になってます．
   * @return point
   */
  abstract point getBackPoint();

}
