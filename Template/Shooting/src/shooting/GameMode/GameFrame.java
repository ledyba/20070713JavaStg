package shooting.GameMode;

import java.awt.*;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.*;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: </p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */
public class GameFrame  extends JFrame {
  GraphicsDevice device;
  DisplayMode oldMode;
  protected static final String FrameTitle = "シューティングゲーム（仮）";
  protected static final int BufferSize = 2;//バッファの枚数
  public static BufferStrategy bs;//バッファ
  protected static boolean isFullScreen = false;//フルスクリーンフラグ
  protected static int Width = 0;//横のサイズ
  protected static int Height = 0;//縦のサイズ
  protected static int BitDepth = 0;//色数の深さ
  protected static Object called = null;//呼び出し元です
  public GameFrame(boolean isFullScreen, int Width,int Height,int BitDepth, Object called) {
    try {
      this.called = called;
      this.isFullScreen = isFullScreen;
      this.Width = Width;//横のサイズ
      this.Height = Height;//縦のサイズ
      this.BitDepth = BitDepth;//色数の深さ
      jbInit();
      start();
    }
    catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    this.setTitle(this.FrameTitle);
    //this.createBufferStrategy(this.BufferSize);//バッファの製作
    //this.bs = this.getBufferStrategy();//バッファにアクセスしやすくするために名前は短くしよう

    KeyListener EscCheck = new EscCheck();
    this.addKeyListener(EscCheck);
  }
  //ウィンドウが閉じられたときに終了するようにオーバーライド
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      EscTyped();//ESCが押されたのと同じ扱いにします．
      /*
      if(isFullScreen){
        device.setDisplayMode(oldMode);
        device.setFullScreenWindow(null);
      }
      System.exit(0);//終了
      */
    }
  }
  public void start(){//はじめる時に読み込む
    if(isFullScreen){//フルスクリーンモード
      this.setUndecorated(true);//ウインドウ修飾を無効にする
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();//画面環境の取得
      device = ge.getDefaultScreenDevice();//デバイスの取得
      GraphicsConfiguration gc = device.getDefaultConfiguration();//デフォルト設定を取得
      oldMode = device.getDisplayMode();//元に戻すときの設定を取得
      DisplayMode mode = new DisplayMode(Width, Height, BitDepth, DisplayMode.REFRESH_RATE_UNKNOWN);//画面モード
      device.setFullScreenWindow(this);//フルスクリーン
      device.setDisplayMode(mode);
    }else{//ウィンドウモード
      this.setSize(Width,Height);
      /*ディスプレイモードの取得*/
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      GraphicsDevice device = ge.getDefaultScreenDevice();
      DisplayMode disMode = device.getDisplayMode();
      //画面の中心に描写
      this.setLocation((disMode.getWidth()-Width) / 2, (disMode.getHeight() - Height) / 2 );
      //this.setModal(true);
      //this.pack();
      //this.show();
    }
    this.setVisible(true);
  }
  public void exit(){//終わるときに読みこむ
    if(isFullScreen){
      device.setDisplayMode(oldMode);
      device.setFullScreenWindow(null);
    }
  }
  protected static void EscTyped(){//ESCキーが押されたときの対処です．
    System.exit(0);
  }
  class EscCheck implements KeyListener{//Escでのゲームの終了を関知します
    public void keyPressed(KeyEvent e){
      if(e.getKeyCode() == KeyEvent.VK_ESCAPE){//ESCを押しているならば
        GameFrame.EscTyped();
      }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
  }
}
