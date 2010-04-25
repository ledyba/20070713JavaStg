package shooting.GameMode.Stage.eachStage;

import java.awt.*;

import shooting.GameMode.Stage.*;
import shooting.GameMode.*;
import shooting.GameMode.Stage.basic.*;
import shooting.GameMode.GameFrame;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: メニューです．キャラクタとして作っておきます．</p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
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
  private int menuCount = 0; //どのメニューを選んでいるかです．
  public ModeSelect_Menu(ModeSelect stg) {
    Input = stg.getInput();
    preInput = Input;
    this.stg = stg;
  }

  /**
   *
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public void Destroy() {
  }

  /**
   *
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void Move() {
    Input = stg.getInput();
    if ( ( (~preInput) & Input) != 0) {
      if ( (GameFrame.getInput() & 1) != 0) { //上
        if (menuCount > 0) {
          menuCount--;
        }
      }
      if ( (GameFrame.getInput() & 2) != 0) { //下
        if (menuCount < MENU_TITLE.length - 1) {
          menuCount++;
        }
      }
      if ( (GameFrame.getInput() & 4) != 0) { //右
      }
      if ( (GameFrame.getInput() & 8) != 0) { //左
      }
      if ( (GameFrame.getInput() & 16) != 0) { //ショット
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
      if ( (GameFrame.getInput() & 32) != 0) { //スロー
      }
    }
    preInput = Input;
  }

  /**
   *
   * @param damage int
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public void addDamage(int damage) {
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
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
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public int getCode() {
    return object.CODE_FRIEND_CHR;
  }

  /**
   *
   * @return int
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public int getDamege() {
    return 0;
  }

  /**
   *
   * @return point
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public point getPoint() {
    return null;
  }

  /**
   *
   * @return Stage
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public Stage getStage() {
    return null;
  }

  /**
   *
   * @return boolean
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public boolean getVisible() {
    return false;
  }

  /**
   *
   * @return boolean
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public boolean isAlive() {
    return true;
  }

  /**
   *
   * @return boolean
   * @param obj object
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public boolean judge(object obj) {
    return false;
  }

  /**
   *
   * @param flag boolean
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public void setKilled(boolean flag) {
  }

  /**
   *
   * @param point point
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void setPoint(point point) {
  }

  /**
   *
   * @param color Color
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public void setShipColor(Color color) {
  }

  /**
   * 所属するステージを設定します.
   *
   * @param stg Stage
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void setStage(Stage stg) {
  }

  /**
   *
   * @param isVisible boolean
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void setVisible(boolean isVisible) {
  }

}
