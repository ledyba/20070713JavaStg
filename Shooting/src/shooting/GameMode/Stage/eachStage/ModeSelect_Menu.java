package shooting.GameMode.Stage.eachStage;

import java.awt.*;

import shooting.GameMode.Stage.*;
import shooting.GameMode.*;
import shooting.GameMode.Stage.basic.*;
import shooting.GameMode.GameFrame;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: ���j���[�ł��D�L�����N�^�Ƃ��č���Ă����܂��D</p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
 * @version 1.0
 */
public class ModeSelect_Menu
    implements chr {
  private String[] MENU_TITLE = {
      "MainGame",
      "Ranking",
      "Config",
      "Exit"
  };
  private byte Input;
  private byte preInput;
  private ModeSelect stg;
  private int menuCount = 0; //�ǂ̃��j���[��I��ł��邩�ł��D
  public ModeSelect_Menu(ModeSelect stg) {
    Input = stg.getInput();
    preInput = Input;
    this.stg = stg;
  }

  /**
   *
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public void Destroy() {
  }

  /**
   *
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void Move() {
    Input = stg.getInput();
    if ( ( (~preInput) & Input) != 0) {
      if ( (GameFrame.getInput() & 1) != 0) { //��
        if (menuCount > 0) {
          menuCount--;
        }
      }
      if ( (GameFrame.getInput() & 2) != 0) { //��
        if (menuCount < MENU_TITLE.length - 1) {
          menuCount++;
        }
      }
      if ( (GameFrame.getInput() & 4) != 0) { //�E
      }
      if ( (GameFrame.getInput() & 8) != 0) { //��
      }
      if ( (GameFrame.getInput() & 16) != 0) { //�V���b�g
        switch (menuCount) {
          case 0:
            stg.setWhatToDo(GameCore.GAME_START, 0);
            break;
          case 1:
            stg.setWhatToDo(GameCore.RANKING, 0);
            break;
          case 2:
            stg.setWhatToDo(GameCore.CONFIG, 0);
            break;
          case 3:
            stg.setWhatToDo(GameCore.EXIT, 0);
            break;

        }
      }
      if ( (GameFrame.getInput() & 32) != 0) { //�X���[
      }
    }
    preInput = Input;
  }

  /**
   *
   * @param damage int
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public void addDamage(int damage) {
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void draw(Graphics g, byte isHitDisp) {
    for (int i = 0; i < this.MENU_TITLE.length; i++) {
      if (i != menuCount) {
        g.setColor(Color.white);
        g.setFont(new Font("Helvetica", Font.PLAIN, 24));
      }
      else {
        g.setColor(Color.RED);
        g.setFont(new Font("Helvetica", Font.PLAIN, 30));
      }
      g.drawString(MENU_TITLE[i], point.getGameAreaStartX() + 20,
                   point.getHeightSize() * 3 / 5 + i * 30);
    }
  }

  /**
   *
   * @return int
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public int getCode() {
    return object.CODE_FRIEND_CHR;
  }

  /**
   *
   * @return int
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public int getDamege() {
    return 0;
  }

  /**
   *
   * @return point
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public point getPoint() {
    return null;
  }

  /**
   *
   * @return Stage
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public Stage getStage() {
    return null;
  }

  /**
   *
   * @return boolean
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public boolean getVisible() {
    return false;
  }

  /**
   *
   * @return boolean
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public boolean isAlive() {
    return true;
  }

  /**
   *
   * @return boolean
   * @param obj object
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public boolean judge(object obj) {
    return false;
  }

  /**
   *
   * @param flag boolean
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public void setKilled(boolean flag) {
  }

  /**
   *
   * @param point point
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void setPoint(point point) {
  }

  /**
   *
   * @param color Color
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public void setShipColor(Color color) {
  }

  /**
   * ��������X�e�[�W��ݒ肵�܂�.
   *
   * @param stg Stage
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void setStage(Stage stg) {
  }

  /**
   *
   * @param isVisible boolean
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void setVisible(boolean isVisible) {
  }

}
