public class Calculator {

    private User user;

    public Calculator(User user) {
        this.user = user;
    }

    public double calculateBMR(){
        double bmr;
        if (user.getGender().equals("male")){
            bmr = (10 * user.getWeight()) + (6.25 * user.getHeight()) - (5 * user.getAge()) + 5;
            return bmr;
        } else {
            bmr = (10 * user.getWeight()) + (6.25 * user.getHeight()) - (5 * user.getAge()) - 161;
            return bmr;
        }
    }

    public double calculateTDEE(User user){
        double tdee;
        double userBMR = calculateBMR();
        switch (user.getActivityLevel()){
            case SEDENTARY:
                tdee = userBMR * 1.2;
                return tdee;
            case LIGHTLY_ACTIVE:
                tdee = userBMR * 1.375;
                return tdee;
            case MODERATELY_ACTIVE:
                tdee = userBMR * 1.55;
                return tdee;
            case VERY_ACTIVE:
                tdee = userBMR * 1.725;
                return tdee;
            case EXTRA_ACTIVE:
                tdee = userBMR * 1.9;
                return tdee;
        }
    }

    public double getDailyTarget(){

    }
}
