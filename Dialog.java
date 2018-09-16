import java.util.Random;

public class Dialog {
	
	public static String m_startMessage = "������ :) � ���� ����� ���-���. "
			+ "���������? ����� ��������� � �����������, "
			+ "������ \"� ����\".";
	
	private static String m_talkToMe = "�� �������� �� ����!";
	
	private static String[] m_typicalPhrasesAndQuestion = {
	        "������� �������� �������.",
	        "����� �������� ����� ������� ������, ������ ���� ����.",
	        "� ��� ����� ���������������. ��� �� �����.",
	        "��� ���������?",
	        "��� ������?",
	        "� �� ������ ���������?",
	        "��� �� ���� ������? ��� ������ � ����� ������ :(",
	        "�������� � ��������� ���� ������� � ������� ����.",
	        "�� ����� �������� � ����� ��������� :)",
	        "����������� ���� ������� ���������������� ���.",
	        "����� ����� ������, �� ����� � ��������, ����� ���.",
	        "����� ����� �� �����?",
	        "������� :(",
	        "� ������ ����, ��� �����!",
	        "�� ��� �������.",
	        "����",
	        "��� �����!",
	        "��� �������, �� ���-�� ��������� �� ����..."};
	
	private static String[] m_typicalAnswers = {
	        "������ ���������, ��� ����� ��������",
	        "�� ���� :(",
	        "������ � ����-�� �������.",
	        "������ �� ������� �� ���?",
	        "��!",
	        "���!",
	        "����� ����� ��������� � ���-�� ������?",
	        "������, �� ��� ����� ������ ������.",
	        "�� ������, ��� ���� ���������� �����.",
	        "����� �������� �������?:)"};
	
	public static String sendAnswer() {
		Random random;
		random = new Random();
		return m_typicalAnswers[random.nextInt(Dialog.m_typicalAnswers.length)];
	}
	
	public static String sendPhraseAndQuestion() {
		Random random;
		random = new Random();
		return m_typicalPhrasesAndQuestion[random.nextInt(Dialog.m_typicalPhrasesAndQuestion.length)];
	}
	
	public static String sendStartMessage() {
		return m_startMessage;
	}
	
	public static String sendTalkToMe() {
		return m_talkToMe;
	}
	
}