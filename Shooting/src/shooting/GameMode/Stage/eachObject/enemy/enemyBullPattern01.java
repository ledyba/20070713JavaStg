package shooting.GameMode.Stage.eachObject.enemy;

import shooting.GameMode.Stage.basic.*;
import shooting.GameMode.Stage.*;
import java.awt.*;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: ���@�_���e�ł��D</p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
 * @version 1.0
 */
public class enemyBullPattern01
    implements bullPattern {
  Stage stage; //�X�e�[�W
  point ship; //���@
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
    //�����A�ˁH
    for (int j = 0; j < 1 + (stage.getRank() >> 2); j++) {
      bull bull;
        bull = new enemyShot01(new point(ship.getCenterX(),
                                         ship.get_endY(),
                                         0, 0), shotColor, stage, dir,j*3);
        //�_��ɂȂ�悤�ɂ��܂��D
        //�����Shot���̃��\�b�h�Œ���
        /*
        for (int i = 0; i < j * 2; i++) {
          bull.Move();
        }*/
        stage.addObj(bull, Stage.ENEMY_BULL);

    }
  }
}
