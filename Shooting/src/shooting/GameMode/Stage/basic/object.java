package shooting.GameMode.Stage.basic;

import java.awt.*;
import shooting.GameMode.Stage.*;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: �I�u�W�F�N�g�̃C���^�[�t�F�[�X�ł�</p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
 * @version 1.0
 */
public interface object {
  public static final int CODE_LND = 0;
  public static final int CODE_BACK = 1;
  public static final int CODE_SCORE = 3;
  public static final int CODE_ENEMY_BULL = 4;
  public static final int CODE_ENEMY_CHR = 5;
  public static final int CODE_FRIEND_BULL = 6;
  public static final int CODE_FRIEND_CHR = 7;
  /**
   * �������܂��i�e�̔����܂ށj
   */
  public abstract void Move();

  /**
   * ���W�i�Ƒ傫���j��ݒ肵�܂�
   * @param point point
   */
  abstract void setPoint(point point); //�`�ʂ�����W�E�T�C�Y��ݒ�

  /**
   * ���W�i�Ƒ傫���j��Ԃ��܂�
   * @return point
   */
  abstract point getPoint();

  /**
   * ������悤�ɂ��邩�C���Ȃ�����ݒ肵�܂�
   * @param isVisible boolean
   */
  abstract void setVisible(boolean isVisible);

  /**
   * �����Ă��邩�̌��݂̏󋵂�Ԃ��܂�
   * @return boolean
   */
  abstract boolean getVisible(); //�����Ă��邩

  /**
   * �����蔻����s���܂�
   * @param obj object
   * @return boolean
   */
  abstract boolean judge(object obj); //�����蔻��

  /**
   * �`�ʂ��܂��D<br>
   * ���ӁF���C���ň����̂Ńo�b�t�@���N���A���Ȃ����ƁI<br>
   * 0x0:�ǂ������Ȃ�<br>
   * 0x1:�{�̂���<br>
   * 0x2:�q�b�g�f�B�X�v����<br>
   * 0x3:��������
   * @param g Graphics
   * @param isHitDisp int
   */
  abstract void draw(Graphics g, byte isHitDisp); //�`�ʁ@
  /**
   * �`�ʂɎg���o�b�t�@�C���[�W���쐬���܂��D
   */
//  abstract void createImage();
  /**
   * ������C���[�W�̃Q�b�^�[
   * @return Image
   */
//  abstract Image getImage();
  /**
   * �����̏�������X�e�[�W��Ԃ��܂��D
   * @return Stage
   */
  abstract Stage getStage();

  /**
   * ��������X�e�[�W��ݒ肵�܂�.
   * @param stg Stage
   */
  abstract void setStage(Stage stg);

  /**
   * �I�u�W�F�N�g�̎�ނ�Ԃ��܂��D
   * @return int
   */
  abstract int getCode();
}
