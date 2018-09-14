import java.util.Random;

public class Dialog {
	
	public static String m_startMessage = "������ :) � ���� ����� ���-���. "
			+ "���������? ����� ��������� � �����������, "
			+ "������ \"� ����\".";
	
	public static String m_talkToMe = "�� �������� �� ����!";
	
	public static String[] m_typicalPhrasesAndQuestion = {
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
	
	public static String[] m_typicalAnswers = {
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
	
}