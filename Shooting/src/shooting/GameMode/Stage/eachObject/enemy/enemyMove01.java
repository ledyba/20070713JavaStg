package shooting.GameMode.Stage.eachObject.enemy;

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
public class enemyMove01
    implements move {
  point pt;
  public enemyMove01(point point) {
    point =pt;
  }

  /**
   *
   * @return point
   * @todo この shooting.GameMode.Stage.basic.move メソッドを実装
   */
  public point move() {
    return pt;
  }
}
