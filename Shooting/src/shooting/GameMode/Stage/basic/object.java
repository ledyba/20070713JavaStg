package shooting.GameMode.Stage.basic;

import java.awt.*;
import shooting.GameMode.Stage.*;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: オブジェクトのインターフェースです</p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
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
   * 動かします（弾の発生含む）
   */
  public abstract void Move();

  /**
   * 座標（と大きさ）を設定します
   * @param point point
   */
  abstract void setPoint(point point); //描写する座標・サイズを設定

  /**
   * 座標（と大きさ）を返します
   * @return point
   */
  abstract point getPoint();

  /**
   * 見えるようにするか，しないかを設定します
   * @param isVisible boolean
   */
  abstract void setVisible(boolean isVisible);

  /**
   * 見えているかの現在の状況を返します
   * @return boolean
   */
  abstract boolean getVisible(); //見えているか

  /**
   * 当たり判定を行います
   * @param obj object
   * @return boolean
   */
  abstract boolean judge(object obj); //当たり判定

  /**
   * 描写します．<br>
   * 注意：レイヤで扱うのでバッファをクリアしないこと！<br>
   * 0x0:どっちもなし<br>
   * 0x1:本体あり<br>
   * 0x2:ヒットディスプあり<br>
   * 0x3:両方あり
   * @param g Graphics
   * @param isHitDisp int
   */
  abstract void draw(Graphics g, byte isHitDisp); //描写　
  /**
   * 描写に使うバッファイメージを作成します．
   */
//  abstract void createImage();
  /**
   * 作ったイメージのゲッター
   * @return Image
   */
//  abstract Image getImage();
  /**
   * 自分の所属するステージを返します．
   * @return Stage
   */
  abstract Stage getStage();

  /**
   * 所属するステージを設定します.
   * @param stg Stage
   */
  abstract void setStage(Stage stg);

  /**
   * オブジェクトの種類を返します．
   * @return int
   */
  abstract int getCode();
}
