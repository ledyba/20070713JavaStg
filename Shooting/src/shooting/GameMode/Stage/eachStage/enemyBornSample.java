package shooting.GameMode.Stage.eachStage;

import shooting.GameMode.Stage.*;
import shooting.GameMode.Stage.eachObject.enemy.*;
import shooting.GameMode.Stage.basic.*;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: �G�𐶂ރN���X�ł��D</p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
 * @version 1.0
 */
public class enemyBornSample
    implements enemyBorn {
  private Stage stage;
  public enemyBornSample(Stage stg) {
    stage = stg;
  }

  public void run() {
    if ( (stage.getFrameCount() & 30) == 30) {
      stage.addObj( (new enemy01(stage,
                                 new point(point.getWidthSize() >> 2, 50, 0, 0))),
                   Stage.ENEMY_CHR);
      stage.addObj( (new enemy01(stage,
                                 new point( (point.getWidthSize() >> 2) * 3, 50,
                                           0, 0))), Stage.ENEMY_CHR);
    }
    if ( (stage.getFrameCount() % 100) == 0) {
      stage.addObj( (new enemy02(stage,
                                   new point(
                                     (int)((point.getWidthSize() >> 2) *((stage.getFrameCount() / 100) % 4))
                                     , 100, 0, 0))),
                   Stage.ENEMY_CHR);

    }
  }
}

