package shooting.GameMode.Stage.basic;
import java.awt.*;
/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: ���@��G�@���C���^�[�t�F�[�X�ł�</p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
 * @version 1.0
 */
public interface chr
    extends object {
  /**
   * ���̃L�����N�^������ł��邩�ۂ��̃Z�b�g
   * @param flag boolean
   */
  public abstract void setKilled(boolean flag);

  /**
   * �E����Ă��邩�ۂ��̎擾
   * @return boolean
   */
  public abstract boolean isAlive();

  /**
   * �e�⎩�@��j�����܂��D
   */
  public abstract void Destroy();

  /**
   * ���̃L�����N�^�Ƀ_���[�W�������܂�
   * @param damage int
   */
  public abstract void addDamage(int damage);

  /**
   * �c��V�[���h��Ԃ��܂�
   * @return int
   */
  public abstract int getDamege();
  /**
   * �F�̐ݒ�
   * @param color Color
   */
  public abstract void setShipColor(Color color);
}
