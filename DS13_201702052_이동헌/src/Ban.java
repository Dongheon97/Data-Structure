
public class Ban extends DictionaryByBinarySearchTree<String, Student>{
	
	//Constructor
	public Ban() {
		super();
	}
	
	private DictionaryElement<String, Student> lowestRecursively
	(BinaryNode<DictionaryElement<String, Student>> aRoot){
		DictionaryElement<String, Student> lowest = aRoot.element();
		if(aRoot.left() != null) {
			DictionaryElement<String, Student> lowestOfLeftSubtree 
				= this.lowestRecursively(aRoot.left());
			if(lowestOfLeftSubtree.object().score() < lowest.object().score()) {
				lowest = lowestOfLeftSubtree;
			}
		}
		if(aRoot.right() != null) {
			DictionaryElement<String, Student> lowestOfRightSubtree = this.lowestRecursively(aRoot.right());
			if(lowestOfRightSubtree.object().score() < lowest.object().score()) {
				lowest = lowestOfRightSubtree;
			}
		}
		return lowest;
	}
	public Student lowest() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			DictionaryElement<String, Student> lowest = this.lowestRecursively(this.root());
			return lowest.object();
		}
	}
	
	private DictionaryElement<String, Student> highestRecursively(BinaryNode<DictionaryElement<String, Student>> aRoot){
		DictionaryElement<String, Student> highest = aRoot.element();
		if(aRoot.left() != null) {
			DictionaryElement<String, Student> highestOfLeftSubtree = this.highestRecursively(aRoot.left());
			if(highestOfLeftSubtree.object().score() > highest.object().score()) {
				highest = highestOfLeftSubtree;
			}
		}
		if(aRoot.right() != null) {
			DictionaryElement<String, Student> highestOfRightSubtree = this.highestRecursively(aRoot.right());
			if(highestOfRightSubtree.object().score() > highest.object().score()) {
				highest = highestOfRightSubtree;
			
			}
		}
		return highest;
	}
	public Student highest() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			DictionaryElement<String, Student> highest = this.highestRecursively(this.root());
			return highest.object();
		}
	}
	
	public int numberOfStudentsAboveAverage() {
		double average = this.average();
		int numberOfStudentsAboveAverage = 0;
		Iterator<DictionaryElement<String, Student>> iterator = this.iterator();
		while(iterator.hasNext()) {
			Student student = iterator().next().object();
			if(student.score() >= average) {
				numberOfStudentsAboveAverage ++;
			}
		}
		return numberOfStudentsAboveAverage;
	}
	
	private int sumOfScoresRecursively(BinaryNode<DictionaryElement<String, Student>> aRoot) {
		int sum = 0;
		sum += aRoot.element().object().score();
		if(aRoot.left() != null) {
			int leftSum = sumOfScoresRecursively(aRoot.left());
			sum += leftSum;
		}
		if(aRoot.right() != null) {
			int rightSum = sumOfScoresRecursively(aRoot.right());
			sum += rightSum;
		}		
		return sum;
	}
	
	private int sumOfScores() {
		return this.sumOfScoresRecursively(this.root());
	}
	
	public double average() {
		return ((double)this.sumOfScores() / (double)this.size());
	}
	
	public char scoreToGrade(int aScore) {
		if(aScore >= 90) {
			return 'A';
		}
		else if(aScore >= 80) {
			return 'B';
		}
		else if(aScore >= 70) {
			return 'C';
		}
		else if(aScore >= 60) {
			return 'D';
		}
		else {
			return 'F';
		}
	}
	
	public GradeCounter countGrades() {
		char grade;
		GradeCounter gradeCounter = new GradeCounter();
		Iterator<DictionaryElement<String, Student>> iterator = this.iterator();
		while(iterator.hasNext()) {
			grade = scoreToGrade(iterator.next().object().score()); // 학생의 성적을 학점으로 반환하고 grade에 넣는다.
			gradeCounter.count(grade);
		}
		return gradeCounter;
	}
	
	
	public Student[] studentsSortedByScore() {
		
		Student[] students = new Student[this.size()];
		Iterator<DictionaryElement<String, Student>> iterator = this.iterator();
		for(int i=0; iterator.hasNext(); i++) {
			students[i] = iterator.next().object();
		}
		for ( int i = 0 ; i < students.length;i++) {
		}
		Sort<Student> quicksort = new QuickSort<Student>();
		quicksort.sort(students, students.length);
		return students;
	}
}
