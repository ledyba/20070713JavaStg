package shooting.GameMode.Stage.basic;

import shooting.GameMode.Stage.basic.*;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: �G�e�������������C���^�[�t�F�[�X�ł�</p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
 * @version 1.0
 */
//�e�̒��ۃ��\�b�h
public interface bull
    extends chr {

  /**
   * �e�̑��x��ݒ肵�܂��D
   * @param speed int
   */
  public abstract void setSpeed(int speed);
  /**
   * �e�̑��x��Ԃ��܂��D
   * @return int
   */
  public abstract int getSpeed();
  }
