import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DialogTest {

	@Test
	void startMessageTest() {
		assertEquals(Dialog.sendStartMessage(), "������ :) � ���� ����� ���-���. "
				+ "���������? ����� ��������� � �����������, "
				+ "������ \"� ����\".");
	}
	
	@Test
	void talkToMeTest() {
		assertEquals(Dialog.sendTalkToMe(), "�� �������� �� ����!");
	}

}
