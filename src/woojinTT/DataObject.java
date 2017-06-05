package woojinTT;

public class DataObject {
	private String  major;		//개설학과전공
	private String  classNumber;	//학수번호
	private String  classDivide;   //분반
	private String	className;	//교과목명
	private String	classCompletion; //이수구분
	private String	classCredit; //학점
	private String  studentGrade;//학년 
	private String  professorName; //교수명
	private String  classTime; //요일 강의시간
	
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
		
		sb.append("개설학과전공 : " + major);
		sb.append(" ,학수번호 : " + classNumber);
		sb.append(" ,분반 : " + classDivide);
		sb.append(" ,교과목명 : " + className);
		sb.append(" ,이수구분 : " + classCompletion);
		sb.append(" ,학점 : " + classCredit);
		sb.append(" ,학년 : " + studentGrade);
		sb.append(" ,교수명 : " + professorName);
		sb.append(" ,요일 및 강의시간 : " + classTime);
		
		return sb.toString();
	}


	
}
