package shooting.GameMode.Stage.eachObject.enemy;

import shooting.GameMode.Stage.basic.*;
import shooting.GameMode.Stage.*;
import java.awt.*;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: 自機狙い弾です．</p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */
public class enemyBullPattern01
    implements bullPattern {
  Stage stage; //ステージ
  point ship; //自機
  Color shotColor;
  public enemyBullPattern01(Stage stg, point shp, Color clr) {
    stage = stg;
    ship = shp;
    shotColor = clr;
  }

  public void fire() {
    float speed = (float) Math.sqrt(stage.getRank() + 3);
    float[] dir = point.getDirectionToShip(stage.isGameOver(), ship, stage,
                                           speed, false);
    //何発連射？
    for (int j = 0; j < 1 + (stage.getRank() >> 2); j++) {
      bull bull;
        bull = new enemyShot01(new point(ship.getCenterX(),
                                         ship.get_endY(),
                                         0, 0), shotColor, stage, dir,j*3);
        //棒状になるようにします．
        //これはShot内のメソッドで調整
        /*
        for (int i = 0; i < j * 2; i++) {
          bull.Move();
        }*/
        stage.addObj(bull, Stage.ENEMY_BULL);

    }
  }
}
