package shooting;

import javax.swing.UIManager;
import java.awt.*;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 * <p>����: </p>
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 * <p>��Ж�: </p>
 * @author ������
 * @version 1.0
 */

public class Game {
  boolean packFrame = true;//�t���[�����s�b�`���z�u����
//boolean packFrame = false;

  //�A�v���P�[�V�����̃r���h
  public Game() {
    Frame frame = new Frame();
    //validate() �̓T�C�Y�𒲐�����
    //pack() �͗L���ȃT�C�Y�������C�A�E�g�Ȃǂ���擾����
    if (packFrame) {
      frame.pack();
    }
    else {
      frame.validate();
    }
    //�E�B���h�E�𒆉��ɔz�u
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  //Main ���\�b�h
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    new Game();
  }

  private void jbInit() throws Exception {
  }
}
