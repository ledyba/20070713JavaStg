package shooting.GameMode.Stage.basic;

import java.awt.*;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: �w�i�������C���^�[�t�F�[�X�ł�</p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
 * @version 1.0
 */

public interface back
    extends object {
  /**
   * �w�i�ł̂ǂ�����ݒ肵�܂��D
   * point�̃T�C�Y�͖������܂��D
   * @param point point
   */
  abstract void setBackPoint(point point);

  /**
   * �w�i���ł̍��W��Ԃ��܂��D
   * point�̃T�C�Y��0�ɂȂ��Ă܂��D
   * @return point
   */
  abstract point getBackPoint();

}
