package woojinTT;

public class DataObject {
	private String  major;		//�����а�����
	private String  classNumber;	//�м���ȣ
	private String  classDivide;   //�й�
	private String	className;	//�������
	private String	classCompletion; //�̼�����
	private String	classCredit; //����
	private String  studentGrade;//�г� 
	private String  professorName; //������
	private String  classTime; //���� ���ǽð�
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}
	public String getClassDivide() {
		return classDivide;
	}
	public void setClassDivide(String classDivide) {
		this.classDivide = classDivide;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassCredit() {
		return classCredit;
	}
	public void setClassCredit(String classCredit) {
		this.classCredit = classCredit;
	}
	public String getStudentGrade() {
		return studentGrade;
	}
	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}
	public String getClassTime() {
		return classTime;
	}
	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	
	public String getClassCompletion() {
		return classCompletion;
	}
	public void setClassCompletion(String classCompletion) {
		this.classCompletion = classCompletion;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("�����а����� : " + major);
		sb.append(" ,�м���ȣ : " + classNumber);
		sb.append(" ,�й� : " + classDivide);
		sb.append(" ,������� : " + className);
		sb.append(" ,�̼����� : " + classCompletion);
		sb.append(" ,���� : " + classCredit);
		sb.append(" ,�г� : " + studentGrade);
		sb.append(" ,������ : " + professorName);
		sb.append(" ,���� �� ���ǽð� : " + classTime);
		
		return sb.toString();
	}


	
}
