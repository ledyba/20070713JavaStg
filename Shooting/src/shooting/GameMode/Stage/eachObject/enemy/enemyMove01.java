package shooting.GameMode.Stage.eachObject.enemy;

import shooting.GameMode.Stage.basic.*;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: </p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
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
   * @todo ���� shooting.GameMode.Stage.basic.move ���\�b�h������
   */
  public point move() {
    return pt;
  }
}
