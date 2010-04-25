package shooting.GameMode.Stage.eachObject.enemy;

import shooting.GameMode.Stage.*;
import shooting.GameMode.Stage.basic.*;
import java.awt.Color;

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
public class enemy02
    extends enemy01 {
  public static final int START_ANGLE = 45;

  private static final int[] AREA = {
      40, 40}; //当たり判定の大きさ

  final int Score = 1;
  final Color shotHitColor = new Color( (float) 0, (float) 1,
                                       (float) 1).brighter(); //ヒットに使います．
 final Color shotHitBackColor = new Color( (float) 0, (float) 1,
                                      (float) 0).brighter(); //打ち返しに使います．

  public enemy02(Stage stg, point point) {
    super(stg, point);
    Shield = 30;
    this.setShipColor(Color.blue.darker());
  }

  void setArea(point p) {
    /*
    p.setX_size(AREA[0]);
    p.setY_size(AREA[1]);
*/
  }
  /**
   * 動き方
   */
  public void Move(){
    aliveCount--;
    if (aliveCount > 0) {
      setSize(AREA);
      shot();
    }else{
      this.setKilled(true);
    }
  }

  public void Destroy() {
    if (this.getDamege() <= 0) {
      hitBack();
      stg.addScore(Score * (ALIVE_LIMIT - aliveCount));
    }
  }

  void shot() {
    switch (this.aliveCount % 60) {
      case 0:
        //発射
        for (float i = START_ANGLE; i < 360 + START_ANGLE; i += 22.5) {
          stg.addObj(new enemyShot01(makeNewPoint(), shotHitColor, stg,
                                     point.
                                     getDirection(i, enemyShot01.DFAULT_SPEED, false),0),
                                     Stage.ENEMY_BULL);
        }
        break;
      case 30:
        for (float i = (float) (START_ANGLE - 11.25); i < 360 + START_ANGLE + 11.25; i += 22.5) {
          stg.addObj(new enemyShot01(makeNewPoint(), shotHitColor, stg,
                                     point.
                                     getDirection(i, enemyShot01.DFAULT_SPEED, false),0),
                                     Stage.ENEMY_BULL);
        }
    }
  }
  /**
   * 打ち返す
   */
  void hitBack() {
    for (float i = START_ANGLE; i < 360 + START_ANGLE; i += 11.25) {
      stg.addObj(new enemyShot01(makeNewPoint(), shotHitBackColor, stg,
                                 point.
                                 getDirection(i, enemyShot01.DFAULT_SPEED * 2, false),0),
                                 Stage.ENEMY_BULL);
    }
    float[] dir = point.getDirectionToShip(this.stg.isGameOver(),
                                           this.getPoint(),
                                           this.stg,
                                           enemyShot01.DFAULT_SPEED * 2, false);
    for (float i = 0; i < 5; i++) {
      stg.addObj(new enemyShot01(makeNewPoint(),
                                 shotHitBackColor, stg,
                                 point.getNewDirection( (float) 20, true, dir, true),10),
                 Stage.ENEMY_BULL);
    }
  }
}
