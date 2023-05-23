import java.util.ArrayList;

public class GradeList {
    private final ArrayList<Double> grades = new ArrayList<>();
    public void addGrade(double x){
        if(x>=2 && x<=5 && x%0.5==0){
            grades.add(x);
        }
    }
    public double averageGrade(){
        if(grades.isEmpty()){
            return -1;
        } else {
            double sum = 0;
            for (Double grade : grades) sum += grade;
            return sum/grades.size();
        }
    }
    public double getBestGrade(){
        if(grades.isEmpty()){
            return -1;
        } else {
            double max = grades.get(0);
            for(int i = 1; i < grades.size(); i++){
                if(grades.get(i)>max){
                    max = grades.get(i);
                }
            }
            return max;
        }
    }
    public double getWorstGrade(){
        if(grades.isEmpty()){
            return -1;
        } else {
            double min = grades.get(0);
            for(int i = 1; i < grades.size(); i++){
                if(grades.get(i)<min){
                    min = grades.get(i);
                }
            }
            return min;
        }
    }
}
